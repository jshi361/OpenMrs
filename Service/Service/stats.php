<style>
    th { 
        border-bottom: 4px solid #000;
    }
    td {
        border-bottom: 1px solid #666;
    }
</style>

<body>
<h2>Queried Visitors</h1>
Visit Counts >= 3</br>
OR Total Actions >= 5 <br/>
OR Total Time >= 120s <br/><br/>
<?php

include('connect-mysql.php');

$sqlget = "SELECT idvisitor, visitor_count_visits, visit_total_actions, visit_total_time 
           FROM piwik_log_visit
           WHERE visitor_count_visits >= 3
                OR visit_total_actions >= 5
                OR visit_total_time >= 120";
$sqldata = mysqli_query($dbcon, $sqlget);

if (!$sqldata) {
    printf("Error: %s\n", mysqli_error($dbcon));
    exit();
}

echo "<table>";
echo "<tr><th>Visitor ID</th><th>Visit Count</th><th>Clicks</th><th>Time Spent</th></tr>";

while ($row = mysqli_fetch_array($sqldata, MYSQLI_ASSOC)) {
    echo "<tr><td>";
    echo $row['idvisitor'];
    echo "</td><td>";
    echo $row['visitor_count_visits'];
    echo "</td><td>";
    echo $row['visit_total_actions'];
    echo "</td><td>";
    echo $row['visit_total_time'];
    echo "</td></tr>";
}

echo "</table>";

$sqlget = "SELECT idvisitor, visitor_count_visits, visit_total_actions, visit_total_time 
           FROM piwik_log_visit";
$sqldata = mysqli_query($dbcon, $sqlget);

if (!$sqldata) {
    printf("Error: %s\n", mysqli_error($dbcon));
    exit();
}
?>


<h2>All Visitors </h2>
<?php
echo "<table>";
echo "<tr><th>Visitor ID</th><th>Visit Count</th><th>Clicks</th><th>Time Spent</th></tr>";

while ($row = mysqli_fetch_array($sqldata, MYSQLI_ASSOC)) {
    echo "<tr><td>";
    echo $row['idvisitor'];
    echo "</td><td>";
    echo $row['visitor_count_visits'];
    echo "</td><td>";
    echo $row['visit_total_actions'];
    echo "</td><td>";
    echo $row['visit_total_time'];
    echo "</td></tr>";
}

echo "</table>";
?>
</body>