@extends('layouts.app')


<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css">
@section('content')
    <h1>Surveys</h1>
    <a href="/surveys/create" class="btn btn-primary">Fill In Survey</a>
    <br>
    <br>
    Sort:
            <a href="{{route('surveys.index', ['SurveyID' => request('SurveyID'), 'sort' => 'asc'])}}">Ascending</a>
            <a href="{{route('surveys.index', ['SurveyID' => request('SurveyID'), 'sort' => 'desc'])}}">Descending</a>

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