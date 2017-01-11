package com.mhl.model;

import com.mhl.db.*;

import java.sql.*;
import java.util.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class EmpModel extends AbstractTableModel {
	public Vector<String> colums;
	@SuppressWarnings("rawtypes")
	public Vector<Vector> rows;

	public boolean UpdateModel(String sql, String[] params) {
		SqlHelper hp = new SqlHelper();
		return hp.updateExecete(sql, params);
	}

	public int getNum(String sql) {
		SqlHelper hp = new SqlHelper();
		int sum = hp.queryExecute(sql);
		return sum;
	}

	@SuppressWarnings("rawtypes")
	public void query(String sql, String[] params) {
		colums = new Vector<String>();
		rows = new Vector<Vector>();
		SqlHelper hp = new SqlHelper();
		ResultSet rs = hp.queryExecute(sql, params);
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				this.colums.add(rsmd.getColumnName(i + 1));
			}
			while (rs.next()) {
				Vector<String> temp = new Vector<String>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					temp.add(rs.getString(i + 1));
				}
				rows.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			hp.close();
		}
	}

	@Override
	public int getColumnCount() {
		return this.colums.size();
	}

	@Override
	public int getRowCount() {
		return this.rows.size();
	}

	@Override
	public String getColumnName(int arg0) {
		return this.colums.get(arg0).toString();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getValueAt(int arg0, int arg1) {
		return ((Vector) rows.get(arg0)).get(arg1);
	}
}

