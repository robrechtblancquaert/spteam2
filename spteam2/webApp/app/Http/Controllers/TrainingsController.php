<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Training;

class TrainingsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $trainings = Training::all();
        return view('trainings.index')->with('trainings',$trainings);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('trainings.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate($request,[
            'Trainingsname' => 'required',
            'Description' => 'required',
            'Location' => 'required',
            'DateTime' => 'required',
            
       ]);

       //Create new Training
       
       $training = new Training;
       $training->Trainingsname = $request->input('Trainingsname');
       $training->Description = $request->input('Description');
       $training->Location = $request->input('Location');
       $training->DateTime = $request->input('DateTime');
       $training->user_id = auth()->user()->id;
       $training->save();

       return redirect('/trainings')->with('success', 'Training Created');
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
        return view('trainings.show')->with('training',$training)->with('users',$role);
        //
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
        if(auth()->user()->id !== $training->user_id){
            return redirect('/trainings')->with('error', 'Unauthorized Page');
        }
        return view('trainings.edit')->with('training',$training);
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
           $training->Trainingsname = $request->input('Trainingsname');
           $training->Description = $request->input('Description');
           $training->Location = $request->input('Location');
           $training->DateTime = $request->input('DateTime');
           
           $training->save();
           return redirect('/trainings')->with('success', 'Training Updated');
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