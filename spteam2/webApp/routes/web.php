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
//Route::get('/certifications', 'PagesController@certifications');
//Route::resource('statistics', 'StatisticsController');



Route::resource('trainings','TrainingsController');
Auth::routes();
Route::resource('books', 'BooksController');
Route::resource('approval','ApprovalController');

Route ::resource('certifications','CertificateController');

//Route::post('/approval',['uses' => 'ApprovalController@update']);





//TOM
Route::resource('surveys', 'SurveysController');






