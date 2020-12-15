package com.pozharsky.dmitri.parser;

import com.pozharsky.dmitri.validator.CubeInitialDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CubeInitialDataParser {
    private static final Logger logger = LogManager.getLogger(CubeInitialDataParser.class);
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_SPACE = " ";

    public List<List<Double>> parse(List<String> cubeData) {
        CubeInitialDataValidator validator = new CubeInitialDataValidator();
        List<List<Double>> listPointCoordinates = new ArrayList<>();
        for (String line : cubeData) {
            String[] points = line.split(DELIMITER_COMMA);
            if (!validator.isCorrectAmountPoint(points)) {
                logger.info("Incorrect amount of point. Should be 8 point. Line: " + line);
                continue;
            }
            if (!validator.isCorrectCoordinate(points)) {
                logger.info("Incorrect coordinate of point. Line: " + line);
                continue;
            }
            List<Double> pointCoordinates = Arrays.stream(points)
                    .flatMap(o->Arrays.stream(o.trim().split(DELIMITER_SPACE)))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            listPointCoordinates.add(pointCoordinates);
        }
        return listPointCoordinates;
    }
}
