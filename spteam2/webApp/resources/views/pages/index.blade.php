
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
        
        
        <div class ="container">
            @include('inc.messages')
           
       <div class="jumbotron text-center" id="jumbTronLogin">
            <h1 id="colorJumb"> Welcome to HelixIR!</h1>
            <p  id="colorJumb">This is our official web application for the HelixIR Training tool.</p>
            <hr>
            <p><a class ="btn btn-primary btn-lg" href="/login" role="button" id="buttonLoginColor">Login</a></p>
            <p><a class ="btn btn-primary btn-lg" href="/register" role="button" id="buttonLoginColor">Login</a></p>
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



