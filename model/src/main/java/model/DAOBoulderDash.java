package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



// TODO: Auto-generated Javadoc
/**
 * The Class DAOBoulderDash.
 */
public class DAOBoulderDash {
	

	/**
	 * Instantiates a new DAO boulder dash.
	 */
	public DAOBoulderDash() {
		// TODO Auto-generated constructor stub
	
	}
	
	/**
	 * Find map.
	 *
	 * @param id the id
	 * @return the result set
	 */
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
	
	/**
	 * Find element.
	 *
	 * @param id the id
	 * @return the result set
	 */
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
	
	/**
	 * Find mobile rock.
	 *
	 * @param id the id
	 * @return the result set
	 */
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
	
	/**
	 * Find diamond.
	 *
	 * @param id the id
	 * @return the result set
	 */
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
	
	/**
	 * Find enemy.
	 *
	 * @param id the id
	 * @return the result set
	 */
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
