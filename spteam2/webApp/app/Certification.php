<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Certification extends Model
{
    protected $table = 'CERTIFICATION';
    public  $primaryKey='CertificationID';
         public $timestamps = false;
}
