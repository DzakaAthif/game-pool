package PoolGame;

import PoolGame.Items.Ball;
import PoolGame.Items.PoolTable;
import PoolGame.Memento.Caretaker;
import PoolGame.Memento.Memento;
import PoolGame.Observer.Score;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ButtonsCreation {

    public List<Button> createSaveRecoverButton(Game game) {

        Caretaker caretaker = game.getCaretaker();
        PoolTable table = game.getPoolTable();
        Text winText = game.getWinText();
        Group root = game.getRoot();

        List<Button> SRbuttons = new ArrayList<>();

        Button save = new Button();

        int y = 220;

        save.setText("save");
        save.setTranslateX(10);
        save.setTranslateY(y);

        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                caretaker.addMemento(table.saveState());
            }
        };

        save.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);

        Button recover = new Button();

        recover.setText("undo");
        recover.setTranslateX(10);
        recover.setTranslateY(y+30);

        EventHandler<MouseEvent> handler2 = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Memento memento = caretaker.getMemento();
                if (memento == null)
                    return;

                winText.setVisible(false);

                for (Ball ball : table.getBalls()) {
                    root.getChildren().remove(ball.getNode());
                }

                table.recoverState(memento);

                for (Ball ball : table.getBalls()) {
                    ball.addToGroup(root.getChildren());
                }
            }
        };

        recover.addEventHandler(MouseEvent.MOUSE_CLICKED, handler2);

        SRbuttons.add(save);
        SRbuttons.add(recover);

        return SRbuttons;
    }

    public List<Button> createDiffButtons(Game game) {

        Map<String, ConfigReader> difficulties = game.getDifficulties();

        List<Button> buttons = new ArrayList<>();
        double posY = 130;
        double posX = 10;

        for (Map.Entry<String, ConfigReader> set :
                difficulties.entrySet()) {

            Button button = new Button();

            button.setText(set.getKey());
            button.setTranslateX(posX);
            button.setTranslateY(posY);

            EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    game.setCurrDifficulty(set.getKey());
                    game.setChanged(true);
                }
            };

            button.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);

            buttons.add(button);
            posY += 30;

        }

        return buttons;
    }

    public void registerCheatingKeys(Game game) {

        Group root = game.getRoot();
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
                if(key.getCode() == KeyCode.DIGIT1) {
                    //System.out.println("1 is pressed!");
                    removeBalls(game, "red");
                }
                if(key.getCode() == KeyCode.DIGIT2) {
                    //System.out.println("2 is pressed!");
                    removeBalls(game, "yellow");
                }
                if(key.getCode() == KeyCode.DIGIT3) {
                    //System.out.println("3 is pressed!");
                    removeBalls(game, "green");
                }
                if(key.getCode() == KeyCode.DIGIT4) {
                    //System.out.println("4 is pressed!");
                    removeBalls(game, "brown");
                }
                if(key.getCode() == KeyCode.DIGIT5) {
                    //System.out.println("5 is pressed!");
                    removeBalls(game, "blue");
                }
                if(key.getCode() == KeyCode.DIGIT6) {
                    //System.out.println("6 is pressed!");
                    removeBalls(game, "purple");
                }
                if(key.getCode() == KeyCode.DIGIT7) {
                    //System.out.println("7 is pressed!");
                    removeBalls(game, "black");
                }
                if(key.getCode() == KeyCode.DIGIT8) {
                    //System.out.println("8 is pressed!");
                    removeBalls(game, "orange");
                }
                if(key.getCode() == KeyCode.W) {
                    //System.out.println("8 is pressed!");
                    if(game.getPoolTable().hasWon())
                        System.out.println("win");
                    else
                        System.out.println("not yet");
                }

            }
        });
    }

    public void removeBalls(Game game, String colour) {
        List<Ball> balls = game.getPoolTable().getBalls();
        Color color = Color.valueOf(colour);

        for (Ball ball : balls) {
            if (ball.getColour().equals(color)) {
                ball.disable();
                ball.alert();
            }
        }
    }
}
