-- super admin
INSERT INTO SUPERADMIN (ID_SUPERADMIN, password, username) VALUES (1, '$2a$10$sb2EdlqFkwUVaNXFJZqBCuFCIQEGXPJmlauuQYm7PmEHlnaDWgXUq', 'admin');
SELECT setval('superadmin_id_superadmin_seq', (SELECT MAX(ID_SUPERADMIN) FROM SUPERADMIN));

-- #data divisi
INSERT INTO divisi (ID_Divisi, Divisi_Name) VALUES
(1, 'Business Development'),
(2, 'Core Banking System Conventional'),
(3, 'Core Banking System Syariah'),
(4, 'Digital Enterprise'),
(5, 'Surrounding Application'),
(6, 'Regulatory & Financial Reporting'),
(7, 'Quality Assurance'),
(8, 'Region 1'),
(9, 'Region 2'),
(10, 'Region 3'),
(11, 'IT Operation Management'),
(12, 'Infrastructure'),
(13, 'Business Support'),
(14, 'Human Capital, Finance, Legal, & Corporate Secretary'),
(15, 'Internal Audit & Risk Management');
SELECT setval('divisi_id_divisi_seq', (SELECT MAX(id_divisi) FROM divisi));

-- #data department
INSERT INTO department (ID_Department, Department_Name, ID_DIVISI) VALUES
(1, 'Sales & Business Development', 1),
(2, 'Business Application Conventional', 2),
(3, 'System Application Development Conventional', 2),
(4, 'Business Application Syariah', 3),
(5, 'System Application Development Syariah', 3),
(6, 'Card & Digital Transaction', 4),
(7, 'Digital Channel', 4),
(8, 'Data Warehouse & Mangement Information System', 5),
(9, 'Regulatory Report', 6),
(10, 'Financial Reporting', 6),
(11, 'Quality Control, Quality Assurance, & Application Control Library', 7),
(12, 'Data Center Operation', 11),
(13, 'Disaster Recovery Center Operation', 11),
(14, 'Digital Enterprise Operation', 11),
(15, 'Security Operation Center', 12),
(16, 'Network Operation', 12),
(17, 'Infrastructure & Application Support Operation', 12),
(18, 'Procurement & Office Management', 13),
(19, 'Human Capital', 14),
(20, 'Finance', 14),
(21, 'Legal & Corporate Secretary', 14),
(22, 'Internal Audit', 15),
(23, 'Information Security & Risk Management', 15);
SELECT setval('department_id_department_seq', (SELECT MAX(ID_Department) FROM department));

-- #DATA PO DEPARTMENT
INSERT INTO product_owner (ID_PO, NAME, USERNAME, PASSWORD, ID_DIVISI, ID_DEPARTMENT) VALUES
(1, 'PO DEPT CDT', 'podeptcdt', '12345678', 1, 1);
-- #DATA PO DIVISI
INSERT INTO product_owner (ID_PO, NAME, USERNAME, PASSWORD, ID_DIVISI) VALUES
(2, 'PO DIV DE', 'podivde', '12345678', 2);
SELECT setval('product_owner_id_po_seq', (SELECT MAX(ID_USER) FROM users));
-- #data bank
INSERT INTO bank (ID_Bank, Bank_Name) VALUES
(1, 'Bank Aceh'),
(2, 'Bank IBKIndonesia'),
(3, 'Bank Sulteng'),
(4, 'Bank NTB'),
(5, 'Bank Bengkulu');
SELECT setval('bank_id_bank_seq', (SELECT MAX(id_bank) FROM bank));

-- #data product
INSERT INTO PRODUCT (ID_PRODUCT, ID_DEPARTMENT, PRODUCT_NAME)
VALUES (1, 1, 'SWITCHING');
INSERT INTO PRODUCT (ID_PRODUCT, ID_DEPARTMENT, PRODUCT_NAME)
VALUES (2, 1, 'MIDDLEWARE');
INSERT INTO PRODUCT (ID_PRODUCT, ID_DEPARTMENT, PRODUCT_NAME)
VALUES (3, 4, 'CONVENTIONAL BANK APP');
SELECT setval('product_id_product_seq', (SELECT MAX(Id_product) FROM product));

