-- begin CEAA_CUSTOMER_FILE_DESCRIPTOR_LINK
alter table CEAA_CUSTOMER_FILE_DESCRIPTOR_LINK add constraint FK_CUSFILDES_ON_CUSTOMER foreign key (CUSTOMER_ID) references CEAA_CUSTOMER(ID)^
alter table CEAA_CUSTOMER_FILE_DESCRIPTOR_LINK add constraint FK_CUSFILDES_ON_FILE_DESCRIPTOR foreign key (FILE_DESCRIPTOR_ID) references SYS_FILE(ID)^
-- end CEAA_CUSTOMER_FILE_DESCRIPTOR_LINK