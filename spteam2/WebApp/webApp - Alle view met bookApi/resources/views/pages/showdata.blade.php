<html>
<head>
    <title></title>
</head>
<body>
Multi database data
<ul> </ul>
@foreach($data as $ori)

<li>Training: {{$ori->Trainingsname}} ,met certificaat: {{$ori->CertificationName}} ,op datum: {{$ori->DateTime}}</li>
@endforeach
</body>
</html>
