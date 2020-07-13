package com.emreozgenc.spacesurfer.collisions;

public class CollisionRectangle {
    public float posX;
    public float posY;
    public int width;
    public int height;

    public CollisionRectangle(float posX, float posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
    }

    public void update(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public boolean isCollide(CollisionRectangle col) {
        return (posX < col.posX + col.width) &&
                (posY < col.posY + col.height) &&
                (posX + width > col.posX) &&
                (posY + height > col.posY);
    }
}
