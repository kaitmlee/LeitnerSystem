
import java.util.ArrayList;

/**
 * A StudyMethod type called Leitner
 *
 */
public class Leitner implements StudyMethod
{
	private ArrayList<Box> boxes = new ArrayList<Box>();
	private String answer;
	private Flashcard card;
	private int boxn;
	/**
	 * Constructs a new Leitner object.
	 * @param theBoxes uses current boxes in the system
	 * @precondition theBoxes != null
	 */
	public Leitner(ArrayList<Box> theBoxes)
	{
		assert theBoxes != null;
		boxes.add(0, theBoxes.get(0));
		for(int i = 1; i< 5; i++){
			boxes.add(i, new Box(i));
			boxes.add(i, theBoxes.get(i));
		}
	}

	/**
	 * Picks a random card and side from all boxes.
	 *
	 * Cards in lower boxes receive higher weight (priority). The method
	 * returns void, but the picked card's sides can be accessed through
	 * getQuestion and getAnswer, the answer tested using checkAnswer.
	 *
	 * @precondition there must be at least one box with one card.
	 */
	public void pickCard()
	{
		double n = (Math.random() * 31);
		if(n<=16){
			if(boxes.get(0).isEmpty()) pickCard();
			else {
				boxn = 0;
				card = boxes.get(0).get();
			}
		}
		else if(n>16 && n<=24){
			if(boxes.get(1).isEmpty()) pickCard();
			else {
				boxn = 1;
				card = boxes.get(1).get();
			}
		}
		else if(n>24 && n<=28){
			if(boxes.get(2).isEmpty()) pickCard();
			else {
				boxn = 2;
				card = boxes.get(2).get();
			}
		}
		else if(n> 28 && n<= 30){
			if(boxes.get(3).isEmpty()) pickCard();
			else {
				boxn = 3;
				card = boxes.get(3).get();
			}
		}
		else if(n>30 && n<=31){
			if(boxes.get(4).isEmpty()) pickCard();
			else {
				boxn = 4;
				card = boxes.get(4).get();
			}
		}
	}

	/**
	 * Returns the question for the last picked card.
	 *
	 * @return the question
	 */
	public String getFront()
	{
		pickCard();
		answer = card.readBack();
		return card.readFront();
	}

	/**
	 * Returns the answer for the last picked card.
	 *
	 * @return the answer
	 */
	public String getBack()
	{
		pickCard();
		answer = card.readFront();
		return card.readBack();
	}
	/**
	 * This returns the other side of the card when prompted
	 * @return String answer
	 */
	public String getAnswer(){
		String print = answer;
		return print;
	}
	/**
	 * Validates the response against the last picked card.
	 *
	 * @param s the response.
	 * @return true, iff s was correct. s is assumed to be correct, if it is empty
	 *         or the String answer equals s.
	 *
	 */
	public boolean testAnswer(String s)
	{
		if(s.equals(answer) || s.equals("")){
			System.out.println("Correct!");
			return true;
		}
			
		System.out.println("Wrong!");
		return false;
	}

	/**
	 * Computes the box number where the card will be placed
	 *
	 * @param box current box number
	 * @param correct indicates whether response was correct.
	 *
	 */
	public int getTargetBox(int box, boolean correct)
	{
		if(correct == false){
			return 0;
		}
		else if(boxn<4){
			return boxn+1;
		}
		return 4;
	}

	/**
	 * Moves card to the target box, depending on whether succ indicates
	 * a correct/incorrect response.
	 *
	 * @param correct, indicates whether the last response was correct.
	 */
	public void moveCard(boolean correct)
	{
		int boxnum = getTargetBox(boxn, correct);
		boxes.get(boxnum).put(card);
		boxes.get(boxn).remove(card);

	}
	/**
	 * makes a copy of the boxes.
	 * @return and ArrayList of boxes to save the current setup
	 */
	public ArrayList<Box> getAllBoxes()
	{
		ArrayList<Box> copy = new ArrayList<Box>();

		for (Box box : boxes) copy.add(box);

		return copy;
	}
}
