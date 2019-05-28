package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DAOBoulderDash {
	private DBConnection db;

	public DAOBoulderDash() {
		// TODO Auto-generated constructor stub
	this.db=new DBConnection();
	}
	
	public ResultSet findMap(final int id) {
		

		try {
			final String sql = "{call transfermap(?)}";
			final CallableStatement call = db.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			
			return resultSet;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet findElement(final int id)
	{

		try {
			final String sql = "{call transferelement(?)}";
			final CallableStatement call = db.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			
			return resultSet;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
