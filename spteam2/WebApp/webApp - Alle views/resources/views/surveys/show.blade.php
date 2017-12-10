@extends('layouts.app')

@section('content')
       

<a href="/surveys"  class="btn btn-default">Go Back</a>
        <h1>Surveyname: {{$survey->Surveyname}}</h1>
        <hr>
        <hr>
                <div >
                 
       <h3>Seminars: {{$survey->Seminars}}</h3>
       <hr>
       <h3>Survey Submitted By: {!!$survey->user_id!!}</h3>
       <hr>
       <h3>Content: {!!$survey->Content!!}</h3>
       <hr>
       <h3>Rating: {!!$survey->Rating!!}/5</h3>
       <hr>
       <h3>TrainingID: {!!$survey->TrainingID!!}</h3>
       <hr>
       <h3>EmployeeID: {!!$survey->EmployeeID!!}</h3>
                
                </div>
       <hr>
      
       <a href="/surveys/{{$survey->SurveyID}}/edit">Edit</a>
       {!!Form::open(['action' => ['SurveysController@destroy',$survey->SurveyID], 'method' => 'POST','class' => 'pull-right'])!!}
                {{Form::hidden('_method','DELETE')}}
                {{Form::submit('Delete',['class' => 'btn btn-danger'])}}
        
        {!!Form::close()!!} 
       
@endsection