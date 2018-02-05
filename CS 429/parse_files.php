<?php
 
ini_set('memory_limit', '128M');
if (file_exists('C:/Users/marco/Documents/CS-Spring-2018/CS 429/Homework 1/datasets/nyt1.csv')){
	echo "File exists";
} else {
	echo "File does not exist";
}

$list = array("Age,Gender,Impressions,Signed_In,Day");

$csv = array_map('str_getcsv', file('C:/Users/marco/Documents/CS-Spring-2018/CS 429/Homework 1/datasets/nyt1.csv'));
echo sizeof($csv); 

// devide into diff sections. 

// $file = fopen("C:/Users/marco/Documents/CS-Spring-2018/CS 429/Homework 1/test/test.csv","w");
// foreach ($list as $line)
//   {
//   fputcsv($file,explode(',',$line));
//   }

// fclose($file);
?>