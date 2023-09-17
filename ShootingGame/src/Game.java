import java.util.List;
import java.util.Vector;

public class Game {
    Coordinate playerPosition;
    List<Coordinate> enemyPositions;

    @Override
    public String toString() {
        return "Game{" +
                "playerPosition=" + playerPosition +
                ", enemyPositions=" + enemyPositions +
                '}';
    }
}
