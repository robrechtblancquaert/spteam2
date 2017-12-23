<?php
namespace App\Http\Controllers;
use Illuminate\Http\Request;
use App\Book;
class BooksController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $books = new Book;
        if (request()->has('BookID')) {
            $books=$books->where('BookID', request('BookID'));
        }
        if (request()->has('sort')){
            $books=$books->orderBy('title', request('sort'));
        }
        $books = $books->paginate(5)->appends([
            'BookID' => request('BookID'),
            'sort' => request('sort'),
        ]);
        
        return view('books.index', compact('books'));
        /*
        if (request()->has("BookID")) {
            $books = Book::where('BookID', request('BookID'))
            ->paginate(5)
            ->appends('BookID', request('BookID'));
        } else if (request()->has('sort')) {
            $books = Book::orderBy('title', request('sort'))
            ->paginate(5)->appends('sort', request('sort'));
        
        } else {
            $books = Book::paginate(5);
        }
*/
        //$books = BOOK::orderby('Title','asc')->paginate(10);
        //return view('books.index')->with('books',$books);
        
    }
    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('books.create');
    }
    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate($request,[
            'Title' => 'required',
            'Author' => 'required',
            'Description' => 'required',
            'ISBN' => 'required'  
       ]);
       //Create new post
       $book = new BOOK;
       $book->Title = $request->input('Title');
       $book->Author = $request->input('Author');
       $book->Description = $request->input('Description');
       $book->ISBN = $request->input('ISBN');
       $book->save();
       return redirect('/books')->with('success', 'Book Created');
    }
    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $book = BOOK::find($id);
        return view('books.show')->with('book',$book);
    
        //
    }
    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $book = BOOK::find($id);
        
                // Check for correct user
                //if(auth()->user()->id !== $survey->user_id){
                   // return redirect('/surveys')->with('error', 'Unauthorized Page');                --------------------
                //}
        
                return view('books.edit')->with('book',$book);
    }
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $this->validate($request, [
            'Title' => 'required',
            'Author' => 'required',
            'Description' => 'required',
            'ISBN' => 'required' 
        ]);
           
           //Create Post
           $book= BOOK::find($id);
           $book->Title = $request->input('Title');
           $book->Author = $request->input('Author');
           $book->Description = $request->input('Description');
           $book->ISBN = $request->input('ISBN');
           $book->save();
    
           return redirect('/books')->with('success', 'Book Updated');
    }
    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $book = BOOK::find($id);
        
               
                
        
                $book->delete();
                return redirect('/books')->with('success', 'Book Removed');
    }
}