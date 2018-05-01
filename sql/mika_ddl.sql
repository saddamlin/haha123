
-- user
create table user_info
(
  user_id int not null auto_increment,
  open_id varchar(100) not null,
  user_name varchar(100),
  gender char(2) not null default 'u' ,
  description varchar(1024),
  phone varchar(20),
  date_of_birth date,
  avatar_url String,
  created_date datetime not null default now(),
  last_update_date datetime not null default now(),
  primary key (user_id, open_id)
);

create table user_relationship
(
  user_id int not null,
  friend_user_id int not null,
  rel_status tinyint not null,
  created_date datetime not null default now(),
  last_update_date datetime not null default now()
);

create table user_session
(
  session_id int not null auto_increment,
  user_id int not null,
  session_key varchar(100),
  start_time datetime,
  end_time datetime,
  latitude int,
  longtitude int,
  accuracy int,
  created_date datetime not null default now(),
  last_update_date datetime not null default now(),
  primary key (session_id)
);

create table user_element
(
  user_id int not null,
  element_id int not null,
  quantity int not null,
  created_date datetime not null default now(),
  last_update_date datetime not null default now(),
  primary key (user_id, element_id)
);

create table user_notification
(
  notification_id int not null,
  user_id int not null,
  notification_type tinyint not null,
  message varchar(1024),
  created_date datetime not null default now(),
  last_update_date datetime not null default now(),
  primary key (notification_id)
);

-- flower 
create table flower_info
(
  flower_id int not null auto_increment,
  user_id int not null,
  flower_status tinyint not null,
  flower_level int not null,
  flower_exp int not null,
  created_date datetime not null default now(),
  last_update_date datetime not null default now()
  primary key (flower_id)
);

create table flower_element
(
  flower_id int not null,
  element_id int not null,
  quantity int not null,
  created_date datetime not null default now(),
  last_update_date datetime not null default now(),
  primary key (flower_id, element_id)
);

create table flower_gift
(
  gift_id int not null,
  flower_id int not null,
  user_id int not null,
  gift_type tinyint not null,
  gift_details varchar(1024),
  gift_status tinyint not null,
  created_date datetime not null default now(),
  last_update_date datetime not null default now(),
  primary key (gift_id)
);

-- quest
create table quest_info
(
  quest_id int not null auto_increment,
  quest_type tinyint not null,
  quest_status tinyint not null,
  created_date datetime not null default now(),
  last_update_date datetime not null default now(),
  primary key (quest_id)
);

create table quest_user_map
(
  quest_id int not null,
  user_id int not null,
  user_type tinyint not null,
  user_status tinyint not null,
  element_id int,
  quantity int,
  created_date datetime not null default now(),
  last_update_date datetime not null default now(),
  primary key (quest_id, user_id)
);

