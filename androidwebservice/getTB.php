<?php
 require_once 'connect.php';

 if ($_SERVER['REQUEST_METHOD']=='POST') {

     $idUser = $_POST['idUser'];
     
   
        $sql = "SELECT * FROM thongbao WHERE idUser = '$idUser' order by time DESC";
   
    

    $data =  mysqli_query($connect, $sql) ;

    $result = array();
    $result['login'] = array();
    if ($data->num_rows > 0)
	{
		while($row =mysqli_fetch_assoc($data)){
            $index['idTB'] = $row['idTB'];
            $index['idUser'] = $row['idUser'];
            $index['Tittle'] = $row['Tittle'];
            $index['Chitiet'] = $row['Chitiet'];
            $index['HinhAnh'] = $row['HinhAnh'];
            $index['time'] = $row['time'];
           
            
            array_push($result['login'], $index);

            $result['success'] = "1";
            $result['message'] = "success";
            
        }
        echo json_encode($result);
        
	}else{
        echo "loi";
    }
 
}

?>