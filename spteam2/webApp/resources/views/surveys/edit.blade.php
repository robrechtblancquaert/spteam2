@extends('layouts.app')

@section('content')
    <h1>Edit Survey</h1>
    {!! Form::open(['action' => ['SurveysController@update', $survey->id],'method' => 'POST','enctype'=> 'multipart/form-data']) !!}
    <div class="form-group">
    {{Form::label('Surveyname', 'Survey Name')}}
    {{Form::text('Surveyname', '',['class' => 'form-control', 'placeholder' => 'Name of the survey'])}}
    </div>
    <div class="form-group">
    {{Form::label('Seminars', 'Seminars')}}
    {{Form::text('Seminars', '',['class' => 'form-control', 'placeholder' => 'Number of seminars'])}}
    </div>
    <div class="form-group">
    {{Form::label('Content', 'Content')}}
    {{Form::textarea('Content', '',['id' => 'article-ckeditor', 'class' => 'form-control', 'placeholder' => 'Type here the content'])}}
    </div>
    <div class="form-group">
    {{Form::label('Rating', 'Rating')}}
    {{Form::text('Rating', '',['class' => 'form-control', 'placeholder' => 'Rating (from 0 to 5)'])}}
    </div>

    <div class="form-group">
    {{Form::label('TrainingID', 'TrainingID')}}
    {{Form::text('TrainingID', '',['class' => 'form-control', 'placeholder' => 'ID of training'])}}
    </div>
    <div class="form-group">
    {{Form::label('EmployeeID', 'EmployeeID')}}
    {{Form::text('EmployeeID', '',['class' => 'form-control', 'placeholder' => 'ID of employee'])}}
    </div>
        {{Form::hidden('_method', 'PUT')}}
        {{Form::submit('Submit', ['class' => 'btn btn-primary'])}}
    {!! Form::close() !!}

@endsection