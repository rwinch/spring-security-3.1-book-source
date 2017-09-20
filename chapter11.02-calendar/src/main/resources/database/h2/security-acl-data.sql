-- class
insert into acl_class (id, class) values (10, 'com.packtpub.springsecurity.domain.Event');

-- SIDs
insert into acl_sid (id, principal, sid) values (20, true, 'user2@example.com');

insert into acl_sid (id, principal, sid) values (21, false, 'ROLE_USER');
insert into acl_sid (id, principal, sid) values (22, false, 'ROLE_ADMIN');


-- object identity
insert into acl_object_identity (id,object_id_identity,object_id_class,parent_object,owner_sid,entries_inheriting)
values (30,100, 10, null, 20, false);

insert into acl_object_identity (id,object_id_identity,object_id_class,parent_object,owner_sid,entries_inheriting)
values (31,101, 10, null, 21, false);

insert into acl_object_identity (id,object_id_identity,object_id_class,parent_object,owner_sid,entries_inheriting)
values (32,102, 10, null, 21, false);


-- ACE list
-- mask == R
insert into acl_entry
    (acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure)
    values(30, 1, 20, 3, true, true, true);