import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class implementing a flashcard application
 * keeps track of Flashcards in the system.
 *
 * @invariant boxes != null && boxes.size() > 0
 */
public class FlashcardApp 
{
	/**
	 * current setup of boxes
	 * and the first box
	 */
  public ArrayList<Box> boxes = new ArrayList<Box>();
  private Box box1 = new Box(1);

  /** Constructs a new flashcard app object and initializes the boxes. */
  public FlashcardApp()
  {
	  for(int i = 0; i<5; i++){
		  boxes.add(new Box (i));
	  }
  }

  /** Returns an object according to the Leitner study method. */
  public Leitner leitner(Leitner game){
	  
    
    return null;
  }

  /**
   * Returns an arraylist containing all flashcards in the system.
   *
   * @return ArrayList<FlashCard>
   */
  public ArrayList<Flashcard> getAllCards()
  {
    /* TODO: complete implementation */
    return null;
  }

  /**
   * Returns an arraylist containing all flashcards that contain a pattern.
   *
   * @param pattern search pattern for texts on flashcards.
   * @return ArrayList<FlashCard> where all elements contain pattern in either
   *         front or back of the card.
   *
   * @precondition pattern != null
   */
  public ArrayList<Flashcard> getCardsWith(String pattern)
  {
    assert pattern != null;

    /* TODO: complete implementation */
    return null;
  }

  /**
   * @param boxid Leitner box id.
   *
   * @precondition 0 < boxid <= number of boxes in the app
   */
  public void getCards(int boxid)
  {
    assert boxid > 0 /* && boxid <= max-number-of-boxes */;
    Box box = boxes.get(boxid);
    ArrayList<Flashcard> copy = box.getAllCards();
    if(copy.isEmpty()){
    	System.out.println("It's empty");
    }
    for(Flashcard card: copy){
    	System.out.println(card.readFront());
    	System.out.println(card.readBack());
    	System.out.println("");
    }
  }
  /**
   * This method creates Flashcards and puts them in the first box
   * @param file to create flashcards
   * @return the number of cards created
 * @throws FileNotFoundException 
   */
  public int create(String file) throws FileNotFoundException
  {
//		Scanner text = null;
//		try {
//			text = new Scanner(new BufferedReader(new FileReader(file)));
//		} catch (FileNotFoundException e) {
//			System.out.println("File didn't work");
//		}
//			int counter = 0;
//		while(text.hasNext()){
//			counter++;
//			String a = text.nextLine();
//			String b = text.nextLine();
//			String empty = text.nextLine();
//		    Flashcard write = new Flashcard(a,b);
//		    box1.put(write);
//		}
//	    boxes.add(0, box1);
//	    return counter;
	    int        cnt = 0;

	    try (Scanner inp = new Scanner(new File(file));)
	    {
	      while (inp.hasNextLine())
	      {
	        String challenge = inp.nextLine();

	        if (!inp.hasNextLine()) break;
	        String response  = inp.nextLine();

	        Flashcard write = new Flashcard(challenge,response);
	        box1.put(write);
	        ++cnt;

	        // skip empty line (except for end of file)
	        if (inp.hasNextLine()) inp.nextLine();
	      }
	    }
	    boxes.add(0,box1);
	    return cnt;
	  }
  
}
