package com.mhl.model;

import java.sql.*;
import com.mhl.db.*;

public class UserModel {
	public String checkUser(String uid, String p) {
		String zhiwei = "";
		SqlHelper hp = null;
		try {
			String sql = "select position from login where login.empid = ? and login.passwd = ?";
			String[] params = { uid, p };
			hp = new SqlHelper();
			ResultSet rs = hp.queryExecute(sql, params);
			if (rs.next()) {
				zhiwei = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			hp.close();
		}
		return zhiwei;
	}

	public String getNameById(String uid) {
		String empname = null;
		SqlHelper hp = null;
		try {
			String sql = "select empname from empinfo where empid = ?";
			String[] params = { uid };
			hp = new SqlHelper();
			ResultSet rs = hp.queryExecute(sql, params);
			if (rs.next()) {
				empname = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			hp.close();
		}
		return empname;
	}
	
	public String getEmpIdByInput(String uid) {
		String empid = null;
		SqlHelper hp = null;
		try {
			String sql = "select empid from empinfo where empid = ?";
			String[] params = { uid };
			hp = new SqlHelper();
			ResultSet rs = hp.queryExecute(sql, params);
			if (rs.next()) {
				empid = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			hp.close();
		}
		return empid;
	}
}