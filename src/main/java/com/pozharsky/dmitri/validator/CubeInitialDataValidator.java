package com.pozharsky.dmitri.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeInitialDataValidator {
    private static final Logger logger = LogManager.getLogger(CubeInitialDataValidator.class);
    private static final String COORDINAT_PATTERN = "[\\d]+\\.[\\d]+ [\\d]+\\.[\\d]+ [\\d]+\\.[\\d]+";

    public boolean validate(String[] points) {
        if (points.length < 8) {
            logger.info("Not enough point with coordinat to create an object of cube. Should be 8 point");
            return false;
        }
        for (String point : points) {
            if (!point.matches(COORDINAT_PATTERN)) {
                logger.info("Incorrect coordinat");
                return false;
            }
        }
        return true;
    }
}