-- #data server app
INSERT INTO server_app (ID_Server_App, IP_Address) VALUES
(1, '10.234.44.80'),
(2, '10.234.44.30'),
(3, '10.234.44.94'),
(4, '10.234.44.56'),
(5, '10.234.44.83'),
(6, '10.234.44.64'),
(7, '10.234.44.81'),
(8, '10.234.44.121'),
(9, '10.234.44.85'),
(10, '10.234.44.113:3901'),
(11, '10.234.44.62:3901'),
(12, '10.234.44.117'),
(13, '10.234.44.116'),
(14, '10.234.44.115');
SELECT setval('server_app_id_server_app_seq', (SELECT MAX(ID_Server_App) FROM server_app));

-- #DATA SERVER APP PATH
INSERT INTO server_app_path (ID_Server_App, ID_Server_App_Path, Path) VALUES
(1, 1, '/'),
(2, 2, '/home'),
(3, 3, '/'),
(4, 4, '/home'),
(5, 5, '/'),
(6, 6, '/'),
(7, 7, '/'),
(8, 8, '/'),
(9, 9, '/'),
(10, 10, '/home'),
(11, 11, '/opt'),
(12, 12, '/'),
(13, 13, '/'),
(14, 14, '/'),
(1, 15, '/'),
(2, 16, '/'),
(3, 17, '/home'),
(4, 18, '/opt'),
(5, 19, '/'),
(6, 20, '/');
SELECT setval('server_app_path_id_server_app_path_seq', (SELECT MAX(ID_Server_App_Path) FROM server_app_path));

-- #DATA BACKUP APP
INSERT INTO backup_app (ID_Server_App, ID_Backup_App, Directory) VALUES
(1, 1, '/backups/ATM116'),
(2, 2, '/backups/BPIH116'),
(3, 3, '/backups/pymaceh/'),
(4, 4, '/home/collega/backup/cms_corp'),
(5, 5, '$EMWARE_LOG'),
(6, 6, '/home/collega/eMware/log'),
(7, 7, '/home/collega/backup'),
(8, 8, '/opt/emware724/rekon/rekonfinnet (116_050012_yyymmdd.txt)'),
(9, 9, '/opt/emware724/report/samolnas (exportsamolnas_ddmmyyyy.csv)'),
(10, 10, '/opt/apache-tomcat_7070/logs'),
(11, 11, '/backups/KSDACEH/backupkasda'),
(12, 12, '/backups/MASKACEH'),
(13, 13, '/home/web116/apache-cardapi-6060/log'),
(14, 14, '/home/web116/apache-apikey-7070/log'),
(1, 15, '/home/web116/apache-emwares-key-5050/log');
SELECT setval('backup_app_id_backup_app_seq', (SELECT MAX(ID_Backup_App) FROM backup_app));

-- #DATA SERVER DB
INSERT INTO server_db (ID_Server_DB, IP_Address) VALUES
(1, '10.234.44.106'),
(2, '10.234.44.101'),
(3, '10.234.44.82'),
(4, '10.234.44.104'),
(5, '10.234.44.65'),
(6, '10.234.44.89'),
(7, '10.234.44.61'),
(8, '10.234.44.119'),
(9, '10.234.44.86'),
(10, '10.234.44.102:22'),
(11, '10.234.44.118'),
(12, '10.234.44.122'),
(13, '10.234.44.123'),
(14, '10.234.44.120');
SELECT setval('server_db_id_server_db_seq', (SELECT MAX(ID_Server_DB) FROM server_db));


