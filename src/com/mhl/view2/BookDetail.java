package com.mhl.view2;

import java.awt.*;

import javax.swing.*;
import javax.swing.JDialog;

import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;

@SuppressWarnings("serial")
public class BookDetail extends JDialog implements ActionListener {

	JPanel p1, p2, p3;
	JTextField jtf0, jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9;
	JTextField tf0, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
	JButton jb1, jb2;
	String deskid, bookid;

	public BookDetail(BookDish bd) {
		super();
		deskid = bd.jtf1.getText().trim();
		bookid = bd.jtf2.getText().trim();
		
		p1 = new JPanel(new GridLayout(9, 1));
		p2 = new JPanel(new GridLayout(9, 1));
		
		jtf1 = new JTextField("foodid", 20);
		jtf2 = new JTextField(20);
		jtf3 = new JTextField(20);
		jtf4 = new JTextField(20);
		jtf5 = new JTextField(20);
		jtf6 = new JTextField(20);
		jtf7 = new JTextField(20);
		jtf8 = new JTextField(20);
		jtf9 = new JTextField(20);
		
		tf1 = new JTextField("foodnum", 20);
		tf2 = new JTextField(20);
		tf3 = new JTextField(20);
		tf4 = new JTextField(20);
		tf5 = new JTextField(20);
		tf6 = new JTextField(20);
		tf7 = new JTextField(20);
		tf8 = new JTextField(20);
		tf9 = new JTextField(20);
		
		p1.add(jtf1);
		p1.add(jtf2);
		p1.add(jtf3);
		p1.add(jtf4);
		p1.add(jtf5);
		p1.add(jtf6);
		p1.add(jtf7);
		p1.add(jtf8);
		p1.add(jtf9);
		p2.add(tf1);
		p2.add(tf2);
		p2.add(tf3);
		p2.add(tf4);
		p2.add(tf5);
		p2.add(tf6);
		p2.add(tf7);
		p2.add(tf8);
		p2.add(tf9);
		
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
		this.add(p2, "East");
		this.add(p3, "South");
		this.setSize(600, 400);
		this.setTitle("Add menu");
		this.setVisible(true);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 300, height / 2 - 200);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb1) {
			String sql = "insert into bookdetail values(?, ?, ?, ?)";
			String[] params1 = { deskid, bookid, jtf2.getText(), tf2.getText() };
			String[] params2 = { deskid, bookid, jtf3.getText(), tf3.getText() };
			String[] params3 = { deskid, bookid, jtf4.getText(), tf4.getText() };
			String[] params4 = { deskid, bookid, jtf5.getText(), tf5.getText() };
			String[] params5 = { deskid, bookid, jtf6.getText(), tf6.getText() };
			String[] params6 = { deskid, bookid, jtf7.getText(), tf7.getText() };
			String[] params7 = { deskid, bookid, jtf8.getText(), tf8.getText() };
			String[] params8 = { deskid, bookid, jtf9.getText(), tf9.getText() };
			String[][] params = { params1, params2, params3, params4, params5, params6, params7, params8 };
			OrderModel om = new OrderModel();
			for (int i = 0; i < params.length; i++) {
				om.UpdateModel(sql, params[i]);
			}
			String sql2 = "insert into bookdish values(?, ?)";
			String[] params9 = { deskid, bookid };
			OrderModel om2 = new OrderModel();
			om2.UpdateModel(sql2, params9);
			JOptionPane.showMessageDialog(null, "Congratulations! Added successfully!");
			this.dispose();
		} else if (arg0.getSource() == jb2) {
			this.dispose();
		}
	}
}