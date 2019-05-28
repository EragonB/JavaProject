package contract;

import java.util.Observable;

public interface IModel {
	
	public IMap getMap();
	public void show();
	public Observable getObservable();
	public void play();

}
