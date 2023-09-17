public class Coordinate {
    private double x;
    private double y;

    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void multi(double t) {
        this.x *= t;
        this.y *= t;
    }

    public double getSpeed() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    public void setSpeed(double s) {
        double currentDist = this.getSpeed();
        if (currentDist == 0) {
            this.setVector(s,0);
        } else {
            this.multi(s / currentDist);
        }
    }

    public void updatePosition(double degrees, double direction) {
        double radians = Math.toRadians(degrees);
        if(direction>0){
            this.x = this.getSpeed()*Math.cos(radians);
            this.y = this.getSpeed()*Math.sin(radians);
        }else {
            this.x = (-1)*this.getSpeed()*Math.cos(radians);
            this.y = (-1)*this.getSpeed()*Math.sin(radians);
        }

    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
