create database mydb0109;
use mydb0109;

create table member(
member_number int auto_increment, primary key(member_number),
member_id varchar(30),
member_password varchar(30),
member_name varchar(30),
member_phone varchar(13)
);

select * from member;