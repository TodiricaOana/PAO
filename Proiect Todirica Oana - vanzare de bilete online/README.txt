	Todirica Oana-Andreea - grupa 244

	Tema 7 - vanzare de bilete online.

	Am organizat clasele in felul urmator (toate clasele contin un id unic, pe langa restul campurilor specifice):
	Clasa Client - din care am derivat clasele Child, Student, Retired - pentru a putea calcula pretul pentru un eveniment cu un discount valabil pentru fiecare categorie de client
	Clasa Location - ce contine numele locatiei si numarul de locuri disponibile pentru acea locatie
	Clasa Event - cu numele si pretul corespunzator fiecarui eveniment
	Clasa EventDetails - ofera toate informatiile despre eveniment: evenimentul in sine, locatia, data, categoria evenimentului(concert, teatru, stand-up etc.)
	Clasa Ticket - contine clientul si detaliile evenimentului pentru care a fost cumparat

	Actiuni si interogari ce se pot realiza:
	Add - pentru fiecare clasa se pot adauga noi obiecte in repository.
	Get - pentru fiecare clasa putem cauta in repository obiecte dupa anumite criterii (Id, nume sau alte campuri specifice clasei)
	Update - pentru fiecare clasa putem modifica un anumit camp
	Delete - putem sterge un client din repository, stergandu-se automat toate bilete cumparate de acesta
	
