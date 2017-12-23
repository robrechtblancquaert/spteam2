<?php
namespace App;
use Illuminate\Database\Eloquent\Model;
class Statistic extends Model
{
    protected $table = 'STATISTIC';
  
    public  $primaryKey='StatisticID';
    public $timestamps = false;
   
   
    
    public function user(){
        return $this->belongsTo('App\User');
    }
    
}