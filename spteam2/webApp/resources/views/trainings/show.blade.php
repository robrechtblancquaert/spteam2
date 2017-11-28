@extends('layouts.app')

@section('content')
       <!-- <h1>{{$training->Trainingname}}</h1> -->

<a href="/trainings"  class="btn btn-primary">Go Back</a>
        <h1>{{$training->Trainingsname}}</h1>
        
                <div >
                <!--Gebruik !! met 1 accolade in plaats van 2 accolades om html code vanuit de texteditor te kunnen parsen 
       -->        {!!$training->Description!!}
                
                </div>
       <hr>
                <div>
                        <H4>Location: {!!$training->Location!!}</H4>
                      
                </div>
                <div>
                <H4>Starting Date:  {!!$training->DateTime!!} </H4>
                       
                </div>
        @if(!Auth::guest())
        @if(Auth::user()->id == $training->user_id)
       <a href="/trainings/{{$training->TrainingID}}/edit">Edit</a>
       {!!Form::open(['action' => ['TrainingsController@destroy',$training->TrainingID], 'method' => 'POST','class' => 'pull-right'])!!}
                {{Form::hidden('_method','DELETE')}}
                {{Form::submit('Delete',['class' => 'btn btn-danger'])}}
        
        {!!Form::close()!!} 
        @endif
        @endif
@endsection