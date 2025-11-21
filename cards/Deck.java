package cards;
public class Deck {
    private Card[] cards;
    private int top;

    public Deck() {
        cards = new Card[52];
        top = 0;
        int index = 0;

        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                cards[index] = new Card(suit, value);
                index++;
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int randIndex = (int)(Math.random() * cards.length);
            Card temp = cards[i];
            cards[i] = cards[randIndex];
            cards[randIndex] = temp;
        }
        top = 0; 
    }

    public Card draw() {
        if (top >= cards.length) {
            throw new IllegalStateException("Deck is empty — no more cards to draw.");
        }
        return cards[top++]; 
    }

   
    public int size() {
        return cards.length - top;
    }
}
