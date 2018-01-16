package games.playpoker;

import java.util.List;
import java.util.Random;

public class Sender {
    public List<String> rank(List<String> cards) {
        int i = cards.size();
        int j = 0;
        String temp = null;

        if (i == 0) {
            return cards;
        }

        while (--i != 0) {
            j = new Random().nextInt(10000) % (i + 1);
            temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
        return cards;
    }

    public void send(List<Player> players, List<String> cards) {
        for (int i = 0; i < cards.size(); i++) {
            players.get(i % players.size()).add(cards.get(i));
        }
    }
}
