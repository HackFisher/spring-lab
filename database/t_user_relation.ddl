create table t_user_relation(
	  id int(10) unsigned NOT NULL AUTO_INCREMENT primary key,
	  user_id int(10) not null,
	  follow_id int(10) not null,
	  type int not null,
      constraint fk_relation_users foreign key(user_id) references ix_user_name,
      constraint fk_relation_follows foreign key(follow_id) references ix_user_name
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create unique index ix_user_relation on t_user_relation (user_id,follow_id);

#create unique index ix_user_relation on t_user_relation (user_id,follow_id, type);