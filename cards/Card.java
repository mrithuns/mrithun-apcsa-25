package cards;

public class Card {
    private int suit;
    private int value;
    private static String[]SUITS = {"♥", "♠", "♣", "♦"};
    private static String[]VALUE = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
    public Card(int su, int val) {
        suit = su;
        value = val;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return VALUE[value] + SUITS[suit];
    }

}
