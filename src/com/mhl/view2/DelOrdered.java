package com.mhl.view2;

import java.awt.*;

import javax.swing.*;
import javax.swing.JDialog;

import com.mhl.db.SqlHelper;
import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class DelOrdered extends JDialog implements ActionListener {
	JPanel p1, p2, p3;
	JLabel jl1;
	JTextField jtf1;
	JButton jb1, jb2;

	public DelOrdered() {
		super();
		p1 = new JPanel(new GridLayout(1, 1));
		jl1 = new JLabel("deskid");
		p1.add(jl1);

		p2 = new JPanel(new GridLayout(1, 1));
		jtf1 = new JTextField();
		p2.add(jtf1);

		p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1 = new JButton("Sumbit");
		jb1.setFont(MyTools.f4);
		jb1.addActionListener(this);
		jb2 = new JButton("Cancel");
		jb2.setFont(MyTools.f4);
		jb2.addActionListener(this);
		p3.add(jb1);
		p3.add(jb2);

		this.setLayout(new BorderLayout());
		this.add(p1, "West");
		this.add(p2, "Center");
		this.add(p3, "South");
		this.setSize(200, 100);
		this.setTitle("Cancel reservation");
		this.setVisible(true);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 100, height / 2 - 50);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		SqlHelper hp = null;
		String status = null;
		
		if (arg0.getSource() == jb1) {
			try {
				String sql = "select deskstatus from status where deskid = ?";
				String[] params = { jtf1.getText() };
				hp = new SqlHelper();
				ResultSet rs = hp.queryExecute(sql, params);
				if (rs.next()) {
					status = rs.getString(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				hp.close();
			}

			if ((0 + "").equals(status)) {
				JOptionPane.showMessageDialog(null, "Sorry, the table is in use");
			} else if ((1 + "").equals(status)) {
				String[] params = { jtf1.getText() };
				OrderModel em = new OrderModel();
				String sql = "update status set deskstatus=2 where deskid=?";
				em.UpdateModel(sql, params);
				JOptionPane.showMessageDialog(null, "Congratulations! Cancel reservation successfully!");
			} else if ((2 + "").equals(status)) {
				JOptionPane.showMessageDialog(null, "Sorry, the talbe is not reserved");
			}
			this.dispose();
		} else if (arg0.getSource() == jb2) {
			this.dispose();
		}
	}
}