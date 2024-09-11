create user if not exists 'cdc'@'%' identified by 'livid';

grant all on livid.* to 'cdc'@'%';

flush privileges;


create database if not exists livid;

use livid;

create table if not exists article(
    id bigint primary key auto_increment,
    content text not null,
    created_at datetime not null default current_timestamp,
    updated_at datetime not null default current_timestamp on update current_timestamp,
    deleted_at datetime null default null,
    is_deleted tinyint not null default 0
);

