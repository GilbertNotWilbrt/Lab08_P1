Project: zuul-bad
Authors: Michael Kölling and David J. Barnes

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

This project is a simple framework for an adventure game. In this version,
it has a few rooms and the ability for a player to walk between these rooms.
That's all.

To start this application, create an instance of class "Game" and call its
"play" method.

This version of the game contains some very bad class design. It should NOT
be used as a basis for extending the project without fixing these design
problems. It serves as an example to discuss good and bad design (chapter 8
of the book).

Chapter 8 of the book contains a detailed description of the problems in this
project, and how to fix them.

The project 'zuul-better' contains a version of this project with better
designed class structure. It includes the fixes discussed in the book.

1. 

This application is a text-based adventure game where navigatable
through connected rooms by using text commands. These commands are 
- go : Moves the player north, east,south, or west
- quit : ends game
- help : displays a list of commands

There are 5 rooms.

Campus pub - Outside - Lecture theater 

            Computing Lab - Admin Office

2.

Game: It controls the game, creates rooms, and processes commands

Parser: Reads and interprets user input

Command: Represents a user command w/ command word and second word

CommandWords: Validates if word is a real command

Room: Represents location with description

3-4.

I made a game set in a mall and the goal is to find the main exit.
Simply changed the names of the rooms but kept the same type of rooms.

5.

 I replaced the code that showed itself twice by making a new method.
I replcaed it as it violated the DRY principle.
Then I updated the code that I deleted in the original with the new method.

9.

HashMap.keySet() returns a set of all keys currently in the map.

12.



13.

 
