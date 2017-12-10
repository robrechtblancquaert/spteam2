<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Statistic;
use App\Post;
use App\User;
use DB;

class StatisticsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */

    public function test()
    {
        
       
            //$surveys = SURVEY::all();
            $statistics = STATISTIC::orderby('EmployeeName','asc')->paginate(10);
    
            return view('statistics.test')->with('statistics',$statistics);
            //
            //$posts =  Post::all();
            //$posts = Post::orderby('created_at','desc')->paginate(10);
            //return view('posts.index')->with('posts',$posts);
            //
        
     }


    public function index()
    {
     

        //$data=DB::select('select distinct EMPLOYEE.Name, TRAINING.Trainingsname, TRAINING.DateTime, CERTIFICATION.CertificationName, EMPLOYEE.EmployeeID
                        //from EMPLOYEE join CERTIFICATION on EMPLOYEE.EmployeeID = CERTIFICATION.EmployeeID
                        //join TRAINING on TRAINING.TrainingID = CERTIFICATION.TrainingID');

       // return view('statistics.index', compact('data'));
        $posts =  Post::all();
        //$user_id = auth()->user()->id;
        //$user = User::find($user_id);

        $user = DB::select('select distinct users.id, users.name
        from users');

        $statistics = STATISTIC::orderby('EmployeeName','asc')->paginate(10);
        //return view('statistics.index')->with('statistics',$statistics);
        return view('statistics.index', compact('statistics', 'user', 'posts'));

    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {

        //return view('statistics.create');
        $this->validate($request, [
            'EmployeeName' => 'required',
            'TrainingCount' => 'required',
            'CertificationCount' => 'required',
            'TrainingName' => 'required',
            'CertificationName' => 'required',
            'Year' => 'required'
            
        ]);
            


           //Create Post
           $statistic=new STATISTIC;
           $statistic->EmployeeName = $request->input('EmployeeName');
           $statistic->TrainingCount = $request->input('TrainingCount');
           $statistic->CertificationCount = $request->input('CertificationCount');
           $statistic->TrainingName = $request->input('TrainingName');
           $statistic->CertificationName = $request->input('CertificationName');
           $statistic->Year = $request->input('Year');
           $statistic->user_name = auth()->user()->name;
          
           $statistic->save();

           return redirect('/statistics')->with('success', 'Statistic Created');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
       
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
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

        return view('statistics.show', compact('data', 'statistics', 'user', 'test'));
        //$statistic = STATISTIC::find($id);
        //return view('statistics.show')->with('statistic',$statistic); 
      
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
       
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        
    }
}
