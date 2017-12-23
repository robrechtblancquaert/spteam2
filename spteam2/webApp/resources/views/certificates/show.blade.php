@extends ('layouts.app');

@section('content')
  <style>
    .certImage {

        width:40% ; 
        margin: auto; 
        display:block;
    }

  </style>
  
  
     <h1>Certificate</h1>
     <hr>
    <br><br>
    <img class="certImage"src="/storage/images/{{$certifications->Image}}">
    <a href="/certifications" class="btn btn-primary"> Go back </a>
    
@endsection