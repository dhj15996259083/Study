package games.playpoker;

import java.util.ArrayList;
import java.util.List;

public class Poker {
    static final String[] specialCards = new String[]{"大王", "小王"};
    static final String[] types = new String[]{"♥️", "♦️", "♣️", "♠️"};
    static final String[] numbers = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A","2"};
    private static List<String> cards;

    static {
        cards = new ArrayList<>(60);
        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                cards.add(types[i] + numbers[j]);
            }
        }
        for (int i = 0; i < specialCards.length; i++) {
            cards.add(specialCards[i]);
        }
    }

    public static List<String> getCards(int num) {
        List<String> copyCards = new ArrayList<>(60 * num);

        for (int i = 0; i < num; i++) {
            copyCards.addAll(cards);
        }
        return copyCards;
    }
}
