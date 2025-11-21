package cards;
import java.util.Arrays;
public class Hand {
    private int max;
    private Card[] cards;
    int length=0;
    public Hand (int max)
    {
        this.max=max;
        cards=new Card[max];
    }
    public void add (Card c)
    {
        cards[length]=c;
        length++;
    } 
    public int length()
    {
        return length;
    }
    public Card get (int index)
    {
        return cards[index];

    }
    public Card remove (int index)
    {
        Card removedCard=cards[index];
        for (int i=index;i<length-1;i++)
        {
            cards[i]=cards[i+1];
        }
        cards[length-1]=null;
        length--;
        return removedCard;
    }
    public String toString()
    {
        String handString="";
        for (int i=0;i<length;i++)
        {
            handString+=cards[i].toString();
            if (i<length-1)
            {
                handString+=", ";   
            }
        }
        return handString;
    }
}