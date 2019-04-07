CREATE TABLE IF NOT EXISTS organization (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name       VARCHAR(50) NOT NULL COMMENT 'Короткое название организации',
    fullname   VARCHAR(50) NOT NULL COMMENT 'Полное название организации',
    inn        INTEGER     NOT NULL COMMENT 'ИНН организации',
    kpp        INTEGER     NOT NULL COMMENT 'КПП организации',
    address    VARCHAR(50) NOT NULL COMMENT 'Адресс организации',
    phone      INTEGER              COMMENT 'Телефон организации',
    is_active  BIT                  COMMENT 'Активный или нет',
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
);
COMMENT ON TABLE organization IS 'Организация';


CREATE TABLE IF NOT EXISTS office (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name       VARCHAR(50) NOT NULL COMMENT 'Название офиса',
    address    VARCHAR(50) NOT NULL COMMENT 'Адресс организации',
    phone      INTEGER              COMMENT 'Телефон офиса',
    is_active  BIT                  COMMENT 'Активный или нет',
    version    INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
);
COMMENT ON TABLE office IS 'Офис';


CREATE TABLE IF NOT EXISTS user (
    id                    INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    first_name            VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name           VARCHAR(50) NOT NULL COMMENT 'Второе имя',
    middle_name           VARCHAR(50) NOT NULL COMMENT 'Отчество',
    position              VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone                 INTEGER     NOT NULL COMMENT 'Телефон сотрудника',
    doc_name              VARCHAR(50) NOT NULL COMMENT 'Название документа',
    doc_number            INTEGER     NOT NULL COMMENT 'Номер документа',
    doc_date              DATE        NOT NULL COMMENT 'Дата документа',
    citizen_ship_name     VARCHAR(50) NOT NULL COMMENT 'Гражданское имя',
    citizen_ship_code     VARCHAR(50) NOT NULL COMMENT 'Гражданский код',
    is_identified         BIT                  COMMENT 'Активный или нет',
    version               INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
);
COMMENT ON TABLE user IS 'Сотрудник';


CREATE TABLE IF NOT EXISTS docs (
    name       VARCHAR(50) NOT NULL COMMENT 'Паспорт гражданина РФ',
    code       INTEGER(21) NOT NULL COMMENT 'Код'
    version    INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
);
COMMENT ON TABLE docs IS 'Справочники';


CREATE TABLE IF NOT EXISTS countries (
    name       VARCHAR(50)  NOT NULL COMMENT 'Российская Федерация',
    code       INTEGER(643) NOT NULL COMMENT 'Код'
    version    INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
);
COMMENT ON TABLE docs IS 'Страны';




