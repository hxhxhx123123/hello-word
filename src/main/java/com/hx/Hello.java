package com.hx;

import org.apache.commons.lang3.StringUtils;

public class Hello {
    public static void main(String[] args) {
        System.out.println(StringUtils.lowerCase("Hello World"));
        Snake snake = new Snake();
        snake.move();

    }
}
