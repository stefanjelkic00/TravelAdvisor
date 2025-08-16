Travel Advisor - Thesis Project

Travel Advisor is a comprehensive application that provides users with information about accommodations, restaurants and landmarks.
It serves for general user information during travel and to provide precise insight into destinations they want to visit.
Travel Advisor application was the topic of my thesis project when completing my studies in Software and Information Technologies.

Technologies used are:

Backend:
Java 17                          -Version used
SpringBoot                       -Framework for developing REST APIs
Spring Security + JWT            -Authentication and authorization
Spring Data JPA                  -ORM layer for database operations
Hibernate                        -Maps Java objects to MySQL relational databases
Lombok                           -Used for simplified implementation
Swagger UI                       -For endpoint testing

Running backend:
1. Ensure MySQL is running
2. After that, the app can be started via DiplomskiApplication file
3. Application will be available at: http://localhost:8001

Frontend:
React                            -Library for user interface development
Axios                            -Library for HTTP requests to backend (GET, POST, PUT, DELETE)
Bootstrap                        -CSS framework for responsive design and layout
React Toastify                   -Display notifications (toast notifications)
Leaflet                          -JavaScript library for interactive maps
React Leaflet                    -React wrapper for Leaflet (to make maps work in React environment)
Formik                           -Tool for form management (inputs, submit, validation...)
Yup                              -Schema-based data validation (often used with Formik)

Running frontend:
Install all dependencies: npm install
Start React application: npm start
Application will be available at: http://localhost:3000

Database:
MySQL. Data for destinations to be entered through query that will be located at the bottom of the readme file.
As for destination images, we will also enter them through query.
Admin to be entered manually via query since registration only allows regular users to register.
As for all other tables, they will be populated through further application testing.
Reviews and reactions will also be in the query below for faster application population.
All queries will be located at the bottom below functionality description.

Functionalities:

Everyone:
Has access to login and registration, both require specific form for data entry.
Has access to homepage that offers choice for further and more detailed access to accommodations, restaurants and landmarks.
When clicking on individual field for accommodations, restaurants and landmarks, it takes us to display of those destinations.
At the top of the window we'll have a search field that will execute when clicking the search button.
Below the search field will be individual destination displays with their initial images, names, accommodation types and addresses.
At the bottom of each destination box there will be a "details" button.
That button will take us to detailed view of each destination which will have display of multiple images of that destination,
below that will be accommodation type, address, name, average rating from reviews that will change color based on current rating.
From 1-2 every rating will be red (e.g., 2.3, 1.2, 2.8...).
Rating 3 will be yellow (3.5, 3.0, 3.7,...).
From 4 to 4.5 will be orange.
From 4.5 to 5 will be green.
Below average rating will be destination description.
Below description are destination maps where we'll have precise display via Google Maps of where our destination is actually located.
Below maps we'll have user reviews containing author's first name, last name, date, rating, comment and reactions.

Logged-in User:
  Besides all functionalities available when not logged in, they can give reviews on destinations.
  User can leave their comment on destination (maximum 1 per destination for more precise logic).
  Besides leaving reviews, they can also leave reactions on all reviews within destinations (like or dislike per review).

Admin:
  All functionalities that everyone and logged-in users have.
  Besides all functionalities that non-logged and logged users have,
  administrator will have more comprehensive role with ability to delete and add destinations.
As for admin, enter them manually in database as desired.
Query for entering all destinations, destination images, restaurants, accommodations, landmarks, reviews, reactions.

