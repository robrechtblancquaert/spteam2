@extends('layouts.app')

@section('content')

<div class="container">
    <div class="row">
        <div class="col-lg-12">
        <a href ="/home" class="btn btn-primary">Go Home</a>
        <hr>
            <div class="panel panel-default">
                <div class="panel-heading" id ="panel-general">General</div>
                
                <div class="panel-body">
                    

                    <a href ="/trainings/create" class="btn btn-primary">Request Training</a>
                    <h3> Your Requested Trainings </h3>
                    @if(count($trainings) > 0)
                    <table class="table table-striped">
                        <tr>
                            <th>Title</th>
                            <th></th>
                            <th></th>
                        </tr>
                        @foreach($trainings as $training)
                        <tr>
                            <td class = "generalBoardTrainingName" >{{$training->Trainingsname}}</td>
                            <td><a href="/trainings/{{$training->TrainingID}}/edit" class="btn btn-default" id="btnColor">Edit</a></td>
                            <td>
                                {!!Form::open(['action' => ['TrainingsController@destroy',$training->TrainingID], 'method' => 'POST','class' => 'pull-right'])!!}
                                {{Form::hidden('_method','DELETE')}}
                                {{Form::submit('Cancel',['class' => 'btn btn-danger'])}}
                                {!!Form::close()!!}
                            </td>
                        </tr>
                        @endforeach
                    </table>
                    @else
                        <p>You have no posts</p>
                    @endif

                </div>
            </div>
        </div>
    </div>
</div>
@endsection
