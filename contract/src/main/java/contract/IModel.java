package contract;

import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Interface IModel.
 */
public interface IModel extends Runnable{
	
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public IMap getMap();
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	//public void show();
	public Observable getObservable();
	
	/**
	 * Play.
	 */
	public void play();
	
	/**
	 * Sets the id map.
	 *
	 * @param id_map the new id map
	 */
	public void setIdMap(int id_map);


}
