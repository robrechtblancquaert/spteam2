<!DOCTYPE HTML>
<html lang="en">
<head> 
    <meta charset="UTF-8"> 
    <title> Reminder </title> 
</head> 
<body> 
    <h1>{{$title}}</h1> 
    <p>{{$content}}</p>
    <h3>Dear, {{$username}}</h3>
    <h2 style ="color:lime"> Your Training has been approved</h2>
    <hr> 
    <h3><strong>Training Information</strong></h3> 
    <H3><strong>Requested Training (Approved)</strong>: {{$trainingsname}}</H3>
    <br>
    <H3><strong>Description</strong>: <br><hr>{!!$description!!}<hr> </H3> 
    <br>
    <H3><strong>Taking Place at this address </strong>: {{$location}} </H3>
    <br> 
    <h2 style="color:red">REMINDER: This Training will start on {{$date}}</h2>
    <br>

    <H3><strong>Thank You</strong></h3><H4>The HelixIR team<H4>
</body> 
</html>
