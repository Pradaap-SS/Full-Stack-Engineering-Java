drop database if exists RainfallReport;

create database RainfallReport;

use RainfallReport;

create table AnnualRainfall(city_pincode int(5) primary key,city_name varchar(25),average_annual_rainfall double(6,2));


commit;
