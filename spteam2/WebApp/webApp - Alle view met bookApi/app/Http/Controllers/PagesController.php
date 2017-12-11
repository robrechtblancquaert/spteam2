<?php

namespace App\Http\Controllers;

use DB;
use App\User;
use App\Post;
use App\Statistic;

use Illuminate\Http\Request;

class PagesController extends Controller
{
    public function index(){
        return view('pages.index');
    }

    public function about(){
        return view('pages.about');
    }

    public function services(){
        return view('pages.services');
    }

    public function statistics(){

        $data = DB::select('select distinct EMPLOYEE.EmployeeID, EMPLOYEE.Name, TRAINING.Trainingsname, TRAINING.DateTime, CERTIFICATION.CertificationName, STATISTIC.TrainingCount, STATISTIC.CertificationCount , STATISTIC.EmployeeName, STATISTIC.StatisticID, STATISTIC.user_name, users.name, users.id
        from EMPLOYEE join CERTIFICATION on EMPLOYEE.EmployeeID = CERTIFICATION.EmployeeID
        join TRAINING on TRAINING.TrainingID = CERTIFICATION.TrainingID
        join STATISTIC on STATISTIC.EmployeeName = EMPLOYEE.Name
        join users on EMPLOYEE.Name = users.name');

        $posts =  Post::all();
        //$user_id = auth()->user()->id;
        //$user = User::all();
        $user = DB::select('select distinct users.id, users.name
        from users');

        $statistics = STATISTIC::orderby('EmployeeName','asc')->paginate(10);
        $test = Statistic::with('user');

        return view('pages.statistics', compact('data', 'statistics', 'user', 'test'));

    }
}