INSERT INTO destinacija (id, adresa, latitude, longitude, naziv, opis, prosecna_ocena) VALUES
(1,'Bulevar oslobodjenja 119 , Novi Sad , Srbija',45.2468,19.8481,'Promenada','Najveci trzni centar u Novom Sadu',3.33),
(2,'Champ de Mars  5 , Paris , Francuska',48.8585,2.29507,'Ajfelov toranj','Najvisi toranj na svetu',4),
(3,'Piazza del Colosseo 1 , Rim , Italija',41.8904,12.4926,'Koloseum','Anticki Rimski amfiteatar',4.33),
(4,'C/ de Mallorca 401 , Barselona , Spanija ',41.4038,2.17509,'Sagrada Familia','Najvisa katolicka crkva na svetu ',4.67),
(5,'Umm Suqeim 3 , Dubai , UAE',25.1471,55.1948,'Burj al Arab','Hotel u Dubaiu ',4.33),
(6,'Invalidestraße129, Berlin ,Nemacka ',52.5337,13.3896,'Apartments Berlin Mitte','Apartmani u Berlinu',3.67),
(7,'1 Seething Ln , London , Engleska ',51.5216,-0.08895,'Apex city of London Hotel','Hotel u Londonu',3.33),
(8,'711 E Camp Wisdom Rd, Duncanville, TX , Dallas , USA',32.6736,-96.8882,'Rodeway inn','Motel u Dallasu',3),
(9,'Хонгконг, Central, Pottinger St  74 , Hong Kong , Kina',22.2837,114.157,'Ta Vie','Kineski restoran u Hong Kongu',4.25),
(10,'Via S. Maurilio 4 , Milano , Italija ',45.5388,8.83334,'San Mauri','Italijanski restoran u Milanu',3.25),
(11,'Кнеза Вишеслава 45 , Beograd , Srbija',44.744,20.4268,'MC Donalds','Brza hrana u Beogradu',3.33),
(12,'Κολοκοτρώνη 38-40 , Atina , Grcka ',37.9777,23.73,'Amber Athens','Grcki restoran u Atini',4.89),
(13,'Via Labicana, 125, Rim , Italija ',41.8902,12.4956,'Aroma','Italijanski restoran u Rimu',4.67),
(14,'C. de Amador de los Ríos, 6, Madrid, Spanija',40.4274,-3.69115,'Saddle','Spanski restoran u Madridu ',4),
(15,'9 Chome-7-1 Akasaka,  Tokyo , Japan',35.6662,139.73,'Hinokizaka','Japanski restoran u Tokiju',3.67),
(16,'Mosman NSW 2088,  Sidnej , Australija',-33.8044,151.246,'Chiosco by Ormeggio','Italijanski restoran u Sidneju',2.67),
(17,'Córdoba Province, Kordoba , Argentina',-31.4314,-64.2228,'Tarquino','Restoran raznovrsnog tipa u Kordobi',4),
(18,'3325 S Las Vegas Blvd, Las Vegas, USA',36.1239,-115.168,'The Pallazo','Hotel u Las Vegasu',1.75),
(19,'Calle Del Torno #39-29, Bolívar, Коlumbija',10.4283,-75.5479,'Sofitel Legend Santa Clara','Hotel u Kartagini',3),
(20,'588 จอมพล, Bangkok, Tajland',13.8098,100.561,'The Saint Residences','Apartmani u Bangkoku',4.33),
(21,'Быковское ш. 55 ,  Moskva , Rusija ',55.6304,37.981,'Kedre motel','Motel u Moskvi ',3),
(22,'Kegelgasse 20, Bec , Austrija ',48.2074,16.3913,'A&A apartments','Apartmani u Becu',4.5),
(23,'Parque Nacional da Tijuca - Alto da Boa Vista, Rio de Janeiro , Brazil',-22.952,-43.2105,'Spomenik Isusa Hrista','Veliki spomenik Isusu Hristu u Riu De Zaeniru',4.5),
(24,'Al Haram, Nazlet El-Semman , Giza , Egipat',29.9791,31.1342,'Keopsova piramida','Skup Keopsovih piramida',3.67),
(25,'Sanduhe Town, Huairou District, Peking, Kina',40.4319,116.57,'Kineski zid ','Kineski zid , najduzi na svetu ',4.5),
(26,'RFP3+PV ,  Aguas Calientes, Перу',-13.1634,-72.5452,'Macu Pikcu','Zaboravljeni grad sakriven u dzunglama Perua',3),
(27,'97751 Tinum, Yucatan, Meksiko',20.683,-88.5686,'Piramida Kukulkan','Majanska piramida u Meksiku',3.5),
(28,'52GR+3V Agra, Utar Prades, Indija',27.1751,78.0422,'Taj Mahal','Istorijska znamenitost u Indiji ',4.5);

 INSERT INTO slika_destinacije (id, putanja, destinacija_id) VALUES
