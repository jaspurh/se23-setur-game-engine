package com.setur.se23.engine.Collision;

import com.setur.se23.engine.core.Entity;
import com.setur.se23.engine.render.BufferItem;
import com.setur.se23.engine.render.Renderer;
import com.setur.se23.engine.render.common.Material;

public abstract class Collider {

    protected Material material;
    protected Entity attachedEntity;

    public Collider(Material material, Entity attachedEntity) {
        this.material = material;
        this.attachedEntity = attachedEntity;

        BufferItem bufferItem = new BufferItem(material, 0, 0, 0, 1, 1);

        Renderer.getInstance().allocateTexture(bufferItem.material().texture());
    }

    public Material getMaterial() {
        return material;
    }

    public abstract double getX();

    public abstract double getY();

    public abstract void uniformScale(double scalingFactor);

    public abstract void RenderGizmo();
}
