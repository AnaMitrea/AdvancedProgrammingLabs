drop table continents;
CREATE TABLE continents(
    idContinent int primary key,
    name varchar(20)
);

INSERT INTO continents VALUES (1,'Europe');
INSERT INTO continents VALUES (2,'Africa');
INSERT INTO continents VALUES (3,'Asia');
INSERT INTO continents VALUES (4,'Australia');
INSERT INTO continents VALUES (5,'Antarctica');
INSERT INTO continents VALUES (6,'North America');
INSERT INTO continents VALUES (7,'South America');

drop table countries;
CREATE TABLE countries(
    id int PRIMARY KEY,
    name VARCHAR(50),
    code VARCHAR(50),
    idContinent int,
    CONSTRAINT fk_continent FOREIGN KEY(idContinent) REFERENCES continents(idContinent)
);


drop table cities;
CREATE TABLE cities(
    id INT PRIMARY KEY,
    name varchar(50),
    latitude varchar(50),
    longitude varchar(50),
    idCountry int,
    population varchar(50),
    CONSTRAINT fk_continent FOREIGN KEY(idCountry) REFERENCES countries(id)
);


CREATE TABLE importedcountries(
    id int primary key,
    name varchar(100),
    capital varchar(100),
    latitude varchar(100),
    longitude varchar(100),
    code varchar(100),
    continent varchar(100)
);


delete from cities;
delete from countries;

select * from cities;
select * from countries;





