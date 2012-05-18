TEMP=fichiersTemp/
NAME=rapport
TEMPFILE=$(TEMP)$(NAME)
COMP=pdflatex
BIB=bibtex

all: pdflatex

pdflatex: compilationSimple $(TEMPFILE).pdf
	mv $(TEMPFILE).pdf ./
	evince $(NAME).pdf

bibtex: compilationBiblio $(TEMPFILE).pdf
	mv $(TEMPFILE).pdf ./
	evince $(NAME).pdf

compilationSimple: $(NAME).tex
	$(COMP) -output-directory $(TEMP) $(NAME).tex
	$(COMP) -output-directory $(TEMP) $(NAME).tex

compilationBiblio: $(NAME).tex
	$(COMP) -output-directory $(TEMP) $(NAME).tex
	$(BIB) $(TEMPFILE).aux
	$(COMP) -output-directory $(TEMP) $(NAME).tex
	$(COMP) -output-directory $(TEMP) $(NAME).tex

.PHONY: clean allclean

clean:
	(cd $(TEMP) && rm *.*)

allclean: clean
	rm $(NAME).pdf

