insert into users values("denny","123456", TRUE);
insert into authorities values("denny","supervisor");
update authorities set authority="supervisor" where username="denny";