@extends('layouts.app')

@section('content')
     

<a href="/books"  class="btn btn-default">Go Back</a>
       <h1><a href="https://books.google.be/books?id={!!$book->ISBN!!}">{{$book->Title}}</a></h1>
     
     
       <div style="clear: left;">
         <p style="float: left;"><img src="http://books.google.com/books/content?id={!!$book->ISBN!!}&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"  border="1px"></p>
         <h3>Author: {{$book->Author}}</h3>
      <br>
      <h3>Description: <br>{!!$book->Description!!}</h3>
      <br>
      <h3>ISBN: {!!$book->ISBN!!}</h3>
       </div>
       <hr>
     
      <a href="/books/{{$book->BookID}}/edit">Edit</a>
      {!!Form::open(['action' => ['BooksController@destroy',$book->BookID], 'method' => 'POST','class' => 'pull-right'])!!}
               {{Form::hidden('_method','DELETE')}}
               {{Form::submit('Delete',['class' => 'btn btn-danger'])}}
       
       {!!Form::close()!!}
      
@endsection