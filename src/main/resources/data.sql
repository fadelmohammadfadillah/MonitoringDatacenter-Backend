




DROP INDEX IF EXISTS BACKUP_SERVER_APP_FK;

DROP INDEX IF EXISTS BACKUP_APP_PK;

DROP TABLE IF EXISTS BACKUP_APP;

DROP INDEX IF EXISTS BACKUP_APP_MON_FK;

DROP INDEX IF EXISTS BACKUP_APP_DTL_MON_FK;

DROP INDEX IF EXISTS BACKUP_APP_MONITORING_PK;

DROP TABLE IF EXISTS BACKUP_APP_MONITORING;

DROP INDEX IF EXISTS BACKUP_SERVER_DB_FK;

DROP INDEX IF EXISTS BACKUP_DB_PK;

DROP TABLE IF EXISTS BACKUP_DB;

DROP INDEX IF EXISTS BACKUP_DB_MON_FK;

DROP INDEX IF EXISTS BACKUP_DB_DTL_MON_FK;

DROP INDEX IF EXISTS BACKUP_DB_MONITORING_PK;

DROP TABLE IF EXISTS BACKUP_DB_MONITORING;

DROP INDEX IF EXISTS BANK_PK;

DROP TABLE IF EXISTS BANK;

DROP INDEX IF EXISTS DIVISI_DEPARTMENT_FK;

DROP INDEX IF EXISTS DEPARTMENT_PK;

DROP TABLE IF EXISTS DEPARTMENT;

DROP INDEX IF EXISTS MONITORING_SUBPRODUCT_FK;

DROP INDEX IF EXISTS PRODUCT_DTL_MON_FK;

DROP INDEX IF EXISTS BANK_DTL_MON_FK;

DROP INDEX IF EXISTS DTL_MON_FK;

DROP INDEX IF EXISTS DETAIL_MONITORING_PK;

DROP TABLE IF EXISTS DETAIL_MONITORING;

DROP INDEX IF EXISTS DIVISI_PK;

DROP TABLE IF EXISTS DIVISI;

DROP INDEX IF EXISTS SUPERVISOR_MONITORING_FK;

DROP INDEX IF EXISTS OPERATOR_MONITORING_FK;

DROP INDEX IF EXISTS MANAGER_MONITORING_FK;

DROP INDEX IF EXISTS EVENT_MONITORING_PK;

DROP TABLE IF EXISTS EVENT_MONITORING;

DROP INDEX IF EXISTS MANAGER_PK;

DROP TABLE IF EXISTS MANAGER;

DROP INDEX IF EXISTS FK_MODULE_CONSIST_O_PRODUCT_FK;

DROP INDEX IF EXISTS MODULE_PK;

DROP TABLE IF EXISTS MODULE;

DROP INDEX IF EXISTS MODULE_MON_FK;

DROP INDEX IF EXISTS MODULE_DTL_MON_FK;

DROP INDEX IF EXISTS MODULE_MONITORING_PK;

DROP TABLE IF EXISTS MODULE_MONITORING;

DROP INDEX IF EXISTS OPERATOR_PK;

DROP TABLE IF EXISTS OPERATOR;

DROP INDEX IF EXISTS PATH_APP_USE_MON_FK;

DROP INDEX IF EXISTS PATH_USE_APP_DTL_MON_FK;

DROP INDEX IF EXISTS PATH_APP_USE_MONITORING_PK;

DROP TABLE IF EXISTS PATH_APP_USE_MONITORING;

DROP INDEX IF EXISTS PATH_DB_USE_MON_FK;

DROP INDEX IF EXISTS PATH_DB_USE_DTL_MON_FK;

DROP INDEX IF EXISTS PATH_DB_USE_MONITORING_PK;

DROP TABLE IF EXISTS PATH_DB_USE_MONITORING;

DROP INDEX IF EXISTS RELATIONSHIP_9_FK;

DROP INDEX IF EXISTS PRODUCT_PK;

DROP TABLE IF EXISTS PRODUCT;

DROP INDEX IF EXISTS SERVER_APP_PK;

DROP TABLE IF EXISTS SERVER_APP;

DROP INDEX IF EXISTS SERVER_APP_MON_FK;

DROP INDEX IF EXISTS SERVER_APP_DTL_MON_FK;

DROP INDEX IF EXISTS SERVER_APP_MONITORING_PK;

