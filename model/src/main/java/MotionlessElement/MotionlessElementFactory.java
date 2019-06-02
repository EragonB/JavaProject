package MotionlessElement;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating MotionlessElement objects.
 */
public class MotionlessElementFactory {
	
	/** The Constant dirt. */
	private static final Dirt dirt = new Dirt();
	
	/** The Constant door. */
	private static final Door door = new Door();
	
	/** The Constant wall. */
	private static final Wall wall = new Wall();
	
	/** The Constant backgroundvoid. */
	private static final Backgroundvoid backgroundvoid = new Backgroundvoid();
	
	
	/**
	 * Creates a new MotionlessElement object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createWall()
	{
		return wall;
	}
	
	/**
	 * Creates a new MotionlessElement object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createDirt()
	{
		return dirt;
	}
	
	/**
	 * Creates a new MotionlessElement object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createDoor()
	{
		return door;
	}
	
	/**
	 * Creates a new MotionlessElement object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createBackgroundvoid()
	{
		return backgroundvoid;
	}

}
