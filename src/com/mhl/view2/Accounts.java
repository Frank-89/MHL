package com.mhl.view2;

import java.awt.*;

import javax.swing.*;
import javax.swing.JDialog;

import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;

@SuppressWarnings("serial")
public class Accounts extends JDialog implements ActionListener {
	JPanel p1, p2, p3;
	JLabel jl1;
	JTextField jtf1;
	JButton jb1, jb2;
	
	public Accounts() {
		super();
		p1 = new JPanel(new GridLayout(1, 1));
		jl1 = new JLabel("deskid");
		p1.add(jl1);

		p2 = new JPanel(new GridLayout(1, 1));
		jtf1 = new JTextField();
		p2.add(jtf1);

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
		this.setSize(250, 100);
		this.setTitle("Please select the table to check out");
		this.setVisible(true);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 125, height / 2 - 50);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb1) {
			OrderModel om = new OrderModel();
			String status = om.geStatusById(jtf1.getText());
			if ((2 + "").equals(status)) {
				new AccountDetail(this);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Sorry, the table is not in use!");
			}
			this.dispose();
		} else if (arg0.getSource() == jb2) {
			this.dispose();
		}
	}
}