<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/



Route::get('/','PagesController@index');
Route::get('/about','PagesController@about');
Route::get('/services','PagesController@services');
Route::get('/certifications','CertificatesController@index');
Route::get('/home','HomeController@index');
Route::get('/general', 'GeneralController@index');
//Dayan
Route::get('/employee','PagesController@employee');
Route::get('/employeeInfo','EmployeeController@index');
Route::get('/employee/{name}', function ($name){
    return 'This is user ' .$name;
});
Route::get('/statistics', 'PagesController@statistics');
Route::get('/certifications', 'PagesController@certifications');
//Route::resource('statistics', 'StatisticsController');



Route::resource('trainings','TrainingsController');
Auth::routes();
Route::resource('books', 'BooksController');
Route::resource('approval','ApprovalController');

//Route::post('/approval',['uses' => 'ApprovalController@update']);
/* Route::get('/trainings/{id}/sendMail',function(){
    $data = [
        'title' => 'Reminder course',
        'content' => 'This is a reminder for your course'
    
    ];
    
    Mail::send('emails.test',$data,function($message){
    
        $message->to('andrew.spteam2@gmail.com','Karim')->subject('Hello student how are you');    
    });
    }); */

   // Route::get('/sendMail', 'EmailController@send');
//TOM
Route::resource('surveys', 'SurveysController');
Route::resource('certifications','CertificateController');







