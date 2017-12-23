<?php

namespace App\Http\Controllers;
use DB;
use Illuminate\Http\Request;
use App\User;
use App\Statistic;
use App\Certification;
use App\Training;


class PagesController extends Controller
{
    public function index(){
        $title = 'Welcome to Laravel!';
       //1ste methode return view('pages.index',compact('title'));
       //2de methode
       return view('pages.index')->with('title',$title);
    }
    public function about(){
        $title = 'About Us';
        return view('pages.about')->with('title',$title);

    }
    public function employee() {
        $title = 'Employees';
        return view('pages.employee')->with('title',$title);
    }
    public function services(){
        $data = array(
            'title' => 'Services',
            'services' => ['Web Design', 'Programming', 'SEO']

        );
        $title = 'Services :)';
        return view('pages.services')->with($data);

    }

    /* public function certifications(){
        //$certifications = CERTIFICATION::all();
  
         $certifications = DB::select('select distinct *
         from CERTIFICATION
         join EMPLOYEE on CERTIFICATION.EmployeeID = EMPLOYEE.EmployeeID
         join TRAINING on TRAINING.TrainingID = CERTIFICATION.TrainingID');
  
        return view('pages.certifications')->with('certifications', $certifications);
     } */
     public function statistics(){
        
               $data = DB::select('select distinct EMPLOYEE.EmployeeID, EMPLOYEE.Name, TRAINING.Trainingsname, TRAINING.DateTime, CERTIFICATION.CertificationName, STATISTIC.TrainingCount, STATISTIC.CertificationCount , STATISTIC.EmployeeName, STATISTIC.StatisticID, STATISTIC.user_name, users.name, users.id
               from EMPLOYEE join CERTIFICATION on EMPLOYEE.EmployeeID = CERTIFICATION.EmployeeID
               join TRAINING on TRAINING.TrainingID = CERTIFICATION.TrainingID
               join STATISTIC on STATISTIC.EmployeeName = EMPLOYEE.Name
               join users on EMPLOYEE.Name = users.name');
        
               $user = DB::select('select distinct users.id, users.name
               from users');
        
               $statistics = STATISTIC::orderby('EmployeeName','asc')->paginate(10);
               $test = Statistic::with('user');
        
               return view('pages.statistics', compact('data', 'statistics', 'user', 'test'));
        
           }
           
}
