import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class Game extends Application {
    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Shooting Game");

        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        Canvas canvas = new javafx.scene.canvas.Canvas(1280, 720);
        GraphicsContext context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        Player player = new Player();
        Enemy enemy = new Enemy();
        player.setImage("player.png");
        enemy.setImage("player.png");
        player.getPosition().setVector(100, 300);

        enemy.getPosition().setVector(800, 300);

        List<Bullet> bullets = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(enemy);

        AnimationTimer game = new AnimationTimer() {
            @Override
            public void handle(long l) {
                mainScene.setOnKeyPressed(
                        event -> {
                            if (event.getCode().toString().equals("LEFT")) {
                                player.changeRotation(-5);
                            }
                            if (event.getCode().toString().equals("RIGHT")) {
                                player.changeRotation(5);
                            }
                            if (event.getCode().toString().equals("UP")) {
                                player.updateVelocity(400);
                            }
                            if (event.getCode().toString().equals("DOWN")) {
                                player.updateVelocity(-200);
                            }
                            if (event.getCode().toString().equals("SPACE")) {
                                Bullet bullet = new Bullet();
                                bullet.setImage("/bullet.png");
                                bullet.setPosition(player.getPosition());
                                bullet.changeRotation(player.getRotation());
                                bullets.add(bullet);
                            }
                            player.update(1 / 60.0);

                        }
                );
                mainScene.setOnKeyReleased(
                        event -> {
                            if (event.getCode().toString().equals("UP")) {
                                player.updateVelocity(0);
                            }
                            if (event.getCode().toString().equals("DOWN")) {
                                player.updateVelocity(0);
                            }
                            player.update(1 / 60.0);
                        }
                );
                context.setFill(Color.WHITE);
                context.fillRect(0, 0, 1280, 720);

                bullets.removeIf(bullet -> bullet.timeToLive >= 1);

                for (var bullet: bullets){
                    bullet.updateVelocity(800);
                    bullet.update(1 / 60.0);
                    bullet.render(context);
                }

                for (var bullet : bullets) {
                    for (var enemy: enemies){
                        if (enemy.collide(bullet)){
                            enemies.remove(enemy);
                            bullets.remove(bullet);
                        }
                    }
                }

                for (var enemy : enemies) {
                    enemy.updateVelocity(100);
                    enemy.update(1 / 60.0);
                    enemy.render(context);
                }


                player.render(context);
            }
        };
        game.start();

        stage.show();
    }
}