-- #DATA SERVER DB PATH
INSERT INTO server_db_path (ID_Server_DB, ID_Server_DB_path, Path) VALUES
(1, 1, '/backups'),
(2, 2, '/backups'),
(3, 3, '/backup'),
(4, 4, '/home'),
(5, 5, '/'),
(6, 6, '/'),
(7, 7, '/'),
(8, 8, '/'),
(9, 9, '/'),
(10, 10, '/'),
(11, 11, '/'),
(12, 12, '/'),
(13, 13, '/'),
(14, 14, '/');
SELECT setval('server_db_path_id_server_db_path_seq', (SELECT MAX(ID_Server_DB_path) FROM server_db_path));


-- #DATA BACKUP DB

INSERT INTO backup_db (ID_Server_DB, ID_Backup_DB, Directory) VALUES
(1, 1, '/home/db2inst1/dbpinpad'),
(2, 2, '/backup/'),
(3, 3, '/home/postgres/backupdb');
SELECT setval('backup_db_id_backup_db_seq', (SELECT MAX(ID_Backup_DB) FROM backup_db));


-- #data subproduct
INSERT INTO subproduct (ID_SubProduct, SubProduct_Name, Id_product) VALUES
(1, 'ATM', 1),
(2, 'BPIH', 1),
(3, 'PAYMENT', 1),
(4, 'KASDA 8080', 2),
(5, 'PINPAD', 1),
(6, 'NOTIFIER', 2),
(7, 'E-REKON', 1),
(8, 'TOOLS', 2),
(9, 'LAKU PANDAI', 1),
(10, 'SERVICE CARDLESS', 1),
(11, 'CMS CORP APP', 1),
(12, 'USERMANAGEMENT', 1),
(13, 'PUSHNOTIF CARDLESS', 2),
(14, 'PAYMENT GATEWAY CARDLESS', 2);
SELECT setval('subproduct_id_subproduct_seq', (SELECT MAX(ID_SubProduct) FROM subproduct));


-- #DATA MODULE
INSERT INTO module (ID_SubProduct, ID_Module, Module_Name, Profile) VALUES
(1, 1, 'mtask', '001'),
(1, 2, 'mcenter', '001'),
(1, 3, 'mcenterajs', '001'),
(1, 4, 'mcenterprima', '001'),
(1, 5, 'mcenterpayajs', '001'),
(1, 6, 'mcenterfinnet', '001'),
(1, 7, 'mcentermpng2', '001'),
(1, 8, 'mcentersms', '001'),
(1, 9, 'mcenterpemko', '001'),
(1, 10, 'mcenteruinarraniry', '001'),
(1, 11, 'mcentersamsat', '001'),
(1, 12, 'auth', '001'),
(1, 13, 'authajs', '002'),
(1, 14, 'authprima', '003'),
(1, 15, 'authfinnet', '001'),
(1, 16, 'authpayajs', '001'),
(1, 17, 'authsms', '001'),
(1, 18, 'authpemko', '001'),
(1, 19, 'authuinarraniry', '001'),
(1, 20, 'authsamsat', '001'),
(1, 21, 'safajs', '001'),
(1, 22, 'saf', '001'),
(1, 23, 'safprima', '001'),
(1, 24, 'saffinnet', '001'),
(1, 25, 'safpayajs', '001'),
(1, 26, 'smspush', '001'),
(1, 27, 'olibsdrv', '001'),
(1, 28, 'olibsajsdrv', '001'),
(1, 29, 'olibsprimadrv', '001'),
(1, 30, 'olibspayajsdrv', '001'),
(1, 31, 'olibssmsdrv', '001'),
(1, 32, 'olibssmsntfdrv', '001'),
(1, 33, 'olibsmpng2drv', '001'),
(1, 34, 'olibspemkodrv', '001'),
(1, 35, 'olibsuinarranirydrv', '001'),
(1, 36, 'olibssamsatdrv', '001'),
(1, 37, 'payajs8583', 'PAYAJS'),
(1, 38, 'finnet8583', 'FINNET'),
(1, 39, 'ajs8583', 'ARTAJASA'),
(1, 40, 'prima8583', 'PRIMA'),
(1, 41, 'pemko8583', 'PEMKO'),
(1, 42, 'uinarraniry8583', 'UINARRANIRY'),
(1, 43, 'samsat8583', 'SAMSAT'),
(1, 44, 'hsmrep', '001'),
(1, 45, 'sms8583', 'SMSAJS'),
(1, 46, 'webolibscard', 'WEBCMD'),
(1, 47, 'mpng28583', 'MPNG2'),
(1, 48, 'host8583', 'TELLERMPNG2'),
(1, 49, 'TCP', 'AD001015'),
(1, 50, 'NDC', 'AD001015'),
(1, 51, 'TCP', 'AD001017'),
(1, 52, 'TCP', 'AD001018'),
(1, 53, 'NDC', 'AD001019'),
(1, 54, 'TCP', 'AD001020'),
(1, 55, 'TCP', 'AD001021'),
(1, 56, 'NDC', 'AD001022'),
(1, 57, 'TCP', 'AD001023'),
(1, 58, 'TCP', 'AD001024'),
(1, 59, 'NDC', 'AD001025');
SELECT setval('module_id_module_seq', (SELECT MAX(ID_Module) FROM module));


