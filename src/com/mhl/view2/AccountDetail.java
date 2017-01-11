package com.mhl.view2;

import java.awt.*;

import javax.swing.*;
import javax.swing.JDialog;

import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;

@SuppressWarnings("serial")
public class AccountDetail extends JDialog implements ActionListener {

	JPanel p1, p2, p3;
	JLabel jl1, jl2;
	JTable table;
	JScrollPane jsp;
	JButton jb1, jb2;
	String deskid, bookid;
	EmpModel em;

	public AccountDetail(Accounts a) {
		super();
		deskid = a.jtf1.getText().trim();
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jl1 = new JLabel("Your bill is as follows:");
		p1.add(jl1);
		p2 = new JPanel(new BorderLayout());
		
		String sql = "select bookid from bookdish where deskid = ?";
		String[] params = { deskid };
		OrderModel om = new OrderModel();
		bookid = om.query(sql, params);

		String sql1 = "select bookdetail.foodid, foodname, foodnum, price from bookdetail, menu where menu.foodid = bookdetail.foodid and deskid = ?";
		String[] params1 = { deskid };
		em = new EmpModel();
		em.query(sql1, params1);
		
		table = new JTable(em);
		jsp = new JScrollPane(table);
		p2.add(jsp);
		p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1 = new JButton("Check out");
		jb1.setFont(MyTools.f4);
		jb1.addActionListener(this);
		jb2 = new JButton("Cancel");
		jb2.setFont(MyTools.f4);
		jb2.addActionListener(this);
		p3.add(jb1);
		p3.add(jb2);
		
		this.setLayout(new BorderLayout());
		this.add(p1, "North");
		this.add(p2, "Center");
		this.add(p3, "South");
		this.setSize(600, 400);
		this.setTitle("Check out");
		this.setVisible(true);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 300, height / 2 - 200);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb1) {
			int row = this.table.getRowCount();
			String[] num = new String[row];
			String[] price = new String[row];
			int sum = 0;
			for (int i = 0; i < row; i++) {
				price[i] = (String) this.table.getValueAt(i, 3);
				num[i] = (String) this.table.getValueAt(i, 2);
				sum += (Integer.valueOf(num[i])).intValue() * (Float.valueOf(price[i]).floatValue());
			}
			OrderModel em = new OrderModel();
			String[] params = { deskid };
			String sql = "update status set deskstatus = 2 where deskid = ?";
			em.UpdateModel(sql, params);
			String sql2 = "delete from bookdetail where deskid = ?";
			em.UpdateModel(sql2, params);
			String sql3 = "delete from status where deskid = ?";
			em.UpdateModel(sql3, params);
			JOptionPane.showMessageDialog(this, "The total: " + sum);
			this.dispose();
		} else if (arg0.getSource() == jb2) {
			this.dispose();
		}
	}
}