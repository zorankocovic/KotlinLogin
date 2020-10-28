<?php


include_once('Authentication.php');
use user\Authentication;

$auth = new Authentication();
$auth->prepare($_GET);
$userStatus = $auth->isUserValidToLogIn();
$response = array();
if ($userStatus) {

    $json['success'] = "1";
 $response = array();
    $json['message'] = 'User Successfully logged';

$userData = $auth->UserData();
$row = mysqli_fetch_array($userData);

//while($row = mysqli_fetch_array($userData))
//{
	$json['id'] = $row['id'];
	$json['FirstName'] = $row['FirstName'];


	 array_push($response, $json);


    echo json_encode($response);
} else {
  
    $json['success'] = "0";
    $json['message'] = 'Wrong email or password';
 array_push($response, $project);

    echo json_encode($response);
}?>