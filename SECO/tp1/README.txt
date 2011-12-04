Contient :
    - doc/                  documentation fractal
    - Examples/             exemple build Ant
    - exo1/                 exercice 1
    - exo2/                 exercice 2
    - exo3/                 exercice 3
    - exo4/                 exercice 4
    - exo5/                 exercice 5
    - exo6/                 exercice 6
    - externals/            bibliothèques externes utilent pour le fonctionnement de fractal
    - initial/              exemples de fonctionnement de fractal
    - rapportSceance.txt    résumé des scéances de tp
    - rapportTPSeco.pdf     rapport concernant le TP à rendre
    - Sujet/                sujet de TP

Pour importer les exercices, si on utilise eclipse : 
    - placer le workspace à la racine du dossier;
    - New -> Other -> Java Project from Existing Ant Buildfile;
    - sélectionner le script Ant de l'exercice voulu, garder le project name que le système défini après avoir chargé le ant.

Concernant l'exercice 6 : les saisies clavier ne sont pas prises en compte avec eclipse et ant.
Pour cela, il suffit de lancer le ant en ligne de commande :
    - se déplacer dans le répertoire de l'exercice 6 avec votre terminal favori;
    - taper la commande : ant execute
