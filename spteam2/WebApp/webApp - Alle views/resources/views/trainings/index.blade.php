@extends('layouts.app')


@section('content')
    <h1>Trainings</h1>
    @if(count($trainings) > 0)

        @foreach($trainings as $training)
                <div class="row">
                    <div class="col">
                  
                    <h3> <a href="/trainings/{{$training->TrainingID}}">{{$training->Trainingname}}</a></h3>
                </div>
                </div>
        @endforeach
    @else
    <p>No Trainings Found.</p>
    @endif
@endsection