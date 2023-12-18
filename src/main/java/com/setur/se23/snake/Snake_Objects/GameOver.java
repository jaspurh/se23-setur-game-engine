package com.setur.se23.snake.Snake_Objects;

import com.setur.se23.engine.core.Entity;
import com.setur.se23.engine.core.Resource;
import com.setur.se23.engine.render.common.Texture2D;
import com.setur.se23.snake.SnakeGlobals;

/**
 * The game over screen, shown when Snake collides with itself.
 */
public class GameOver extends Entity{

    private static final double PIXEL_SIZE = SnakeGlobals.PIXEL_SIZE;  // Default 1.

    /**
     * Constructor.
     */
    public GameOver() {
        super(new Texture2D(Resource.getSprite("gameover.png"), 192, 42), 
              300*PIXEL_SIZE, //scaling according to Screen size.
              384*PIXEL_SIZE,
              0, 
              1*PIXEL_SIZE, 
              1*PIXEL_SIZE);
    }  
    
}
