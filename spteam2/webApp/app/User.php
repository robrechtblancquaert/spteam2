<?php

namespace App;

use Illuminate\Notifications\Notifiable;
use Illuminate\Foundation\Auth\User as Authenticatable;

class User extends Authenticatable
{
    use Notifiable;

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'name', 'email', 'password',
    ];

    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array
     */
    protected $hidden = [
        'password', 'remember_token',
    ];
    public function trainings(){
        return $this->hasMany('App\Training');
    }

    //RoleCheck
    public function isDisabled(){
        return $this->roleCheck();
    }
    public function isHR(){
            return $this->roleCheck(1);
    }
    public function isEmployee(){
        return $this->roleCheck(2);
    }
    protected function roleCheck($Role = 0){
        return $this->Role === $Role ? true : false;
    }
}
