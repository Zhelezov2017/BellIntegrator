CREATE TABLE IF NOT EXISTS organization (
    id         BIGINT      NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name       VARCHAR(50) NOT NULL COMMENT 'Короткое название организации',
    full_name  VARCHAR(50) NOT NULL COMMENT 'Полное название организации',
    inn        VARCHAR(50) NOT NULL COMMENT 'ИНН организации',
    kpp        VARCHAR(50) NOT NULL COMMENT 'КПП организации',
    address    VARCHAR(50) NOT NULL COMMENT 'Адресс организации',
    phone      VARCHAR(50)          COMMENT 'Телефон организации',
    is_active  BIT         NOT NULL COMMENT 'Активный или нет',
    version    INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
);
COMMENT ON TABLE organization IS 'Организация';
CREATE INDEX organization_index_id ON organization (id);

CREATE TABLE IF NOT EXISTS office (
    id         BIGINT      NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name       VARCHAR(50) NOT NULL COMMENT 'Название офиса',
    address    VARCHAR(50) NOT NULL COMMENT 'Адресс организации',
    phone      VARCHAR(50)          COMMENT 'Телефон офиса',
    is_active  BIT         NOT NULL COMMENT 'Активный или нет',
    org_id     INTEGER              COMMENT 'Внешний ключ',
    version    INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    FOREIGN KEY (org_id) REFERENCES organization(id)
);
COMMENT ON TABLE office IS 'Офис';
CREATE INDEX office_index_id ON office (id);

CREATE TABLE IF NOT EXISTS user (
    id                    BIGINT      NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    first_name            VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name           VARCHAR(50) NOT NULL COMMENT 'Отчество',
    middle_name           VARCHAR(50) NOT NULL COMMENT 'Фамилия',
    position              VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone                 VARCHAR(50) NOT NULL COMMENT 'Телефон сотрудника',
    doc_name              VARCHAR(50) NOT NULL COMMENT 'Название документа',
    doc_number            VARCHAR(50) NOT NULL COMMENT 'Номер документа',
    doc_date              DATE        NOT NULL COMMENT 'Дата выдачи',
    citizen_ship_name     VARCHAR(50)          COMMENT 'Гражданское имя',
    citizen_ship_code     VARCHAR(50)          COMMENT 'Гражданский код',
    is_identified         BIT         NOT NULL COMMENT 'Активный или нет',
    country_id            INTEGER              COMMENT 'Внешний ключ страны',
    version               INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',


    FOREIGN KEY (country_id) REFERENCES Country(id),
);
COMMENT ON TABLE user IS 'Сотрудник';
CREATE INDEX user_index_id ON user (id);


CREATE TABLE IF NOT EXISTS doc (
    id         BIGINT      NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name       VARCHAR(50) NOT NULL COMMENT 'Название документа',
    code       VARCHAR(21) NOT NULL COMMENT 'Код',
    version    INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
);
COMMENT ON TABLE doc IS 'Справочники';
CREATE INDEX doc_index_id ON doc (id);


CREATE TABLE IF NOT EXISTS country (
    id         BIGINT       NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name       VARCHAR(50)  NOT NULL COMMENT 'Страны',
    code       VARCHAR(643) NOT NULL COMMENT 'Код',
    version    INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
);
COMMENT ON TABLE country IS 'Страны';
CREATE INDEX country_index_id ON country (id);


CREATE TABLE IF NOT EXISTS proxy_table (
    id         BIGINT       NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    doc_id     BIGINT       NOT NULL COMMENT 'Внешний ключ документа',
    country_id BIGINT       NOT NULL COMMENT 'Внешний ключ страны',
    office_id  BIGINT       NOT NULL COMMENT 'Внешний ключ офиса',
    user_id    BIGINT       NOT NULL COMMENT 'Внешний ключ пользователя',
    version    INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
);
COMMENT ON TABLE proxy_table IS 'Таблица для связи ManyToMany';


CREATE SEQUENCE sequence_table
INCREMENT BY 1
MINVALUE 1
MAXVALUE 20
CACHE 20;

CREATE SEQUENCE sequence_autoincrement
INCREMENT BY 1
MINVALUE 1
MAXVALUE 1000
CACHE 100;



