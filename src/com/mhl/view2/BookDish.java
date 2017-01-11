package com.mhl.view2;

import java.awt.*;

import javax.swing.*;
import javax.swing.JDialog;

import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;

@SuppressWarnings("serial")
public class BookDish extends JDialog implements ActionListener {
	JPanel p1, p2, p3;
	JLabel jl1, jl2;
	JTextField jtf1, jtf2;
	JButton jb1, jb2;

	public BookDish() {
		super();
		p1 = new JPanel(new GridLayout(2, 1));
		jl1 = new JLabel("deskid");
		jl2 = new JLabel("bookid");
		p1.add(jl1);
		p1.add(jl2);
		
		p2 = new JPanel(new GridLayout(2, 1));
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		p2.add(jtf1);
		p2.add(jtf2);

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
		this.setSize(300, 150);
		this.setTitle("Select table to order");
		this.setVisible(true);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 150, height / 2 - 75);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb1) {

			OrderModel om = new OrderModel();

			String status = om.geStatusById(jtf1.getText());
			// System.out.print(status);
			if ((0 + "").equals(status)) {
				JOptionPane.showMessageDialog(null, "Sorry, the table is in use");
			} else {
				// String deskId=jtf1.getText().trim();
				new BookDetail(this);
				this.dispose();
				OrderModel em = new OrderModel();
				String params[] = { jtf1.getText() };
				String sql = "update status set deskstatus = 2 where deskid = ?";
				em.UpdateModel(sql, params);
			}
			this.dispose();
		} else if (arg0.getSource() == jb2) {
			this.dispose();
		}
	}

}