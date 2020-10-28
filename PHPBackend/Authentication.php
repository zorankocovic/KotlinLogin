<?php

namespace user;


class Authentication
{
    private $EMAIL = "";
    private $PASSWORD = "";

    private $DB_CONNECTION;
    private $servername = "YOUR SERVERNAME";
    private $username = "SERVER USERNAME";
    private $password = "SERVER PASSWORD";
    private $dbname = "DATABASE NAME";
 public $eId;
    function __construct()
    {
        $this->DB_CONNECTION = mysqli_connect($this->servername, $this->username,
            $this->password, $this->dbname);
    }

    public function prepare($data)
    {
        if (array_key_exists('email', $data))
            $this->EMAIL = $data['email'];

        if (array_key_exists('password', $data))
            $this->PASSWORD = $data['password'];

    }

    function isUserExisted() {
        $sql = "SELECT `id` FROM `users` WHERE EmailAddress = '". $this->EMAIL."' ";

        $result = mysqli_query($this->DB_CONNECTION, $sql);

        if(mysqli_num_rows($result) > 0) {
            return true;
        }else {
            return false;
        }
    }

    function isUserValidToLogin() {
        $sql = "SELECT `id` FROM `users` WHERE EmailAddress = '". $this->EMAIL."'
         AND Password  = '".$this->PASSWORD."'";

        $result = mysqli_query($this->DB_CONNECTION, $sql);

        if(mysqli_num_rows($result) > 0) {
            return true;
        }else {
            return false;
        }
    }

 function userdata() {
        $sql = "SELECT * FROM `users` WHERE EmailAddress = '". $this->EMAIL."' ";

        $result = mysqli_query($this->DB_CONNECTION, $sql)or die (mysqli_error($this->DB_CONNECTION));

	   return $result;
    }


}
?>