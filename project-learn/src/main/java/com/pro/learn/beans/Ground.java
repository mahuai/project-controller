package com.pro.learn.beans;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.beans
 * @date: Created in 2018/9/27  14:06
 */
public class Ground {

    private boolean garbage;

    public Ground(boolean garbage) {
        this.garbage = garbage;
    }

    public boolean isGarbage() {
        return garbage;
    }

    public void setGarbage(boolean garbage) {
        this.garbage = garbage;
    }
}
