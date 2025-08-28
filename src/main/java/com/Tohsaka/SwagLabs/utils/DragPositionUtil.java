package com.Tohsaka.SwagLabs.utils;

public class DragPositionUtil {
    private int costumX = 0;
    private int costumY = 0;

    public DragPositionUtil(int costumX, int costumY) {
        this.costumX = costumX;
        this.costumY = costumY;
    }

    public int getCostumX() {
        return costumX;
    }

    public void setCostumX(int costumX) {
        this.costumX = costumX;
    }

    public int getCostumY() {
        return costumY;
    }

    public void setCostumY(int costumY) {
        this.costumY = costumY;
    }
}
