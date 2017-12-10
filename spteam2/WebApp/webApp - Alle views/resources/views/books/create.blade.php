@extends('layouts.app')

@section('content')
    <h1>Create Book</h1>
    {!! Form::open(['action' => 'BooksController@store','method' => 'POST', 'enctype'=> 'multipart/form-data']) !!}

        <div class="form-group">
            {{Form::label('Title', 'Title')}}
            {{Form::text('Title', '',['class' => 'form-control', 'placeholder' => 'Title'])}}
        </div>
        <div class="form-group">
            {{Form::label('Author', 'Author')}}
            {{Form::text('Author', '',['class' => 'form-control', 'placeholder' => 'Author'])}}
        </div>
        <div class="form-group">
            {{Form::label('Description', 'Description')}}
            {{Form::textarea('Description', '',['id' => 'article-ckeditor', 'class' => 'form-control', 'placeholder' => 'Type here the description'])}}
        </div>
        <div class="form-group">
            {{Form::label('ISBN', 'ISBN')}}
            {{Form::text('ISBN', '',['class' => 'form-control', 'placeholder' => 'ISBN'])}}
        </div>

    


        {{Form::submit('Submit', ['class' => 'btn btn-primary'])}}
    {!! Form::close() !!}

@endsection