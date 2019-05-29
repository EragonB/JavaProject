package contract;



/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {
public void ReadBoard(IMap map);

public void setController(IController controller);
public void moveValue(int i);
public void AddKeyListener();

}
