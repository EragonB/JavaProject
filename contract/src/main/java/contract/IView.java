package contract;



// TODO: Auto-generated Javadoc
/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

/**
 * Read board.
 *
 * @param map the map
 */
public void ReadBoard(IMap map);

/**
 * Sets the controller.
 *
 * @param controller the new controller
 */
public void setController(IController controller);

/**
 * Adds the key listener.
 */
public void AddKeyListener();

/**
 * Sets the frame.
 *
 * @param id_map the new frame
 */
public void setFrame(int id_map);


}