DROP TABLE IF EXISTS SERVER_APP_MONITORING;

DROP INDEX IF EXISTS PATH_SERVER_APP_FK;

DROP INDEX IF EXISTS SERVER_APP_PATH_PK;

DROP TABLE IF EXISTS SERVER_APP_PATH;

DROP INDEX IF EXISTS SERVER_DB_PK;

DROP TABLE IF EXISTS SERVER_DB;

DROP INDEX IF EXISTS SERVER_DB_MON_FK;

DROP INDEX IF EXISTS SERVER_DB_DTL_MON_FK;

DROP INDEX IF EXISTS SERVER_DB_MONITORING_PK;

DROP TABLE IF EXISTS SERVER_DB_MONITORING;

DROP INDEX IF EXISTS PATH_SERVER_DB_FK;

DROP INDEX IF EXISTS SERVER_DB_PATH_PK;

DROP TABLE IF EXISTS SERVER_DB_PATH;

DROP INDEX IF EXISTS HAS_SUB_PRODUCT_FK;

DROP INDEX IF EXISTS SUBPRODUCT_PK;

DROP TABLE IF EXISTS SUBPRODUCT;

DROP INDEX IF EXISTS SUPERVISOR_PK;

DROP TABLE IF EXISTS SUPERVISOR;

DROP INDEX IF EXISTS USER_DEPARTMENT_FK;

DROP INDEX IF EXISTS USER_DEPARTMENT_PK;

DROP TABLE IF EXISTS USER_DEPARTMENT;

DROP INDEX IF EXISTS USER_DIVISI_FK;

DROP INDEX IF EXISTS USER_DIVISI_PK;

DROP TABLE IF EXISTS USER_DIVISI;

DROP TABLE IF EXISTS SUPER_ADMIN;

DROP INDEX IF EXISTS SUPER_ADMIN_PK;

CREATE TABLE SUPER_ADMIN(
   ID_SUPERADMIN        INT4                 NOT NULL,
   USERNAME             VARCHAR(20)          NOT NULL,
   PASSWORD             VARCHAR(20)          NOT NULL,
   CONSTRAINT PK_SUPERADMIN PRIMARY KEY (ID_SUPERADMIN)
);

CREATE UNIQUE INDEX PK_SUPERADMIN ON SUPER_ADMIN (
   ID_SUPERADMIN
);


create table BACKUP_APP (
   ID_BACKUP_APP        INT4                 not null,
   ID_SERVER_APP        INT4                 null,
   DIRECTORY            VARCHAR(100)         null,
   constraint PK_BACKUP_APP primary key (ID_BACKUP_APP)
);




create unique index BACKUP_APP_PK on BACKUP_APP (
ID_BACKUP_APP
);




create  index BACKUP_SERVER_APP_FK on BACKUP_APP (
ID_SERVER_APP
);




create table BACKUP_APP_MONITORING (
   ID_BACKUP_APP_MON    INT4                 not null,
   ID_BACKUP_APP        INT4                 null,
   ID_DTL_MON           INT4                 null,
   STATUS               VARCHAR(10)          null,
   LOG                  VARCHAR(500)         null,
   OPERATOR_NOTES       VARCHAR(500)         null,
   constraint PK_BACKUP_APP_MONITORING primary key (ID_BACKUP_APP_MON)
);




create unique index BACKUP_APP_MONITORING_PK on BACKUP_APP_MONITORING (
ID_BACKUP_APP_MON
);




create  index BACKUP_APP_DTL_MON_FK on BACKUP_APP_MONITORING (
ID_DTL_MON
);




create  index BACKUP_APP_MON_FK on BACKUP_APP_MONITORING (
ID_BACKUP_APP
);




create table BACKUP_DB (
   ID_BACKUP_DB         INT4                 not null,
   ID_SERVER_DB         INT4                 null,
   DIRECTORY            VARCHAR(100)         null,
   constraint PK_BACKUP_DB primary key (ID_BACKUP_DB)
);




create unique index BACKUP_DB_PK on BACKUP_DB (
ID_BACKUP_DB
);




create  index BACKUP_SERVER_DB_FK on BACKUP_DB (
ID_SERVER_DB
);




