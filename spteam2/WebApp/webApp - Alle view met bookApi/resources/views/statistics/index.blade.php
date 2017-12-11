@extends('layouts.app')


@section('content')
    <h1>Statistics</h1>

    <hr>
    @if(count($statistics) > 0)

        @foreach($statistics as $statistic)
              <div class="well">
                <div class="row">
                    <div class="col-md-8 col-sm-8">
                  
                    <h3> <a href="/statistics/{{$statistic->EmployeeName}}">{{$statistic->EmployeeName}}</a></h3>
                    <small>Amount of trainings: {{$statistic->TrainingCount}}</small>
                   
                    <small>Amount of certifications: {{$statistic->CertificationCount}} </small>
                </div>
                </div>
                </div>
        @endforeach
    @else
    <p>No statistics Found.</p>
    @endif
@endsection

