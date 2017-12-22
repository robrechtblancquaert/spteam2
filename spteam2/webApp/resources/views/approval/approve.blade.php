@extends('layouts.app')

@section('content')
        <h1>Edit Training</h1>
        {{ Form::model($training, array('route' => array('approval.update', $training->TrainingID), 'files' => true, 'method' => 'PUT')) }}
            <div class ="form-group">
                {{Form::label('Trainingsname','Training Name')}}
                {{Form::text('Trainingsname',$training->Trainingsname,['class' => 'form-control','placeholder' =>'Trainingsname'])}}
            </div>
            <div class ="form-group">
                {{Form::label('Description','Description of Training')}}
                {{Form::textarea('Description',$training->Description,['id' =>'article-ckeditor','class' => 'form-control','placeholder' =>'Description Text'])}}
            </div>
            <div class ="form-group">
                {{Form::label('Location','Taking place at (address)')}}
                {{Form::text('Location',$training->Location,['class' => 'form-control','placeholder' =>'Taking place at (address)'])}}
            </div>


        <div class ="form-group">
                {{Form::label('DateTime','When')}}
                {{Form::date('DateTime', \Carbon\Carbon::now())}}
            </div>

            {{Form::hidden('_method','PUT')}}    
            {{Form::submit('Approve Training', ['class' => 'btn btn-success'])}}
        {!! Form::close() !!}   
       
@endsection