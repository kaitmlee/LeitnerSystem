import java.util.ArrayList;

/**
 * This is a type of StudyMethod called Simple
 *
 */
public class Simple implements StudyMethod{
	/**
	 * it has an ArrayList of boxes,
	 * keeps track of the specified box, card, and answer.
	 */
	private ArrayList<Box> boxes = new ArrayList<Box>();
	private int boxn;
	private Flashcard card;
	private String answer;
	/**
	 * Initializes Simple object
	 * @param theBoxes is the current box/flashcard setup in the system
	 * @param boxnum is the specified box to be used for this method
	 */
	public Simple(ArrayList<Box> theBoxes, int boxnum){
		assert theBoxes != null;
		boxes.add(0, theBoxes.get(0));
		for(int i = 1; i< 5; i++){
			boxes.add(i, new Box(i));
			boxes.add(i, theBoxes.get(i));
		}
		boxn = boxnum-1;
	}
	/**
	 * tests to see if the specified box is empty first
	 * @return String of the side of card which is picked.
	 */
	public String getFront(){
		if(boxes.get(boxn).isEmpty()){
			String s = "Simple session is over; press !exit";
			return s;
		}
		card = boxes.get(boxn).getFirst();
		answer = card.readBack();
		return card.readFront();
	}
	/**
	 * picks the first card out of the box.
	 * tests to see if the specified box is empty first
	 * @return String of the side of card which is picked.
	 */
	public String getBack(){
		if(boxes.get(boxn).isEmpty()){
			String s = "Simple session is over; press !exit";
			return s;
		}
		card = boxes.get(boxn).getFirst();
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
	 * Tests to see if the user guessed corectly or alreay knows the answer.
	 * @param s is the user input
	 * @return true if correct.
	 */
	public boolean testAnswer(String s){
		if(s.equals(answer) || s.equals("")) return true;

		return false;
	}
	/**
	 * Moves the card into the next box if correct
	 * and to the previous box if wrong
	 * @param correct is true if the user was right
	 */
	public void moveCard(boolean correct){
	    int boxnum = getTargetBox(boxn, correct);
	    boxes.get(boxnum).put(card);
	    boxes.get(boxn).remove(card);
	}
	/**
	 * Calculates which box the card should be moved to.
	 * @param box is the current box the card is in
	 * @param correct is true if the user was right
	 * @return the box that the card will be placed in.
	 */
	public int getTargetBox(int box, boolean correct)
	{
		/* computes the box where the current card needs to be placed.
		 * 1 iff !correct
		 * min(box+1, boxes.size()) iff correct
		 */
		if(correct == false && box>0){
			System.out.println("Wrong!");
			return box-1;
		}
		else if(correct == false && box ==0){
			System.out.println("Wrong!");
			return 0;
		}
		else if(correct == true && boxn<4){
			System.out.println("Correct!");
			return boxn+1;
		}
		return 4;
	}
	/**
	 * @return the current flashcard/box setup in the system.
	 */
	public ArrayList<Box> getAllBoxes(){
		return boxes;
	}
}
