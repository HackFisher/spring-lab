CREATE TABLE  t_msg_info
(
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  user_id int(10) NOT NULL,
  content varchar(140) NOT NULL,
  time_t datetime DEFAULT NULL,
  PRIMARY KEY (id),
  constraint fk_msg_user foreign key(user_id) references users(id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;