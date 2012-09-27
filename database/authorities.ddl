create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create unique index ix_auth_username on authorities (username,authority);