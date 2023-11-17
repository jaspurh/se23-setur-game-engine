package com.setur.se23;

import com.setur.se23.dependency.render.canvas.CanvasRenderer;
import com.setur.se23.engine.loop.FX_FrameUpdate;
import com.setur.se23.engine.render.Renderer;
import com.setur.se23.engine.render.common.ViewPort;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        Globals.mainStage = stage;

        Globals.mainStage.setWidth(800.0f);
        Globals.mainStage.setHeight(800.0f);
        Globals.mainStage.setTitle("Game Engine Boilerplate!");

        initializeRenderer(Globals.mainStage);
        FX_FrameUpdate frameUpdate = new FX_FrameUpdate();
        frameUpdate.start();
    }


    private void initializeRenderer(Stage stage) {
        var canvasRenderer = new CanvasRenderer(stage);

        Renderer.Instantiate(canvasRenderer)
                .initialize(new ViewPort(stage.getWidth(), stage.getHeight()));
    }
}