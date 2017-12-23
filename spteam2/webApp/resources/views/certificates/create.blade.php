@extends('layouts.app')


@section('content')
   <h1>Insert certificate</h1>

   {!! Form::open(['action' => 'CertificateController@store','method' => 'POST', 'enctype'=> 'multipart/form-data']) !!}

       <div class="form-group">
           {{Form::label('CertificationName', 'Certificate name')}}
           {{Form::text('CertificationName', '',['class' => 'form-control', 'placeholder' => 'Certificate name'])}}
       </div>
       <div class="form-group">
           {{Form::label('CertificationType', 'Certificate type')}}
           {{Form::text('CertificationType', '',['class' => 'form-control', 'placeholder' => 'Certificate type'])}}
       </div>

       <div class="form-group">
           {{Form::label('TrainingID', 'TrainingID')}}
           {{Form::text('TrainingID', '',['class' => 'form-control', 'placeholder' => 'TrainingID'])}}
       </div>
       <div class="form-group">
           {{Form::label('EmployeeID', 'EmployeeID')}}
           {{Form::text('EmployeeID', '',['class' => 'form-control', 'placeholder' => 'EmployeeID'])}}
       </div>
       <div class="form-group" style="color:black">
            {{Form::label('Date', 'Date')}}
            {{Form::date('Date', \Carbon\Carbon::now())}}
        </div>
       <div class="form-group">
            {{Form::file('Image')}}
        </div>

       {{Form::submit('Submit', ['class' => 'btn btn-primary'])}}
   {!! Form::close() !!} 
   
@endsection