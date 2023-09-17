import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameLoader {
    public static Game loadGame(String filename) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(filename);
        Game game = gson.fromJson(reader, Game.class);
        System.out.println(game);
        return game;
    }
    public static void saveGame(String filename, Game game) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(game);
        System.out.println(json);
        FileWriter writer = new FileWriter(filename);
        writer.write(json);
        writer.close();
    }
}