(1,'promenada.jpg',1),
(2,'eiffel.jpg',2),
(3,'colloseum.jpg',3),
(4,'sagrada.jpg',4),
(5,'burjalarab.jpg',5),
(6,'berlinmite.jpg',6),
(7,'apexcity.jpg',7),
(8,'rodewayinn.jpg',8),
(9,'tavie.jpg',9),
(10,'sanmauri.jpg',10),
(11,'mcdonalds.jpg',11),
(12,'amber.jpg',12),
(13,'aroma.jpg',13),
(14,'saddle.jpg',14),
(15,'hinokizaka.jpg',15),
(16,'chioscobyormeggio.jpg',16),
(17,'tarqino.jpg',17),
(18,'pallazo.jpg',18),
(19,'sofitel.jpg',19),
(20,'thesaintresidence.jpg',20),
(21,'kedre.jpg',21),
(22,'a&a.jpg',22),
(23,'keopsova.jpg',24),
(24,'kineskizid.jpg',25),
(25,'macupikcu.jpg',26),
(26,'kukulkan.jpg',27),
(27,'tajmahal.jpg',28),
(28,'berlinmite2.jpg',6),
(29,'berlinmite3.jpg',6),
(30,'burjalarab2.jpg',5),
(31,'burjalarab3.jpg',5),
(32,'burjalarab4.jpg',5),
(33,'burjalarab5.jpg',5),
(34,'apexcity2.jpg',7),
(35,'apexcity3.jpg',7),
(36,'apexcity4.jpg',7),
(37,'rodewayinn2.jpg',8),
(38,'rodewayinn3.jpg',8),
(39,'rodewayinn4.jpg',8),
(40,'rodewayinn5.jpg',8),
(41,'pallazo2.jpg',18),
(42,'pallazo3.jpg',18),
(43,'pallazo4.jpg',18),
(44,'pallazo5.jpg',18),
(45,'sofitel2.jpg',19),
(46,'sofitel3.jpg',19),
(47,'sofitel4.jpg',19),
(48,'sofitel5.jpg',19),
(49,'thesaintresidence2.jpg',20),
(50,'thesaintresidence3.jpg',20),
(51,'thesaintresidence4.jpg',20),
(52,'thesaintresidence5.jpg',20),
(53,'kedre3.jpg',21),
(54,'kedre2.jpg',21),
(55,'a&a2.jpg',22),
(56,'a&a3.jpg',22),
(57,'a&a4.jpg',22),
(58,'a&a5.jpg',22),
(59,'tavie2.jpg',9),
(60,'tavie3.jpg',9),
(61,'tavie4.jpg',9),
(62,'jesus.jpg',23),
(63,'sanmauri2.jpg',10),
(64,'sanmauri3.jpg',10),
(65,'sanmauri4.jpg',10),
(66,'sanmauri5.jpg',10),
(67,'mcdonalds2.jpg',11),
(68,'mcdonalds3.jpg',11),
(69,'mcdonalds4.jpg',11),
(70,'amber2.jpg',12),
(71,'amber3.jpg',12),
(72,'amber4.jpg',12),
(73,'amber5.jpg',12),
(74,'aroma2.jpg',13),
(75,'aroma3.jpg',13),
(76,'aroma4.jpg',13),
(77,'aroma5.jpg',13),
(78,'saddle2.jpg',14),
(79,'saddle3.jpg',14),
(80,'saddle4.jpg',14),
(81,'saddle5.jpg',14),
(82,'hinokizaka2.jpg',15),
(83,'hinokizaka3.jpg',15),
(84,'hinokizaka4.jpg',15),
(85,'hinokizaka5.jpg',15),
(86,'chioscobyormeggio2.jpg',16),
(87,'chioscobyormeggio3.jpg',16),
(88,'chioscobyormeggio4.jpg',16),
(89,'tarqino2.jpg',17),
(90,'tarqino3.jpg',17),
(91,'promenada2.jpg',1),
(92,'promenada3.jpg',1),
(93,'promenada4.jpg',1),
(94,'colosseum2.jpg',3),
(95,'colosseum3.jpg',3),
(96,'colosseum4.jpg',3),
(97,'sagrada2.jpg',4),
(98,'sagrada3.jpg',4),
(99,'sagrada4.jpg',4),
(100,'jesus2.jpg',23),
(101,'jesus3.jpg',23),
(102,'keopsova2.jpg',24),
(103,'keopsova3.jpg',24),
(104,'kineski2.jpg',25),
(105,'kineski3.jpg',25),
(106,'macupikcu2.jpg',26),
(107,'macupikcu3.jpg',26),
(108,'kukulkan2.jpg',27),
(109,'kukulkan3.jpg',27),
(110,'tajmahal2.jpg',28),
(111,'tajmahal3.jpg',28);


INSERT INTO restoran (tip_restorana, destinacija_id) VALUES
('KINESKI', 9),
('ITALIJANSKI', 10),
('FAST_FOOD', 11),
('GRCKI', 12),
('ITALIJANSKI', 13),
('SPANSKI', 14),
('JAPANSKI', 15),
('ITALIJANSKI', 16),
('ITALIJANSKI', 17);

INSERT INTO smestaj (tip_smestaja, destinacija_id) VALUES
('HOTEL', 5),
('APARTMAN', 6),
('HOTEL', 7),
('MOTEL', 8),
('HOTEL', 18),
('HOTEL', 19),
('APARTMAN', 20),
('MOTEL', 21),
('APARTMAN', 22);

