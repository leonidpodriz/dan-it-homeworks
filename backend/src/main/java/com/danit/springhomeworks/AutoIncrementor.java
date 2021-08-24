package com.danit.springhomeworks;

public class AutoIncrementor {
    long current;

    public AutoIncrementor(long current) {
        this.current = current;
    }

    public AutoIncrementor() {
        this(0);
    }

    public long next() {
        return ++current;
    }
}
