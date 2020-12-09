package com.pozharsky.dmitri.parser;

import com.pozharsky.dmitri.validator.CubeInitialDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CubeParser {
    private static final Logger logger = LogManager.getLogger(CubeParser.class);
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_SPACE = " ";

    public List<List<Double>> parse(List<String> lines, CubeInitialDataValidator validator) {
        List<List<Double>> lists = new ArrayList<>();
        for (String line : lines) {
            String[] points = line.split(DELIMITER_COMMA);
            if (validator.validate(points)) {
                List<Double> coordinats = Arrays.stream(points)
                        .flatMap(e -> Stream.of(e.trim().split(DELIMITER_SPACE)))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());
                lists.add(coordinats);
            } else {
                logger.info("Incorrect line: " + line);
            }
        }
        return lists;
    }
}