create table BACKUP_DB_MONITORING (
   ID_BACKUP_DB_MON     INT4                 not null,
   ID_DTL_MON           INT4                 null,
   ID_BACKUP_DB         INT4                 null,
   STATUS               VARCHAR(10)          null,
   LOG                  VARCHAR(500)         null,
   OPERATOR_NOTES       VARCHAR(500)         null,
   constraint PK_BACKUP_DB_MONITORING primary key (ID_BACKUP_DB_MON)
);




create unique index BACKUP_DB_MONITORING_PK on BACKUP_DB_MONITORING (
ID_BACKUP_DB_MON
);




create  index BACKUP_DB_DTL_MON_FK on BACKUP_DB_MONITORING (
ID_DTL_MON
);




create  index BACKUP_DB_MON_FK on BACKUP_DB_MONITORING (
ID_BACKUP_DB
);




create table BANK (
   BANK_NAME            VARCHAR(50)          null,
   ID_BANK              INT4                 not null,
   constraint PK_BANK primary key (ID_BANK)
);




create unique index BANK_PK on BANK (
ID_BANK
);




create table DEPARTMENT (
   DEPARTMENT_NAME      VARCHAR(50)          null,
   ID_DEPARTMENT        INT4                 not null,
   ID_DIVISI            INT4                 null,
   constraint PK_DEPARTMENT primary key (ID_DEPARTMENT)
);




create unique index DEPARTMENT_PK on DEPARTMENT (
ID_DEPARTMENT
);




create  index DIVISI_DEPARTMENT_FK on DEPARTMENT (
ID_DIVISI
);




create table DETAIL_MONITORING (
   ID_DTL_MON           INT4                 not null,
   ID_PRODUCT           INT4                 null,
   ID_SUBPRODUCT        INT4                 null,
   ID_MONITORING        INT4                 null,
   ID_BANK              INT4                 null,
   constraint PK_DETAIL_MONITORING primary key (ID_DTL_MON)
);




create unique index DETAIL_MONITORING_PK on DETAIL_MONITORING (
ID_DTL_MON
);




create  index DTL_MON_FK on DETAIL_MONITORING (
ID_MONITORING
);




create  index BANK_DTL_MON_FK on DETAIL_MONITORING (
ID_BANK
);




create  index PRODUCT_DTL_MON_FK on DETAIL_MONITORING (
ID_PRODUCT
);




create  index MONITORING_SUBPRODUCT_FK on DETAIL_MONITORING (
ID_SUBPRODUCT
);




create table DIVISI (
   ID_DIVISI            INT4                 not null,
   DIVISI_NAME          VARCHAR(50)          null,
   constraint PK_DIVISI primary key (ID_DIVISI)
);




create unique index DIVISI_PK on DIVISI (
ID_DIVISI
);




create table EVENT_MONITORING (
   APPROVAL_STATUS      VARCHAR(10)          null,
   ID_MONITORING        INT4                 not null,
   ID_MANAGER           INT4                 not null,
   ID_OPERATOR          INT4                 not null,
   ID_SUPERVISOR        INT4                 null,
   OPERATOR_NOTES       VARCHAR(500)         null,
   DATE                 DATE                 null,
   "TIME"               TIME                 null,
   constraint PK_EVENT_MONITORING primary key (ID_MONITORING)
);




create unique index EVENT_MONITORING_PK on EVENT_MONITORING (
ID_MONITORING
);




create  index MANAGER_MONITORING_FK on EVENT_MONITORING (
ID_MANAGER
);




create  index OPERATOR_MONITORING_FK on EVENT_MONITORING (
ID_OPERATOR
);




create  index SUPERVISOR_MONITORING_FK on EVENT_MONITORING (
ID_SUPERVISOR
);




create table MANAGER (
   ID_MANAGER           INT4                 not null,
   NAME                 VARCHAR(50)          null,
   USERNAME             VARCHAR(20)          null,
   PASSWORD             VARCHAR(20)          null,
   constraint PK_MANAGER primary key (ID_MANAGER)
);




create unique index MANAGER_PK on MANAGER (
ID_MANAGER
);




create table MODULE (
   ID_SUBPRODUCT        INT4                 not null,
   ID_MODULE            INT4                 not null,
   MODULE_NAME          VARCHAR(50)          null,
   PROFILE              VARCHAR(30)          null,
   constraint PK_MODULE primary key (ID_SUBPRODUCT, ID_MODULE)
);




