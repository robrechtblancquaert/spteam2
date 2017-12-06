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

    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.6.2.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script> <!-- http://api.jquery.com/category/plugins/templates/ -->

     <script>
            jQuery(document).ready(function () {
            var query = "http://services.odata.org/v2/northwind/northwind.svc/Employees" //root uri
            + "?$select=EmployeeID,FirstName, LastName" //reduce the payload to what we need
            + "&$orderby=EmployeeID%20asc" //order by and sort by the latest shows
            + "&$top=10" //take the top 5
            + "&$format=json" //give me json
            + "&$callback=callback"; //this is my callback

             jQuery.ajax({
                dataType: 'jsonp',
                url: query,
                jsonpCallback: 'callback',
                success: callback
            });

            function callback(result) {
                var shows = result.d;
                jQuery('#employeeListTmpl').tmpl(shows).appendTo('#employeeList');
            }
        });

        </script>
</head>
<body>
    <!-- nav bar -->
    <div id="app">
        
        @include('inc.navbar')
        <div class ="container">
            @include('inc.messages')
            @yield('content')
        </div>
    </div>
    <h1 id="employee">{{$title}}</h1>
    </div>
        
        <script id="employeeListTmpl" type="text/html">
            <ul>
                
                <li id="employeeItem">${FirstName} ${LastName}</li> 
                
            </ul> 

           
        </script>

        <img src = "http://accweb/emmployees/davolio.bmp">
        <div id="employeeList"></div>

   
</body>
</html>
