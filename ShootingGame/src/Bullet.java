public class Bullet extends Player{
    public double timeToLive;
    public Bullet(){
        super();
        timeToLive = 0;
    }

    @Override
    public void update(double time) {
        this.timeToLive += time;
        super.update(time);
    }
}
