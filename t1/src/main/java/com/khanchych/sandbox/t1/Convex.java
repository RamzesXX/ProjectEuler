package com.khanchych.sandbox.t1;

public class Convex {
    private static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public Point(Generator generator) {
            this.x = generator.next();
            this.y = generator.next();
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static class Generator {
        long seed;

        Generator(long seed) {
            this.seed = seed;
        }

        long next() {
            long oldSeed = seed;
            seed = oldSeed * oldSeed % 50515093L;

            return (-1000 + oldSeed % 2000);
        }
    }

    public static void main(String[] args) {
        System.out.println('a'+0);
    }
}
