package com.pozharsky.dmitri.creator;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.exception.ShapeException;
import com.pozharsky.dmitri.factory.impl.CubeFactory;
import com.pozharsky.dmitri.factory.impl.CubePointFactory;
import com.pozharsky.dmitri.generator.CubeIdGenerator;
import com.pozharsky.dmitri.parser.CubeInitialDataParser;
import com.pozharsky.dmitri.reader.CubeInitialDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CubeCreator {
    private static final Logger logger = LogManager.getLogger(CubeCreator.class);

    public List<Cube> createCubes(CubeFactory cubeFactory, CubePointFactory cubePointFactory, CubeInitialDataReader reader, String file) {
        CubeInitialDataParser parser = new CubeInitialDataParser();
        List<String> data = reader.readData(file);
        List<List<Double>> listPointCoordinates = parser.parse(data);
        List<Cube> cubes = new ArrayList<>();
        try {
            for (List<Double> pointCoordinates : listPointCoordinates) {
                List<CubePoint> cubePoints = new ArrayList<>();
                for (int i = 0; i < pointCoordinates.size() / 3; i++) {
                    double x = pointCoordinates.get(i * 3);
                    double y = pointCoordinates.get(i * 3 + 1);
                    double z = pointCoordinates.get(i * 3 + 2);
                    CubePoint cubePoint = cubePointFactory.createPoint(x, y, z);
                    cubePoints.add(cubePoint);
                }
                Cube cube = cubeFactory.createShape(CubeIdGenerator.generate(), cubePoints);
                cubes.add(cube);
            }
        } catch (ShapeException e) {
            logger.error(e);
        }
        return cubes;
    }
}
