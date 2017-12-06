<!DOCTYPE html>
<html lang="{{ app()->getLocale() }}">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSRF Token -->
    <meta name="csrf-token" content="{{ csrf_token() }}">

    <title>{{ config('app.name', 'Laravel') }}</title>

    <!-- Styles -->
    <link href="{{ asset('css/app.css') }}" rel="stylesheet">
</head>
<body>
    <div id="app">
        
        @include('inc.navbar')
        <div class ="container"id="outer">
            @include('inc.messages')
            
        <div class="album " id ="middle" >
            <div class="container" id="inner">

                <div class="row" >
                    <a href="/trainings">
                        <div class="card" id="homeMenu">
                            <H1 id="colorHomeMen">Trainings</H1>
                            <p id="colorHomeMen">WIP->Karim</p>
                        </div>
                    </a>

                    <a href="/surveys">
                        <div class="card" id="homeMenu">
                            <H1 id="colorHomeMen"><a href="/surveys">Surveys </a></H1>
                            <p id="colorHomeMen">WIP ->TOM</p>
                        </div>
                    </a>

                    <a href="/general">
                        <div class="card" id="homeMenu">
                            <H1 id="colorHomeMen">Profile</H1>
                            <p id="colorHomeMen">WIP->Karim</p>
                        </div>
                    </a>

                    <a href="/settings">
                        <div class="card" id="homeMenu">
                            <H1 id="colorHomeMen">Settings</H1>
                            <p id="colorHomeMen">WIP->Dayan</p>
                        </div>
                    </a>
                </div>
            </div>
        </div>


        </div>
    </div>

    <!-- Scripts -->
    <script src="{{ asset('js/app.js') }}"></script>
     <script src="/vendor/unisharp/laravel-ckeditor/ckeditor.js"></script>
    <script>
        CKEDITOR.replace( 'article-ckeditor' );
    </script>
</body>
</html>
