package view;

import java.io.*;
import java.sql.*;
import java.util.Vector;




public final class View {
	public View() {
		ViewFrame viewframe = new ViewFrame();
		SaveTest("Bonjour");
	}
	
	public static void SaveTest(String Perso)
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
			
			String sql = "INSERT INTO `perso` (`persocolo`) VALUES ('Boby La Fouine')";
			
			st.executeUpdate(sql);
			try {
				sauveIMG("../picture/Wall.png","Wallaaa", cn);
				chargeIMG("WallBias","../picture/WallBias.png",cn);
				
				getAllNames(cn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

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
	
	public static void sauveIMG(String location, String name, Connection cn) throws Exception
	{
		File ImageTest = new File(location);
		FileInputStream istreamImageTest = new FileInputStream(ImageTest);
		
		try {
			PreparedStatement ps = cn.prepareStatement("insert into image (name, img) values (?,?)");
			try
			{
				ps.setString(1, name);
		        ps.setBinaryStream(2, istreamImageTest, (int) ImageTest.length());
		        ps.executeUpdate();
			}
			finally
			{
				ps.close();
			}
		}
		finally
		{
			istreamImageTest.close();
		}

	}
	
	
	public static void chargeIMG(String name, String location, Connection cn) throws Exception
	{
	  File monImage = new File(location);
	  FileOutputStream ostreamImage = new FileOutputStream(monImage);         
	  try
	  {
	    PreparedStatement ps = cn.prepareStatement("select img from image where name=?");
	    try
	    {
	      ps.setString(1, name);
	      ResultSet rs = ps.executeQuery();
	      try
	      {
	        if(rs.next())
	        {
	      	  InputStream istreamImage = rs.getBinaryStream("img");
	      
	      	  byte[] buffer = new byte[1024];
	      	  int length = 0;
		
	      	  while((length = istreamImage.read(buffer)) != -1)
	      	  {
	      	    ostreamImage.write(buffer, 0, length);
		  }
	  	}
	      }
	      finally
	      {
	        rs.close();
	      }
	    }
	    finally
	    {
	      ps.close();
	    }
	  }
	  finally
	  {
	    ostreamImage.close();
	  }
	}
	
	public static Vector getAllNames(Connection cn) throws Exception
	{
	  Vector res = new Vector();

	  Statement stmt = cn.createStatement();

	  try
	  {
	    ResultSet rset = stmt.executeQuery("select name from image");

	    try
	    {
	      while(rset.next())
	      {
	        res.add(rset.getString("name"));
	      }
	    }
	    finally
	    {
	      rset.close();
	    }
	  }
	  finally
	  {
	    stmt.close();
	  }

	  return res;
	}
}
