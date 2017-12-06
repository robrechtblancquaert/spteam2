<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class PagesController extends Controller
{
    public function index(){
        $title = 'Welcome to Laravel!';
       //1ste methode return view('pages.index',compact('title'));
       //2de methode
       return view('pages.index')->with('title',$title);
    }
    public function employee() {
        $title = 'Employees';
        return view('pages.employee')->with('title',$title);

    }

    public function settings() {
        $title = 'Settings';
        return view('pages.settings')->with('title',$title);

    }
}
