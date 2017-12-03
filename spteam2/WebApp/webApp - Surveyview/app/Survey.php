<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Survey extends Model
{
 //Tabel Naam
 protected $table = 'SURVEY';
 //PK    
 public  $primaryKey='SurveyID';
 //Timestamps
 public $timestamps = false;
// Functie om trainingen op te zoeken

public function surveySearch($query,$search){
//return $query->where('title','LIKE', %search% );

}

}
