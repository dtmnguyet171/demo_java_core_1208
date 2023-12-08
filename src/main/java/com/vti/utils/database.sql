drop database if exists final_exam;
create database final_exam;
use final_exam;
create table user
(
    id          int auto_increment
        primary key,
    full_name   varchar(50) charset utf8mb3  null,
    email       varchar(50)                  not null,
    password    varchar(12)                  not null,
    exp_in_year int                          null,
    pro_skill   varchar(10)                  null,
    project_id  int                          null,
    role        enum ('MANAGER', 'EMPLOYEE') null
);

select * from user where id = 1;

INSERT INTO final_exam.user (id, full_name, email, password, exp_in_year, pro_skill, project_id, role) VALUES (1, 'Đỗ Minh Nguyệt', 'nguyet@gmail.com', '123456', null, 'java', 1, 'EMPLOYEE');
INSERT INTO final_exam.user (id, full_name, email, password, exp_in_year, pro_skill, project_id, role) VALUES (2, 'Trần Long Nhật', 'nhat@gmail.com', '123456', 2, null, 1, 'MANAGER');
INSERT INTO final_exam.user (id, full_name, email, password, exp_in_year, pro_skill, project_id, role) VALUES (3, 'Hoàng Quốc Phong', 'phong@gmail.com', '123456', null, '.NET', 3, 'EMPLOYEE');
