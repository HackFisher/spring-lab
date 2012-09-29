CREATE TABLE  ACTIVITIES
(
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  timefrom datetime DEFAULT NULL,
  timeto datetime DEFAULT NULL,
  type varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;