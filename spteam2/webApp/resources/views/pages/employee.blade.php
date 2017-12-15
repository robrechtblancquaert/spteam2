@extends('layouts.app')

@section('content')
<!-- scripts -->
    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.6.2.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script> <!-- http://api.jquery.com/category/plugins/templates/ -->
   
  
     <script>
            jQuery(document).ready(function () {
            var query = "http://services.odata.org/v2/northwind/northwind.svc/Employees" //root uri
            + "?$select=EmployeeID,FirstName, LastName" //reduce the payload to what we need
            + "&$orderby=EmployeeID%20asc" //order by and sort by the latest shows
            + "&$top=10" //take the top 10
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
 <!-- end -->

 <!-- content -->
    <h1 id="employee">{{$title}}</h1>
    </div>
        
        <script id="employeeListTmpl" type="text/html">
        
                <p id="employeeItem">${FirstName} ${LastName}</p>
                
        </script>

        
        <div id="employeeList"></div>
    
       
@endsection
