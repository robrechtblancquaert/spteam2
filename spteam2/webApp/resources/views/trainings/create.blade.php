@extends('layouts.app')

@section('content');
        <h1>Create Training</h1>
        {!! Form::open(['action' => 'TrainingsController@store','method' => 'POST']) !!}
            <div class ="form-group">
                {{Form::label('Trainingsname','Training Name')}}
                {{Form::text('Trainingsname','',['class' => 'form-control','placeholder' =>'Training Name'])}}
            </div>
            <div class ="form-group">
                {{Form::label('Description','Description of Training')}}
                {{Form::textarea('Description','',['id' =>'article-ckeditor','class' => 'form-control','placeholder' =>'Description Text'])}}
            </div>
            <div class ="form-group">
                {{Form::label('Location','Taking place at (address)')}}
                {{Form::text('Location','',['class' => 'form-control','placeholder' =>'Taking place at (address)'])}}
            </div>
        <div class ="form-group">
                {{Form::label('DateTime','When')}}
                {{Form::date('DateTime', \Carbon\Carbon::now())}}
            </div>


            {{Form::submit('Submit', ['class' => 'btn btn-primary'])}}
        {!! Form::close() !!}   
       
@endsection