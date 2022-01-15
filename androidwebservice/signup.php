<?php
 require_once 'connect.php';

 if ($_SERVER['REQUEST_METHOD']=='POST') {

    $Username = $_POST['Username'];
    $Pass = $_POST['Pass'];
    $phone = $_POST['phone'];
    $address = $_POST['address'];
    $fullname = $_POST['fullname'];
    
    $sql = "INSERT INTO `user` (`idUser`, `Username`, `Pass`, `phone`, `dob`, `address`, `fullname`) 
    VALUES (NULL, '$Username', '$Pass', '$phone', current_timestamp(), '$address', '$fullname');";

    $data =  mysqli_query($connect, $sql) ;

    $result = array();
    $result['login'] = array();
    if ($data)
	{
		

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);
       
        
	}else{
        echo "loi";
    }

}

?>