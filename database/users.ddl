create table users(
	  id int(10) NOT NULL AUTO_INCREMENT primary key,
      username varchar(50) not null,
      password varchar(50) not null,
      enabled boolean not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create unique index ix_user_name on users(username);