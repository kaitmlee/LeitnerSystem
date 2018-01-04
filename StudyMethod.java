import java.util.ArrayList;

/**
 * Interface StudyMethod requires all other study methods have these methods.
 *
 */
public interface StudyMethod {

	public String getFront();

	public String getBack();

	public String getAnswer();

	public boolean testAnswer(String s);

	public void moveCard(boolean correct);

	public ArrayList<Box> getAllBoxes();

}
