###### Users ######
-- USER_INFO
CREATE TABLE USER_INFO
(
USER_ID integer primary key,
USER_AVATAR blob,
USER_SIGNATURE text,
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

##### Backpack #####

CREATE TABLE USER_ELEMENT_BACKPACK
(
ELEMENT_ID integer primary key,
USER_ID integer primary key,
ELEMENT_TYPE int4,
ELEMENT_STATUS int4,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

CREATE TABLE MINE_ELEMENT_DETAILS
(
ELEMENT_ID integer primary key,
MINT_TYPE int4,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

CREATE TABLE USER_SEED_BACKPACK
(
SEED_ID integer primary key,
USER_ID integer primary key,
SEED_TYPE int4,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

CREATE TABLE USER_FRUIT_BACKPACK
(
FRUIT_ID integer primary key,
USER_ID integer primary key,
FRUIT_STATUS int4,
FRUIT_TYPE int4,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);


###### Plant ######

CREATE TABLE PLANT_INFO
(
PLANT_ID integer primary key,
SEED_ID integer,
USER_ID integer,
PLANT_TYPE int4,
PLANT_STATUS int4,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

CREATE TABLE PLANT_ELEMENT
(
PLANT_ID integer primary key,
ELEMENT_ID integer primary key,
QUANTITY integer,
TRANSFORMED_DATE timestamp,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

CREATE TABLE PLANT_FRUIT
(
PLANT_ID integer primary key,
FRUIT_ID integer primary key,
QUANTITY integer,
FRUTION_DATE timestamp,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp 
);

CREATE TABLE FRUIT_ELEMENTW
(
FRUIT_ID integer primary key,
ELEMENT_ID integer primary key,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp 
);

CREATE TABLE GENE_ELEMENT_DETAILS
(
ELEMENT_ID integer primary key,
GENE_TYPE int4,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp 
);

-- QUEST_INFO
CREATE TABLE QUEST_INFO
(
QUEST_ID integer primary key,
USER_ID integer,
FRUIT_ID integer,
START_DATE timestamp,
END_DATE timestamp,
IS_SUCCESS boolean,
GENE_ELEMENT_ID integer,
CREATED_DATE timestamp,
LAST_MODIFIED_DATE timestamp
);