-- #DATA OPERATOR
INSERT INTO OPERATOR (ID_OPERATOR, NAME, USERNAME, PASSWORD, ID_DIVISI, ID_DEPARTMENT)
VALUES (1, 'OPERATOR1', 'optr1', '12345678', 1, 1);
INSERT INTO OPERATOR (ID_OPERATOR, NAME, USERNAME, PASSWORD, ID_DIVISI, ID_DEPARTMENT)
VALUES (2, 'OPERATOR2', 'optr2', '12345678', 2, 2);
INSERT INTO OPERATOR (ID_OPERATOR, NAME, USERNAME, PASSWORD, ID_DIVISI, ID_DEPARTMENT)
VALUES (3, 'OPERATOR3', 'optr3', '12345678', 3, 3);
SELECT setval('operator_id_operator_seq', (SELECT MAX(ID_OPERATOR) FROM OPERATOR));


-- #DATA SUPERVISOR
INSERT INTO SUPERVISOR (ID_SUPERVISOR, NAME, USERNAME, PASSWORD, ID_DIVISI, ID_DEPARTMENT)
VALUES (1, 'SUPERVISOR1', 'spv1', '12345678', 1, 1);
INSERT INTO SUPERVISOR (ID_SUPERVISOR, NAME, USERNAME, PASSWORD, ID_DIVISI, ID_DEPARTMENT)
VALUES (2, 'SUPERVISOR2', 'spv2', '12345678', 2, 2);
INSERT INTO SUPERVISOR (ID_SUPERVISOR, NAME, USERNAME, PASSWORD, ID_DIVISI, ID_DEPARTMENT)
VALUES (3, 'SUPERVISOR3', 'spv3', '12345678', 3, 3);
SELECT setval('supervisor_id_supervisor_seq', (SELECT MAX(ID_SUPERVISOR) FROM SUPERVISOR));


-- #DATA EVENT MONITORING
INSERT INTO EVENT_MONITORING (APPROVAL_STATUS, ID_MONITORING, ID_OPERATOR, ID_SUPERVISOR, OPERATOR_NOTES, DATE_MON, TIME_MON)
VALUES ('Approved', 1, 1, 1, 'All tasks completed', '2024-07-07', '08:00:00');
INSERT INTO EVENT_MONITORING (APPROVAL_STATUS, ID_MONITORING, ID_OPERATOR, ID_SUPERVISOR, OPERATOR_NOTES, DATE_MON, TIME_MON)
VALUES ('REJECTED', 2, 2, 2, 'THERE IS SOME ERROR', '2024-07-07', '10:00:00');
INSERT INTO EVENT_MONITORING (APPROVAL_STATUS, ID_MONITORING, ID_OPERATOR, ID_SUPERVISOR, OPERATOR_NOTES, DATE_MON, TIME_MON)
VALUES ('WAITING', 3, 3, 3, 'All tasks completed', '2024-07-07', '16:00:00');
SELECT setval('event_monitoring_id_monitoring_seq', (SELECT MAX(ID_MONITORING) FROM EVENT_MONITORING));

