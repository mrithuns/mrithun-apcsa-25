/*
 This question involves the Hand class which models the set of cards in a player’s hand. You will
write the complete Hand class, which contains the constructor and four methods.
The Hand constructor takes one integer parameter. The parameter specifies the maximum
number of cards the Hand can store.
The add method has one Card parameter for the Card to add to the Hand.
The length method has no parameters and returns the number of cards currently stored in the
Hand.
The get method returns the card with the specified index. This method does not otherwise
modify the Hand.
- Inputs must be from zero to less than length.
The remove method removes the card with the specified index from the Hand and returns the
removed card.

- The length shall be reduced by one.
- Any cards with a greater index shall be shifted to fill in the gap.
The toString method returns a string representation of the cards in the Hand.
 */
package cards;
import java.util.
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
