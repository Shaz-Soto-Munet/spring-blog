CREATE DATABASE IF NOT EXISTS spring_blog_db;

CREATE USER IF NOT EXISTS spring_blog@localhost IDENTIFIED BY 'codeup-1';
GRANT ALL ON spring_blog_db.* TO spring_blog@localhost;

