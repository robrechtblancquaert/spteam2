<?php
namespace App\Http\Controllers;
use Illuminate\Http\Request;
use App\Survey;
class SurveysController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //$surveys = SURVEY::all();
        $surveys = SURVEY::orderby('Surveyname','asc')->paginate(10);
        return view('surveys.index')->with('surveys',$surveys);
        //
        //$posts =  Post::all();
        //$posts = Post::orderby('created_at','desc')->paginate(10);
        //return view('posts.index')->with('posts',$posts);
        //
    }
    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('surveys.create');
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
            'Surveyname' => 'required',
            'Seminars' => 'required',
            'Content' => 'required',
            'Rating' => 'required',
            'TrainingID' => 'required',
            'EmployeeID' => 'required'
       ]);
       //Create new post
       $survey = new SURVEY;
       $survey->Surveyname = $request->input('Surveyname');
       $survey->Seminars = $request->input('Seminars');
       $survey->Content = $request->input('Content');
       $survey->Rating = $request->input('Rating');
       $survey->TrainingID = $request->input('TrainingID');
       $survey->EmployeeID = $request->input('EmployeeID');
       $survey->user_id = auth()->user()->id;
       $survey->save();
       return redirect('/surveys')->with('success', 'Survey Created');
    }
    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $survey = SURVEY::find($id);
        return view('surveys.show')->with('survey',$survey);
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
        $survey = SURVEY::find($id);
        
                // Check for correct user
                //if(auth()->user()->id !== $survey->user_id){
                   // return redirect('/surveys')->with('error', 'Unauthorized Page');        
                //}
        
                return view('surveys.edit')->with('survey',$survey);
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
            'Surveyname' => 'required',
            'Seminars' => 'required',
            'Content' => 'required',
            'Rating' => 'required',
            'TrainingID' => 'required',
            'EmployeeID' => 'required'
        ]);
           
           //Create Post
           $survey= SURVEY::find($id);
           $survey->Surveyname = $request->input('Surveyname');
           $survey->Seminars = $request->input('Seminars');
           $survey->Content = $request->input('Content');
           $survey->Rating = $request->input('Rating');
           $survey->TrainingID = $request->input('TrainingID');
           $survey->EmployeeID = $request->input('EmployeeID');
           
           $survey->save();
           return redirect('/surveys')->with('success', 'Post Updated');
    }
    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $survey = SURVEY::find($id);
        
                // Check for correct user
                //if(auth()->user()->id !== $survey->user_id){                        
                  //  return redirect('/surveys')->with('error', 'Unauthorized Page');
                //}
                
        
                $survey->delete();
                return redirect('/surveys')->with('success', 'Post Removed');
    }
}