-- #DATA DETAIL MONITORING
INSERT INTO DETAIL_MONITORING (ID_DTL_MON, ID_PRODUCT, ID_SUBPRODUCT, ID_MONITORING, ID_BANK)
VALUES (1, 1, 1, 1, 1);
INSERT INTO DETAIL_MONITORING (ID_DTL_MON, ID_PRODUCT, ID_SUBPRODUCT, ID_MONITORING, ID_BANK)
VALUES (2, 1, 2, 1, 1);
INSERT INTO DETAIL_MONITORING (ID_DTL_MON, ID_PRODUCT, ID_SUBPRODUCT, ID_MONITORING, ID_BANK)
VALUES (3, 1, 3, 1, 1);
INSERT INTO DETAIL_MONITORING (ID_DTL_MON, ID_PRODUCT, ID_SUBPRODUCT, ID_MONITORING, ID_BANK)
VALUES (4, 1, 3, 2, 1);
SELECT setval('detail_monitoring_id_dtl_mon_seq', (SELECT MAX(ID_DTL_MON) FROM DETAIL_MONITORING));


-- SELECT * FROM SUBPRODUCT;

-- #DATA MODULE MONITORING
INSERT INTO MODULE_MONITORING (ID_MODULE_MON, ID_SUBPRODUCT, ID_MODULE, ID_DTL_MON,  STATUS, OPERATOR_NOTES, PERFORMA, LOG)
VALUES (1, 3, 1, 1, 'OK', 'Module running smoothly', '<=2 DETIK', 'No issues detected');
INSERT INTO MODULE_MONITORING (ID_MODULE_MON, ID_SUBPRODUCT, ID_MODULE, ID_DTL_MON,  STATUS, OPERATOR_NOTES, PERFORMA, LOG)
VALUES (2, 3, 2, 1,  'OK', 'Module running smoothly', '<=2 DETIK', 'No issues detected');
INSERT INTO MODULE_MONITORING (ID_MODULE_MON, ID_SUBPRODUCT, ID_MODULE, ID_DTL_MON,  STATUS, OPERATOR_NOTES, PERFORMA, LOG)
VALUES (3, 3, 1, 4,  'NOK', 'THERE ARE SOME PROBLEM', '>=5 DETIK', 'No issues detected');
INSERT INTO MODULE_MONITORING (ID_MODULE_MON, ID_SUBPRODUCT, ID_MODULE, ID_DTL_MON,  STATUS, OPERATOR_NOTES, PERFORMA, LOG)
VALUES (4, 3, 1, 3,  'OK', 'Module running smoothly', '<=2 DETIK', 'No issues detected');
SELECT setval('module_monitoring_id_module_mon_seq', (SELECT MAX(ID_MODULE_MON) FROM MODULE_MONITORING));

