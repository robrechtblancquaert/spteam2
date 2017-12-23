
  @extends('layouts.app')
  
  
  @section('content') 

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
            + "?$select=EmployeeID,FirstName, LastName, BirthDate, Title, HireDate , HomePhone , Address , City , PostalCode" //reduce the payload to what we need
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
      
       <p class="greetind-id"></p>
       
       <script>
       $(document).ready(function() {
           $.ajax({
       url: "http://services.odata.org/V4/Northwind/Northwind.svc/Employees("+id+")"
       }).then(function(data) {
      $('.greeting-id').append(data.EmployeeID);
      $('.birthdate').append("Birthdate: "+data.BirthDate.substring(0,9));
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

        <a href="/employee"  class="btn btn-primary">Go Back</a>
        <script id="employeeListTmpl" type="text/html">
        <h1>Information About ${FirstName} ${LastName}</h1>
         <hr><hr>
        <div id="infoEmployee">
                <h3 class="employees">Employee Full Name: ${FirstName} ${LastName} </h3>
                <hr>
                <h3 class="birthdate"></h3>
                <hr>
                <h3 class="hire"></h3>
                <hr>
                <h3>Function: ${Title} </h3>
                <hr>
                <h3>Phone number : ${HomePhone}</h3>
                <hr>
                <h3>Address : ${Address} ${City} ${PostalCode}</h3>
                <hr>
        </div>
        
</script>

        <div id="employeeList"></div>
        
       
        @endsection