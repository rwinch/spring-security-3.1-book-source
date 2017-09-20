create table security_filtermetadata (
    id bigint identity,
    ant_pattern varchar(1024) not null unique,
    expression varchar(1024) not null,
    sort_order bigint not null
);