-- #DATA SERVER APP MON
INSERT INTO SERVER_APP_MONITORING (ID_SERVER_APP_MON, ID_SERVER_APP, ID_DTL_MON, RAM_USAGE, CPU_USAGE, DISK_USAGE, OPERATOR_NOTES, LOG)
VALUES (1, 1, 1, 60, 65, 30, 'OK', 'NORMAL');
INSERT INTO SERVER_APP_MONITORING (ID_SERVER_APP_MON, ID_SERVER_APP, ID_DTL_MON, RAM_USAGE, CPU_USAGE, DISK_USAGE, OPERATOR_NOTES, LOG)
VALUES (2, 2, 1, 70, 75, 40, 'NOK', 'CPU IS HIGH');
INSERT INTO SERVER_APP_MONITORING (ID_SERVER_APP_MON, ID_SERVER_APP, ID_DTL_MON, RAM_USAGE, CPU_USAGE, DISK_USAGE, OPERATOR_NOTES, LOG)
VALUES (3, 1, 2, 65, 70, 32, 'OK', 'NORMAL');
INSERT INTO SERVER_APP_MONITORING (ID_SERVER_APP_MON, ID_SERVER_APP, ID_DTL_MON, RAM_USAGE, CPU_USAGE, DISK_USAGE, OPERATOR_NOTES, LOG)
VALUES (4, 1, 3, 60, 65, 33, 'OK', 'NORMAL');
SELECT setval('server_app_monitoring_id_server_app_mon_seq', (SELECT MAX(ID_SERVER_APP_MON) FROM SERVER_APP_MONITORING));


-- #DATA SERVER DB MON
INSERT INTO SERVER_DB_MONITORING (ID_SERVER_DB_MON, ID_DTL_MON, ID_SERVER_DB, RAM_USAGE, CPU_USAGE, DISK_USAGE, OPERATOR_NOTES, LOG)
VALUES (1, 1, 1, 60, 65, 30, 'OK', 'NORMAL');
INSERT INTO SERVER_DB_MONITORING (ID_SERVER_DB_MON, ID_DTL_MON, ID_SERVER_DB, RAM_USAGE, CPU_USAGE, DISK_USAGE, OPERATOR_NOTES, LOG)
VALUES (2, 2, 1, 70, 75, 40, 'NOK', 'CPU IS HIGH');
INSERT INTO SERVER_DB_MONITORING (ID_SERVER_DB_MON, ID_DTL_MON, ID_SERVER_DB, RAM_USAGE, CPU_USAGE, DISK_USAGE, OPERATOR_NOTES, LOG)
VALUES (3, 1, 2, 65, 70, 32, 'OK', 'NORMAL');
INSERT INTO SERVER_DB_MONITORING (ID_SERVER_DB_MON, ID_DTL_MON, ID_SERVER_DB, RAM_USAGE, CPU_USAGE, DISK_USAGE, OPERATOR_NOTES, LOG)
VALUES (4, 1, 3, 60, 65, 33, 'OK', 'NORMAL');
SELECT setval('server_db_monitoring_id_server_db_mon_seq', (SELECT MAX(ID_SERVER_DB_MON) FROM SERVER_DB_MONITORING));


-- #DATA PATH APP USE MON
INSERT INTO PATH_APP_USE_MONITORING (ID_PATH_APP_USE_MON, ID_DTL_MON, ID_SERVER_APP_PATH, USAGE)
VALUES (1, 2, 1, 50);
INSERT INTO PATH_APP_USE_MONITORING (ID_PATH_APP_USE_MON, ID_DTL_MON, ID_SERVER_APP_PATH, USAGE)
VALUES (2, 3, 3, 60);
INSERT INTO PATH_APP_USE_MONITORING (ID_PATH_APP_USE_MON, ID_DTL_MON, ID_SERVER_APP_PATH, USAGE)
VALUES (3, 3, 2, 20);
INSERT INTO PATH_APP_USE_MONITORING (ID_PATH_APP_USE_MON, ID_DTL_MON, ID_SERVER_APP_PATH, USAGE)
VALUES (4, 4, 1, 80);
SELECT setval('path_app_use_monitoring_id_path_app_use_mon_seq', (SELECT MAX(ID_PATH_APP_USE_MON) FROM PATH_APP_USE_MONITORING));

