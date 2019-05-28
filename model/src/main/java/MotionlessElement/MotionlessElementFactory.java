package MotionlessElement;

public class MotionlessElementFactory {
	
	private static final Dirt dirt = new Dirt();
	private static final Door door = new Door();
	private static final Wall wall = new Wall();
	private static final Backgroundvoid backgroundvoid = new Backgroundvoid();
	
	
	public static MotionlessElement createWall()
	{
		return wall;
	}
	
	public static MotionlessElement createDirt()
	{
		return dirt;
	}
	
	public static MotionlessElement createDoor()
	{
		return door;
	}
	
	public static MotionlessElement createBackgroundvoid()
	{
		return backgroundvoid;
	}

}
