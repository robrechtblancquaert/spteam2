<?php
use App\Training;
?>
@extends('layouts.app')

@section('content')
       <!-- <h1>{{$training->Trainingname}}</h1> -->

<a href="/trainings"  class="btn btn-primary">Go Back</a>
        <hr>
        @if(Auth::user()->isHR())
        @if(!$training->Approved)
        <a href="/approval/{{$training->TrainingID}}/edit" class="btn btn-success">Approve</a>
        
        {!!Form::close()!!} 
        
        <h2 style ="color:red">Still Pending Approval!</h2> 
        @else
        <h2 style ="color:Lime">Training Approved!</h2> 
        @endif
        <hr>
        @endif
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
                              
               

                       

       
@endsection