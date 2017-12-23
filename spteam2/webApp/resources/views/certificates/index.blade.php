@extends('layouts.app')


@section('content')
   <h1>Certifications</h1>
   <a href="/certifications/create" class="btn btn-primary">Insert Certificate</a>
   <hr>
       @foreach($certifications as $certification)
       <div class="well">
               <div class="row" style="color:black">
                   <div class="col-md-4 col-sm-4">
                            <a href="/certifications/{{$certification->CertificationID}}"><img  style="width:80%"src="/storage/images/{{$certification->Image}}"></a>
                    </div>
                    <div class="col-md-8 col-sm-8">
                        
                        <h3>Certification Name: {{$certification->CertificationName}}<h3>
                    <h3> Certification Type: {{$certification->CertificationType}} <h3>
                    <h3> Certification Date: {{$certification->Date}} <h3>
                    <h3> Training: <a href="/trainings/{{$certification->TrainingID}}"> {{$certification->Trainingsname}} </a> <h3>
                         
                    </div>
               </div>
               </div>
             
       @endforeach
   
@endsection