-- #DATA PATH DB USE MON
INSERT INTO PATH_DB_USE_MONITORING (ID_PATH_DB_USE_MON, ID_DTL_MON, ID_SERVER_DB_PATH, USAGE)
VALUES (1, 2, 1, 70);
INSERT INTO PATH_DB_USE_MONITORING (ID_PATH_DB_USE_MON, ID_DTL_MON, ID_SERVER_DB_PATH, USAGE)
VALUES (2, 3, 3, 50);
INSERT INTO PATH_DB_USE_MONITORING (ID_PATH_DB_USE_MON, ID_DTL_MON, ID_SERVER_DB_PATH, USAGE)
VALUES (3, 3, 2, 70);
INSERT INTO PATH_DB_USE_MONITORING (ID_PATH_DB_USE_MON, ID_DTL_MON, ID_SERVER_DB_PATH, USAGE)
VALUES (4, 4, 1, 85);
SELECT setval('path_db_use_monitoring_id_path_db_use_mon_seq', (SELECT MAX(ID_PATH_DB_USE_MON) FROM PATH_DB_USE_MONITORING));


-- #DATA BACKUP APP MON
INSERT INTO BACKUP_APP_MONITORING (ID_BACKUP_APP_MON, ID_BACKUP_APP, ID_DTL_MON, STATUS, LOG, OPERATOR_NOTES)
VALUES (1, 1, 1, 'OK', 'BACKUP DONE', 'ALL BACKUP COMPLETED');
INSERT INTO BACKUP_APP_MONITORING (ID_BACKUP_APP_MON, ID_BACKUP_APP, ID_DTL_MON, STATUS, LOG, OPERATOR_NOTES)
VALUES (2, 1, 1, 'OK', 'BACKUP DONE', 'ALL BACKUP COMPLETED');
INSERT INTO BACKUP_APP_MONITORING (ID_BACKUP_APP_MON, ID_BACKUP_APP, ID_DTL_MON, STATUS, LOG, OPERATOR_NOTES)
VALUES (3, 2, 3, 'OK', 'BACKUP DONE', 'ALL BACKUP COMPLETED');
INSERT INTO BACKUP_APP_MONITORING (ID_BACKUP_APP_MON, ID_BACKUP_APP, ID_DTL_MON, STATUS, LOG, OPERATOR_NOTES)
VALUES (4, 3, 4, 'NOK', 'BACKUP NOT DONE', 'BACKUP INCOMPLETED');
SELECT setval('backup_app_monitoring_id_backup_app_mon_seq', (SELECT MAX(ID_BACKUP_APP_MON) FROM BACKUP_APP_MONITORING));

-- #DATA BACKUP DB MON
INSERT INTO BACKUP_DB_MONITORING (ID_BACKUP_DB_MON, ID_BACKUP_DB, ID_DTL_MON, STATUS, LOG, OPERATOR_NOTES)
VALUES (1, 1, 1, 'OK', 'BACKUP DONE', 'ALL BACKUP COMPLETED');
INSERT INTO BACKUP_DB_MONITORING (ID_BACKUP_DB_MON, ID_BACKUP_DB, ID_DTL_MON, STATUS, LOG, OPERATOR_NOTES)
VALUES (2, 1, 2, 'OK', 'BACKUP DONE', 'ALL BACKUP COMPLETED');
INSERT INTO BACKUP_DB_MONITORING (ID_BACKUP_DB_MON, ID_BACKUP_DB, ID_DTL_MON, STATUS, LOG, OPERATOR_NOTES)
VALUES (3, 2, 3, 'OK', 'BACKUP DONE', 'ALL BACKUP COMPLETED');
INSERT INTO BACKUP_DB_MONITORING (ID_BACKUP_DB_MON, ID_BACKUP_DB, ID_DTL_MON, STATUS, LOG, OPERATOR_NOTES)
VALUES (4, 3, 4, 'NOK', 'BACKUP NOT DONE', 'BACKUP INCOMPLETED');
SELECT setval('backup_db_monitoring_id_backup_db_mon_seq', (SELECT MAX(ID_Backup_DB) FROM BACKUP_DB_MONITORING));
