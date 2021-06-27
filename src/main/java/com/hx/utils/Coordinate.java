package com.hx.utils;

import org.apache.commons.lang3.tuple.MutablePair;

import java.util.Objects;

/*
 注意Coordinate采用的是像素点，与SnakeConf里的B_WIDTH和B_HEIGHT相对应
 */
public class Coordinate {
    private final MutablePair<Integer, Integer> pair = new MutablePair<>();

    public Coordinate(int x, int y) {
        pair.setLeft(x);
        pair.setValue(y);
    }

    public int getX() {
        return pair.getLeft();
    }

    public int getY() {
        return pair.getRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(pair, that.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pair);
    }
}
