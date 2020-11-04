package controlador.database;

import java.sql.*;

public class ConexionDB implements IConexionDB {
	private String host = "127.0.0.1";
	private String port = "3306";
	private String user = "root";
	private String password = "1gradosuperior";
	private String pattern = "jdbc:mariadb://" + host + ":" + port + "/";
	private static Connection connectionDb = null;
	private String database;
	private String url;

	public String getUrl() {
		return this.url;
	}

	public ConexionDB(String database) {

		this.database = database;
		this.url = pattern + this.database;

		// Registramos el Driver
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Errorï¿½ï¿½ al registrar el driver de MariaDB: " + ex);
		}

		// Establecemos la conexion
		connectDataBase(url);
	}

	@Override
	public void connectDataBase(String url) {
		try {
			connectionDb = DriverManager.getConnection(url, user, password);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			connectionDb = null;
		}
	}

	/**
	 * checkConnectionDatabase
	 * @return tipo: boolean
	 */
	public static boolean checkConnectionDatabase() {
		boolean bConnected;
		try {
			connectionDb.isValid(5000);
			bConnected = true;
		} catch (Exception e) {
			bConnected = false;
		}
		return bConnected;
	}

	/**
	 * disconnectDatabase
	 */
	public static void disconnectDatabase() {
		try {
			connectionDb.close();
		} catch (Exception e) {
			connectionDb = null;
		}
	}

	/**
	 * getConnection
	 * @return tipo: Connection
	 */
	public static Connection getConnection() {
		return connectionDb;
	}

	/**
	 * executeCount
	 * @param sql tipo: String
	 * @return tipo: int
	 */
	public static int executeCount(String sql) {
		Statement stm = null;
		ResultSet rs = null;
		int iCount = 0;

		try {
			stm = ConexionDB.getConnection().createStatement();
			rs = stm.executeQuery(sql);
			if (rs.next()) {
				iCount = rs.getInt(1);
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			iCount = 0;
		}

		return iCount;
	}

	/**
	 * executeUpdate
	 * @param sql tipo: String
	 * @return tipo: int
	 */
	public static int executeUpdate(String sql) {
		Statement stm = null;
		int iCount = 0;

		try {
			stm = ConexionDB.getConnection().createStatement();
			iCount = stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			iCount = 0;
		}
		return iCount;
	}

}
