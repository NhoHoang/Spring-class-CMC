alter table user
    add column gender varchar(1);

update user
set user.gender = 'h'
where user.gender is null