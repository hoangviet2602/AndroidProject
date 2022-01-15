<?php
 require_once 'connect.php';

 if ($_SERVER['REQUEST_METHOD']=='POST') {

     $idUser = $_POST['idUser'];
     $trangthai = $_POST['trangthai'];
   
        $sql = "SELECT dh.idUser,ct.*,sp.Tittle,sp.HinhAnh
        FROM donhang as dh , chitietdonhang as ct , sanpham as sp
        WHERE dh.idDH = ct.idDH and dh.idUser = '$idUser' and ct.idSP = sp.idSP and dh.TrangThai = '$trangthai'
        ORDER BY dh.idDH DESC";
   
    

    $data =  mysqli_query($connect, $sql) ;

    $result = array();
    $result['login'] = array();
    if ($data->num_rows > 0)
	{
		while($row =mysqli_fetch_assoc($data)){
            $index['Tittle'] = $row['Tittle'];
            $index['SoLuong'] = $row['SoLuong'];
            $index['DonGia'] = $row['DonGia'];
            $index['HinhAnh'] = $row['HinhAnh'];
 
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