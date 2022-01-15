
<?php 
include 'connect.php';
    class SanPham{
            function SanPham($idDM ,$idSP,$Tittle,$HinhAnh,$Gia,$UuDai,$SoDanhGia,$SoSao,$size,$loai,$ram,$rom,$pin){
                    $this->idDM  = $idDM;
                    $this->idSP = $idSP;
                    $this->Tittle = $Tittle;
                    $this->HinhAnh = $HinhAnh;
                    $this->Gia= $Gia;
                    $this->UuDai = $UuDai;
                    $this->SoDanhGia = $SoDanhGia;
                    $this->SoSao = $SoSao;
                    $this->size = $size;
                    $this->loai = $loai;
                    $this->ram = $ram;
                    $this->rom = $rom;
                    $this->pin = $pin;


            }

    }
$arraySP1 = array();
while($row =mysqli_fetch_assoc($data3)){
    array_push($arraySP1,new SanPham($row['idDM'] ,$row['idSP'],$row['Tittle'],$row['HinhAnh'],$row['Gia'],$row['UuDai'],$row['SoDanhGia'],$row['SoSao'],
            $row['sizemanhinh'],$row['lmanhinh'],$row['ram'],$row['rom'],$row['pin']));
}
echo json_encode($arraySP1);

?>