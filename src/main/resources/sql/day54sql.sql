drop database if exists mydb0102;
create database mydb0102;
use mydb0102;

create table board(
board_index int unsigned auto_increment, primary key(board_index),
board_title varchar(100) not null,
board_content longtext,
board_date datetime default now(),
board_writer varchar(30) not null,
board_password varchar(30) not null
);

insert into board(board_title, board_content, board_writer, board_password) values("제목1","내용1","유재석","1234");
insert into board(board_title, board_content, board_writer, board_password) values("제목2","내용2","강호동","1234");
insert into board(board_title, board_content, board_writer, board_password) values("제목3","내용3","신동엽","1234");