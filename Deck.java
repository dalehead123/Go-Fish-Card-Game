import java.util.*;


/**
 * Represents a deck of cards
 * Has two shuffle methods
 * 
 *
 */
public class Deck{
  
  public static final int DECKSIZE = 52;
  private Card[] deck;
  private int cardsDealt = 0;
  
  public Deck() {
    this.initializeDeck();
    cardsDealt=0;
  }
  private void reset() {
    cardsDealt = 0;
  }
  public int getCardsLeft() {
    return deck.length - cardsDealt;
  }
  
  public int getCardsDealt() {
    return cardsDealt;
  }
  
  public Card dealCard() {
    if ( getCardsLeft() <= 0 ) {
      return null;
    }
    return deck[cardsDealt++];
  }
  /**
   * Create a full deck of 52 playing cards
   * initializes an array of the cards, unshuffled, with unique cards
   * Called only in Constructor
   */
  private void initializeDeck() {
    deck = new Card[DECKSIZE];
    int pos = 0;
    
    for( int suit = Card.SPADES; suit <= Card.DIAMONDS; suit++ ) {
      for( int rank = 2; rank <= Card.ACE; rank++ ) {
        deck[pos++] = new Card( suit, rank );
      }
    }
  }
  
  public void randomShuffle() {
    Card[] other = deck;
    deck = new Card[deck.length];
    Random random = new Random(System.nanoTime());
    
    for( int i = 0; i < deck.length; i++ ) {
      int pos = random.nextInt(DECKSIZE);
      while( other[pos] == null ) {
        pos = random.nextInt(DECKSIZE);
      }
      deck[i] = other[pos];
      other[pos] = null;
    }
    reset();
  }
  public void randomShuffleSwap() {
    
    Random random = new Random(System.nanoTime());
    
    for( int i = 0; i < deck.length; i++ ) {
      int pos = random.nextInt(DECKSIZE);
      Card holder = new Card(deck[i]);
      deck[i] = deck[pos];
      deck[pos] = holder;
    }
    reset();
  }
  public String toString(){
    String retString="";
    
    for (int i = 0; i<deck.length;i++){
      retString = retString + deck[i]+"\n";
      
      
    }
    return retString;
  }
}
