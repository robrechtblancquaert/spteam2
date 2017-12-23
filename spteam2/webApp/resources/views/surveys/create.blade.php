@extends('layouts.app')

@section('content')
    <h1>Fill In Survey</h1>
    {!! Form::open(['action' => 'SurveysController@store','method' => 'POST', 'enctype'=> 'multipart/form-data']) !!}

        <div class="form-group">
            {{Form::label('Surveyname', 'Survey Name')}}
            {{Form::text('Surveyname', '',['class' => 'form-control', 'placeholder' => 'Survey Name'])}}
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
            {{Form::text('Rating', '',['class' => 'form-control', 'placeholder' => 'Rating'])}}
        </div>

        <div class="form-group">
            {{Form::label('TrainingID', 'TrainingID')}}
            {{Form::text('TrainingID', '',['class' => 'form-control', 'placeholder' => 'TrainingID'])}}
        </div>
        <div class="form-group">
            {{Form::label('EmployeeID', 'EmployeeID')}}
            {{Form::text('EmployeeID', '',['class' => 'form-control', 'placeholder' => 'EmployeeID'])}}
        </div>


        {{Form::submit('Submit', ['class' => 'btn btn-primary'])}}
    {!! Form::close() !!}

@endsection