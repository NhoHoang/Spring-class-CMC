create table user_permission
(
    id         bigint auto_increment primary key,
    user_id    bigint,
    permission varchar(1),
    foreign key (user_id) references user (id)
)