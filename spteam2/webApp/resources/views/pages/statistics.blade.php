@extends('layouts.app')

@section('content')

<h1 class="text-center">Statistics</h1>
<h3>Overzicht van alle opleidingen per personeelslid, welke certificaten heeft welk personeelslid, enz...</h3>

       
  <?php $counter = 0; ?>
  <?php $count = 0; ?>

@foreach($data as $ori)


<?php $counter++; ?>

@if($ori->Name ==  $ori->name)

<ul> 
<h1>{{$ori->Name}} </h1> 

<li>Gevolgde training: {{$ori->Trainingsname}}</li>
<li>Behaald certificaat: {{$ori->CertificationName}}</li>
<li>Op datum: {{$ori->DateTime}}</li>

</ul>
<hr>
@endif
@endforeach

<h3>Totaal aantal trainingen gevolgd door iedereen: {{$counter}}   </h3>

@endsection