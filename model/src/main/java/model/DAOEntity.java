package model;

import java.sql.Connection;
import java.sql.SQLException;

import entity.Entity;

abstract class DAOEntity<E extends Entity> {

	/** The connection. */
	private final Connection connection;

	public DAOEntity(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	
	protected Connection getConnection() {
		return this.connection;
	}

	public abstract E find(int id);

	public abstract E find(String code);

}
