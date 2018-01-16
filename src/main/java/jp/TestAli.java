package jp;

import java.util.*;

/**
 * Created by peng on 2018/1/12.
 */
public class TestAli {

    private static Poker poker;

    private static List<Gamer> gamers;

    public static void main(String[] args){
        init();
        sendCards();
        showCards();
    }

    private static void showCards() {
        for (Gamer gamer:gamers){
            System.out.println(gamer.toString());
        }
    }

    private static void sendCards() {
        Set<Card> cards = poker.offer();
        int gamerNum = gamers.size();
        Iterator<Card> iterator = cards.iterator();
        while (iterator.hasNext()){
            for (int i = 0; i < gamerNum; i++) {
                if (iterator.hasNext()){
                    gamers.get(i).receiveCard(iterator.next());
                }else {
                    return;
                }
            }
        }
    }

    private static void init() {
        poker = new Poker(13);
        gamers = new ArrayList<Gamer>(4);
        gamers.add(createGamer("gamer1"));
        gamers.add(createGamer("gamer2"));
        gamers.add(createGamer("gamer3"));
        gamers.add(createGamer("gamer4"));
    }

    private static Gamer createGamer(String name) {
        return new Gamer(name);
    }

    static class Gamer{
        private String name;
        private List<Card> cards = new ArrayList<Card>();

        public Gamer(String name){
            this.name = name;
        }

        public void receiveCard(Card card){
            cards.add(card);
        }

        @Override
        public String toString() {
            StringBuilder info = new StringBuilder(name).append(" cards:");
            for (Card card : cards){
                info.append(card);
            }
            return info.toString();
        }
    }

    static class Poker{
        private Set<Card> cards;
        private int num;

        public Poker(int num){
            this.num = num;
            this.cards = new HashSet(num * 4);
            doInit();
        }

        private void doInit() {
            for (int i = 0; i < this.num; i++) {
                int currentNum = i + 1;
                this.cards.add(getCard(currentNum,Color.fangkuai));
                this.cards.add(getCard(currentNum,Color.hongtao));
                this.cards.add(getCard(currentNum,Color.heitao));
                this.cards.add(getCard(currentNum,Color.hua));
            }
        }

        private Card getCard(int num, Color color) {
            Card card = new Card();
            card.setColor(color);
            card.setNum(num);
            return card;
        }

        public Set<Card> offer(){
            return this.cards;
        }

    }

    static class Card{
        private int num;
        private Color color;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return new StringBuilder("(").append(color.toString()).append(",").append(num).append(")").toString();
        }
    }

    enum Color{
        fangkuai,hongtao,heitao,hua
    }
}
