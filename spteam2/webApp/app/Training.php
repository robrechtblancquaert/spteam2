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

public function user(){
    return $this->belongsTo('App\User');
}

public function trainingSearch($query,$search){
//return $query->where('title','LIKE', %search% );

}
//Approve Training
public function isPending(){
    return $this->approveCheck(0);
}
public function isApproved(){
    return $this->approveCheck(1);
}
protected function approveCheck($approved = 0) {
    return $this->Approved === $approved ? true : false;
}
}
