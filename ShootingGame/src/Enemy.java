public class Enemy extends Player{

    @Override
    public void update(double time) {
        this.stop(1280, 720);
        this.changeDirection(1280, 720);
        this.position.add(this.velocity.getX() * time, this.velocity.getY() * time);
    }

    public void changeDirection(double screenW, double screenH) {
        if (this.position.getX() <= this.image.getWidth() / 2
                || this.position.getY() <= this.image.getHeight() / 2
                || this.position.getX() >= screenW - this.image.getWidth() / 2
                || this.position.getY() >= screenH - this.image.getHeight() / 2) {
            this.changeRotation(90 * Math.random());
        }
    }
}
