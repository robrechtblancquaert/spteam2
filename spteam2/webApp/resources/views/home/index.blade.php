@extends('layouts.app')
    
@section('content')
 <body>
 <div class ="midden" align ="center">
     <div class="card" style="width: 50rem;" id="homeDiv">
       <a href="/trainings">
         <img class="img" img src="{{URL::asset('/img/training.jpg')}}" alt="profile Pic" height="250" width="300">
       </a>
         <div class="card-body">
          <h4>Trainings</h4>
         </div>
       </div>

<div class="card" style="width: 50rem;" id="homeDiv">
       <a href="/employee">
         <img class="img" img src="{{URL::asset('/img/em.jpg')}}" alt="profile Pic" height="250" width="300">
       </a>
         <div class="card-body">
          <h4>Employees</h4>
         </div>
       </div>
<p></p>
        <div class="card" style="width: 50rem;" id="homeDiv">
       <a href="/books">
         <img class="img" img src="{{URL::asset('/img/books.jpg')}}" alt="profile Pic" height="250" width="300">
       </a>
         <div class="card-body">
          <h4 class="card-title">Books</h4>
         </div>
       </div>

        <div class="card" style="width: 50rem;" id="homeDiv">
       <a href="/surveys">
         <img class="img" img src="{{URL::asset('/img/survey.jpg')}}" alt="profile Pic" height="250" width="300">
       </a>
         <div class="card-body">
          <h4 class="card-title">Survey</h4>
         </div>
       </div>
     </body>
 @stop