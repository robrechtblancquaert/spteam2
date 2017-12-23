<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use DB;
use Mail;
use App\User;
use App\Training;

class ApprovalController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $trainings = DB::select('select *
        from TRAINING WHERE Approved = 0');
        return view('approval.index')->with('trainings',$trainings);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $training = Training::find($id);
        $role = auth()->user()->Role;
        return view('approval.show')->with('training',$training)->with('users',$role);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $training = Training::find($id);
        // Check for correct user
        
        return view('approval.approve')->with('training',$training);
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
        



        $this->validate($request, [
            'Trainingsname' => 'required',
            'Description' => 'required',
            'Location' => 'required',
           'DateTime' => 'required',
        ]);
        
           
           //Update Training
           $training= Training::find($id);
            $training->Approved = 1;
           $training->save();
           //mail
           $user = User::find($training->user_id);
           
               $title = 'Reminder course';
               $content = 'This is a reminder for your course';
               $date = $training->DateTime;
               $trainingsname = $training->Trainingsname;
               $location = $training->Location;
               $description = $training->Description;
               $username = $user->name;
           
        
   
           Mail::send('emails.test', [
               'title' => $title,
                'content' => $content,
                'date'=>$date,
                'trainingsname'=>$trainingsname,
                'location'=>$location,
                'description'=>$description,
                'username'=>$username
            ],
           function ($message) use ($user) {
               $message->subject('Training Reminder');
               $message->to($user->email);
           });



           return redirect('/approval')->with('success', 'Training Approved, reminder sent through mail');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
