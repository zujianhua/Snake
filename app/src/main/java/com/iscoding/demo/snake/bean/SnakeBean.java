package com.iscoding.demo.snake.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ic on 2017/12/7.
 */

public class SnakeBean {
    private List<PointBean> snake  = new ArrayList<>();
    public List<PointBean> getSnake() {
        return snake;
    }
    public void setSnake(List<PointBean> snake) {
        this.snake = snake;
    }
}
