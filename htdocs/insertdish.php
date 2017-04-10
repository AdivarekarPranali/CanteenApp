<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "canteen";

$dish=$_POST['dishname'];

$price=$_POST['price'];


$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "INSERT INTO menu ( dishname, price)
VALUES ('".$dish."','".$price."')";


if ($conn->query($sql) === TRUE) {
    echo "true";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
echo "true";
//return "true"
?>
