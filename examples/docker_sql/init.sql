CREATE USER 'demo_java' IDENTIFIED BY 'Java123!';
GRANT ALL PRIVILEGES ON * . * TO 'demo_java' with grant option;
create schema chatroom;
use chatroom; 
create table if not exists Log(id int auto_increment primary key, username varchar(30), date_time datetime, message tinytext);

