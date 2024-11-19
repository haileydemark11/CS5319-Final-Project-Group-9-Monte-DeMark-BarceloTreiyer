# CS5319-Final-Project-Group-9-Monte-DeMark-Treiyer

# Implementation for Final Project: Hangman
 
## Event Based Implementation - How to play

### Windows

> An executable, Hangman_EventManager.exe, is available in the root directory to play the game. All a user must do is click on the program after download.

### Mac

> A user must have the latest Java JDK installed on his/her computer.
> <br>Link to download: https://www.oracle.com/java/technologies/downloads/ <br>
> Once installed, a user must open their terminal, navigate to the directory holding this source code, and run the command: <br>
> java -jar Hangman_EventManager.jar


## Model-View-Controller Implementation 

# Model-View-Controller Code Overview  
> Our model-view-controller implementation is written in Java. The MVC architecture for our Hangman game neatly separates game logic between the Model, View, and Controller components. This helps to keep the code organized and and is a frequently used architecture pattern in web development.  

# System Requirements 
> We compiled the MVC code in Visual Studio Code 3 after installing these extensions: 
>> Java (from Oracle Corporation)
>> Debugger for Java (from Microsoft)
>> Extension Pack for Java (from Microsoft) 

> We also had other extensions downloaded from previous projects, so if you run into issues compiling, try to install:
>> Gradle for Java (from Microsoft)
>> Maven for Java (from Microsoft)
>> Test Runner for Java (from Microsoft) 
>> Project Manager for Java (from Microsoft) 
>> CMake
>> CMake Tools 
>> Code Runner 

# To Run 
> First, clone our repository into your terminal, or download our ZIP file.
> Open Visual Studio Code 3
> Open oru folder in VS code 
> Make sure the proper extensions are installed in your VS code 
> Open the "GameController.java" class in the project 
> You can build the prokect by pressing (Ctrl + Shoft + P)
> Run the code from GameController. You can do this from the terminal or by pressing the run button in the top right hand side of your VS code browser (it looks like the play icon) 
> Once you run the code, a Java GUI will pop up where you can play the game.

# How to play
> When you run the code, the start screen that says "Welcome to Hangman" will pop up in a java GUI. When you are ready to start the game, press the "Start Game" button at the bottom of the GUI. Once you press the start button, it will take you to the game screen. This screen displays an empty gallow, the category of the level (called "theme" on screen), the number of characters in the unknown word, an array that holds user guessed letters, the number of remaining guesses the user has, and a keyboard. The user will click on a key from the keyboard on the GUI to guess a letter. If the user guesses a letter in the word, the place of that letter in the word will be revealed. If the user guesses a letter that is not in the word, a body part of the hangman will be drawn. Since there are six body parts to be drawn, users have six chances to reveal the unknown word. If they run out of guesses, the user loses the game and is directed to the "Game Over" screen. On this screen, users are shown the word and have an option to play again by clicking another button. If the user decides to play again, they are sent back to the first round where a random word from that category is chosen. For testing purposes, we have limited the amount of words the game can choose from, but you can theoretically add as many words as you would like to the array in WordManager. Once the user guesses a letter, the letter will be disabled on the keyboard so users won't try to guess it again. If the player uncovers the first word, they are directed to a "Congratulations" screen, where they can press a button "Next Level" to move on to a more challenging level. There are five levels, each with increasing compleixty of words. If the user guesses all of the words, they are directed to the final Winning screen where they have an option to restart the game. 
> The goal of the game is to keep uncovering the unknown words and to defeat the final level. 

# Quick Instructions 
1. Run the game from GameController.java 
2. Press the "Start Game" button 
3. Click any letter on the GUI keyboard to guess 
4. View your status by looking at "Guessed Letters", "Remaining Guesses", and the updated hangman drawing 
5. If you won the first round, press the "Next Level" button 
6. Keep pressing "Next Level" or "Play Again" until you beat all 5 levels! 



## EXPLAIN WHY WE CHOSE EVENT-BASED OVER MVC WITH SPECIFICS 
