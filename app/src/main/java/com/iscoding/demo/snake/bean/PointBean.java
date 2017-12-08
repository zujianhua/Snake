package com.iscoding.demo.snake.bean;

/**
 * Created by ic on 2017/12/7.
 */

public class PointBean {
    private int x;
    private int y;

    public PointBean(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PointBean{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
