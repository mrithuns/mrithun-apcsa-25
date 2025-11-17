package cards;
import java.util.
public class Hand {
    private int max;
    private Card[] cards;
    int length=0;
    public Hand (int max)
    {
        this.max=max;
    }
    public void add (Card c)
    {
        cards[length]=c;
        length++;
    }
    

}
