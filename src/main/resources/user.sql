use springboot;
drop table if exists `user`;
create table user(
    student_no varchar(45) not null
                 PRIMARY KEY ,
    the_password varchar(45) not null ,
    institute varchar(45) not null ,
    grade int not null ,
    the_class varchar(45) not null,
    the_name varchar(45) not null
)
INSERT INTO user(student_no,the_password,institute,grade,the_class,the_name)
VALUES('2021212205','WZasd20021003','cqupt',2021,'04822101','伍舟'),('2021212210','asd20021003','zero',2021,'04822101','鲁路修'),
    ('2021212217','123456789','love home',2021,'04822101','c.c');
