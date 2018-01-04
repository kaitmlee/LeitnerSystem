import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This is the TUI
 */
public class TUI {
	/**
	 * This is where the user can type input
	 * and recieve output.
	 * @param fc to keep track of flashcards in system.
	 */
	public static void start(FlashcardApp fc){	
		boolean imported = false;
		System.out.println("Type import filename to import flashcards. Must be 3 lines per FC.");
		System.out.println("Type leitner to start studying");
		System.out.println("Type !exit to quit");
		String input = "";
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(sc.hasNextLine()){
			input = sc.nextLine();	
			if(input.contains("import")){
				String file = input.substring(7);
				try {
					count = fc.create(file);
					imported = true;
					
				} catch (FileNotFoundException e) {
					System.out.println("File " + file + " not found");
				}
				System.out.println("You created " + count + " new cards.");
			}
			else if(input.contains("list-box")){
				String text = input.substring(9);
				fc.getCards(Integer.parseInt(text) - 1);
			}
			else if(input.equals("!exit")){
				System.exit(0);
						}
			else if(input.contains("leitner-gui") || input.contains("drill-gui") || input.contains("simple-gui")){
				if(imported==true) {
					StudyMethod game = getStudyMethod(input, fc);
					GUI gui = new GUI();
					gui.display(game);
					fc.boxes = game.getAllBoxes();
				}
				else System.out.println("Import flashcards first");
			}
			else if(input.contains("leitner") || input.contains("drill") || input.contains("simple")){
				if(imported==true) {
					StudyMethod game = getStudyMethod(input, fc);
					while(!input.equals("!exit")){
						double n = Math.random();
						if(n<0.5){
							System.out.println(game.getFront());
						}
						else System.out.println(game.getBack());
						input = sc.nextLine();
						if(input.equals("!exit")){
							break;
						}
						if(input.equals("%")){
							System.out.println(game.getAnswer());
						}
						boolean correct = game.testAnswer(input);
						game.moveCard(correct);
					}
					fc.boxes = game.getAllBoxes();
				}
				else System.out.println("Import flashcards first");
			}
			else System.out.println("Invalid Command");
		}

	}
	/**
	 * 
	 * @param input could be leitner, drill n, or simple n
	 * 		or any of the gui versions
	 * @param fc to use current Flashcard/box setup in new StudyMethod
	 * @return the type of StudyMethod to be used
	 */
	public static StudyMethod getStudyMethod(String input, FlashcardApp fc){
		if(input.contains("leitner")){
			StudyMethod game = new Leitner(fc.boxes);
			return game;
		}
		else if(input.contains("drill-gui")){
			String text = input.substring(10);
			int n = Integer.parseInt(text);
			StudyMethod game = new Drill(fc.boxes, n);
			return game;
			}
		else if(input.contains("drill")){
			String text = input.substring(6);
			int n = Integer.parseInt(text);
			StudyMethod game = new Drill(fc.boxes, n);
			return game;
			}
		else if(input.contains("simple-gui")){
			String text = input.substring(11);
			int n = Integer.parseInt(text);
			StudyMethod game = new Drill(fc.boxes, n);
			return game;
			}
		String text = input.substring(7);
		int n = Integer.parseInt(text);
		StudyMethod game = new Simple(fc.boxes, n);
		return game;
			
	}
	/**
	 * Main initializes a Flashcard App
	 * @param args
	 */
	public static void main(String[] args){
		FlashcardApp fc = new FlashcardApp();
		start(fc);
	}
}