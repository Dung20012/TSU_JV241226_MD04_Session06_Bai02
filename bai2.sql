create database login_demo;
use login_demo;

create table customers (
	id bigint primary key auto_increment,
    username varchar(50) not null,
	password varchar(50) not null,
    phone varchar(20),
    address varchar(255),
    gender varchar(10),
    email varchar(100),
    role enum('ADMIN', 'USER')
);
-- Tạo tài khoản mẫu:
INSERT INTO customers(username, password, phone, address, gender, email, role)
VALUES ('admin', '123', '0123456789', 'Hanoi', 'Male', 'admin@example.com', 'ADMIN'),
       ('user1', '123', '0987654321', 'HCM', 'Female', 'user1@example.com', 'USER');

CREATE TABLE movies (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    duration INT NOT NULL,
    language VARCHAR(50) NOT NULL
);
INSERT INTO movies (title, director, genre, description, duration, language)
VALUES 
('Inception', 'Christopher Nolan', 'Sci-fi', 'A mind-bending thriller.', 148, 'English'),
('Parasite', 'Bong Joon Ho', 'Drama', 'Class conflict and secrets unravel.', 132, 'Korean');
