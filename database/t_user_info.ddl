create table t_user_info(
	  user_id int(10) not null,
      user_name varchar(50) not null,
      signature varchar(100),
      location_id int(10),
      constraint fk_user_infos foreign key(user_id) references users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;