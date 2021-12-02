
<?php 
include 'connect.php';
    class DanhMuc{
            function DanhMuc($idDM ,$TenDM,$HinhAnh){
                    $this->idDM  = $idDM;
                    $this->TenDM = $TenDM;
                    $this-> HinhAnh = $HinhAnh;
            }

    }
$arrayDM = array();
while($row =mysqli_fetch_assoc($data)){
    array_push($arrayDM,new DanhMuc($row['idDM'] ,$row['TenDM'],$row['HinhAnh']));
}
echo json_encode($arrayDM);

?>