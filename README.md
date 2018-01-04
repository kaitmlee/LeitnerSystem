# LeitnerSystem

This is a flashcard app inspired by the Leitner system. The user uploads a .txt file of "flashcards", and can choose three different methods to study. The are called leitner, simple, and drill.

Leitner chooses a random box and a random card and shows the user a random side to the card and they have to guess the answer. If the answer is wrong then the card goes back to the first box. If they are right then it goes to the next box. There are four boxes total.

Simple draws a random card from a specified box by the user. It will only draw the cards that are in the box at that moment though. If the user is right the card goes to the next box, if they are wrong it goes back to the first. This continues until the box is empty then the game is over.

Drill is similiar to simple except the card is simply removed from the box once the user answers it correctly. If they are wrong then it is placed back into the box until they get it right.

There is a gui available for all three study methods as well. 

The commands to use this system are:
import flashcardfile.txt
leitner
simple box#
drill box#
leitner-gui
simple-gui box#
drill-gui box#
list-with box#          //this lists all the flashcards with the specified string in a certain box
list-box box#           //this lists all the flashcards in the specified box
!exit
