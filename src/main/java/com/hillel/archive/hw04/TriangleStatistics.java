package com.hillel.archive.hw04;

public class TriangleStatistics {
    public void countEquilateral(Triangle[] triangles) {
        int count = 0;
        double maxPerimeter = 0;
        double maxArea = 0;

        for (Triangle triangle : triangles) {
            if (triangle.isEquilateral()) {
                count++;

                if (triangle.getPerimeter() > maxPerimeter) {
                    maxPerimeter = triangle.getPerimeter();
                }

                if (triangle.getArea() > maxArea) {
                    maxArea = triangle.getArea();
                }
            }
        }

        System.out.println("equilateral=" + count + ", maxPerimeter=" + maxPerimeter + ", maxArea=" + maxArea);
    }

    public void countIsosceles(Triangle[] triangles) {
        int count = 0;
        double maxPerimeter = 0;
        double maxArea = 0;

        for (Triangle triangle : triangles) {
            if (triangle.isIsosceles()) {
                count++;

                if (triangle.getPerimeter() > maxPerimeter) {
                    maxPerimeter = triangle.getPerimeter();
                }

                if (triangle.getArea() > maxArea) {
                    maxArea = triangle.getArea();
                }
            }
        }

        System.out.println("isosceles=" + count + ", maxPerimeter=" + maxPerimeter + ", maxArea=" + maxArea);
    }

    public void countRectangular(Triangle[] triangles) {
        int count = 0;
        double maxPerimeter = 0;
        double maxArea = 0;

        for (Triangle triangle : triangles) {
            if (triangle.isRectangular()) {
                count++;

                if (triangle.getPerimeter() > maxPerimeter) {
                    maxPerimeter = triangle.getPerimeter();
                }

                if (triangle.getArea() > maxArea) {
                    maxArea = triangle.getArea();
                }
            }
        }

        System.out.println("rectangular=" + count + ", maxPerimeter=" + maxPerimeter + ", maxArea=" + maxArea);
    }

    public void countRandom(Triangle[] triangles) {
        int count = 0;
        double maxPerimeter = 0;
        double maxArea = 0;

        for (Triangle triangle : triangles) {
            if (triangle.isEquilateral() || triangle.isIsosceles() || triangle.isRectangular()) {
                continue;
            } else {
                count++;

                if (triangle.getPerimeter() > maxPerimeter) {
                    maxPerimeter = triangle.getPerimeter();
                }

                if (triangle.getArea() > maxArea) {
                    maxArea = triangle.getArea();
                }
            }
        }

        System.out.println("random=" + count + ", maxPerimeter=" + maxPerimeter + ", maxArea=" + maxArea);
    }
}
