Compulsory
-
- EntityManagerFactory este singleton.


Homework:
-
- S-au facut toate clasele entitate si s-au facut toate clasele repository.
- Implementarea relatiei One-To-Many.
- Creare AbstractRepository conform  CrudRepository.
- Inserare, utilizand JPA, un nr mare de date in tabela cities ==> a se descarca fisierul de aici: https://we.tl/t-Xn5uFu1bGt.
- log the execution time of your JPQL queries
- Assume each city has a new property, its population. Use a constraint solver, such as Choco solver, OptaPlanner or ORTools, in order to find a set of cities having names that start with the same letter, the total sum of their population is between two given bounds and they are from different countries.
- S-au facut cateva modificari in tabele: a se executa comenzile:
- Stergere tabel continents si recrearea lui:

CREATE TABLE continents(idContinent int primary key,
                        name varchar(20));

+countries

CREATE TABLE countries (
	id int PRIMARY KEY,
	name VARCHAR ( 50 ) ,
	code VARCHAR(50),
	idContinent int,
	continent varchar(50),
	CONSTRAINT fk_continent
      FOREIGN KEY(idContinent) 
	  REFERENCES continents(idContinent)
);

--select * from countries; <br>
--select * from continents; <br>
--delete from continents; <br>
--delete from countries; <br>
--select * from cities; <br>
--delete from cities; <br>
alter table cities drop column capital;

ALTER TABLE cities ALTER COLUMN longitude TYPE varchar(300);

https://www.kaggle.com/datasets/juanmah/world-cities


