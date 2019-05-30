package contract;

import java.util.Observable;

public interface IModel extends Runnable{
	
	public IMap getMap();
	//public void show();
	public Observable getObservable();
	public void play();
	public void setIdMap(int id_map);
	public void start();

}