create unique index MODULE_PK on MODULE (
ID_SUBPRODUCT,
ID_MODULE
);




create  index FK_MODULE_CONSIST_O_PRODUCT_FK on MODULE (
ID_SUBPRODUCT
);




create table MODULE_MONITORING (
   ID_MODULE_MON        INT4                 not null,
   ID_SUBPRODUCT        INT4                 not null,
   ID_MODULE            INT4                 not null,
   ID_DTL_MON           INT4                 null,
   STATUS               VARCHAR(10)          null,
   OPERATOR_NOTES       VARCHAR(500)         null,
   PERFORMA             VARCHAR(20)          null,
   LOG                  VARCHAR(500)         null,
   constraint PK_MODULE_MONITORING primary key (ID_MODULE_MON)
);




create unique index MODULE_MONITORING_PK on MODULE_MONITORING (
ID_MODULE_MON
);




create  index MODULE_DTL_MON_FK on MODULE_MONITORING (
ID_DTL_MON
);




create  index MODULE_MON_FK on MODULE_MONITORING (
ID_SUBPRODUCT,
ID_MODULE
);




create table OPERATOR (
   ID_OPERATOR          INT4                 not null,
   NAME                 VARCHAR(50)          null,
   USERNAME             VARCHAR(20)          null,
   PASSWORD             VARCHAR(20)          null,
   constraint PK_OPERATOR primary key (ID_OPERATOR)
);




create unique index OPERATOR_PK on OPERATOR (
ID_OPERATOR
);




create table PATH_APP_USE_MONITORING (
   ID_PATH_APP_USE_MON  INT4                 not null,
   ID_DTL_MON           INT4                 null,
   ID_SERVER_APP_PATH   INT4                 null,
   USAGE                INT4                 null,
   constraint PK_PATH_APP_USE_MONITORING primary key (ID_PATH_APP_USE_MON)
);




create unique index PATH_APP_USE_MONITORING_PK on PATH_APP_USE_MONITORING (
ID_PATH_APP_USE_MON
);




create  index PATH_USE_APP_DTL_MON_FK on PATH_APP_USE_MONITORING (
ID_DTL_MON
);




create  index PATH_APP_USE_MON_FK on PATH_APP_USE_MONITORING (
ID_SERVER_APP_PATH
);




create table PATH_DB_USE_MONITORING (
   ID_PATH_DB_USE_MON   INT4                 not null,
   ID_DTL_MON           INT4                 null,
   ID_SERVER_DB_PATH    INT4                 null,
   USAGE                INT4                 null,
   constraint PK_PATH_DB_USE_MONITORING primary key (ID_PATH_DB_USE_MON)
);




create unique index PATH_DB_USE_MONITORING_PK on PATH_DB_USE_MONITORING (
ID_PATH_DB_USE_MON
);




create  index PATH_DB_USE_DTL_MON_FK on PATH_DB_USE_MONITORING (
ID_DTL_MON
);




create  index PATH_DB_USE_MON_FK on PATH_DB_USE_MONITORING (
ID_SERVER_DB_PATH
);




create table PRODUCT (
   ID_PRODUCT           INT4                 not null,
   ID_DEPARTMENT        INT4                 null,
   PRODUCT_NAME         VARCHAR(50)          null,
   constraint PK_PRODUCT primary key (ID_PRODUCT)
);




create unique index PRODUCT_PK on PRODUCT (
ID_PRODUCT
);




create  index RELATIONSHIP_9_FK on PRODUCT (
ID_DEPARTMENT
);




create table SERVER_APP (
   ID_SERVER_APP        INT4                 not null,
   IP_SERVER            VARCHAR(15)          null,
   constraint PK_SERVER_APP primary key (ID_SERVER_APP)
);




create unique index SERVER_APP_PK on SERVER_APP (
ID_SERVER_APP
);




create table SERVER_APP_MONITORING (
   ID_SERVER_APP_MON    INT4                 not null,
   ID_SERVER_APP        INT4                 not null,
   ID_DTL_MON           INT4                 null,
   RAM_USAGE            INT2                 null,
   CPU_USAGE            INT2                 null,
   DISK_USAGE           INT2                 null,
   OPERATOR_NOTES       VARCHAR(500)         null,
   LOG                  VARCHAR(500)         null,
   constraint PK_SERVER_APP_MONITORING primary key (ID_SERVER_APP_MON)
);




