package contract;



/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {
public void ReadBoard(IMap map);

public void setController(IController controller);
public void AddKeyListener();
public void setFrame(int id_map);


}
