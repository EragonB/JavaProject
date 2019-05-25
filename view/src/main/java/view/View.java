package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public final class View {
	public View() {
		ViewFrame viewframe = new ViewFrame();
		SaveTest("Bonjour");
	}
	
	public static void SaveTest(String Images)
	{
		String url = "jdbc:mysql://localhost/javaproject?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris&useSSL=FALSE";
		String login = "root";
		String passwd = "";
		
		Connection cn 	= null;
		Statement st 	= null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			
			st = cn.createStatement();
			System.out.println("Probleme");
			String sql = "INSERT INTO `JavaImageProto` (`Picture`) VALUES (`" + Images + "`)";
			
			st.executeUpdate(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
