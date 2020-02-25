package com.joeso.designpattern_mvp;

public class MyModel implements Imodel {
    @Override
    public int getNumber() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return (int)Math.round(Math.random()*10000);
        }
    }
}
