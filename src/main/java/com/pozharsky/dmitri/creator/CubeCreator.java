package com.pozharsky.dmitri.creator;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.factory.impl.CubeFactory;
import com.pozharsky.dmitri.factory.impl.CubePointFactory;
import com.pozharsky.dmitri.generator.CubeIdGenerator;
import com.pozharsky.dmitri.parser.CubeInitialDataParser;
import com.pozharsky.dmitri.reader.CubeInitialDataReader;

import java.util.ArrayList;
import java.util.List;

public class CubeCreator {
    public List<Cube> createCubes(CubeFactory cubeFactory, CubePointFactory cubePointFactory, String file) {
        CubeInitialDataReader reader = new CubeInitialDataReader();
        CubeInitialDataParser parser = new CubeInitialDataParser();
        List<String> data = reader.readData(file);
        List<List<Double>> listPointCoordinates = parser.parse(data);
        List<Cube> cubes = new ArrayList<>();
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
        return cubes;
    }
}
