Compulsory
-
- Creat serverul de postgresql folosind utilitarul pgAdmin
- Creat conexiunea la baza de date
- Creat clasele specifice:
  - Main
  - Database
  - CreateTables
  - CountriesDAO
  - ContinentsDAO

Update Compulsory:
-
- Database este de tipul Singleton
- In clasele de creare ale tabelelor s-a completat cu IF NOT EXISTS deoarece genera eroare daca rulai de +1 ori fata de prima data cand ai creat tabelul.
- In ContinentDAO
    - verificarea de duplicate   
    - verificarea maximului de id in caz ca mai exista un id la fel in baza de date si incrementarea lui cu 1.
- Adaugarea continutului in CountriesDAO
    - la fel ca la continente.
- Unit testing folosing JUnit

Homework
-
- A se descarca fisierul de la https://www.kaggle.com/datasets/nikitagrec/world-capitals-gps pt homework'
- Creat tool ce importa date dintr-un CSV intr-o tabela din baza de date
- Creat model OOP pentru City, Country si Continent
- Populat tabela cities
- Creat CitiesDAO
- Creat metoda pentru a calcula distanta intre doua orase
