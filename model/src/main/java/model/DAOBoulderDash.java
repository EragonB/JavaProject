package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DAOBoulderDash {
	

	public DAOBoulderDash() {
		// TODO Auto-generated constructor stub
	
	}
	
	public ResultSet findMap(final int id) {
		

		try {
			final String sql = "{call transfermap(?)}";
			final CallableStatement call = DBConnection.getInstance().getConnection().prepareCall(sql);
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
			final CallableStatement call = DBConnection.getInstance().getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			
			return resultSet;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet FindMobileRock(final int id)
	{
		
		try {
			final String sql = "{call TestPasMap(?)}";
			final CallableStatement call = DBConnection.getInstance().getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			
			return resultSet;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet FindDiamond(final int id)
	{
		
		try {
			final String sql = "{call RecupDiams(?)}";
			final CallableStatement call = DBConnection.getInstance().getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			
			return resultSet;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet FindEnemy(final int id)
	{
		
		try {
			final String sql = "{call EnemyCount(?)}";
			final CallableStatement call = DBConnection.getInstance().getConnection().prepareCall(sql);
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
