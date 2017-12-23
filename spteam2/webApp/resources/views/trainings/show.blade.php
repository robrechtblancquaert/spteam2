<?php
use App\Training;
?>
@extends('layouts.app')

@section('content')
       <!-- <h1>{{$training->Trainingname}}</h1> -->

<a href="/trainings"  class="btn btn-primary">Go Back</a>
        <hr>
        @if(!Auth::guest())
        @if(Auth::user()->id == $training->user_id)
       <a href="/trainings/{{$training->TrainingID}}/edit" class="btn btn-default" id="btnColor">Edit</a>
       
        <hr>
        @endif
        @endif
        @if(Auth::user()->isHR())
        @if(!$training->Approved)
        
        
        {!!Form::close()!!} 
        
        <h2 style ="color:red">Still Pending Approval!</h2> 
        @else
        <h2 style ="color:Lime">Training Approved!</h2> 
        @endif
        <hr>
        @endif
        
        <h1>{{$training->Trainingsname}}</h1>
        
                <div >
                <!--Gebruik !! met 1 accolade in plaats van 2 accolades om html code vanuit de texteditor te kunnen parsen 
       -->        {!!$training->Description!!}
                
                </div>
       <hr>
                <div>
                        <H4>Location: {!!$training->Location!!}</H4>
                      
                </div>
                <div>
                <H4>Starting Date:  {!!$training->DateTime!!} </H4>
                     
                </div>
                <!--Functie om de locatie uit de database (die een string is) om te zetten naar coordinaten door gebruik te maken van google maps api -->
                <?php
                        $adress = $training->Location;
                        
                        
                        $adress = urlencode($adress);
                        $url = 'http://maps.googleapis.com/maps/api/geocode/xml?address=' . $adress . '&sensor=true';
                          $xml = simplexml_load_file($url);
                          $status = $xml->status;
                          if ($status == 'OK') {
                              $latitude = $xml->result->geometry->location->lat;
                              $longitude = $xml->result->geometry->location->lng;
                   ?>
                <!--Maakt een google map object aan en toont de locatie van de training door gebruik te maken van de functie hierboven -->
                <!--Bron : https://developers.google.com/maps/documentation/javascript/adding-a-google-map?refresh=1 -->                
                <div id="map"></div>
                        <script>
                        function initMap() {
                                var uluru = {lat: <?php echo $latitude; ?>, lng: <?php echo $longitude; ?>};
                                var map = new google.maps.Map(document.getElementById('map'), {
                                zoom:12 ,
                                center: uluru
                                });
                                var marker = new google.maps.Marker({
                                position: uluru,
                                map: map
                                });
                        }
                        </script>
                        <script async defer
                        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCxS_cNOtnfbgEjLX4UU_M1vLH7OKn8TX4&callback=initMap">
                        </script>

                        <?php        }


                ?>
                
                        <hr>
                        <p>Sometimes the map doesn't load up, refreshing while clearing the cache(ctrl+F5) will fix this issue</p>

       
@endsection