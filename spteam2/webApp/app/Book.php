<?php
namespace App;
use Illuminate\Database\Eloquent\Model;
class Book extends Model
{
    protected $table = 'BOOK';
    public  $primaryKey='BookID';
         public $timestamps = false;
   
   
}