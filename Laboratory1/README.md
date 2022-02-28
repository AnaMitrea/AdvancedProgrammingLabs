<a href="https://profs.info.uaic.ro/~acf/java/labs/lab_01.html" target="_blank">Lab 1</a>

Compulsory
-
- implementat functie de calculare suma cifrelor unui numar
- implementat numar aleatoriu
- implementat conversii string (numar binar) to decimal, string (numar hexadecimal) to decimal
- implementat calcule
- implementat afisari specifice

Homework 
-
- clean code + organizare cod
- implementat validare input
- implementat generare de n cuvinte cu p caractere
- creare matrice de adiacenta a vecinilor de n x n
- implementat functie de verificare adiacenta cuvinte generate
- creare arrayList pentru a stoca vecinii fiecarui cuvant
- afisare running time in ns pt un input n foarte mare (>30_000)
- modificare JVM Heap Space using the VM options -Xms4G -Xmx4G. - ???

Bonus
-
- implementare lista cuvinte distincte (eliminare posibile duplicate)
- creare o noua matrice de adiacenta a vecinilor listei anterioare
- implementare parcurgere DFS cu ajutorul :
      *  lista de cuvinte generate
      *  lista de "noduri" vizitate cu ajutorul careia se elimina posibilitatea alegerii unui nod deja ales in pasii anteriori
      *  matricea de vecini cu ajutorul careia se aleg urmatoarele noduri adiacente (vecine) cu nodul curent
      *  pozitia curenta a nodului care este adaugat in formarea circuitului
- implementare metoda de start a parcurgerii DFS pentru fiecare cuvant generat
      * creare lista noua de "noduri" vizitate cu ajutorul careia se verifica lungimea circuitului in functie de lista anterioara
      * afisare cuvinte din circuit
      * afisare lungime circuit
