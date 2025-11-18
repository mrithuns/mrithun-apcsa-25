package cards;
/*
This question involves the Deck class which models a deck of 52 playing cards. You will write
the complete Deck class, which contains the constructor and four methods.
The Deck constructor takes no parameters. The constructor should create and store Card
objects with each possible suite and value (4 * 13 = 52).
The shuffle method randomizes the order of the deck.
The cut method has a single int parameter with a value from 0 to 51.
- Cards at positions from the top of the deck up to, but not including, the provided index
shall be moved to the end of the deck.
- The cut method may work only on a complete deck.
- The order of the cards will otherwise stay the same as before the cut method is called.
The draw method has no parameters. The method returns the card at the top of the deck.
- Subsequent calls to draw shall return subsequent cards.
- When the deck is empty draw shall return null.
The print method has one int parameter with a value from 0 to 51. Calling the print method
shall print out string representations of the number of cards from the top of the deck to the
provided string parameter.
- Output must be on one line.
- Each card shall be separated by whitespace.
 */
public class Deck {
    private Card[] cards;
    private int top;
    public Deck()
    {
        cards=new Card[52];
        top=0;
        int index=0;
        for (int suit=0;suit<4;suit++)
        {
            for (int value=0;value<13;value++)
            {
                cards[index]=new Card(suit,value);
                index++;
            }
        }
    }
    public void shuffle()
    {
        for (int i=0;i<cards.length;i++)
        {
            int randIndex=(int)(Math.random()*cards.length);
            Card temp=cards[i];
            cards[i]=cards[randIndex];
            cards[randIndex]=temp;  

        }
    }
