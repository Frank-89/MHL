package com.mhl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlHelper {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/RestaurantDB?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	String user = "root";
	String passwd = "root";
	int sum = 0;

	public SqlHelper() {
		try {
			// load driver
			Class.forName(driver);
			// get connectivity
			con = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet queryExecute(String sql, String[] params) {
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setString(i + 1, params[i]);
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int queryExecute(String sql) {
		try {
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			if (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;
	}

	public boolean updateExecete(String sql, String[] params) {
		boolean b = true;
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setString(i + 1, params[i]);
			}
			if (ps.executeUpdate() != 1) {
				b = false;
			}
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;

	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
