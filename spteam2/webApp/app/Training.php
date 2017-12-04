<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Training extends Model
{
 //Tabel Naam
 protected $table = 'TRAINING';
 //PK    
 public  $primaryKey='TrainingID';
 //Timestamps
 public $timestamps = false;
// Functie om trainingen op te zoeken

public function trainingSearch($query,$search){
//return $query->where('title','LIKE', %search% );

}
}
