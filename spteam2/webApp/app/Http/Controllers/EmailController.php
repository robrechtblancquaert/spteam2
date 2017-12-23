<?php

namespace App\Http\Controllers;
use DB;
use App\User;
use Mail;
use Illuminate\Http\Request;
use App\Training;


class EmailController extends Controller
{
    public function send(Request $request){
      /*   $title = $request->input('title');
        $content = $request->input('content');

        $users = DB::select('SELECT * FROM users WHERE Role=3')
        ;
        if (!empty($users)) {
            foreach ($users as $user) {
                Mail::send('emails.test', ['title' => $title, 'content' => $content],
                    function ($message) use ($user) {
                        $message->subject('Training Reminder');
                        $message->to($user->email);
                    });
            }
        }
        return redirect('/trainings')->with('success', 'Reminder sent');
        
        

        return response()->json(['message' => 'Request completed']);
    } */

}
