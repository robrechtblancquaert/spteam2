@extends('layouts.app')

@section('content')
<!--
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Dashboard</div>

                <div class="panel-body">
                    

                    <a href ="/trainings/create" class="btn btn-primary">Request Training</a>
                    <h3> Your Requested Trainings </h3>
                    <table class="table table-striped">
                        <tr>
                            <th>Title</th>
                            <th></th>
                            <th></th>
                        </tr>
                        @foreach($trainings as $training)
                        <tr>
                            <td>{{$training->Trainingsname}}</td>
                            <td><a href="/trainings/{{$trainings->TrainingID}}/edit" class="btn btn-default">Edit</a></td>
                            <td>
                                {!!Form::open(['action' => ['TrainingsController@destroy',$training->TrainingID], 'method' => 'POST','class' => 'pull-right'])!!}
                                {{Form::hidden('_method','DELETE')}}
                                {{Form::submit('Delete',['class' => 'btn btn-danger'])}}
                                {!!Form::close()!!}
                            </td>
                        </tr>
                        @endforeach
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
-->