package com.hx.utils;

/*
 贪食蛇全局配置类
 */
public class SnakeConf {
    // 游戏窗口的最大宽度，单位：屏幕像素
    public static final int B_WIDTH = 300;
    // 游戏窗口的最大高度
    public static final int B_HEIGHT = 300;
    // 贪食蛇一节身体，所占的像素
    public static final int SNAKE_UNIT_SIZE = 10;
    // 贪食蛇的速度，单位：毫秒，每隔这段时间，画面重绘，贪食蛇前进一步。数字越小，贪食蛇速度越快
    public static final int SNAKE_DELAY = 70;
    // 贪食蛇初始时的长度
    public static final int SNAKE_INIT_LENGTH = 5;
    // 贪食蛇左右或者上下的最大长度，因为目前窗口是正方形，左右和上下都一样
    public static final int LINE_DOTS = B_WIDTH / SNAKE_UNIT_SIZE;
}
