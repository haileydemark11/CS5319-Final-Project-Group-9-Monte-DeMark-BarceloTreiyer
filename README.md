# CS5319-Final-Project-Group-9-Monte-DeMark-BarceloTreiyer

# Final Project: Hangman
 
## Event Based Implementation - How to Compile and Execute

### Windows

> An executable, Hangman_EventManager.exe, is available in the root directory to play the game. All a user must do is click on the program after download.

### Mac

> A user must have the latest Java JDK installed on his/her computer.
> <br>Link to download: https://www.oracle.com/java/technologies/downloads/ <br>
> Once installed, a user must open their terminal, navigate to the directory holding this source code, and run the command: <br>
> java -jar Hangman_EventManager.jar
>

#
## Model-View-Controller Implementation - How to Compile and Execute
 Our MVC code runs in both IntelliJ and Visual Studio Code. First, clone our repository into your terminal, or download our ZIP file.

### IntelliJ
Download IntelliJ from their website. Then open the application and run the program through the GameController.java class. The GUI will then pop up so the user can play. 

> <br>Link to download: https://www.oracle.com/java/technologies/downloads/ <br>


### Visual Studio Code
  Download and open Visual Studio Code 3 and install the following extensions:
  > * Java (from Oracle Corporation)
  > * Debugger for Java (from Microsoft)
  > * Extension Pack for Java (from Microsoft) 
  
  We also had other extensions downloaded from previous projects, so if you run into issues compiling, try to install:
  > * Gradle for Java (from Microsoft)
  > * Maven for Java (from Microsoft)
  > * Test Runner for Java (from Microsoft) 
  > * Project Manager for Java (from Microsoft) 
  > * CMake
  > * CMake Tools 
  > * Code Runner 
  
   Once the extensions all installed, run from the GameController.java class and begin the game in your pop up GUI. 

####
## Quick Game Play Instructions 
1. Run the game from GameController.java 
2. Press the "Start Game" button 
3. Click any letter on the GUI keyboard to guess 
4. View your status by looking at "Guessed Letters", "Remaining Guesses", and the updated hangman drawing 
5. If you guessed the word correctly, press the "Next Level" button on the next screen  
6. Keep pressing "Next Level" or "Play Again" until you beat all 5 levels! 


## How to play - Detailed
 When you run the code, the start screen that says "Welcome to Hangman" will pop up in a java GUI. When you are ready to start the game, press the "Start Game" button at the bottom of the GUI. Once you press the start button, it will take you to the game screen. This screen displays an empty gallow, the category of the level (called "theme" on screen), the number of characters in the unknown word, an array that holds user guessed letters, the number of remaining guesses the user has, and a keyboard. The user will click on a key from the keyboard on the GUI to guess a letter. If the user guesses a letter in the word, the place of that letter in the word will be revealed. If the user guesses a letter that is not in the word, a body part of the hangman will be drawn. Since there are six body parts to be drawn, users have six chances to reveal the unknown word. If they run out of guesses, the user loses the game and is directed to the "Game Over" screen. On this screen, users are shown the word and have an option to play again by clicking another button. If the user decides to play again, they are sent back to the first round where a random word from that category is chosen. 
 
 For testing purposes, we have limited the amount of words the game can choose from, but you can theoretically add as many words as you would like to the array in WordManager. Once the user guesses a letter, the letter will be disabled on the keyboard so users won't try to guess it again. If the player uncovers the first word, they are directed to a "Congratulations" screen, where they can press a button "Next Level" to move on to a more challenging level. There are five levels, each with increasing compleixty of words. If the user guesses all of the words, they are directed to the final Winning screen where they have an option to restart the game. The goal of the game is to keep uncovering the unknown words and to defeat the final level. 


## Why We Chose Event-Based Over MVC Architecture
In our event-based architecture, the code relies on the EventManager to listen for all the other classes updates. Its components do not directly depend on each other, which allows them to operate independently. The EventManager is the central hub for managing events and routing them to relevant subscribers. In our model-view-controller code, the system is separated into a Controller, Model, and View components. The controller handles user input and delegates data through the GameController class, the model takes the user requests from the controller and updates the system before sending the manipulated data back to the controller, and the view gets the updated data from the GameController and then handles the user interface. 


Our event-based architecture communicates asynchronously. Components emit events, and any subscribed component can respond without the emitting component knowing who is listening. This allows components to be added or removed without disrupting the system. In our model-view-controller code, communication is synchronous and tightly coupled between the layers. The controller acts as the mediator and processes user input to update the model. The model sends this back to the controller to update the view so the UI can be updated. This means that adding new features usually requires updating the model, the view, and the controller, which increases complexity. 


Our event-based code is flexible and can easily add new game features since other components do not have to be modified. This makes our event-based architecture highly scalable since new components can subscribe to existing events or emit new ones without changing the core game logic. Our MVC code is highly structured and best suited for static applications where the system's core functionality is unlikely to change. When new features are incorporated, this causes modification to all three layers. While coding the MVC, we had to modify game logic by adding the InputHandler class since our user input was initially handled in GameController. We wanted to separate the two components. Doing so created more complexity and resulted in much time to fix, even though both components are in the controller. 

Our team decided that our event-based code was better suited for Hangman since it is scalable and flexible to changes. We originally wanted to add more features to enhance our Hangman game, including a statistics tracker, multi-player, or a timed mode. However, it was challenging to scale our MVC code to include all these features. Our event-based code is more adaptable to scale our game to include these options since new components don't impact the core components. We also chose our event-based code since the components are independent, which helps maintain modularity and simplicity. While model-view-controller is a great architecture pattern for large systems with complex interactions, its structure and tight coupling create unnecessary challenges for our Hangman game. 