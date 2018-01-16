package games.playpoker;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Sender sender;
    private List<Player> players;
    private List<String> cards;

    public Game(int playerNum, int pockerNum) {
        this.sender = new Sender();
        try {
            players = new ArrayList<>();
            Constructor<Player> constructor = Player.class.getConstructor(new Class[]{String.class});
            for (int i = 0; i < playerNum; i++) {
                players.add(constructor.newInstance("play" + (i + 1)));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        cards = Poker.getCards(pockerNum);
    }

    public void start() {
        sender.rank(cards);
        sender.send(players, cards);
        for (Player player : players) {
            player.showCards();
        }
    }

    public static void main(String[] args) {
        new Game(2, 1).start();
    }
}
