CREATE TABLE DIAKOK ( id int not null primary key, 
                              nev varchar(40), 
                              kod varchar(40), 
                              szuletesiev int,
			      koltsegteriteses boolean);

INSERT INTO DIAKOK VALUES(1,'Orosz Imre','ORIMABC.PTE',1995,false);
INSERT INTO DIAKOK VALUES(2,'Varga Koppány','VAKOABC.PTE',1989,true);
INSERT INTO DIAKOK VALUES(3,'Kun Ágota','KUAGABC.PTE',1994,false);
INSERT INTO DIAKOK VALUES(4,'Szilágyi Dezső','SZDEABC.PTE',1992,false);
INSERT INTO DIAKOK VALUES(5,'Balogh Béla','BABEABC.PTE',1991,true);
INSERT INTO DIAKOK VALUES(6,'Sipos Zalán','SIZAABC.PTE',1994,false);
INSERT INTO DIAKOK VALUES(7,'Faragó Bálint','FABAABC.PTE',1990,true);
INSERT INTO DIAKOK VALUES(8,'Csordás Ibolya','CSIBABC.PTE',1992,true);
INSERT INTO DIAKOK VALUES(9,'Fábián Éva','FAEVABC.PTE',1993,false);
INSERT INTO DIAKOK VALUES(10,'Hegedűs András','HEANABC.PTE',1995,false);