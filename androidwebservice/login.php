<?php
 require_once 'connect.php';

 if ($_SERVER['REQUEST_METHOD']=='POST') {

    $User = $_POST['email'];
    $password = $_POST['password'];
    class NguoiDung{
        function NguoiDung($idUser ,$UserName,$Pass){
                $this->idUser  = $idUser;
                $this->UserName = $UserName;
                $this->Pass = $Pass;
        }

}
   
   
    $sql = "SELECT * FROM user WHERE Username='$User' AND Pass = '$password' ";

    $data =  mysqli_query($connect, $sql) ;

    $result = array();
    $result['login'] = array();
    if ($data->num_rows > 0)
	{
		while($row =mysqli_fetch_assoc($data)){
            $index['idUser'] = $row['idUser'];
            $index['Username'] = $row['Username'];
            $index['Pass'] = $row['Pass'];
           

            array_push($result['login'], $index);

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);
        }
        
	}else{
        echo "loi";
    }
}
    

?>