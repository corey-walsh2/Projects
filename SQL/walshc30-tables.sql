Create table blogger (
id 	char(5),
name 	varchar(20),
street	varchar(20),
city	varchar(20),
zipcode	varchar(5),
primary key (id)
);
create table blog (
id char(5),
blogger_id char(5),
post_date varchar(20),
subject	varchar(20),
body	varchar(20),
primary key (id)
);
create table tag (
id char(5),
name varchar(20),
primary key (id),
foreign key (name) references blog(subject) 
);
create table post_tag (
post_id char(5),
tag_id char(5),
primary key (post_id, tag_id),
foreign key (post_id) references blog(id),
foreign key (tag_id) references tag(id)
);
