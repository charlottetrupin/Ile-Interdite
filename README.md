# Ile-Interdite

Ce projet a été réalisé en binome lors d'un cours de programmation objet et génie logiciel en 2020, 2ème année de licence.

Il reprend le concept du jeu coopératif Ile Interdite. 

Dans notre jeu, les 4 joueurs doivent récupérer 4 artefacts, chacun lié à un élément (air, eau, terre, feu). L’île
est formée par un ensemble de zones disposées en grille. Outre les zones ordinaires on a les cas particuliers suivants :
— un héliport, d’où les joueurs doivent s’envoler à l’issue de la partie,
— des zones associées à chacun des éléments, qui permettent de récupérer l’artefact correspondant.

Chaque zone est dans l’une des situations suivantes : « normale », « inondée » ou « submergée ». Une 
zone « inondée » peut être asséchée et revenir à la situation « normale ». Une zone « submergée »
a définitivement disparu. 

Un joueur peut avoir en main des clés, chacune associée à un élément, et qui permettent de récupérer l’artefact correspondant.

Chaque joueur à le droit à plusieurs actions durant son tour : se déplacer (haut,bas,droite,gauche), assécher une case inondée, récupérer un artefact,
acquerir potentiellement une clé (peut aussi ne rien donner ou inonder la case où se situe le joueur). A la fin de son tour, 3 cases sont automatiques inondés.

La partie est gagnée lorsque les 4 artefacts sont récupérés et que tous les joueurs sont regroupés à
l’héliport. La partie est perdue dès qu’il n’est plus possible de la gagner.
