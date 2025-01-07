create database db0107;
use db0107;
create table student(
student_index int auto_increment, primary key(student_index),
student_name varchar(32) not null,
student_kor int,
student_math int,
student_eng int
);