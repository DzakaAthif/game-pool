# PoolGame

## Commands

### Running the code/Starting the game
Enter gradle run

## Game features
* Pockets and More Coloured Balls
* Multiple Difficulty Levels
* Time and Score
* Undo
* Cheat

## How to select difficulty level:
After running the game click any of the "easy", "normal", "hard" buttons.
The buttons corresponds with easy, normal, and hard level respectively.
After pressing a new difficulty level, the game will start from the very beginning,
and pressing the undo button would not make you go back to the previous difficulty 
level. 

## How to undo:
press save at any point during the game to save the current state (balls state and score). 
pressing undo will make you go back to the saved state. The saved state will dissapear, once
the saved state used (e.g saved state 1, play normally, go back to state 1, play normally,
cannot go back to state 1 again (unless you saved again right after go back to state 1).)

## Cheat: How to remove balls using keyboard keys
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

## Design patterns used
Prototype: Prototype.Prototype, Prototype.PocketPrototypeFactory, Items.Ball, Items.Pocket
Memento: Memento.Caretaker, Memento.Memento, Items.PoolTable
Observer: Observer.Subject, Observer.Clock, Items.Ball, Observer.Observer, Observer.ClockObserver, 
Observer.BallObserver
