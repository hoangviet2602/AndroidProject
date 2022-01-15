<?php
 require_once 'connect.php';

  if ($_SERVER['REQUEST_METHOD']=='POST') {

    $idUser = $_POST['idUser'];
    $TongTien = $_POST['TongTien'];
    //$NgayDat = '12/1/2021';
    $tennguoinhan = $_POST['tennguoinhan'];
    $sdt = $_POST['sdt'];
    $diachi = $_POST['diachi'];
    $chitiet = $_POST['chitiet'];
    $hinhanh=$_POST['hinhanh'];

    $sql = "INSERT  INTO `donhang` (`idDH`, `idUser`, `TongTien`,  `tennguoinhan`, `sdt`, `diachi`) 
    values (NULL,'$idUser','$TongTien','$tennguoinhan','$sdt','$diachi') ";

    $data =  mysqli_query($connect, $sql) ;

    

    if($data){
        
        $query = "select  idDH from donhang where idUser   = '$idUser' ORDER BY idDH DESC LIMIT 1"; 
        $data2 = mysqli_query($connect, $query) ;

        while($row = mysqli_fetch_assoc($data2)){
            $iddonhang = ($row);
            
        }
        if(!empty($iddonhang)){
            $chitiet = json_decode($chitiet,true);
            
            foreach($chitiet as $key => $value ){
                $idSP = $value['idSP'];
                $soluong = $value['soluong'];
                $giatien = $value['giatien'];
                $idDH = $iddonhang['idDH'];
                $truyvan = " INSERT  INTO  chitietdonhang  VALUES ('$idDH','$idSP' ,'$soluong' ,'$giatien') ";

                $data3 =  mysqli_query($connect, $truyvan) ;
            }
        }
    }
    
    if ($data3)
	{
            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);
	}else{
        echo "loi";
    }

    $queryInsertTB = "INSERT INTO `thongbao` (`idTB`, `idUser`, `Tittle`, `Chitiet`, `HinhAnh`, `time`) VALUES (NULL, '$idUser',
    'Đặt hàng thành công', 'Đơn hàng $idDH của bản đã được đặt thành công', '$hinhanh', current_timestamp())";
    mysqli_query($connect, $queryInsertTB); 
   
 }
    

?>