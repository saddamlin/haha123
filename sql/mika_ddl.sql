-- USER_INFO
CREATE TABLE USER_INFO
(
USER_ID integer primary key,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

-- USER FRIENDS
CREATE TABLE USER_FRIENDS
(
USER_ID integer primary key,
FRIEND_USER_ID integer primary key,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

-- USER_ELEMENT
CREATE TABLE USER_ELEMENT_SUMMARY
(
USER_ID integer primary key,
ELEMENT_ID integer primary key,
QUANTITY integer,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

-- USER_ELEMENT_HIST
CREATE TABLE USER_ELEMENT_OBTAINED
(
USER_ID integer primary key,
ELEMENT_ID integer primary key,
QUANTITY integer,
OBTAINED_DATE timestamp,
QUEST_ID integer,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

CREATE TABLE USER_ELEMENT_TRANSFORMED
(
USER_ID integer primary key,
ELEMENT_ID integer primary key,
QUANTITY integer,
TRANSFORMED_DATE timestamp,
FLOWER_ID integer,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

-- FLOWER
CREATE TABLE FLOWER_INFO
(
FLOWER_ID integer primary key,
USER_ID integer,
FLOWER_TYPE int4,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

-- SEED

CREATE TABLE SEED_INFO
(
SEED_ID integer primary key,
USER_ID integer,
SEED_TYPE int4,
SOURCE int4,
IS_FLOWERING boolean,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

CREATE TABLE SEED_ELEMENT_SUMMARY
(
SEED_ID integer primary key,
USER_ID integer,
ELEMENT_ID integer,
QUANTITY integer,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

-- QUEST_INFO
CREATE TABLE QUEST_INFO
(
QUEST_ID integer primary key,
USER_ID integer,
START_DATE timestamp,
END_DATE timestamp,
IS_SUCCESS boolean,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

