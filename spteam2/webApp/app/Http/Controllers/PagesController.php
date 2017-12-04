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
    public function about(){
        $title = 'About Us';
        return view('pages.about')->with('title',$title);

    }
    public function services(){
        $data = array(
            'title' => 'Services',
            'services' => ['Web Design', 'Programming', 'SEO']

        );
        $title = 'Services :)';
        return view('pages.services')->with($data);

    }
}
