public class Shape {
    double x;
    double y;
    double width;
    double height;

    public Shape() {
        this.setPosition(0, 0);
        this.setSize(1, 1);
    }

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Shape(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setSize(double w, double h) {
        this.width = w;
        this.height = h;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean collide(Shape shape) {
        return ((this.x + this.width/2 >= shape.x-shape.width/2&&this.x + this.width/2 <= shape.x+shape.width/2)
                || (shape.x + shape.width/2 >= this.x - this.width/2&&shape.x + shape.width/2 <= this.x + this.width/2))
                &&( (this.y + this.height/2 >= shape.y-shape.height/2 &&this.y + this.height/2 <= shape.y+shape.height/2)
                || (shape.y + shape.height/2 >= this.y - this.height/2&&shape.y + shape.height/2 <= this.y + this.height/2));
    }

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
