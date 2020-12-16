package com.pozharsky.dmitri.comparator;

import com.pozharsky.dmitri.entity.impl.CubePoint;

import java.util.Comparator;

public enum CubePointComparator implements Comparator<CubePoint> {
    X {
        @Override
        public int compare(CubePoint o1, CubePoint o2) {
            return Double.compare(o1.getX(), o2.getX());
        }
    },
    Y {
        @Override
        public int compare(CubePoint o1, CubePoint o2) {
            return Double.compare(o1.getY(), o2.getY());
        }
    },
    Z {
        @Override
        public int compare(CubePoint o1, CubePoint o2) {
            return Double.compare(o1.getZ(), o2.getZ());
        }
    }
}
