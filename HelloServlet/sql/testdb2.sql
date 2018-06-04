drop database if exists testdb2;
create database testdb2;
use testdb2;
create table test_table2(
user_id int,
user_name varchar(255),
password varchar(255)
);

insert into test_table2 values(1,"taro","123");
insert into test_table2 values(2,"jiro","456");
insert into test_table2 values(3,"hanako","789");
