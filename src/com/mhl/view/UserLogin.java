package com.mhl.view;

import com.mhl.tools.*;
import com.mhl.view2.Window2;
import com.mhl.model.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class UserLogin extends JDialog implements ActionListener {
	JLabel jl1, jl2, jl3;
	JTextField jname;
	JPasswordField jpass;
	JButton jconfirm, jcancel;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		UserLogin ul = new UserLogin();
	}

	public UserLogin() {
		Container ct = this.getContentPane();
		this.setLayout(null);
		jl1 = new JLabel("Employee id: ");
		jl1.setFont(MyTools.f1);
		jl1.setBounds(60, 190, 150, 30);
		ct.add(jl1);
		jname = new JTextField(20);
		jname.setFont(MyTools.f1);
		jname.setBounds(180, 190, 120, 30);
		jname.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jname);

		jl2 = new JLabel("(User id)");
		jl2.setFont(MyTools.f2);
		jl2.setForeground(Color.red);
		jl2.setBounds(100, 210, 100, 30);
		//ct.add(jl2);

		jl3 = new JLabel("Password: ");
		jl3.setFont(MyTools.f1);
		jl3.setBounds(60, 240, 150, 30);
		ct.add(jl3);
		jpass = new JPasswordField(20);
		jpass.setFont(MyTools.f1);
		jpass.setBounds(180, 240, 120, 30);
		jpass.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpass);

		jconfirm = new JButton("Login");
		jconfirm.addActionListener(this);
		jconfirm.setFont(MyTools.f1);
		jconfirm.setBounds(110, 300, 70, 30);
		ct.add(jconfirm);

		jcancel = new JButton("Cancel");
		jcancel.addActionListener(this);
		jcancel.setFont(MyTools.f1);
		jcancel.setBounds(210, 300, 70, 30);
		ct.add(jcancel);
		BackImage bi = new BackImage();
		bi.setBounds(0, 0, 360, 360);
		ct.add(bi);
		
		this.setSize(360, 360);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 200, height / 2 - 200);
		this.setVisible(true);
	}

	public class BackImage extends JPanel {
		Image img;

		public BackImage() {
			try {
				img = ImageIO.read(new File("image/login.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, 360, 360, this);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jconfirm) {
			String uid = this.jname.getText().trim();
			String p = new String(this.jpass.getPassword());
			UserModel um = new UserModel();
			String empid = um.getEmpIdByInput(uid);
			String empname = um.getNameById(uid);
			if (empid != null) {
				String position = new String(um.checkUser(uid, p).trim());
					if ("Manager".equals(position) || position.equals("Boss") || position.equals("Director")) {
						new Window1();
						this.hide();
						String welcome = "Welcome--" + position;
						JOptionPane.showMessageDialog(this, welcome);
						this.dispose();
					} else if ("Cashier".equals(position) || position.equals("Captain")) {
						Window2 w2 = new Window2(empname, position);
						Thread a = new Thread(w2);
						a.start();
						this.hide();
						String welcome = "Welcome--" + position;
						JOptionPane.showMessageDialog(this, welcome);
						this.dispose();
					} else {
						JOptionPane.showMessageDialog(this, "Sorry! You do not have permission to login");
					}
			} else {
				JOptionPane.showMessageDialog(this, "Sorry! Your employee id or password is incorrect");
			}
		} else if (e.getSource() == jcancel){
			this.dispose();
		}
	}
}