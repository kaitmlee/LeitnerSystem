/**
 * Flashcard is a an object 
 */
public class Flashcard {
	private String front;
	private String back;
	/**
	 * Initializes Flashcard object
	 * @param Two Strings for the front and back of the card.
	 */
	public Flashcard(String q, String a){
		front = q;
		back = a;
	}
	/**
	 * Reads the front of the card.
	 * @return String of the text on the front.
	 */
	public void setFront(String text){
		front = text;
	}
	public void setBack(String text){
		back = text;
	}
	public String readFront(){
		return front;
	}
	/**
	 * Reads the back of the card
	 * @return a String of the text on the back.
	 */
	public String readBack(){
		return back;
	}
}