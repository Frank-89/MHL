package com.mhl.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.JDialog;

import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;

@SuppressWarnings("serial")
public class AddFoodDialog extends JDialog implements ActionListener {

	JPanel p1, p2, p3;
	JLabel jl1, jl2, jl3, jl4;
	JTextField jtf1, jtf2, jtf3, jtf4;
	JButton jb1, jb2;

	public AddFoodDialog(MenuInfo empInfo, String title, boolean model) {
		p1 = new JPanel(new GridLayout(4, 1));
		jl1 = new JLabel("foodid");
		jl2 = new JLabel("foodname");
		jl3 = new JLabel("price");
		jl4 = new JLabel("type");
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
		jb1 = new JButton("Add");
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
		this.setSize(400, 200);
		this.setTitle("Add Menu");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb1) {
			String sql = "insert into menu values(?, ?, ?, ?)";
			String[] params = { jtf1.getText(), jtf2.getText(), jtf3.getText(), jtf4.getText() };
			EmpModel em = new EmpModel();
			if (!em.UpdateModel(sql, params)) {
				JOptionPane.showMessageDialog(null, "Failed to add, please enter the correct data type!");
			} else {
				JOptionPane.showMessageDialog(null, "Congratulations! Added successfully!");
				this.dispose();
			}
		} else if (arg0.getSource() == jb2) {
			this.dispose();
		}
	}
}