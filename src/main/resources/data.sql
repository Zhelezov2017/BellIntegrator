INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active, version)
        VALUES (1, 'BellInt', 'BellIntegrator', '54325234', '231433', 'ул. Иванова 7', '2233424',1, 0);

INSERT INTO organization (id, name, full_name, inn, kpp, address, phone, is_active, version)
        VALUES (2, 'Google', 'GG', '84143234', '251221', 'ул. Прыгунова 47', '2235124',1, 0);


INSERT INTO office (id, name, address, phone, is_active, org_id, version)
        VALUES (sequence_table.nextval, 'Shelter', 'ул. Прыгунова 47', '9871524', 1, 1, 0);

INSERT INTO office (id, name, address, phone, is_active, org_id, version)
        VALUES (sequence_table.nextval, 'SecondOffice', 'ул. Иванова 7', '2233424', 1, 1, 0);

INSERT INTO office (id, name, address, phone, is_active, org_id, version)
        VALUES (sequence_table.nextval, 'FirstOffice', 'ул. Иванова 8', '2136434', 1, 2, 0);


INSERT INTO country (id, name, code, version)
        VALUES (1, 'Российская Федерация' , '5745', 0) ;

INSERT INTO country (id, name, code, version)
        VALUES (2, 'Соединённые Шта́ты Аме́рики' , '6745', 0) ;


INSERT INTO doc (id, name, doc_number, doc_date, code, country_id, version)
        VALUES ( 1, 'Паспорт гражданина РФ', '1', '2014-3-24', '1453', 1, 0);

INSERT INTO doc (id, name, doc_number, doc_date, code, country_id,  version)
        VALUES ( 2, 'Военный билет', '1', '2015-2-24', '5432', 1, 0);

INSERT INTO doc (id, name, doc_number, doc_date, code, country_id,  version)
        VALUES ( 3, 'Паспорт гражданина РФ', '1', '2013-8-21', '1453', 2, 0);

INSERT INTO doc (id, name, doc_number, doc_date, code, country_id, version)
        VALUES ( 4, 'Военный билет', '1', '2016-8-14', '5432', 2, 0);


INSERT INTO user (id, first_name, second_name, middle_name, position, phone, citizen_ship_name, citizen_ship_code, is_identified, doc_id, version)
        VALUES (sequence_autoincrement.nextval, 'Vlad', 'Igorevich', 'Zhelezov', 'Meneger',  '89549613229', null, null, 1, 1, 0);

INSERT INTO user (id, first_name, second_name, middle_name, position ,phone, citizen_ship_name, citizen_ship_code, is_identified, doc_id, version)
        VALUES (sequence_autoincrement.nextval, 'Anton', 'Sergeevich', 'Makarev', 'Ingener', '89349212225',  null, null, 1, 2, 0);

INSERT INTO user (id, first_name, second_name, middle_name, position, phone, citizen_ship_name, citizen_ship_code, is_identified, doc_id, version)
        VALUES (sequence_autoincrement.nextval, 'Sergey', 'Vladimirovich', 'Bontor', 'Director',  '89999713479',  null, null, 1, 3, 0);

INSERT INTO user (id, first_name, second_name, middle_name, position ,phone, citizen_ship_name, citizen_ship_code, is_identified, doc_id, version)
        VALUES (sequence_autoincrement.nextval, 'Anton', 'Petrovich', 'Razmil', 'Ingener', '89543270323', null, null, 1, 4, 0);


INSERT INTO user_office (office_id, user_id, version)
        VALUES (1, 1, 0) ;
INSERT INTO user_office (office_id, user_id, version)
        VALUES (2, 2, 0) ;
INSERT INTO user_office (office_id, user_id, version)
        VALUES (2, 3, 0) ;
INSERT INTO user_office (office_id, user_id, version)
        VALUES (1, 2, 0) ;