@extends('layouts.app')

@section('content')
      

<a href="/books"  class="btn btn-default">Go Back</a>
        <h1>Title: {{$book->Title}}</h1>
        <hr>
        <hr>
                <div >
                
       <h3>Author: {{$book->Author}}</h3>
       <hr>
       <h3>Description: {!!$book->Description!!}</h3>
       <hr>
       <h3>ISBN: {!!$book->ISBN!!}</h3>
                
                </div>
       <hr>
      
       <a href="/books/{{$book->BookID}}/edit">Edit</a>
       {!!Form::open(['action' => ['BooksController@destroy',$book->BookID], 'method' => 'POST','class' => 'pull-right'])!!}
                {{Form::hidden('_method','DELETE')}}
                {{Form::submit('Delete',['class' => 'btn btn-danger'])}}
        
        {!!Form::close()!!} 
       
@endsection