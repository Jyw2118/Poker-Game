ReadMe

This code is compiled of 5 different classes: A card class, a deck class, a player class, a game class,
and a Poker class.

Card class: The card class creates the card object. It implements the comparable interface and allows the 
program to check to see if two cards have similar suits and if two cards have adjacent ranks. It also has
methods to print out the card, and to get the rank and the suit and to set the rank and the suit.

Deck class: The deck class creates the 52 cards that make up the deck. It also shuffles the deck randomly
by randomly choosing a number between 1-52 and switching it with the card at the counter. It does this 52 times.
The deck class also has a method to deal the top card. It then increments the counter so the next cards is 
the top card.

Player class: The player class creates the player object. This class has methods to add or remove a card
with or without an index, increment the bankroll based on the bet and calculate the winnings. It can
also return the bankroll, get a specific card, remove all the cards, and sort all the cards based on the rank.

Game class: The game class has two constructors, one with the parameter that sets the suit and rank
based on the string by using ascii and subtracting accordingly and the other that plays the game normally.
The play method plays the actual game. It starts by telling the player how many tokens they have and 
asking them how many they would like to bet. It does not let the player play if the bet is not between 1-5 
inclusive or if they don't have enough money. It then deals out the first five top cards and checks what it is. 
It then asks the player if they want to exchange any cards. The player then inputs 1-5 which is the corresponding
card number. A prompt tells player that they cannot change the same card twice but there is not restriction on it.
The code assumes that the player will follow the directions. It then recalculates based on the new cards, tells
the player what they won and asks if they want to play again. It does not let them play again if "no" or if
the player doesn't have any tokens left. If the player selects "yes", the variables reset for the new round.

Game class(checking the hand): This method checks what type the cards are. It sorts the cards based on rank and
counts all the adjacent and equivalent sets. It also checks how many cards have the same suit.
For full house, two pairs, and royal flush, I had to hard code in the check. The straight flush is true
if the adjacent counter=4, four of a kind is true when the equal counter=3, flush is true when the flush count
=4, three of a kind is true when the equal counter=2, and one pair is true when equal count=1. If none are true
then it returns no pair. 

Game class(hand value): This method assigns points based on what they type of cards are.