package games.playpoker;

import java.util.ArrayList;
import java.util.List;

public class Poker {
    private static String[] specialCards = new String[]{"大王", "小王"};
    private static String[] types = new String[]{"红桃", "方片", "梅花", "黑桃"};
    private static String[] numbers = new String[]{" 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K"};
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
