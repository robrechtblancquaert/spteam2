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

 
<!--<li>test0: {{$data[0]->name}}, {{$data[0]->id}}</li>
<li>test1: {{$data[1]->name}}, {{$data[1]->id}}</li>
<li>test2: {{$data[2]->name}}, {{$data[2]->id}}</li>
<li>test: {{count($data)}}</li>
<li>test: {{count($ori)}}</li>-->

</ul>
<hr>
@endif
@endforeach

<h3>Totaal aantal trainingen gevolgd door iedereen: {{$counter}}   </h3>

@endsection