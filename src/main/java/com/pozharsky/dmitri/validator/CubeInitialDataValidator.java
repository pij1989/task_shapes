package com.pozharsky.dmitri.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class CubeInitialDataValidator {
    private static final Logger logger = LogManager.getLogger(CubeInitialDataValidator.class);
    private static final String COORDINAT_REG = "([\\d]+\\.[\\d]+ [\\d]+\\.[\\d]+ [\\d]+\\.[\\d]+)";

    public boolean validate(String[] points) {
        if (points.length < 8) {
            logger.info("Not enough point with coordinat to create an object of cube. Should be 8 point");
            return false;
        }
        Pattern pattern = Pattern.compile(COORDINAT_REG);
        for (String point : points) {
            if (!pattern.matcher(point).matches()) {
                logger.info("Incorrect coordinat");
                return false;
            }
        }
        return true;
    }
}
