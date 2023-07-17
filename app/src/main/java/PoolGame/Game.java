package PoolGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import PoolGame.Builder.BallBuilderDirector;
import PoolGame.Config.BallConfig;
import PoolGame.Config.PocketConfig;
import PoolGame.Items.Ball;
import PoolGame.Items.Pocket;
import PoolGame.Items.PoolTable;
import PoolGame.Memento.Caretaker;
import PoolGame.Memento.Memento;
import PoolGame.Observer.Clock;
import PoolGame.Observer.ClockObserver;
import PoolGame.Observer.Observer;
import PoolGame.Observer.Score;
import PoolGame.Prototype.PocketPrototypeFactory;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/** The game class that runs the game */
public class Game {
    private PoolTable table;
    private boolean shownWonText = false;
    private final Text winText = new Text(50, 50, "Win and Bye");
    private Map<String, ConfigReader> difficulties;
    private String currDifficulty;
    private boolean changed;
    private Group root;
    private double fps;
    private final ButtonsCreation buttonsCreation = new ButtonsCreation();
    private final Text time = new Text(10, 90, "00:00");
    private final Clock clock = new Clock();
    private final Observer clockObserver = new ClockObserver(clock, time);
    private final Text scoreText =  new Text(10, 115, "Score: 0");
    private final Score score = new Score(scoreText);
    private final Caretaker caretaker = new Caretaker();
    /**
     * Initialise the game with the provided config
     * @param configs The config parser to load the config from
     */
    public Game(Map<String, ConfigReader> configs, double fps) {
        this.difficulties = configs;
        this.fps = fps;
        this.clock.attach(clockObserver);
        this.clock.setFPS(fps);

        this.setup(configs.get("easy"));
    }

    private void setup(ConfigReader config) {
        this.table = new PoolTable(config.getConfig().getTableConfig());

        List<BallConfig> ballsConf = config.getConfig().getBallsConfig().getBallConfigs();
        List<Ball> balls = new ArrayList<>();
        BallBuilderDirector builder = new BallBuilderDirector();
        builder.registerDefault();
        for (BallConfig ballConf: ballsConf) {
            Ball ball = builder.construct(ballConf);
            if (ball == null) {
                System.err.println("WARNING: Unknown ball, skipping...");
            } else {
                balls.add(ball);
            }
        }

        List<PocketConfig> pocketsConf = config.getConfig().getPocketsConfig().getPocketConfigs();
        List<Pocket> pockets = new ArrayList<>();

        PocketPrototypeFactory pocketFactory = new PocketPrototypeFactory();
        pocketFactory.setDefault(pocketsConf.get(0));
        for (PocketConfig pocketConf : pocketsConf) {
            Pocket pocket = pocketFactory.create(pocketConf);
            pockets.add(pocket);
        }

        this.score.setPoints(0);
        this.table.setupBalls(balls, score);
        this.table.setupPockets(pockets);

        this.winText.setVisible(false);
        this.winText.setX(table.getDimX() / 2);
        this.winText.setY(table.getDimY() / 2);

        this.time.setFont(Font.font(15));
        this.scoreText.setFont(Font.font(15));

        clock.reset();
    }

    /**
     * Get the window dimension in the x-axis
     * @return The x-axis size of the window dimension
     */
    public double getWindowDimX() {
        return this.table.getDimX();
    }

    /**
     * Get the window dimension in the y-axis
     * @return The y-axis size of the window dimension
     */
    public double getWindowDimY() {
        return this.table.getDimY();
    }

    /**
     * Get the pool table associated with the game
     * @return The pool table instance of the game
     */
    public PoolTable getPoolTable() {
        return this.table;
    }

    public Caretaker getCaretaker () {return this.caretaker;}
    public Text getWinText() {return this.winText;}
    public Group getRoot() {return this.root;}
    public Map<String,ConfigReader> getDifficulties() {
        return this.difficulties;}

    public void setCurrDifficulty(String currDifficulty) {
        this.currDifficulty = currDifficulty;}

    public void setChanged(boolean changed) {this.changed = changed;}

    /** Add all drawable object to the JavaFX group
     * @param root The JavaFX `Group` instance
     */
    public void addDrawables(Group root) {
        this.root = root;

        ObservableList<Node> groupChildren = root.getChildren();
        table.addToGroup(groupChildren);

        List<Button> buttons =
                buttonsCreation.createDiffButtons(this);
        for (Button button : buttons) {
            root.getChildren().add(button);
        }

        List<Button> SRbuttons =
                buttonsCreation.createSaveRecoverButton(this);
        for (Button button : SRbuttons) {
            root.getChildren().add(button);
        }

        groupChildren.add(this.winText);
        groupChildren.add(this.time);
        groupChildren.add(this.scoreText);
        this.winText.setVisible(false);
        this.shownWonText = false;

        buttonsCreation.registerCheatingKeys(this);
    }

    public void removeWinText() {

        root.getChildren().remove(this.winText);
        root.getChildren().remove(this.time);
        root.getChildren().remove(this.scoreText);
    }

    /** Reset the game */
    public void reset() {
        this.winText.setVisible(false);
        this.shownWonText = false;
        this.table.reset();
        this.score.setPoints(0);
    }

    /** Code to execute every tick. */
    public void tick() {

        clock.incrementFrame();
        if (clock.isChanged()) {
            clock.alert();
            clock.setChanged(false);
        }

        if (changed) {
            changed = false;
            setup(difficulties.get(currDifficulty));
            removeWinText();
            addDrawables(root);
            caretaker.reset();
        }
        if (table.hasWon() && !this.shownWonText) {
            System.out.println(this.winText.getText());
            this.winText.setVisible(true);
            this.shownWonText = true;
        }
        table.checkPocket(this);
        table.handleCollision();
        this.table.applyFrictionToBalls();
        for (Ball ball : this.table.getBalls()) {
            ball.move();
        }
    }


}
