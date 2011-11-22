-- Script generated by USE 2.6.2

!create F1 : Hotel
!set F1.adresse := '1 rue du moulin 25000 Besançon'
!set F1.etageMin := 1
!set F1.etageMax := 14

!create P1 : Personne
!set P1.nom := 'P1'
!set P1.age := 20
!set P1.sexe := SEXE::masculin
!create P2 : Personne
!set P2.nom := 'P2'
!set P2.age := 20
!set P2.sexe := SEXE::feminin
!create P3 : Personne
!set P3.nom := 'P3'
!set P3.age := 20
!set P3.sexe := SEXE::masculin
!create P4 : Personne
!set P4.nom := 'P4'
!set P4.age := 3
!set P4.sexe := SEXE::feminin
!create P5 : Personne
!set P5.nom := 'P5'
!set P5.age := 3
!set P5.sexe := SEXE::masculin
!create P6 : Personne
!set P6.nom := 'P6'
!set P6.age := 20
!set P6.sexe := SEXE::feminin

!create Ch1 : Chambre
!set Ch1.etage := 1
!set Ch1.numero := 11
!set Ch1.nbDeLits := 2
!set Ch1.prix := 100
!create Ch2 : Chambre
!set Ch2.etage := 2
!set Ch2.numero := 21
!set Ch2.nbDeLits := 2
!set Ch2.prix := 100
!create Ch3 : Chambre
!set Ch3.etage := 3
!set Ch3.numero := 31
!set Ch3.nbDeLits := 2
!set Ch3.prix := 100
!create Ch4 : Chambre
!set Ch4.etage := 4
!set Ch4.numero := 41
!set Ch4.nbDeLits := 2
!set Ch4.prix := 100
!create Ch5 : Chambre
!set Ch5.etage := 5
!set Ch5.numero := 51
!set Ch5.nbDeLits := 2
!set Ch5.prix := 100
!create Ch6 : Chambre
!set Ch6.etage := 6
!set Ch6.numero := 61
!set Ch6.nbDeLits := 2
!set Ch6.prix := 100
!create Ch7 : Chambre
!set Ch7.etage := 7
!set Ch7.numero := 71
!set Ch7.nbDeLits := 2
!set Ch7.prix := 100
!create Ch8 : Chambre
!set Ch8.etage := 8
!set Ch8.numero := 81
!set Ch8.nbDeLits := 2
!set Ch8.prix := 100
!create Ch9 : Chambre
!set Ch9.etage := 9
!set Ch9.numero := 91
!set Ch9.nbDeLits := 2
!set Ch9.prix := 100
!create Ch10 : Chambre
!set Ch10.etage := 10
!set Ch10.numero := 101
!set Ch10.nbDeLits := 2
!set Ch10.prix := 100
!create Ch11 : Chambre
!set Ch11.etage := 11
!set Ch11.numero := 111
!set Ch11.nbDeLits := 2
!set Ch11.prix := 100
!create Ch12 : Chambre
!set Ch12.etage := 12
!set Ch12.numero := 121
!set Ch12.nbDeLits := 2
!set Ch12.prix := 100
!create Ch13 : Chambre
!set Ch13.etage := 14
!set Ch13.numero := 141
!set Ch13.nbDeLits := 2
!set Ch13.prix := 100
!create Ch14 : Chambre
!set Ch14.etage := 14
!set Ch14.numero := 142
!set Ch14.nbDeLits := 2
!set Ch14.prix := 100

!create SDB1 : SalleDeBain
!set SDB1.etage := 1
!set SDB1.nbUtilisateurs := 0
!set SDB1.numero := 11
!create SDB2 : SalleDeBain
!set SDB2.etage := 2
!set SDB2.nbUtilisateurs := 0
!set SDB2.numero := 21
!create SDB3 : SalleDeBain
!set SDB3.etage := 3
!set SDB3.nbUtilisateurs := 0
!set SDB3.numero := 31
!create SDB4 : SalleDeBain
!set SDB4.etage := 4
!set SDB4.nbUtilisateurs := 0
!set SDB4.numero := 41
!create SDB5 : SalleDeBain
!set SDB5.etage := 5
!set SDB5.nbUtilisateurs := 0
!set SDB5.numero := 51

!insert(P1, F1) into dirige

!insert(F1, Ch1) into contient
!insert(F1, Ch2) into contient
!insert(F1, Ch3) into contient
!insert(F1, Ch4) into contient
!insert(F1, Ch5) into contient
!insert(F1, Ch6) into contient
!insert(F1, Ch7) into contient
!insert(F1, Ch8) into contient
!insert(F1, Ch9) into contient
!insert(F1, Ch10) into contient
!insert(F1, Ch11) into contient
!insert(F1, Ch12) into contient
!insert(F1, Ch13) into contient
!insert(F1, Ch14) into contient

!insert(Ch1, SDB1) into possede
!insert(Ch2, SDB2) into possede
!insert(Ch3, SDB3) into possede
!insert(Ch4, SDB4) into possede
!insert(Ch5, SDB5) into possede

!insert(F1, P2) into heberge
!insert(F1, P3) into heberge
!insert(F1, P4) into heberge
!insert(F1, P5) into heberge
!insert(F1, P6) into heberge

!insert(P2, Ch1) into loue
!insert(P3, Ch1) into loue
!insert(P3, Ch3) into loue
-- 2 adultes + 1 enfants de moins de 4 ans dans une chambre 2 places
!insert(P4, Ch2) into loue
!insert(P5, Ch2) into loue
!insert(P6, Ch2) into loue




