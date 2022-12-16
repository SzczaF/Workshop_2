drop database  workshop2;
CREATE DATABASE workshop2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use workshop2;

create table users (
    id int(11) primary key auto_increment,
    email varchar(255) not null unique,
    username varchar(255) not null,
    password varchar(60) not null
);

describe users;


select * from users;