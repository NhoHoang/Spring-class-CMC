create table identity
(
    id        bigint auto_increment primary key,
    id_number varchar(20)
);

alter table identity
    add column user_id bigint references user (id);