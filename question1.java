//import java.util.Vector;
//import java.awt.*;
import java.util.*;

public class question1
{
	public static void main(String[] args)
	{
		int times = Integer.parseInt(args[0]);  // iteration times
		int num_deal = Integer.parseInt(args[1]); // number of players 
		float goodness = Float.parseFloat(args[2]);  // goodness

		for (int i=0;i<times;i++) 
		{
			Deck deck = new Deck();
	        deck.shuffle(goodness);
//	        deck.print();
			float num_stright = 0; 
			for (int j=0;j<num_deal;j++) // number of players
			{   
				System.out.println("Cards of player "+j);
				Card[] playeri = new Card[5];
				
				playeri = deck.dealOne(); // print 5 cards that this player has.
				for (int k = 0; k<5; k++) 
				{	
					System.out.println(playeri[k].print());
				}
//				int stright = hasStright(playeri);
				int stright = 1; 
				if (stright == 1) 
				{
					System.out.println("There's a stright! : ) ");
					num_stright++;
				}
				else {
					System.out.println("There's no stright. : ( ");
				}			
				
			}
			float possibility = num_stright/num_deal; 
			System.out.println("Possibility: "+possibility);
			deck.print();
	}
	
	
	
	
//	public static int hasStraight(int len, boolean sameSuit, Hand hand)
//	{
//		
//		int res = 1;
//		hand.sortBySuit();
//		if (sameSuit == true) 
//		{
//			for (int i=0;i<len;i++) 
//			{
//				int flag1 = 0;
//				if (hand.getCard(i).getSuit()==hand.getCard(i+1).getSuit()) 
//				{
//					flag1 = 1;
//					res = res*flag1;						
//				} 
//			}
//			return res;
//		}
//		else {
//			if (sameSuit==true) 
//			{
//				for (int i=0;i<len;i++)
//				{
//					int flag2 = 0;
//					if (hand.getCard(i).getValue()==(hand.getCard(i+1).getValue()-1)) 
//					flag2 = 1;
//					res = res*flag2;	
//				}
//			}
//			return res;
//		}
//		
//	}
//


}



	
public static class Card {

	public final static int SPADES = 0,       // Codes for the 4 suits.
							HEARTS = 1,
							DIAMONDS = 2,
							CLUBS = 3;
							
	public final static int ACE = 1,          // Codes for the non-numeric cards.
							JACK = 11,        //   Cards 2 through 10 have their 
							QUEEN = 12,       //   numerical values for their codes.
							KING = 13;
							
	private final int suit;   // The suit of this card, one of the constants
							  //    SPADES, HEARTS, DIAMONDS, CLUBS.
							  
	private final int value;  // The value of this card, from 1 to 11.
							 
	public Card(int theValue, int theSuit) {
			// Construct a card with the specified value and suit.
			// Value must be between 1 and 13.  Suit must be between
			// 0 and 3.  If the parameters are outside these ranges,
			// the constructed card object will be invalid.
		value = theValue;
		suit = theSuit;
	}
		
	public int getSuit() {
			// Return the int that codes for this card's suit.
		return suit;
	}
	
	public int getValue() {
			// Return the int that codes for this card's value.
		return value;
	}
	
	public String getSuitAsString() {
			// Return a String representing the card's suit.
			// (If the card's suit is invalid, "??" is returned.)
		switch ( suit ) {
		   case SPADES:   return "Spades";
		   case HEARTS:   return "Hearts";
		   case DIAMONDS: return "Diamonds";
		   case CLUBS:    return "Clubs";
		   default:       return "??";
		}
	}
	
	public String getValueAsString() {
			// Return a String representing the card's value.
			// If the card's value is invalid, "??" is returned.
		switch ( value ) {
		   case 1:   return "Ace";
		   case 2:   return "2";
		   case 3:   return "3";
		   case 4:   return "4";
		   case 5:   return "5";
		   case 6:   return "6";
		   case 7:   return "7";
		   case 8:   return "8";
		   case 9:   return "9";
		   case 10:  return "10";
		   case 11:  return "Jack";
		   case 12:  return "Queen";
		   case 13:  return "King";
		   default:  return "??";
		}
	}
	
	public String print() {
		   // Return a String representation of this card, such as
		   // "10 of Hearts" or "Queen of Spades".
		return getValueAsString() + " of " + getSuitAsString();
	}


} // end class Card


public static class Deck {

