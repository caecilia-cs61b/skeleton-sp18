public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    final static double g = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName; // Strings are immutable, so you can copy them just coping the reference to them.
    }

    /**
     * Calculates the distance between two Planets.
     * @param targetPlanet
     * @return The distance between a supplied and the planet that is doing the calculation
     */
    public double calcDistance(Planet targetPlanet) {
        double xxDist = targetPlanet.xxPos - this.xxPos;
        double yyDist = targetPlanet.yyPos - this.yyPos;
        return Math.sqrt((xxDist * xxDist) + (yyDist * yyDist));
    }

    /**
     * Calculates the force exerted on this planet by the given planet.
     * @param targetPlanet
     * @return The force exerted on this planet by the given planet
     */
    public double calcForceExertedBy(Planet targetPlanet) {
        double distance = this.calcDistance(targetPlanet);
        return g * this.mass * targetPlanet.mass / (distance * distance);
    }

    /**
     * Calculates the force exerted on this planet by the given planet in X direction.
     * @param targetPlanet
     * @return The force exerted on this planet by the given planet in X direction
     */
    public double calcForceExertedByX(Planet targetPlanet) {
        double xxDist = targetPlanet.xxPos - this.xxPos;
        double rrDist = calcDistance(targetPlanet);
        double unsignedForce = calcForceExertedBy(targetPlanet);
        return unsignedForce * xxDist / rrDist;
    }

    /**
     * Calculates the force exerted on this planet by the given planet in Y direction.
     * @param targetPlanet
     * @return The force exerted on this planet by the given planet in Y direction
     */
    public double calcForceExertedByY(Planet targetPlanet) {
        double yyDist = targetPlanet.yyPos - this.yyPos;
        double rrDist = calcDistance(targetPlanet);
        double unsignedForce = calcForceExertedBy(targetPlanet);
        return unsignedForce * yyDist / rrDist;
    }

    /**
     * Calculate the net X force exerted by an array of Planets upon the current Planet.
     * @param planets An array of Planets
     * @return The net X force exerted by all planets in that array upon the current Planet
     */
    public double calcNetForceExertedByX(Planet[] planets) {
        double xxNetForce = 0;
        for (Planet p: planets) {
            if (!p.equals(this)) {
                xxNetForce += calcForceExertedByX(p);
            }
        }
        return xxNetForce;
    }

    /**
     * Calculate the net Y force exerted by an array of Planets upon the current Planet.
     * @param planets An array of Planets
     * @return The net Y force exerted by all planets in that array upon the current Planet
     */
    public double calcNetForceExertedByY(Planet[] planets) {
        double yyNetForce = 0;
        for (Planet p: planets) {
            if (!p.equals(this)) {
                yyNetForce += calcForceExertedByY(p);
            }
        }
        return yyNetForce;
    }

    /**
     * Determines how much the forces exerted on the planet will cause that planet to accelerate, and the resulting change in the planet’s velocity and position in a small period of time dt.
     * @param dt a small period of time
     * @param fX the forces exerted on the planet in X direction
     * @param fY the forces exerted on the planet in Y direction
     */
    public void update(double dt, double fX, double fY) {
        double xxAcc = fX / this.mass;
        double yyAcc = fY / this.mass;
        this.xxVel += xxAcc * dt;
        this.yyVel += yyAcc * dt;
        this.xxPos += xxVel * dt;
        this.yyPos += yyVel * dt;
    }

    /**
     * Uses the StdDraw API to draw the Planet’s image at the Planet’s position.
     */
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
