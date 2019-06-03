package contract;

import java.util.Observer;

import javax.swing.JFrame;

public interface IView {

	/**
	 * Read board.
	 *
	 * @param map the map
	 */
	public void ReadBoard(IMap map);
	
	public JFrame getViewframe();

	public Observer getObserver();

	public void frame(int value);
}
