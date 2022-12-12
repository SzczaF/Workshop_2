CREATE DATABASE workshop2;

use workshop2;

create table users (
    id int(11) primary key auto_increment,
    email varchar(255) not null unique,
    username varchar(255) not null,
    password varchar(60) not null
);

describe users;


delete from users u where u.id = ?;