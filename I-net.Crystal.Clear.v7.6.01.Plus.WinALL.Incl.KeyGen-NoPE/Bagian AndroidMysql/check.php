    <?php

    $un=$_POST['username'];
    $pw=$_POST['password'];

    $conn = mysql_connect("localhost","root","");
    mysql_select_db("latihan");

    $query = "SELECT * FROM user WHERE username = '$un' AND password ='$pw'";
    $result = mysql_query($query) or die("Unable to verify user because : " . mysql_error());

    
   if (mysql_num_rows($result) == 1){
   
	    echo 1;
	}
   else {
 
	    // print status message
   	   echo 0;
	}

    ?>

