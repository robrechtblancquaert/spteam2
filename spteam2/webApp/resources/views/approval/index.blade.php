@extends('layouts.app')


@section('content')
    <h1>Trainings needing Approval</h1>
    <div class="container mt-5">
    <div class="card-deck">
    @if(count($trainings) > 0)

        @foreach($trainings as $training)
                
                  
                    
                            
                                <div class="card" style="width: 20rem;">
                                <img class="card-img-top" src="..." alt="">
                                <div class="card-block">
                                    <h4 class="card-title">{{$training->Trainingsname}}</h4>
                                    <p class="card-text"></p>
                                    <a href="/approval/{{$training->TrainingID}}" class="btn btn-primary" id="btnTraining" >
                                        <p id="titleTraining">{{$training->Trainingsname}}</p>
                                    </a>
                                </div>
                                </div>
                                
                                
        @endforeach
    @else
    <p>No Trainings Found.</p>
    @endif
    </div>
    </div>
@endsection