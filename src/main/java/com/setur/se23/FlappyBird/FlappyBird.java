package com.setur.se23.FlappyBird;

import java.util.ArrayList;

import com.setur.se23.FlappyBird.Flappy_Bird_Objects.Background;
import com.setur.se23.FlappyBird.Flappy_Bird_Objects.Bird;
import com.setur.se23.FlappyBird.Flappy_Bird_Objects.Ground;
import com.setur.se23.FlappyBird.Flappy_Bird_Objects.Pipe;
import com.setur.se23.engine.core.Core;
import com.setur.se23.engine.core.Entity;
import com.setur.se23.engine.input.FX_input;
import com.setur.se23.engine.input.InputType;
import com.setur.se23.engine.loop.Loop;

import javafx.scene.input.KeyCode;

public class FlappyBird {

    public Loop gameLoop = new Loop();

    public FlappyBird() {
        sendGameObjects();
    }

    private void sendGameObjects() {
        Pipe.started = false;

        gameLoop.sendScene(createFlappyBirdObjects(), getRunnables());
    }

    private ArrayList<Entity> createFlappyBirdObjects() {

        // entities are rendered in list order
        // i.e. last in list is rendered over the others

        ArrayList<Entity> entities = new ArrayList<Entity>();
        
        entities.add(new Background());

        addPipes(entities, 4);

        entities.add(new Ground());
        
        Bird player = new Bird(200, 300);

        createInputs(player);

        entities.add(player);

        return entities;
    }

    private void addPipes(ArrayList<Entity> entities, int pairAmount) {

        int spacing = 500;

        double random = Core.randomDouble(1, 8);

        for (int i = 0; i < pairAmount; i++) {

            entities.add(new Pipe(true,  spacing,  (random * 50 - 500)));
            entities.add(new Pipe(false, spacing,  (random * 50 + 250)));

            spacing += 300;
            random = Core.randomDouble(1, 8);
        }
    }

    private void createInputs(Bird player) {

        GameEvents gameEvents = new GameEvents(player, () -> sendGameObjects());

        FX_input inputSystem = new FX_input(gameEvents);

        //on key press
        inputSystem.addInput(InputType.onPress, KeyCode.SPACE, "Jump");
        inputSystem.addInput(InputType.onPress, KeyCode.UP, "Jump");
        inputSystem.addInput(InputType.onPress, KeyCode.P, "toggle_FPS_Counter");
        inputSystem.addInput(InputType.onPress, KeyCode.O, "toggle_Gizmos");
        inputSystem.addInput(InputType.onPress, KeyCode.R, "Restart");

        //on key release
        inputSystem.addInput(InputType.onRelease, KeyCode.SPACE, "Jump_Ready");
        inputSystem.addInput(InputType.onRelease, KeyCode.UP, "Jump_Ready");

        inputSystem.setInputs();
    }

    private ArrayList<Runnable> getRunnables() {
        ArrayList<Runnable> runnables = new ArrayList<Runnable>();

        runnables.add(() -> Pipe.loopAroundPipes());

        return runnables;
    }
}
