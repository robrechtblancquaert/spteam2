@extends('layouts.app')

@section('content')
       <?php 
        session_start();
    ?>
    <h1>{{$title}}</h1>
    <h3 id="title">Change the style </h3>
    <button id="test" type="button" onclick="changeColor()">Default</button>
       <!-- <button type="button" onclick="myGray()">Light Gray</button>
        <button type="button" onclick="myBlue()">Blue</button> -->

    <!--<h3>Change Logo</h3> -->
    <div class="color" id="change" style="width:100% , height:100%;">
        <p>test</p>

    <div>
   <script>
    function changeColor(){
        $('#change').toggleClass('clicked');
        $('#change').toggleClass('color');
        if(typeof(Storage) !== "undefined") {
            localStorage.setItem("color", $('#change').attr('class'));
        }
      }

      $(document).ready(function(){

    if(typeof(Storage) !== "undefined" && localStorage.getItem("color") !='') {
        $('#change').attr('class','');
        $('#change').attr('class', localStorage.getItem("color"));
    }
    });

   
   
   </script>
       
@endsection
