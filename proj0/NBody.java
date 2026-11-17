public class NBody {
    /**
     * Given a file name, it should return a double corresponding to the radius of the universe in that file.
     * @param filename
     * @return
     */
    public static double readRadius(String filename) {
        In in = new In(filename);
		in.readInt();
		return in.readDouble();
    }

    /**
     * Given a file name, it should return an array of Planets corresponding to the planets in the file.
     * @param filename
     * @return
     */
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int numOfPlanets = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[numOfPlanets];
        for (int i = 0;i < numOfPlanets;i++) {
            planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }

    /**
     * NBody Simulation
     * @param args
     */
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        for (double time = 0;time < T;time += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p: planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        System.out.println(planets.length);
        System.out.printf("%.2e\n", radius);
        for (Planet p: planets) {
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName
            );
        }
    }
}
