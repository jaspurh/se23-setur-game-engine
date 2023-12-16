package com.setur.se23.engine.render;

import com.setur.se23.engine.render.common.Texture2D;
import com.setur.se23.engine.render.common.ViewPort;

public class RendererPipelineStub implements RenderPipelineInterface {

    @Override
    public void initialize(ViewPort viewport) {

    }

    @Override
    public void allocateTexture(Texture2D texture) {

    }

    @Override
    public void swapBuffers() {

    }

    @Override
    public void render(Texture2D texture, double x, double y, double angle, double scaleX, double scaleY) {

    }
}
