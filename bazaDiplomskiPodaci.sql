-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: diplomski
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `destinacija`
--

LOCK TABLES `destinacija` WRITE;
/*!40000 ALTER TABLE `destinacija` DISABLE KEYS */;
INSERT INTO `destinacija` VALUES (1,'Bulevar oslobodjenja 119 , Novi Sad , Srbija',45.2468,19.8481,'Promenada','Najveci trzni centar u Novom Sadu',3.3333333333333335),(2,'Champ de Mars  5 , Paris , Francuska',48.8585,2.29507,'Ajfelov toranj','Najvisi toranj na svetu',4),(3,'Piazza del Colosseo 1 , Rim , Italija',41.8904,12.4926,'Koloseum','Anticki Rimski amfiteatar',4.333333333333333),(4,'C/ de Mallorca 401 , Barselona , Spanija ',41.4038,2.17509,'Sagrada Familia','Najvisa katolicka crkva na svetu ',4.666666666666667),(5,'Umm Suqeim 3 , Dubai , UAE',25.1471,55.1948,'Burj al Arab','Hotel u Dubaiu ',4.333333333333333),(6,'Invalidestraße129, Berlin ,Nemacka ',52.5337,13.3896,'Apartments Berlin Mitte','Apartmani u Berlinu',3.6666666666666665),(7,'1 Seething Ln , London , Engleska ',51.5216,-0.08895,'Apex city of London Hotel','Hotel u Londonu',3.3333333333333335),(8,'711 E Camp Wisdom Rd, Duncanville, TX , Dallas , USA',32.6736,-96.8882,'Rodeway inn','Motel u Dallasu',3),(9,'Хонгконг, Central, Pottinger St  74 , Hong Kong , Kina',22.2837,114.157,'Ta Vie','Kineski restoran u Hong Kongu',4.25),(10,'Via S. Maurilio 4 , Milano , Italija ',45.5388,8.83334,'San Mauri','Italijanski restoran u Milanu',3.25),(11,'Кнеза Вишеслава 45 , Beograd , Srbija',44.744,20.4268,'MC Donalds','Brza hrana u Beogradu',3.3333333333333335),(12,'Κολοκοτρώνη 38-40 , Atina , Grcka ',37.9777,23.73,'Amber Athens','Grcki restoran u Atini',4.888888888888889),(13,'Via Labicana, 125, Rim , Italija ',41.8902,12.4956,'Aroma','Italijanski restoran u Rimu',4.666666666666667),(14,'C. de Amador de los Ríos, 6, Madrid, Spanija',40.4274,-3.69115,'Saddle','Spanski restoran u Madridu ',4),(15,'9 Chome-7-1 Akasaka,  Tokyo , Japan',35.6662,139.73,'Hinokizaka','Japanski restoran u Tokiju',3.6666666666666665),(16,'Mosman NSW 2088,  Sidnej , Australija',-33.8044,151.246,'Chiosco by Ormeggio','Italijanski restoran u Sidneju',2.6666666666666665),(17,'Córdoba Province, Kordoba , Argentina',-31.4314,-64.2228,'Tarquino','Restoran raznovrsnog tipa u Kordobi',4),(18,'3325 S Las Vegas Blvd, Las Vegas, USA',36.1239,-115.168,'The Pallazo','Hotel u Las Vegasu',1.75),(19,'Calle Del Torno #39-29, Bolívar, Коlumbija',10.4283,-75.5479,'Sofitel Legend Santa Clara','Hotel u Kartagini',3),(20,'588 จอมพล, Bangkok, Tajland',13.8098,100.561,'The Saint Residences','Apartmani u Bangkoku',4.333333333333333),(21,'Быковское ш. 55 ,  Moskva , Rusija ',55.6304,37.981,'Kedre motel','Motel u Moskvi ',3),(22,'Kegelgasse 20, Bec , Austrija ',48.2074,16.3913,'A&A apartments','Apartmani u Becu',4.5),(23,'Parque Nacional da Tijuca - Alto da Boa Vista, Rio de Janeiro , Brazil',-22.952,-43.2105,'Spomenik Isusa Hrista','Veliki spomenik Isusu Hristu u Riu De Zaeniru',4.5),(24,'Al Haram, Nazlet El-Semman , Giza , Egipat',29.9791,31.1342,'Keopsova piramida','Skup Keopsovih piramida',3.6666666666666665),(25,'Sanduhe Town, Huairou District, Peking, Kina',40.4319,116.57,'Kineski zid ','Kineski zid , najduzi na svetu ',4.5),(26,'RFP3+PV ,  Aguas Calientes, Перу',-13.1634,-72.5452,'Macu Pikcu','Zaboravljeni grad sakriven u dzunglama Perua',3),(27,'97751 Tinum, Yucatan, Meksiko',20.683,-88.5686,'Piramida Kukulkan','Majanska piramida u Meksiku',3.5),(28,'52GR+3V Agra, Utar Prades, Indija',27.1751,78.0422,'Taj Mahal','Istorijska znamenitost u Indiji ',4.5);
/*!40000 ALTER TABLE `destinacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'stefan@gmail.com','Stefan','$2a$10$5jZ8PhNbuZyHBVjI4gW1PuS.MIhWfwJcDL/n20HxDYDyHJ1nO/lOC','Stefanovic','ROLE_KORISNIK'),(3,'stefan123@gmail.com','Stefan','$2a$10$LOm.cUedADxVHwHhc5LkWuhBRFQEh53bU.h4Y.qauaHlaM3RvhdoS','Peric','ROLE_KORISNIK'),(5,'milan123@gmail.com','Milan','$2a$10$tbNL9zXZCiIb4NnRvsmTfeYZWDtWxOjcxmqfXZBF5R0H19sWR/Ny2','Milanovic','ROLE_KORISNIK'),(6,'nikola123@gmail.com','Nikola','$2a$10$md31oagJKVBq9QGXVW6fGevw0kAmUv5aVXFhqQ.jYkyS5kKem0/UC','Nikolic','ROLE_KORISNIK'),(7,'petar123@gmail.com','Petar','$2a$10$JUrz1Ejnw2B2nIRsK1eTTOccL/L2MvssflyTdsDRWFpfbiI8OU0AW','Petrovic','ROLE_KORISNIK'),(8,'aleksa123@gmail.com','Aleksa','$2a$10$xwMad6WlN9p5C2vE1TUj/.m2ZH/Ndi4N88q07C5ZGimOEFAx9uGVC','Aleksic','ROLE_KORISNIK');
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reakcija`
--

LOCK TABLES `reakcija` WRITE;
/*!40000 ALTER TABLE `reakcija` DISABLE KEYS */;
INSERT INTO `reakcija` VALUES (11,_binary '',5,19),(12,_binary '\0',5,20),(13,_binary '\0',6,20),(14,_binary '\0',6,23),(15,_binary '',6,29),(16,_binary '',6,24),(17,_binary '\0',7,19),(18,_binary '',7,26),(19,_binary '',7,33),(20,_binary '',7,20),(21,_binary '',7,25),(22,_binary '\0',7,34),(23,_binary '',7,21),(24,_binary '\0',7,27),(25,_binary '\0',7,30),(26,_binary '',7,36),(27,_binary '',7,14),(28,_binary '\0',7,22),(29,_binary '\0',7,28),(30,_binary '',7,37),(31,_binary '',7,24),(32,_binary '',7,38),(33,_binary '\0',7,31),(34,_binary '',7,39),(35,_binary '',8,19),(36,_binary '',8,26),(37,_binary '\0',8,33),(38,_binary '',8,20),(39,_binary '\0',8,25),(40,_binary '',8,34),(41,_binary '',8,21),(42,_binary '',8,27),(43,_binary '',8,35),(44,_binary '',8,30),(45,_binary '\0',8,36),(46,_binary '',8,14),(47,_binary '',8,22),(48,_binary '\0',8,28),(49,_binary '\0',8,37),(50,_binary '',8,23),(51,_binary '',8,29),(52,_binary '',8,24),(53,_binary '\0',8,38),(54,_binary '',8,31),(55,_binary '\0',8,39),(56,_binary '',8,32),(57,_binary '',8,42),(58,_binary '',8,45),(59,_binary '',6,42),(60,_binary '',6,43),(61,_binary '\0',6,44),(62,_binary '',6,49),(63,_binary '',6,45),(64,_binary '',6,52),(65,_binary '',6,54),(66,_binary '',3,42),(67,_binary '\0',3,47),(68,_binary '',3,55),(69,_binary '',3,47),(70,_binary '\0',3,43),(71,_binary '\0',3,48),(72,_binary '',3,56),(73,_binary '\0',3,44),(74,_binary '',3,49),(76,_binary '',3,45),(79,_binary '',5,45),(80,_binary '',5,58),(81,_binary '',5,51),(82,_binary '',5,59),(83,_binary '',5,52),(84,_binary '\0',5,60),(85,_binary '\0',5,53),(86,_binary '',5,61),(87,_binary '',5,54),(88,_binary '',5,62),(89,_binary '\0',5,46),(90,_binary '\0',7,42),(91,_binary '',7,47),(92,_binary '',7,55),(93,_binary '\0',7,43),(94,_binary '',7,48),(95,_binary '\0',7,56),(96,_binary '\0',7,44),(97,_binary '',7,49),(98,_binary '',7,45),(99,_binary '\0',7,58),(100,_binary '',7,67),(101,_binary '',7,51),(102,_binary '\0',7,59),(103,_binary '\0',7,53),(104,_binary '',7,61),(105,_binary '',7,69),(106,_binary '\0',7,52),(107,_binary '',7,60),(108,_binary '',7,54),(109,_binary '',7,62),(110,_binary '',7,46),(111,_binary '',7,63),(112,_binary '',3,16),(113,_binary '',3,75),(114,_binary '',7,16),(115,_binary '',7,79),(116,_binary '',7,72),(117,_binary '',7,80),(118,_binary '',7,73),(119,_binary '',7,74),(120,_binary '',7,76),(121,_binary '',7,77),(122,_binary '',7,85),(123,_binary '',7,78),(124,_binary '\0',7,86),(125,_binary '',5,16),(126,_binary '\0',5,79),(127,_binary '',5,79),(128,_binary '\0',5,88),(129,_binary '',5,72),(130,_binary '',5,80),(131,_binary '',5,73),(132,_binary '\0',5,81),(133,_binary '',5,74),(134,_binary '',5,82),(135,_binary '',5,75),(136,_binary '\0',5,92),(137,_binary '',5,76),(138,_binary '',5,83),(139,_binary '',5,85),(141,_binary '',5,90),(142,_binary '',5,81),(143,_binary '',5,93),(144,_binary '',5,95),(145,_binary '',5,84),(146,_binary '\0',5,77),(147,_binary '',5,87);
/*!40000 ALTER TABLE `reakcija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `recenzija`
--

LOCK TABLES `recenzija` WRITE;
/*!40000 ALTER TABLE `recenzija` DISABLE KEYS */;
INSERT INTO `recenzija` VALUES (14,0,2,'2024-06-28 17:30:12.669168','fgvfe',4,18,3),(16,0,3,'2024-06-30 18:47:03.198246','Dobar tržni centar . Ima sve što vam je potrebno , jedina zamerka je velika gužva . ',3,1,3),(19,1,2,'2024-06-30 20:33:08.451592','Odlican smestaj',4,5,5),(20,2,2,'2024-06-30 20:34:37.050739','Nisam toliko zadovoljan. Neljubazna usluga',2,6,5),(21,0,2,'2024-06-30 20:56:24.066592','Odlican smestaj , sve preporuke .',5,7,3),(22,1,1,'2024-06-30 20:56:51.928229','Najbolji smestaj u kojem sam ikad bio . ',5,18,3),(23,1,1,'2024-06-30 20:57:14.327086','Dobar smestaj blizu mora . ',4,19,3),(24,0,3,'2024-06-30 20:59:06.949799','Dobar smestaj ali nema parkinga u okolini slobodnog ',3,20,3),(25,1,1,'2024-06-30 21:00:59.171125','Dobar smestaj',4,6,6),(26,0,2,'2024-06-30 21:01:16.505969','Odlican smestaj',5,5,6),(27,1,1,'2024-06-30 21:01:36.624950','Dobar smestaj , jedino je parking problem',4,7,6),(28,2,0,'2024-06-30 21:02:08.744639','Najbolji smestaj u kojem sam bio',5,18,6),(29,0,2,'2024-06-30 21:03:41.601509','Previse bucno naselje ',2,19,6),(30,1,1,'2024-06-30 21:04:31.821233','Jefin i uredan smestaj za male pare ',4,8,6),(31,1,1,'2024-06-30 21:04:48.253405','Neuredan smestaj i bucno naselje ',2,21,6),(32,0,1,'2024-06-30 21:05:19.906371','Odlican smestaj blizu centra ',5,22,6),(33,1,1,'2024-06-30 21:08:03.557238','Sve pohvale za smestaj',4,5,7),(34,1,1,'2024-06-30 21:08:24.468538','Smestaj na zavidnom nivou ',5,6,7),(35,0,1,'2024-06-30 21:08:46.373288','Nezadovoljan sam uslugom',1,7,7),(36,1,1,'2024-06-30 21:09:01.038028','Prosecan smestaj',2,8,7),(37,1,1,'2024-06-30 21:09:26.061885','Preskup smestaj',1,18,7),(38,1,1,'2024-06-30 21:09:56.025709','Smestaj uredan i prostran',5,20,7),(39,1,1,'2024-06-30 21:10:20.409551','Zadovoljan sam smestajem spram cene',4,21,7),(40,0,0,'2024-06-30 21:13:48.689487','Odlican smestaj za datu cenu ',5,20,8),(41,0,0,'2024-06-30 21:14:17.949266','Odlican smestaj , imaju i svoju kuhinju . ',4,22,8),(42,1,3,'2024-06-30 21:15:56.165182','Odlican restoran sa raznovrsnom hranom',4,9,8),(43,2,1,'2024-06-30 21:16:16.239392','Prosecna hrana',3,10,8),(44,3,0,'2024-06-30 21:16:31.970361','Brza usluga',4,11,8),(45,0,5,'2024-06-30 21:16:50.040334','Ekskluzivan restoran , sve pohvale ',5,12,8),(46,1,1,'2024-06-30 21:17:40.767272','Prelep ambijent\n',4,17,8),(47,1,2,'2024-06-30 21:18:17.104450','Prelepo mesto sa jos lepsom hranom',5,9,6),(48,1,1,'2024-06-30 21:18:33.754246','Hrana mi se nije svidela ',2,10,6),(49,0,3,'2024-06-30 21:18:56.223145','Ne svidja mi se hrana',2,11,6),(51,0,2,'2024-06-30 21:19:26.240116','Prelep pogled i hrana',5,13,6),(52,1,2,'2024-06-30 21:19:39.664938','Unikatan restoran',5,14,6),(53,2,0,'2024-06-30 21:19:52.211616','Izvrsna hrana',5,15,6),(54,0,3,'2024-06-30 21:20:06.812055','Prosecan restoran',3,16,6),(55,0,2,'2024-06-30 21:22:16.200023','Lep restoran ali nemaju svoj parking',3,9,3),(56,1,1,'2024-06-30 21:22:32.782011','Lepo mesto',4,10,3),(58,1,1,'2024-06-30 21:26:07.155617','Sve pohvale',5,12,5),(59,1,1,'2024-06-30 21:26:26.060878','Najlepsi pogled',5,13,5),(60,1,1,'2024-06-30 21:26:37.682453','Obican restoran',3,14,5),(61,0,2,'2024-06-30 21:26:51.703407','Neljubazno osoblje',2,15,5),(62,0,2,'2024-06-30 21:27:13.006420','Lepa hrana ali losa lokacija',2,16,5),(63,0,1,'2024-06-30 21:27:38.620511','Lep restoran ali nema parkinga',3,17,5),(64,0,0,'2024-06-30 21:29:51.125091','Lep restoran',5,9,7),(65,0,0,'2024-06-30 21:30:10.208651','Niske cene',4,10,7),(66,0,0,'2024-06-30 21:30:25.411123','Brzo i prakticno',4,11,7),(67,0,1,'2024-06-30 21:30:38.691845','Predivan ambijent',5,12,7),(68,0,0,'2024-06-30 21:30:58.315182','Najlepsi restoran u kom sam ikad bio \n',4,13,7),(69,0,1,'2024-06-30 21:32:17.602138','Najbolji restoran u Japanu',4,15,7),(70,0,0,'2024-06-30 21:32:40.640966','Prosecan restoran ',3,16,7),(71,0,0,'2024-06-30 21:32:58.246242','Dobar restoran , i odlicna usluga',5,17,7),(72,0,2,'2024-06-30 22:18:02.062573','Prelepo mesto ',4,2,3),(73,0,2,'2024-06-30 22:18:25.099379','Prelepa istorijska znamenitost',5,3,3),(74,0,2,'2024-06-30 22:18:46.248351','Prelep pogled , jedino sto je prevelika guzva ',4,4,3),(75,0,2,'2024-06-30 22:22:48.401994','Prelepa znamenitosti , predugacak put je do spomenika',4,23,3),(76,0,2,'2024-06-30 22:23:04.536461','Prelepo ali istovremeno je pretoplo ',5,24,3),(77,1,1,'2024-06-30 22:23:41.301692','Lepse je na slikama nego uzivo i prekoplikovano doci do destinacije ',3,26,3),(78,0,1,'2024-06-30 22:24:00.767619','Odlicna destinacija',5,27,3),(79,1,2,'2024-06-30 22:28:06.791717','Odlican trzni centar ',5,1,7),(80,0,2,'2024-06-30 22:28:30.025471','Unikatno mesto sa prelepom atmosferom ',5,2,7),(81,1,1,'2024-06-30 22:28:55.607632','Posetio bih ponovo',5,3,7),(82,0,1,'2024-06-30 22:30:52.618589','Prelepa destinacija blizu mora',5,4,7),(83,0,1,'2024-06-30 22:31:12.049513','Pretoplo je bilo kada sam bio u poseti ',2,24,7),(84,0,1,'2024-06-30 22:31:49.796705','Peru prelepo mesto sa prelepim znamenitostima , ali je ova zabacena ',3,26,7),(85,0,2,'2024-06-30 22:32:03.082753','Neverovatna destinacija',5,25,7),(86,1,0,'2024-06-30 22:32:39.567116','Komplikovan dolazak do destinacije ',2,27,7),(87,0,1,'2024-06-30 22:32:56.883183','Prekrasna palata',4,28,7),(88,1,0,'2024-06-30 22:34:27.277947','Previse visoke cene spram kvaliteta svega',2,1,5),(89,0,0,'2024-06-30 22:41:45.633444','Meni se nije toliko svidelo ',3,2,5),(90,0,1,'2024-06-30 22:42:04.789789','Lepa destinacija ali se brzo obidje ',3,3,5),(91,0,0,'2024-06-30 22:42:16.458355','Prelepa crkva ',5,4,5),(92,1,0,'2024-06-30 22:42:52.755750','Unikatna lokacija',5,23,5),(93,0,1,'2024-06-30 22:43:08.653691','Ponovo bih posetio ',4,24,5),(95,0,1,'2024-06-30 22:48:00.281234','Ponovo bih obisao ',4,25,5),(96,0,0,'2024-06-30 22:48:26.617617','Prelepa destinacija',5,28,5);
/*!40000 ALTER TABLE `recenzija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `restoran`
--

LOCK TABLES `restoran` WRITE;
/*!40000 ALTER TABLE `restoran` DISABLE KEYS */;
INSERT INTO `restoran` VALUES ('KINESKI',9),('ITALIJANSKI',10),('FAST_FOOD',11),('GRCKI',12),('ITALIJANSKI',13),('SPANSKI',14),('JAPANSKI',15),('ITALIJANSKI',16),('ITALIJANSKI',17);
/*!40000 ALTER TABLE `restoran` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `slika_destinacije`
--

LOCK TABLES `slika_destinacije` WRITE;
/*!40000 ALTER TABLE `slika_destinacije` DISABLE KEYS */;
INSERT INTO `slika_destinacije` VALUES (1,'promenada.jpg',1),(2,'eiffel.jpg',2),(3,'colloseum.jpg',3),(4,'sagrada.jpg',4),(5,'burjalarab.jpg',5),(6,'berlinmite.jpg',6),(7,'apexcity.jpg',7),(8,'rodewayinn.jpg',8),(9,'tavie.jpg',9),(10,'sanmauri.jpg',10),(11,'mcdonalds.jpg',11),(12,'amber.jpg',12),(13,'aroma.jpg',13),(14,'saddle.jpg',14),(15,'hinokizaka.jpg',15),(16,'chioscobyormeggio.jpg',16),(17,'tarqino.jpg',17),(18,'pallazo.jpg',18),(19,'sofitel.jpg',19),(20,'thesaintresidence.jpg',20),(21,'kedre.jpg',21),(22,'a&a.jpg',22),(23,'keopsova.jpg',24),(24,'kineskizid.jpg',25),(25,'macupikcu.jpg',26),(26,'kukulkan.jpg',27),(27,'tajmahal.jpg',28),(28,'berlinmite2.jpg',6),(29,'berlinmite3.jpg',6),(30,'burjalarab2.jpg',5),(31,'burjalarab3.jpg',5),(32,'burjalarab4.jpg',5),(33,'burjalarab5.jpg',5),(34,'apexcity2.jpg',7),(35,'apexcity3.jpg',7),(36,'apexcity4.jpg',7),(37,'rodewayinn2.jpg',8),(38,'rodewayinn3.jpg',8),(39,'rodewayinn4.jpg',8),(40,'rodewayinn5.jpg',8),(41,'pallazo2.jpg',18),(42,'pallazo3.jpg',18),(43,'pallazo4.jpg',18),(44,'pallazo5.jpg',18),(45,'sofitel2.jpg',19),(46,'sofitel3.jpg',19),(47,'sofitel4.jpg',19),(48,'sofitel5.jpg',19),(49,'thesaintresidence2.jpg',20),(50,'thesaintresidence3.jpg',20),(51,'thesaintresidence4.jpg',20),(52,'thesaintresidence5.jpg',20),(53,'kedre3.jpg',21),(54,'kedre2.jpg',21),(55,'a&a2.jpg',22),(56,'a&a3.jpg',22),(57,'a&a4.jpg',22),(58,'a&a5.jpg',22),(59,'tavie2.jpg',9),(60,'tavie3.jpg',9),(61,'tavie4.jpg',9),(62,'jesus.jpg',23),(63,'sanmauri2.jpg',10),(64,'sanmauri3.jpg',10),(65,'sanmauri4.jpg',10),(66,'sanmauri5.jpg',10),(67,'mcdonalds2.jpg',11),(68,'mcdonalds3.jpg',11),(69,'mcdonalds4.jpg',11),(70,'amber2.jpg',12),(71,'amber3.jpg',12),(72,'amber4.jpg',12),(73,'amber5.jpg',12),(74,'aroma2.jpg',13),(75,'aroma3.jpg',13),(76,'aroma4.jpg',13),(77,'aroma5.jpg',13),(78,'saddle2.jpg',14),(79,'saddle3.jpg',14),(80,'saddle4.jpg',14),(81,'saddle5.jpg',14),(82,'hinokizaka2.jpg',15),(83,'hinokizaka3.jpg',15),(84,'hinokizaka4.jpg',15),(85,'hinokizaka5.jpg',15),(86,'chioscobyormeggio2.jpg',16),(87,'chioscobyormeggio3.jpg',16),(88,'chioscobyormeggio4.jpg',16),(89,'tarqino2.jpg',17),(90,'tarqino3.jpg',17),(91,'promenada2.jpg',1),(92,'promenada3.jpg',1),(93,'promenada4.jpg',1),(94,'colosseum2.jpg',3),(95,'colosseum3.jpg',3),(96,'colosseum4.jpg',3),(97,'sagrada2.jpg',4),(98,'sagrada3.jpg',4),(99,'sagrada4.jpg',4),(100,'jesus2.jpg',23),(101,'jesus3.jpg',23),(102,'keopsova2.jpg',24),(103,'keopsova3.jpg',24),(104,'kineski2.jpg',25),(105,'kineski3.jpg',25),(106,'macupikcu2.jpg',26),(107,'macupikcu3.jpg',26),(108,'kukulkan2.jpg',27),(109,'kukulkan3.jpg',27),(110,'tajmahal2.jpg',28),(111,'tajmahal3.jpg',28);
/*!40000 ALTER TABLE `slika_destinacije` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `smestaj`
--

LOCK TABLES `smestaj` WRITE;
/*!40000 ALTER TABLE `smestaj` DISABLE KEYS */;
INSERT INTO `smestaj` VALUES ('HOTEL',5),('APARTMAN',6),('HOTEL',7),('MOTEL',8),('HOTEL',18),('HOTEL',19),('APARTMAN',20),('MOTEL',21),('APARTMAN',22);
/*!40000 ALTER TABLE `smestaj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `znamenitost`
--

LOCK TABLES `znamenitost` WRITE;
/*!40000 ALTER TABLE `znamenitost` DISABLE KEYS */;
INSERT INTO `znamenitost` VALUES ('TRZNI_CENTAR',1),('TORANJ',2),('ISTORIJSKE_ZNAMENISTOSI',3),('ISTORIJSKE_ZNAMENISTOSI',4),('ISTORIJSKE_ZNAMENISTOSI',23),('ISTORIJSKE_ZNAMENISTOSI',24),('ISTORIJSKE_ZNAMENISTOSI',25),('ISTORIJSKE_ZNAMENISTOSI',26),('ISTORIJSKE_ZNAMENISTOSI',27),('ISTORIJSKE_ZNAMENISTOSI',28);
/*!40000 ALTER TABLE `znamenitost` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-15 17:10:44
