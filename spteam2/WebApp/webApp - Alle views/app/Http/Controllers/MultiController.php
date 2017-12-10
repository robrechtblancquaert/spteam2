<?php

namespace App\Http\Controllers;



use Illuminate\Http\Request;
use DB;

class MultiController extends Controller
{
    public function test(){
       
        $data=DB::select('select STATISTIC.TrainingName, TRAINING.Trainingsname, TRAINING.DateTime, CERTIFICATION.CertificationName
                        from STATISTIC join TRAINING on STATISTIC.TrainingName = TRAINING.Trainingsname
                        join CERTIFICATION on CERTIFICATION.TrainingID = TRAINING.TrainingID');

        return view('pages.showdata', compact('data'));
    }

}

// STATISTIC: TrainingName
//TRAINING: Trainingsname