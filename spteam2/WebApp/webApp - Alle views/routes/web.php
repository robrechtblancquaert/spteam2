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

Route::get('/', 'PagesController@index');
Route::get('/about', 'PagesController@about');
Route::get('/services', 'PagesController@services');
Route::get('/statistics', 'PagesController@statistics');

Route::get('/getdata','MultiController@test');

Route::resource('posts', 'PostsController');
Route::resource('surveys', 'SurveysController');
//Route::resource('statistics', 'StatisticsController');
Route::resource('books', 'BooksController');
ROute::resource('trainings', 'TrainingsController');


Auth::routes();

Route::get('/dashboard', 'DashboardController@index');