create unique index SERVER_APP_MONITORING_PK on SERVER_APP_MONITORING (
ID_SERVER_APP_MON
);




create  index SERVER_APP_DTL_MON_FK on SERVER_APP_MONITORING (
ID_DTL_MON
);




create  index SERVER_APP_MON_FK on SERVER_APP_MONITORING (
ID_SERVER_APP
);




create table SERVER_APP_PATH (
   ID_SERVER_APP_PATH   INT4                 not null,
   ID_SERVER_APP        INT4                 null,
   PATH                 VARCHAR(100)         null,
   constraint PK_SERVER_APP_PATH primary key (ID_SERVER_APP_PATH)
);




create unique index SERVER_APP_PATH_PK on SERVER_APP_PATH (
ID_SERVER_APP_PATH
);




create  index PATH_SERVER_APP_FK on SERVER_APP_PATH (
ID_SERVER_APP
);




create table SERVER_DB (
   ID_SERVER_DB         INT4                 not null,
   IP_ADDRESS           VARCHAR(15)          null,
   constraint PK_SERVER_DB primary key (ID_SERVER_DB)
);




create unique index SERVER_DB_PK on SERVER_DB (
ID_SERVER_DB
);




create table SERVER_DB_MONITORING (
   ID_SERVER_DB_MON     INT4                 not null,
   ID_DTL_MON           INT4                 null,
   ID_SERVER_DB         INT4                 null,
   RAM_USAGE            INT2                 null,
   CPU_USAGE            INT2                 null,
   DISK_USAGE           INT2                 null,
   OPERATOR_NOTES       VARCHAR(500)         null,
   LOG                  VARCHAR(500)         null,
   constraint PK_SERVER_DB_MONITORING primary key (ID_SERVER_DB_MON)
);




create unique index SERVER_DB_MONITORING_PK on SERVER_DB_MONITORING (
ID_SERVER_DB_MON
);




create  index SERVER_DB_DTL_MON_FK on SERVER_DB_MONITORING (
ID_DTL_MON
);




create  index SERVER_DB_MON_FK on SERVER_DB_MONITORING (
ID_SERVER_DB
);




create table SERVER_DB_PATH (
   ID_SERVER_DB_PATH    INT4                 not null,
   ID_SERVER_DB         INT4                 null,
   PATH                 VARCHAR(100)         null,
   constraint PK_SERVER_DB_PATH primary key (ID_SERVER_DB_PATH)
);




create unique index SERVER_DB_PATH_PK on SERVER_DB_PATH (
ID_SERVER_DB_PATH
);




create  index PATH_SERVER_DB_FK on SERVER_DB_PATH (
ID_SERVER_DB
);




create table SUBPRODUCT (
   SUBPRODUCT_NAME      VARCHAR(50)          null,
   ID_SUBPRODUCT        INT4                 not null,
   ID_PRODUCT           INT4                 null,
   constraint PK_SUBPRODUCT primary key (ID_SUBPRODUCT)
);




create unique index SUBPRODUCT_PK on SUBPRODUCT (
ID_SUBPRODUCT
);




create  index HAS_SUB_PRODUCT_FK on SUBPRODUCT (
ID_PRODUCT
);




create table SUPERVISOR (
   ID_SUPERVISOR        INT4                 not null,
   NAME                 VARCHAR(50)          null,
   USERNAME             VARCHAR(20)          null,
   PASSWORD             VARCHAR(20)          null,
   constraint PK_SUPERVISOR primary key (ID_SUPERVISOR)
);




create unique index SUPERVISOR_PK on SUPERVISOR (
ID_SUPERVISOR
);




create table USER_DEPARTMENT (
   ID_DEPARTMENT        INT4                 not null,
   ID_USER_DEPARTMENT   INT4                 not null,
   NAME                 VARCHAR(50)          null,
   USERNAME             VARCHAR(20)          null,
   PASSWORD             VARCHAR(20)          null,
   constraint PK_USER_DEPARTMENT primary key (ID_DEPARTMENT, ID_USER_DEPARTMENT)
);




create unique index USER_DEPARTMENT_PK on USER_DEPARTMENT (
ID_DEPARTMENT,
ID_USER_DEPARTMENT
);




create  index USER_DEPARTMENT_FK on USER_DEPARTMENT (
ID_DEPARTMENT
);




