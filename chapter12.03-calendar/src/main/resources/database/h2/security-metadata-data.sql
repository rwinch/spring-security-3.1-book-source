insert into security_filtermetadata(ant_pattern,expression,sort_order) values ('/','permitAll',10);
insert into security_filtermetadata(ant_pattern,expression,sort_order) values ('/login/*','permitAll',20);
insert into security_filtermetadata(ant_pattern,expression,sort_order) values ('/signup/*','permitAll',30);
insert into security_filtermetadata(ant_pattern,expression,sort_order) values ('/logout','permitAll',40);
insert into security_filtermetadata(ant_pattern,expression,sort_order) values ('/errors/**','permitAll',50);
insert into security_filtermetadata(ant_pattern,expression,sort_order) values ('/admin/**','local and hasRole("ROLE_ADMIN")',60);
insert into security_filtermetadata(ant_pattern,expression,sort_order) values ('/**','hasRole("ROLE_USER")',70);