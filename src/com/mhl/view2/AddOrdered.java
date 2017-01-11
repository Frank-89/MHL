package com.mhl.view2;

import java.awt.*;

import javax.swing.*;
import javax.swing.JDialog;
import java.util.Calendar;

import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;

@SuppressWarnings("serial")
public class AddOrdered extends JDialog implements ActionListener {
	JPanel p1, p2, p3;
	JLabel jl1, jl2, jl3, jl4;
	JTextField jtf1, jtf2, jtf3, jtf4;
	JButton jb1, jb2;

	public AddOrdered() {
		super();
		p1 = new JPanel(new GridLayout(4, 1));
		jl1 = new JLabel("deskid");
		jl2 = new JLabel("customname");
		jl3 = new JLabel("tel");
		jl4 = new JLabel("number");

		p1.add(jl1);
		p1.add(jl2);
		p1.add(jl3);
		p1.add(jl4);

		p2 = new JPanel(new GridLayout(4, 1));
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();

		p2.add(jtf1);
		p2.add(jtf2);
		p2.add(jtf3);
		p2.add(jtf4);

		p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1 = new JButton("Submit");
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
		this.setSize(400, 250);
		this.setTitle("Reserved seats");
		this.setVisible(true);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 200, height / 2 - 125);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb1) {
			OrderModel om = new OrderModel();
			String status = om.geStatusById(jtf1.getText());
			if ((0 + "").equals(status)) {
				JOptionPane.showMessageDialog(null, "Failed to add, the talbe is in use");
			} else if ((1 + "").equals(status)) {
				JOptionPane.showMessageDialog(null, "Failed to add, the table is reserved");
			} else if ((2 + "").equals(status)) {
				String sql = "insert into orderdesk values(?, ?, ?, ?, ?)";
				String[] params = { jtf1.getText(), jtf2.getText(), jtf3.getText(), jtf4.getText(),
						Calendar.getInstance().getTime().toLocaleString() };
				OrderModel em = new OrderModel();
				em.UpdateModel(sql, params);
				String params2[] = { jtf1.getText() };
				String sql2 = "insert into status value(?, 1)";
				em.UpdateModel(sql2, params2);
				JOptionPane.showMessageDialog(null, "Congratulations! Added successfully!");
			}
			this.dispose();
		} else if (arg0.getSource() == jb2) {
			this.dispose();
		}
	}
}