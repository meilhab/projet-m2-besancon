-- Script generated by USE 2.6.2

!create J1 : Journal
!set J1.name := 'Petit Journal'
!set J1.issueNumber := 3

!create I1 : Issue
!set I1.number := 1
!set I1.specialIssue := true
!set I1.title := 'edition1'
!set I1.pageNumber := 3
!create I2 : Issue
!set I2.number := 2
!set I2.specialIssue := false
!set I2.title := ''
!set I2.pageNumber := 2
!create I3 : Issue
!set I3.number := 3
!set I3.specialIssue := false
!set I3.title := ''
!set I3.pageNumber := 1

!create P1 : Paper
!set P1.title := 'p1-sub'
!set P1.beginPage := 1
!set P1.endPage := 2
!set P1.type := Gender::research
!create P2 : Paper
!set P2.title := 'p2-pub'
!set P2.beginPage := 1
!set P2.endPage := 1
!set P2.type := Gender::application
!create P3 : Paper
!set P3.title := 'p3-sub'
!set P3.beginPage := 1
!set P3.endPage := 8
!set P3.type := Gender::research
!create P4 : Paper
!set P4.title := 'p4-pub'
!set P4.beginPage := 1
!set P4.endPage := 2
!set P4.type := Gender::application
!create P5 : Paper
!set P5.title := 'p5-sub'
!set P5.beginPage := 1
!set P5.endPage := 4
!set P5.type := Gender::research
!create P6 : Paper
!set P6.title := 'p6-pub'
!set P6.beginPage := 1
!set P6.endPage := 2
!set P6.type := Gender::application
!create P7 : Paper
!set P7.title := 'p7-sub'
!set P7.beginPage := 1
!set P7.endPage := 2
!set P7.type := Gender::research
!create P8 : Paper
!set P8.title := 'p8-pub'
!set P8.beginPage := 1
!set P8.endPage := 1
!set P8.type := Gender::application

!create R1 : Reviewer
!set R1.id := '1'
!set R1.name := 'p1'
!create R2 : Reviewer
!set R2.id := '2'
!set R2.name := 'p2'
!create R3 : Reviewer
!set R3.id := '3'
!set R3.name := 'p3'
!create R4 : Reviewer
!set R4.id := '4'
!set R4.name := 'p4'
!create R5 : Reviewer
!set R5.id := '5'
!set R5.name := 'p5'
!create R6 : Reviewer
!set R6.id := '6'
!set R6.name := 'p6'

!create A1 : Author
!set A1.id := '1'
!set A1.name := 'p1'
!create A2 : Author
!set A2.id := '2'
!set A2.name := 'p2'
!create A3 : Author
!set A3.id := '3'
!set A3.name := 'p3'
!create A4 : Author
!set A4.id := '4'
!set A4.name := 'p4'
!create A5 : Author
!set A5.id := '5'
!set A5.name := 'p5'
!create A6 : Author
!set A6.id := '6'
!set A6.name := 'p6'

!insert (J1, I1) into journalIssue
!insert (J1, I2) into journalIssue
!insert (J1, I3) into journalIssue

!insert (J1, A1) into journalAuthor
!insert (J1, A2) into journalAuthor
!insert (J1, A3) into journalAuthor
!insert (J1, A4) into journalAuthor
!insert (J1, A5) into journalAuthor
!insert (J1, A6) into journalAuthor

!insert (J1, R1) into journalReviewer
!insert (J1, R2) into journalReviewer
!insert (J1, R3) into journalReviewer
!insert (J1, R4) into journalReviewer
!insert (J1, R5) into journalReviewer
!insert (J1, R6) into journalReviewer

!insert (I1, P1) into issuePaperSubmit
!insert (I1, P3) into issuePaperSubmit
!insert (I2, P5) into issuePaperSubmit
!insert (I2, P7) into issuePaperSubmit

!insert (I1, P2) into issuePaperPublication 
!insert (I1, P4) into issuePaperPublication 
!insert (I2, P6) into issuePaperPublication 
!insert (I3, P8) into issuePaperPublication 

!insert (P1, R1) into paperReviewer
!insert (P2, R2) into paperReviewer
!insert (P2, R3) into paperReviewer
!insert (P2, R4) into paperReviewer
!insert (P3, R3) into paperReviewer
!insert (P4, R4) into paperReviewer
!insert (P4, R5) into paperReviewer
!insert (P4, R6) into paperReviewer
!insert (P5, R5) into paperReviewer
!insert (P6, R6) into paperReviewer
!insert (P6, R1) into paperReviewer
!insert (P6, R2) into paperReviewer
!insert (P7, R1) into paperReviewer
!insert (P8, R2) into paperReviewer
!insert (P8, R3) into paperReviewer
!insert (P8, R4) into paperReviewer

!insert (P1, A6) into paperAuthor
!insert (P2, A1) into paperAuthor
!insert (P3, A2) into paperAuthor
!insert (P4, A3) into paperAuthor
!insert (P5, A4) into paperAuthor
!insert (P6, A5) into paperAuthor
!insert (P7, A6) into paperAuthor
!insert (P8, A1) into paperAuthor
!insert (P8, A5) into paperAuthor
