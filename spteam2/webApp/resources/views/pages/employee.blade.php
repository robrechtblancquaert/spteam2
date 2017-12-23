
  @extends('layouts.app')
  
  
  @section('content')  
   
   
    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.6.2.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script> 

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

    <h1>{{$title}}</h1>
        <hr>
        
        <script id="employeeListTmpl" type="text/html">
               
           <div class="well">
            <div class="row" style="color:black">
                     <div class="col-md-8 col-sm-8">
                         
                            <h3><a href="/employeeInfo?id=${EmployeeID}">${FirstName} ${LastName}</a></h3> 
                     </div>
                </div>
            </div>
              
        </script>

        
        <div id="employeeList"></div>

        

        @endsection