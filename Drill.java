import java.util.ArrayList;

/**
 * a StudyMethod type called Drill
 */
public class Drill implements StudyMethod{
	private ArrayList<Box> boxes = new ArrayList<Box>();
	private Box copy = new Box(0);
	private Flashcard card;
	private String answer;
	/**
	 * Initializes Drill
	 * @param theBoxes is the current box setup
	 * @param boxnum the box that was picked for Drill.
	 */
	public Drill(ArrayList<Box> theBoxes, int boxnum){
		copy = theBoxes.get(boxnum - 1);
	}
	/**
	 * tests if the box is empty
	 * If not it returns one side of the Flashcard
	 * @return the String question
	 */
	public String getFront(){
		if(copy.isEmpty()){
			String s = "Drill session is over; press !exit";
			return s;
		}
		card = copy.get();
		answer = card.readBack();
		return card.readFront();
	}
	/**
	 * tests if the box is empty
	 * If not it returns one side of the Flashcard
	 * @return the String question
	 */
	public String getBack(){
		if(copy.isEmpty()){
			String s = "Drill session is over; press !exit";
			return s;
		}
		card = copy.get();
		answer = card.readFront();
		return card.readBack();
	}
	/**
	 * This returns the other side of the card when prompted
	 * @return String answer
	 */
	public String getAnswer(){
		String print = "The answer was " + answer + ".";
		return print;
	}
	/**
	 * Tests to see if the answer is correct or wrong
	 * @return boolean true if correct.
	 * @param s is the input the user typed
	 */
	public boolean testAnswer(String s){
	    if(s.equals(answer) || s.equals("")) {
	    	System.out.println("Correct!");
	    	return true;
	    }
	    System.out.println("Wrong!");
	    return false;
	}
	/**
	 * Removes card from box if correct
	 * @param correct is true if user was right
	 */
	public void moveCard(boolean correct){
		if(correct == true) copy.remove(card);
	}
	/**
	 * @return the current box setup.
	 */
	public ArrayList<Box> getAllBoxes(){
		return boxes;
	}
}
