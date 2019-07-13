-- begin CEAA_CUSTOMER
create table CEAA_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    FIRST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end CEAA_CUSTOMER
-- begin CEAA_CUSTOMER_FILE_DESCRIPTOR_LINK
create table CEAA_CUSTOMER_FILE_DESCRIPTOR_LINK (
    CUSTOMER_ID varchar(36) not null,
    FILE_DESCRIPTOR_ID varchar(36) not null,
    primary key (CUSTOMER_ID, FILE_DESCRIPTOR_ID)
)^
-- end CEAA_CUSTOMER_FILE_DESCRIPTOR_LINK
