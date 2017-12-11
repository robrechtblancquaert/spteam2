@extends('layouts.app')

@section('content')
      

<h1 class="text-center">Statistics</h1>
<h3>Overzicht van alle opleidingen per personeelslid, wie volgde meeste trainigen in jaar X, welke certificaten heeft welk personeelslid, enz...</h3>

    <!--index:  Naam|Totaal aantal trainingen|Aantal certificaten
    Naam:   Opleiding |met certificaat|In jaar-->
        

    @foreach($statistics as $statistic)

@for($i=0, $count= count($data); $i < $count; $i++)

@if($data[$i]->name==$statistic->EmployeeName)




<ul> 
<h1>{{$data->Name}} </h1> 

<li>Gevolgde training: {{$data->Trainingsname}}</li>
<li>Behaald certificaat: {{$data->CertificationName}}</li>
<li>Op datum: {{$data->DateTime}}</li>

<li>Totaal aantal trainingen gevolgd door iedereen: {{$loop->count}}   </li>
<li>test0: {{$data[0]->name}}, {{$data[0]->id}}</li>
<li>test1: {{$data[1]->name}}, {{$data[1]->id}}</li>
<li>test2: {{$data[2]->name}}, {{$data[2]->id}}</li>
</ul>
<hr>

@endif

@endfor


@endforeach

@endsection



    