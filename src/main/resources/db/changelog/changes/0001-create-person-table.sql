--liquibase formatted sql

--changeset dagnis:1

create table person
(
    personal_id   VARCHAR(50) PRIMARY KEY,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    date_of_birth DATE        NOT NULL,
    gender        VARCHAR(50) NOT NULL
);

insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('52191485762', 'Eloise', 'Swetenham', '1924-03-03', 'FEMALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('14859493223', 'Mitchel', 'Purse', '1949-01-08', 'MALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('75154099672', 'Vinnie', 'Cayser', '1963-12-15', 'FEMALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('18728057682', 'Danyelle', 'Fitzsimons', '1963-09-09', 'FEMALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('39720403916', 'Madeleine', 'Warrington', '1989-09-26', 'FEMALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('74313696167', 'Kahaleel', 'Beven', '1958-02-28', 'MALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('46983115972', 'Marcos', 'Colleymore', '1993-03-16', 'MALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('43841636650', 'Genia', 'Martygin', '1962-12-31', 'FEMALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('37459076747', 'Kenton', 'Jeske', '1942-04-08', 'MALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('02830255567', 'Desi', 'Ghio', '1970-10-19', 'MALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('52806714046', 'Eimile', 'Grimme', '1999-10-18', 'FEMALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('51943857663', 'Lynn', 'Bonnyson', '1950-09-13', 'FEMALE');
insert into person (personal_id, first_name, last_name, date_of_birth, gender)
values ('78788186547', 'Dill', 'Edgeller', '1963-02-14', 'MALE');