create table USER_DIVISI (
   ID_DIVISI            INT4                 not null,
   ID_USER_DIVISI       INT4                 not null,
   NAME                 VARCHAR(50)          null,
   USERNAME             VARCHAR(20)          null,
   PASSWORD             VARCHAR(20)          null,
   constraint PK_USER_DIVISI primary key (ID_DIVISI, ID_USER_DIVISI)
);




create unique index USER_DIVISI_PK on USER_DIVISI (
ID_DIVISI,
ID_USER_DIVISI
);




create  index USER_DIVISI_FK on USER_DIVISI (
ID_DIVISI
);

alter table BACKUP_APP
   add constraint FK_BACKUP_A_BACKUP_SE_SERVER_A foreign key (ID_SERVER_APP)
      references SERVER_APP (ID_SERVER_APP)
      on delete restrict on update restrict;

alter table BACKUP_APP_MONITORING
   add constraint FK_BACKUP_A_BACKUP_AP_DETAIL_M foreign key (ID_DTL_MON)
      references DETAIL_MONITORING (ID_DTL_MON)
      on delete restrict on update restrict;

alter table BACKUP_APP_MONITORING
   add constraint FK_BACKUP_A_BACKUP_AP_BACKUP_A foreign key (ID_BACKUP_APP)
      references BACKUP_APP (ID_BACKUP_APP)
      on delete restrict on update restrict;

alter table BACKUP_DB
   add constraint FK_BACKUP_D_BACKUP_SE_SERVER_D foreign key (ID_SERVER_DB)
      references SERVER_DB (ID_SERVER_DB)
      on delete restrict on update restrict;

alter table BACKUP_DB_MONITORING
   add constraint FK_BACKUP_D_BACKUP_DB_DETAIL_M foreign key (ID_DTL_MON)
      references DETAIL_MONITORING (ID_DTL_MON)
      on delete restrict on update restrict;

alter table BACKUP_DB_MONITORING
   add constraint FK_BACKUP_D_BACKUP_DB_BACKUP_D foreign key (ID_BACKUP_DB)
      references BACKUP_DB (ID_BACKUP_DB)
      on delete restrict on update restrict;

alter table DEPARTMENT
   add constraint FK_DEPARTME_DIVISI_DE_DIVISI foreign key (ID_DIVISI)
      references DIVISI (ID_DIVISI)
      on delete restrict on update restrict;

alter table DETAIL_MONITORING
   add constraint FK_DETAIL_M_BANK_DTL__BANK foreign key (ID_BANK)
      references BANK (ID_BANK)
      on delete restrict on update restrict;

alter table DETAIL_MONITORING
   add constraint FK_DETAIL_M_DTL_MON_EVENT_MO foreign key (ID_MONITORING)
      references EVENT_MONITORING (ID_MONITORING)
      on delete restrict on update restrict;

alter table DETAIL_MONITORING
   add constraint FK_DETAIL_M_MONITORIN_SUBPRODU foreign key (ID_SUBPRODUCT)
      references SUBPRODUCT (ID_SUBPRODUCT)
      on delete restrict on update restrict;

alter table DETAIL_MONITORING
   add constraint FK_DETAIL_M_PRODUCT_D_PRODUCT foreign key (ID_PRODUCT)
      references PRODUCT (ID_PRODUCT)
      on delete restrict on update restrict;

alter table EVENT_MONITORING
   add constraint FK_EVENT_MO_MANAGER_M_MANAGER foreign key (ID_MANAGER)
      references MANAGER (ID_MANAGER)
      on delete restrict on update restrict;

alter table EVENT_MONITORING
   add constraint FK_EVENT_MO_OPERATOR__OPERATOR foreign key (ID_OPERATOR)
      references OPERATOR (ID_OPERATOR)
      on delete restrict on update restrict;

alter table EVENT_MONITORING
   add constraint FK_EVENT_MO_SUPERVISO_SUPERVIS foreign key (ID_SUPERVISOR)
      references SUPERVISOR (ID_SUPERVISOR)
      on delete restrict on update restrict;

alter table MODULE
   add constraint FK_MODULE_FK_MODULE_SUBPRODU foreign key (ID_SUBPRODUCT)
      references SUBPRODUCT (ID_SUBPRODUCT)
      on delete restrict on update restrict;

