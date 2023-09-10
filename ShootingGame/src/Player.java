import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player {
    protected Coordinate position;
    protected Coordinate velocity;
    protected double rotation;
    protected Image image;
    protected Shape boundary;

    public Player() {
        this.position = new Coordinate();
        this.velocity = new Coordinate();
        this.rotation = 0;
        this.boundary = new Shape();
    }

    public void update(double time) {
        this.stop(1280, 720);
        this.position.add(this.velocity.getX() * time, this.velocity.getY() * time);
    }

    public void render(GraphicsContext context) {
        context.save();
        context.translate(this.position.getX(), this.position.getY());
        context.rotate(this.rotation);
        context.translate(-this.image.getWidth()/2,-this.image.getHeight()/2);
        context.drawImage(this.image,0,0);

        context.restore();
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }


    public void updateVelocity(double v) {
        this.velocity.setSpeed(v);
        this.velocity.updatePosition(this.rotation,v);
    }

    public double getRotation() {
        return rotation;
    }

    public void changeRotation(double rotation) {
        this.rotation += rotation;
    }

    public void setImage(String path) {
        this.image = new Image(path);
        this.boundary.setSize(this.image.getWidth(), this.image.getHeight());
    }

    public void updateBoundary(){
        this.boundary.setPosition(this.position.getX(), this.position.getY());
    }

    public Shape getBoundary(){
        this.updateBoundary();
        return this.boundary;
    }

    public boolean collide(Player player){
        return this.getBoundary().collide(player.getBoundary());
    }

    public void stop(double screenW, double screenH){
        if(this.position.getX()<=this.image.getWidth()/2){
            this.position.setX(this.image.getWidth()/2);
        }
        if(this.position.getY()<=this.image.getHeight()/2){
            this.position.setY(this.image.getHeight()/2);
        }
        if(this.position.getX()>=screenW-this.image.getWidth()/2){
            this.position.setX(screenW-this.image.getWidth()/2);
        }
        if(this.position.getY()>=screenH-this.image.getHeight()/2){
            this.position.setY(screenH-this.image.getHeight()/2);
        }
    }

}
