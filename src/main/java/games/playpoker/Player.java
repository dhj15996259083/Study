package games.playpoker;

import java.util.*;

public class Player {
    private List<String> cards = new ArrayList<>();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void showCards() {
        Collections.sort(cards, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String n1 = o1.length() == 2 ? o1 : o1.substring(2);
                String n2 = o2.length() == 2 ? o2 : o2.substring(2);
                return n1.compareTo(n2);
            }
        });
        System.out.println(this.name + ":");
        for (String card : cards) {
            System.out.print(card + '、');
        }
        System.out.println();
    }

    public void add(String card) {
        cards.add(card);
    }
}
