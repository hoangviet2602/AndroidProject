<?php
 require_once 'connect.php';

  if ($_SERVER['REQUEST_METHOD']=='POST') {

     $idDM = $_POST['idDM'];
   // $idDM = "1";
    if($idDM != null){
        $sql = "SELECT * FROM sanpham WHERE idDM = '$idDM' ";
    }else{
        $sql = "SELECT * FROM sanpham  ";
    }
    

    $data =  mysqli_query($connect, $sql) ;

    $result = array();
    $result['login'] = array();
    if ($data->num_rows > 0)
	{
		while($row =mysqli_fetch_assoc($data)){
            $index['idDM'] = $row['idDM'];
            $index['idSP'] = $row['idSP'];
            $index['Tittle'] = $row['Tittle'];
            $index['HinhAnh'] = $row['HinhAnh'];
            $index['UuDai'] = $row['UuDai'];
            $index['Gia'] = $row['Gia'];
            $index['SoDanhGia'] = $row['SoDanhGia'];
            $index['size'] = $row['sizemanhinh'];
            $index['loai'] = $row['lmanhinh'];
            $index['ram'] = $row['ram'];
            $index['rom'] = $row['rom'];
            $index['pin'] = $row['pin'];
            
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