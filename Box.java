import java.util.ArrayList;

/**
 * Box is an object that stores Flashcards.
 */
public class Box {
	private ArrayList<Flashcard> cards;
	/**
	 * Initializes a Box object
	 */
	public Box(int num){								//The idea and code for boxnum came from the class for
		assert num > 0;									//box that we were given.
		cards = new ArrayList<Flashcard>();
	}
	/**
	 * Puts a Flashcard in the box.
	 * @param a Flashcard
	 */
	public void put(Flashcard n){
		cards.add(n);
	}
	/**
	 * Retrieves current Flashcard
	 * @return the Flashcard.
	 */
	public Flashcard get(){
		int n = cards.size();
		int i = (int)(Math.random() * n);
		return cards.get(i); 
	}
	/**
	 * Retrieves first Flashcard
	 * @return the Flashcard.
	 */
	public Flashcard getFirst(){
		return cards.get(0); 
	}
	/**
	 * Removes Flashcard from box
	 * @param a Flashcard
	 */
	public void remove(Flashcard card){
		cards.remove(card); 					//from file
	}
	/**
	 * Checks to see if the Box is empty
	 * @return true if it is empty, false if it isn't
	 */
	public boolean isEmpty(){
		return cards.isEmpty();
	}
	  /**
	   * Returns an ArrayList<FlashCard> containing all cards in the box.
	   *
	   * @return an ArrayList<FlashCard>
	   */
	  public ArrayList<Flashcard> getAllCards()
	  {
	    ArrayList<Flashcard> copy = new ArrayList<Flashcard>();

	    for (Flashcard card : cards) copy.add(card);

	    return copy;
	  }
}