		private Card[] deck;   // An array of 52 Cards, representing the deck.
		private int cardsUsed; // How many cards have been dealt from the deck.
		// private Card[] dealt = new Card[52];
		public List dealt = new ArrayList();
		public List non_dealt = new ArrayList();
		public Deck() 
		{
					 // Create an unshuffled deck of cards.
			 deck = new Card[52];
			 
			 int cardCt = 0; // How many cards have been created so far.
			 for ( int suit = 0; suit <= 3; suit++ ) {
					for ( int value = 1; value <= 13; value++ ) {
						 deck[cardCt] = new Card(value,suit);
						 cardCt++;
					}
			 }
			 cardsUsed = 0;
		}
		
		public void shuffle(double goodness) {

				for ( int i = 51; i > 0; i-- ) {
						// int rand = (int)(Math.random()*(i+1));
						int rand = (int)(Math.random()*(i+1)*(1-goodness));
						Card temp = deck[i];
						deck[i] = deck[rand];
						deck[rand] = temp;
				}
				cardsUsed = 0;
		}
		
		public int cardsLeft() {
					// As cards are dealt from the deck, the number of cards left
					// decreases.  This function returns the number of cards that
					// are still left in the deck.
				return 52 - cardsUsed;
		}
		
		public Card[] dealOne() {
					// Deals one player with 5 cards.
				if (cardsUsed == 52)
					 shuffle(0);
				Card[] player = new Card[5];
				for (int i=0; i<5; i++) 
				{
					player[i] = deck[cardsUsed];
					cardsUsed++;
				}
				return player;
		}
		
		public void print()
		{	
	 		 for(int i = 0; i<cardsUsed; i++)
			{
				dealt.add(deck[i].print());			
			}
			
			System.out.println("dealted-cards:  " + dealt);
			for(int i = cardsUsed; i<52; i++)
			{
				non_dealt.add(deck[i].print());
			}
			System.out.println("non-dealt-cards:  " + non_dealt);
		}

} // end class Deck




public static class Hand {

	private Vector hand;   // The cards in the hand.
	
	public Hand() {
			  // Create a Hand object that is initially empty.
		hand = new Vector();
	}
	
	public void clear() {
			// Discard all the cards from the hand.
		hand.removeAllElements();
	}
	
	public void addCard(Card c) {
			// Add the card c to the hand.  c should be non-null.  (If c is
			// null, nothing is added to the hand.)
		if (c != null)
			hand.addElement(c);
	}
	
	public void removeCard(Card c) {
			// If the specified card is in the hand, it is removed.
		hand.removeElement(c);
	}
	
	public void removeCard(int position) {
			// If the specified position is a valid position in the hand,
			// then the card in that position is removed.
		if (position >= 0 && position < hand.size())
			hand.removeElementAt(position);
	}
	
	public int getCardCount() {
			// Return the number of cards in the hand.
		return hand.size();
	}
	
	public Card getCard(int position) {
			 // Get the card from the hand in given position, where positions
			 // are numbered starting from 0.  If the specified position is
			 // not the position number of a card in the hand, then null
			 // is returned.
		if (position >= 0 && position < hand.size())
			return (Card)hand.elementAt(position);
		else
			return null;
	}
	
	public void sortBySuit() {
			// Sorts the cards in the hand so that cards of the same suit are
			// grouped together, and within a suit the cards are sorted by value.
			// Note that aces are considered to have the lowest value, 1.
		Vector newHand = new Vector();
		while (hand.size() > 0) {
			int pos = 0;  // Position of minimal card.
			Card c = (Card)hand.elementAt(0);  // Minumal card.
			for (int i = 1; i < hand.size(); i++) {
				Card c1 = (Card)hand.elementAt(i);
				if ( c1.getSuit() < c.getSuit() ||
						  (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
					 pos = i;
					 c = c1;
				}
			}
			hand.removeElementAt(pos);
			newHand.addElement(c);
		}
		hand = newHand;
	}
	
	public void sortByValue() {
			// Sorts the cards in the hand so that cards of the same value are
			// grouped together.  Cards with the same value are sorted by suit.
			// Note that aces are considered to have the lowest value, 1.
		Vector newHand = new Vector();
		while (hand.size() > 0) {
			int pos = 0;  // Position of minimal card.
			Card c = (Card)hand.elementAt(0);  // Minumal card.
			for (int i = 1; i < hand.size(); i++) {
				Card c1 = (Card)hand.elementAt(i);
				if ( c1.getValue() < c.getValue() ||
						  (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
					 pos = i;
					 c = c1;
				}
			}
			hand.removeElementAt(pos);
			newHand.addElement(c);
		}
		hand = newHand;
	}


	
}

}