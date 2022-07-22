create database springdemo; 
use springdemo;
create table if not exists `user`
(
    id   bigint auto_increment primary key,
    name varchar(255)
);

insert into `user`(name)
values ('Giang'),
       ('Khoa'),
       ('Vu'),
       ('Nguyen'),
       ('Trung'),
       ('Tu'),
       ('Thinh'),
       ('Duc'),
       ('Dat');
	

update `user`
set user.gender = 'h'
where user.gender is null;

create table  if not exists user_permission
(
    id         bigint auto_increment primary key,
    user_id    bigint,
    permission varchar(1),
    foreign key (user_id) references user (id)
);

create table if not exists identity
(
    id        bigint auto_increment primary key,
    id_number varchar(20)
);

alter table identity
    add column user_id bigint references user (id);
    


insert into user_permission(user_id,permission )
values (1,"r"),
       (1,"w"),
       (2,"e"),
       (3,"r");
       
       
       
       insert into identity(id_number )
values ("112222245554"),
       ("446454646545"),
       ("854646465454"),
       ("855554312313");
UPDATE `springdemo`.`user` SET `gender` = 'm' WHERE (`id` = '1');
UPDATE `springdemo`.`user` SET `gender` = 'f' WHERE (`id` = '2');
UPDATE `springdemo`.`user` SET `gender` = 'h' WHERE (`id` = '3');
UPDATE `springdemo`.`user` SET `gender` = 'h' WHERE (`id` = '4');
UPDATE `springdemo`.`user` SET `gender` = 'h' WHERE (`id` = '5');
UPDATE `springdemo`.`user` SET `gender` = 'h' WHERE (`id` = '6');
UPDATE `springdemo`.`user` SET `gender` = 'h' WHERE (`id` = '7');
UPDATE `springdemo`.`user` SET `gender` = 'm' WHERE (`id` = '8');
UPDATE `springdemo`.`user` SET `gender` = 'm' WHERE (`id` = '9');
UPDATE `springdemo`.`user` SET `gender` = 'm' WHERE (`id` = '10');
UPDATE `springdemo`.`user` SET `gender` = 'm' WHERE (`id` = '11');
UPDATE `springdemo`.`user` SET `gender` = 'm' WHERE (`id` = '12');
UPDATE `springdemo`.`user` SET `gender` = 'm' WHERE (`id` = '13');
UPDATE `springdemo`.`user` SET `gender` = 'm' WHERE (`id` = '14');

UPDATE `springdemo`.`identity` SET `user_id` = '1' WHERE (`id` = '1');
UPDATE `springdemo`.`identity` SET `user_id` = '2' WHERE (`id` = '2');
UPDATE `springdemo`.`identity` SET `user_id` = '3' WHERE (`id` = '3');
UPDATE `springdemo`.`identity` SET `user_id` = '4' WHERE (`id` = '4');



