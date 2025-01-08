 create database tododb;
 use tododb;
 
 create table todolist(
 todo_index int unsigned auto_increment, primary key(todo_index),
 todo_content longtext,
 todo_status boolean default false
 );