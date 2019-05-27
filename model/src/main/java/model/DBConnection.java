package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Class DBConnection.
 *
 * @author Jean-Aymeric Diet
 */
final class DBConnection {
	/** The instance. */
	private static DBConnection	INSTANCE	= null;

	/** The connection. */
	private Connection	connection;
	

	/** The url. */
	private String url	= "jdbc:mysql://localhost:3306/BoulderDash?serverTimezone=UTC&autoReconnect=true&useSSL=false";

	/** The login. */
	private String login = "root";

	/** The password. */
	private String password = "";
	
	private Statement statement=null;

	/**
	 * Instantiates a new DB connection.
	 */
	public DBConnection() {
		this.open();
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	private Boolean open() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(this.getUrl(), this.getLogin(),this.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}
}
