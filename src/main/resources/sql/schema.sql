create table msg(
date varchar(32) primary key not null,
msg text not null
);

create table express(
type varchar(32) not null,
content varchar(256) primary key not null
);