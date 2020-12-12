package com.pozharsky.dmitri.validator;

public class CubeInitialDataValidator {
    private static final String COORDINATE_PATTERN = "-?[\\d]+\\.[\\d]+ -?[\\d]+\\.[\\d]+ -?[\\d]+\\.[\\d]+";
    private static final int AMOUNT_POINT = 8;

    public boolean isCorrectAmountPoint(String[] points) {
        return points.length == AMOUNT_POINT;
    }

    public boolean isCorrectCoordinate(String[] points) {
        for (String point : points) {
            if (!point.matches(COORDINATE_PATTERN)) {
                return false;
            }
        }
        return true;
    }
}
