<?php 
    $connect = mysqli_connect("localhost","root","","phoneshop");
    mysqli_query($connect,"SET NAME 'utf8");

    $query = "SELECT * FROM danhmuc";
    $data = mysqli_query($connect,$query);

    $query2 = "SELECT * FROM sanpham";
    $data2 = mysqli_query($connect,$query2);

    

?>