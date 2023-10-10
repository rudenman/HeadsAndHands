package game;

import org.entity.Monster;
import org.entity.Player;

public class Game {

    public static void main(String[] args) {
        Player player = new Player("Игрок",300, 5, 5, 3, 10);
        Monster monster1 = new Monster("Монстр1",30, 5, 0, 3, 5);
        player.hit(monster1);
        monster1.checkHealth();
        monster1.hit(player);
        player.checkHealth();

        player.hit(monster1);
        monster1.checkHealth();
        monster1.hit(player);
        player.checkHealth();

        player.hit(monster1);
        monster1.checkHealth();
        monster1.hit(player);
        player.checkHealth();

        player.hit(monster1);
        monster1.checkHealth();
        monster1.hit(player);
        player.checkHealth();
        player.heal();

        player.checkHealth();
    }
}
