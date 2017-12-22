@extends('layouts.app')


@section('content')
    <h1>Certifications</h1>

        @foreach($certifications as $certification)
        <div class="well">
                <div class="row">
                    <div class="col-md-8 col-sm-8">
                  
                    <h3>{{$certification->Name}} </h3>
                    <h5> Certification Name: {{$certification->CertificationName}} </h5>
                    <h5> Certification Type: {{$certification->CertificationType}} </h5>
                    <h5> Certification Date: {{$certification->Date}} </h5> 
                    <h5> Training: <a href="/trainings/{{$certification->TrainingID}}"> {{$certification->Trainingsname}} </a> </h5> 
                   
                </div>
                </div>
                </div>
              
        @endforeach
    
@endsection

