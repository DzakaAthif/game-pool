- how to run your code (e.g., any quirks to run your application).
Enter gradle run

- List which features (i.e., Pockets and More Coloured Balls, Difficulty Level, Time and Score, and Undo and Cheat) you have implemented in your extension.
I have implemented all the features. The features are: Pockets and More Coloured Balls, Difficulty Level, Time and Score, and Undo and Cheat

- List the names of the design patterns you have used in your extension and provide the corresponding class and file names regarding these patterns.
Prototype: Prototype.Prototype, Prototype.PocketPrototypeFactory, Items.Ball, Items.Pocket
Memento: Memento.Caretaker, Memento.Memento, Items.PoolTable
Observer: Observer.Subject, Observer.Clock, Items.Ball, Observer.Observer, Observer.ClockObserver, 
Observer.BallObserver

Attention Please: class and file names that are not listed here will not be assessed as part of the design pattern.

- Describe how to select difficulty level, how to undo and how to cheat in your code (i.e., what operations your maker needs to do).

- Select difficulty level:
After running the game click any of the "easy", "normal", "hard" buttons.
The buttons corresponds with easy, normal, and hard level respectively.
After pressing a new difficulty level, the game will start from the very beginning,
and pressing the undo button would not make you go back to the previous difficulty 
level. 

- How to undo.
press save at any point during the game to save the current state (balls state and score). 
pressing undo will make you go back to the saved state. The saved state will dissapear, once
the saved state used (e.g saved state 1, play normally, go back to state 1, play normally,
cannot go back to state 1 again (unless you saved again right after go back to state 1).)

- How to remove balls using keyboard keys
pressing one of the digit keys will remove the corresponding coloured ball that exists
in the table. For example: pressing digit 1 will remove all the red balls on the table,
and add the red balls points to the score. If there are 2 red balls, then pressing digit 1,
will remove all the red balls and added 2 points to the score.
The following are the digits and the corresponding coloured ball it will remove:
1: red
2: yellow
3: green
4: brown
5: blue
6: purple
7: black
8: orange

- Any other info you would like your marker to know regarding your implementation.
After the clock hits 60 minutes it will go back to 0.