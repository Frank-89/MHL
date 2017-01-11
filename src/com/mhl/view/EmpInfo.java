package com.mhl.view;

import com.mhl.tools.*;
import com.mhl.model.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class EmpInfo extends JPanel implements ActionListener {
	JPanel p1, p2, p3, p4, p5;
	JLabel p1_l1, p3_l1;
	JTextField p1_jtf;
	JButton p1_jb, p4_jb1, p4_jb2, p4_jb3, p4_jb4, p4_jb5;
	JTable jtable;
	JScrollPane jsp;
	EmpModel em = null;
	int sum;

	public EmpInfo() {
		// North
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_l1 = new JLabel("Please enter employee id or name: ");
		p1_l1.setFont(MyTools.f1);
		p1_jtf = new JTextField(20);
		p1_jb = new JButton("Query");
		p1_jb.addActionListener(this);
		p1_jb.setFont(MyTools.f4);
		p1.add(p1_l1);
		p1.add(p1_jtf);
		p1.add(p1_jb);

		// Center
		p2 = new JPanel(new BorderLayout());
		String[] params = { "1" };
		String sql = "select empid, empname, sex, position, address, education from empinfo where 1 = ?";
		em = new EmpModel();
		em.query(sql, params);
		jtable = new JTable(em);
		//jtable.setModel(em);
		jsp = new JScrollPane(jtable);
		p2.add(jsp);

		// South
		p5 = new JPanel(new BorderLayout());
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		sql = "select count(*) from empinfo";
		em = new EmpModel();
		sum = em.getNum(sql);
		p3_l1 = new JLabel("The total record is " + sum);
		p3.add(p3_l1);
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1 = new JButton("Details");
		p4_jb1.addActionListener(this);
		p4_jb1.setFont(MyTools.f4);
		p4_jb2 = new JButton("Add");
		p4_jb2.addActionListener(this);
		p4_jb2.setFont(MyTools.f4);
		p4_jb3 = new JButton("Edit");
		p4_jb3.addActionListener(this);
		p4_jb3.setFont(MyTools.f4);
		p4_jb4 = new JButton("Delete");
		p4_jb4.addActionListener(this);
		p4_jb4.setFont(MyTools.f4);
		p4_jb5 = new JButton("Refresh");
		p4_jb5.addActionListener(this);
		p4_jb5.setFont(MyTools.f4);
		
		p4.add(p4_jb1);
		p4.add(p4_jb2);
		p4.add(p4_jb3);
		p4.add(p4_jb4);
		p4.add(p4_jb5);
		
		p5.add(p3, "West");
		p5.add(p4, "East");
		
		this.setLayout(new BorderLayout());
		this.add(p1, "North");
		this.add(p2, "Center");
		this.add(p5, "South");
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(p1_jb)) {

			if (p1_jtf.getText().trim().equals("")) {
				String[] params = { "1" };
				String sql = "select empid, empname, sex, position, address, education from empinfo where 1 = ?";
				em = new EmpModel();
				em.query(sql, params);
				jtable.setModel(em);
			} else {
				String params[] = { p1_jtf.getText().trim(), p1_jtf.getText().trim() };
				String sql = "select empid, empname, sex, position, address, education from rszl where empid = ? or empname = ?";
				em = new EmpModel();
				em.query(sql, params);
				jtable.setModel(em);
			}
		} else if (arg0.getSource().equals(p4_jb1)) {
			int rowNum = this.jtable.getSelectedRow();
			if (rowNum == -1) {
				JOptionPane.showMessageDialog(this, "Please select a row!");
			}
			String empId = (String) this.jtable.getValueAt(rowNum, 0);
			String sql = "select * from empinfo where empid = ?";
			String[] params = { empId };
			em = new EmpModel();
			em.query(sql, params);
			jtable.setModel(em);
		} else if (arg0.getSource().equals(p4_jb2)) {
			if (true) {
				new AddEmpDialog(this, "Add", true);
			}
			String sql = "select empid, empname, sex, position, address, education from empinfo where 1 = ?";
			String[] params = { "1" };
			em = new EmpModel();
			em.query(sql, params);
			jtable.setModel(em);
			
			sql = "select count(*) from empinfo";
			sum = em.getNum(sql);
			p3_l1.setText("The total record is " + String.valueOf(sum));
			p3.add(p3_l1);
		} else if (arg0.getSource().equals(p4_jb3)) {
			int rowNum = this.jtable.getSelectedRow();
			if (rowNum == -1) {
				JOptionPane.showMessageDialog(this, "Please select a row!");
			} else {
				new UpdEmpDialog(this, "Edit", true, em, rowNum);
			}
			String sql = "select empid, empname, sex, position, address, education from empinfo where 1 = ?";
			String[] params = { "1" };
			em = new EmpModel();
			em.query(sql, params);
			jtable.setModel(em);
		} else if (arg0.getSource().equals(p4_jb4)) {
			int rowNum = this.jtable.getSelectedRow();
			if (rowNum == -1) {
				JOptionPane.showMessageDialog(this, "Please select a row!");
			} else {
				String empId = (String) this.jtable.getValueAt(rowNum, 0);
				String sql = "delete from empinfo where empid = ?";
				String sql1 = "delete from login where empid = ?";
				String[] params = { empId };
				String[] params1 = { empId };
				JOptionPane.showMessageDialog(null, "Congratulations! Successfully deleted!");
				em = new EmpModel();
				em.UpdateModel(sql, params);
				em.UpdateModel(sql1, params1);
			}
			String sql = "select empid, empname, sex, position, address, education from empinfo where 1 = ?";
			String[] params = { "1" };
			em = new EmpModel();
			em.query(sql, params);
			jtable.setModel(em);
			
			sql = "select count(*) from empinfo";
			sum = em.getNum(sql);
			p3_l1.setText("The total record is " + String.valueOf(sum));
			p3.add(p3_l1);
		} else if (arg0.getSource().equals(p4_jb5)) {
			String sql = "select empid, empname, sex, position, address, education from empinfo where 1 = ?";
			String[] params = { "1" };
			em = new EmpModel();
			em.query(sql, params);
			jtable.setModel(em);
			
			sql = "select count(*) from empinfo";
			sum = em.getNum(sql);
			p3_l1.setText("The total record is " + String.valueOf(sum));
			p3.add(p3_l1);
		}
	}
}