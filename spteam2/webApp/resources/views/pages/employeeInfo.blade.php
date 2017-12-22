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
    <script type="text/javascript" src="date.js"></script>

  <script>
            function getParam(name){
                if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
                return decodeURIComponent(name[1]);
            }
            var id = getParam("id");
            

            jQuery(document).ready(function () {
            var query = "http://services.odata.org/v2/northwind/northwind.svc/Employees("+id+")" //root uri
            + "?$select=EmployeeID,FirstName, LastName, BirthDate, Title, HireDate" //reduce the payload to what we need
           //+ "&$orderby=EmployeeID%20asc" //order by and sort by the latest shows
            //+ "&$top=2" //take the top 5
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
    
    </div>  
        

                
       <p class="greetind-id"></p>
       
       <script>
       $(document).ready(function() {
           $.ajax({
       url: "http://services.odata.org/V4/Northwind/Northwind.svc/Employees("+id+")"
       }).then(function(data) {
      $('.greeting-id').append(data.EmployeeID);
      $('.age').append("Age: "+data.BirthDate.substring(0,9));
      $('.hire').append("Joined: "+ data.HireDate.substring(0,9));

       });
       });
   
      
       </script>
        <?php
       // $dateFromDB;// put your info in this variable
        //$toCovert=strtotime($dateFromDB);
        //$toOutput("j-n-Y",$toCovert);// "j-n-Y", is the pattern you want the date output as, in this case DAY-MONTH-YEAR NUMERIC. 
        //echo $toOutput;
        ?>

        <script id="employeeListTmpl" type="text/html">
        <h1 id="employee">Information About ${FirstName} ${LastName}</h1><br><br>
         
        <div id="infoEmployee">
                <p class="employees">Employee Full Name: ${FirstName} ${LastName} </p>
                <br>
                <p class="age"></p>
                <br>
                <p class="hire"></p>
                <br>
                <p>Function: ${Title} <br><br>
              
        </div>
        
</script>

        <div id="employeeList"></div>
        
       
   </body>
</html>