alter table MODULE_MONITORING
   add constraint FK_MODULE_M_MODULE_DT_DETAIL_M foreign key (ID_DTL_MON)
      references DETAIL_MONITORING (ID_DTL_MON)
      on delete restrict on update restrict;

alter table MODULE_MONITORING
   add constraint FK_MODULE_M_MODULE_MO_MODULE foreign key (ID_SUBPRODUCT, ID_MODULE)
      references MODULE (ID_SUBPRODUCT, ID_MODULE)
      on delete restrict on update restrict;

alter table PATH_APP_USE_MONITORING
   add constraint FK_PATH_APP_PATH_APP__SERVER_A foreign key (ID_SERVER_APP_PATH)
      references SERVER_APP_PATH (ID_SERVER_APP_PATH)
      on delete restrict on update restrict;

alter table PATH_APP_USE_MONITORING
   add constraint FK_PATH_APP_PATH_USE__DETAIL_M foreign key (ID_DTL_MON)
      references DETAIL_MONITORING (ID_DTL_MON)
      on delete restrict on update restrict;

alter table PATH_DB_USE_MONITORING
   add constraint FK_PATH_DB__PATH_DB_U_DETAIL_M foreign key (ID_DTL_MON)
      references DETAIL_MONITORING (ID_DTL_MON)
      on delete restrict on update restrict;

alter table PATH_DB_USE_MONITORING
   add constraint FK_PATH_DB__PATH_DB_U_SERVER_D foreign key (ID_SERVER_DB_PATH)
      references SERVER_DB_PATH (ID_SERVER_DB_PATH)
      on delete restrict on update restrict;

alter table PRODUCT
   add constraint FK_PRODUCT_RELATIONS_DEPARTME foreign key (ID_DEPARTMENT)
      references DEPARTMENT (ID_DEPARTMENT)
      on delete restrict on update restrict;

alter table SERVER_APP_MONITORING
   add constraint FK_SERVER_A_SERVER_AP_DETAIL_M foreign key (ID_DTL_MON)
      references DETAIL_MONITORING (ID_DTL_MON)
      on delete restrict on update restrict;

alter table SERVER_APP_MONITORING
   add constraint FK_SERVER_A_SERVER_AP_SERVER_A foreign key (ID_SERVER_APP)
      references SERVER_APP (ID_SERVER_APP)
      on delete restrict on update restrict;

alter table SERVER_APP_PATH
   add constraint FK_SERVER_A_PATH_SERV_SERVER_A foreign key (ID_SERVER_APP)
      references SERVER_APP (ID_SERVER_APP)
      on delete restrict on update restrict;

alter table SERVER_DB_MONITORING
   add constraint FK_SERVER_D_SERVER_DB_DETAIL_M foreign key (ID_DTL_MON)
      references DETAIL_MONITORING (ID_DTL_MON)
      on delete restrict on update restrict;

alter table SERVER_DB_MONITORING
   add constraint FK_SERVER_D_SERVER_DB_SERVER_D foreign key (ID_SERVER_DB)
      references SERVER_DB (ID_SERVER_DB)
      on delete restrict on update restrict;

alter table SERVER_DB_PATH
   add constraint FK_SERVER_D_PATH_SERV_SERVER_D foreign key (ID_SERVER_DB)
      references SERVER_DB (ID_SERVER_DB)
      on delete restrict on update restrict;

alter table SUBPRODUCT
   add constraint FK_SUBPRODU_HAS_SUB_P_PRODUCT foreign key (ID_PRODUCT)
      references PRODUCT (ID_PRODUCT)
      on delete restrict on update restrict;

alter table USER_DEPARTMENT
   add constraint FK_USER_DEP_USER_DEPA_DEPARTME foreign key (ID_DEPARTMENT)
      references DEPARTMENT (ID_DEPARTMENT)
      on delete restrict on update restrict;

alter table USER_DIVISI
   add constraint FK_USER_DIV_USER_DIVI_DIVISI foreign key (ID_DIVISI)
      references DIVISI (ID_DIVISI)
      on delete restrict on update restrict;



-- INSERT INTO SUPERADMIN (id, password, username) VALUES (1, '$2a$10$sb2EdlqFkwUVaNXFJZqBCuFCIQEGXPJmlauuQYm7PmEHlnaDWgXUq', 'admin');