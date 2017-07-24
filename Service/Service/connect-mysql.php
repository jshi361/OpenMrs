<?php

DEFINE ('DB_USER', 'finalbossman12');
DEFINE ('DB_PSWD', 'omgwtfbbq123');
DEFINE ('DB_HOST', 'db4free.net');
DEFINE ('DB_NAME', 'cs370fludata');

$dbcon = mysqli_connect(DB_HOST, DB_USER, DB_PSWD, DB_NAME) or die ("Connection Failed");

?>