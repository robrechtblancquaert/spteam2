@extends('layouts.app')


@section('content')
    <h1>Surveys</h1>
    <a href="/surveys/create" class="btn btn-primary">Create Survey</a>
    <hr>
    @if(count($surveys) > 0)

        @foreach($surveys as $survey)
              <div class="well">
                <div class="row">
                    <div class="col-md-8 col-sm-8">
                  
                    <h3> <a href="/surveys/{{$survey->SurveyID}}">{{$survey->Surveyname}}</a></h3>
                </div>
                </div>
                </div>
        @endforeach
    @else
    <p>No Surveys Found.</p>
    @endif
@endsection