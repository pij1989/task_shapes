package com.pozharsky.dmitri.generator;

public class CubeIdGenerator {
    private static long count = 1;

    private CubeIdGenerator() {}

    public static long generate() {
        return count++;
    }
}