INSERT INTO znamenitost (tip_znamenitosti, destinacija_id) VALUES
('TRZNI_CENTAR', 1),
('TORANJ', 2),
('ISTORIJSKE_ZNAMENISTOSI', 3),
('ISTORIJSKE_ZNAMENISTOSI', 4),
('ISTORIJSKE_ZNAMENISTOSI', 23),
('ISTORIJSKE_ZNAMENISTOSI', 24),
('ISTORIJSKE_ZNAMENISTOSI', 25),
('ISTORIJSKE_ZNAMENISTOSI', 26),
('ISTORIJSKE_ZNAMENISTOSI', 27),
('ISTORIJSKE_ZNAMENISTOSI', 28);


INSERT INTO recenzija (id, broj_nesvidjanja, broj_svidjanja, datum, komentar, ocena, destinacija_id, korisnik_id) VALUES
(14,0,2,'2024-06-28 17:30:12','fgvfe',4,18,3),
(16,0,3,'2024-06-30 18:47:03','Dobar tržni centar . Ima sve što vam je potrebno , jedina zamerka je velika gužva .',3,1,3),
(19,2,1,'2024-06-30 20:33:08','Odlican smestaj',4,5,5),
(20,2,2,'2024-06-30 20:34:37','Nisam toliko zadovoljan. Neljubazna usluga',2,6,5),
(21,0,2,'2024-06-30 20:56:24','Odlican smestaj , sve preporuke .',5,7,3),
(22,1,1,'2024-06-30 20:56:51','Najbolji smestaj u kojem sam ikad bio .',5,18,3),
(23,1,1,'2024-06-30 20:57:14','Dobar smestaj blizu mora .',4,19,3),
(24,0,3,'2024-06-30 20:59:06','Dobar smestaj ali nema parkinga u okolini slobodnog',3,20,3),
(25,1,1,'2024-06-30 21:00:59','Dobar smestaj',4,6,6),
(26,0,3,'2024-06-30 21:01:16','Odlican smestaj',5,5,6),
(27,1,1,'2024-06-30 21:01:36','Dobar smestaj , jedino je parking problem',4,7,6),
(28,2,0,'2024-06-30 21:02:08','Najbolji smestaj u kojem sam bio',5,18,6),
(29,0,2,'2024-06-30 21:03:41','Previse bucno naselje',2,19,6),
(30,1,1,'2024-06-30 21:04:31','Jefin i uredan smestaj za male pare',4,8,6),
(31,1,1,'2024-06-30 21:04:48','Neuredan smestaj i bucno naselje',2,21,6),
(32,0,1,'2024-06-30 21:05:19','Odlican smestaj blizu centra',5,22,6),
(33,2,1,'2024-06-30 21:08:03','Sve pohvale za smestaj',4,5,7),
(34,1,1,'2024-06-30 21:08:24','Smestaj na zavidnom nivou',5,6,7),
(35,0,1,'2024-06-30 21:08:46','Nezadovoljan sam uslugom',1,7,7),
(36,1,1,'2024-06-30 21:09:01','Prosecan smestaj',2,8,7),
(37,1,1,'2024-06-30 21:09:26','Preskup smestaj',1,18,7),
(38,1,1,'2024-06-30 21:09:56','Smestaj uredan i prostran',5,20,7),
(39,1,1,'2024-06-30 21:10:20','Zadovoljan sam smestajem spram cene',4,21,7),
(40,0,0,'2024-06-30 21:13:48','Odlican smestaj za datu cenu',5,20,8),
(41,0,0,'2024-06-30 21:14:17','Odlican smestaj , imaju i svoju kuhinju .',4,22,8);

    
INSERT INTO reakcija (id, svidjanje, korisnik_id, recenzija_id) VALUES
(11,0,5,19),
(12,0,5,20),
(13,0,6,20),
(14,0,6,23),
(15,1,6,29),
(16,1,6,24),
(17,0,7,19),
(18,1,7,26),
(19,1,7,33),
(20,1,7,20),
(21,1,7,25),
(22,0,7,34),
(23,1,7,21),
(24,0,7,27),
(25,0,7,30),
(26,1,7,36),
(27,1,7,14),
(28,0,7,22),
(29,0,7,28),
(30,1,7,37),
(31,1,7,24),
(32,1,7,38),
(33,0,7,31),
(34,1,7,39),
(35,1,8,19),
(36,1,8,26),
(37,0,8,33),
(38,1,8,20),
(39,0,8,25),
(40,1,8,34),
(41,1,8,21),
(42,1,8,27),
(43,1,8,35),
(44,1,8,30),
(45,0,8,36),
(46,1,8,14),
(47,1,8,22),
(48,0,8,28),
(49,0,8,37),
(50,1,8,23);

    
