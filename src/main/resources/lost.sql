use springboot;
drop table if exists `lost`;
create table lost(
                     lost_id varchar(45) not null
                         PRIMARY KEY ,
                     lost_name varchar(45) not null ,
                     lost_position varchar(45) not null ,
                     lost_description varchar(45) not null,
                     claim_position varchar(45) not null,
                     lost_date varchar(45) not null,
                     is_returned int not null
);
    INSERT INTO lost(lost_id,lost_name,lost_position,lost_description,claim_position,lost_date,is_returned)
VALUES('2021212205','knightmare','cqupt','my knife','classroom','2022-10-03',0),('2021212204','wechat','qq','聊天工具','test1','2021-12-21',0);