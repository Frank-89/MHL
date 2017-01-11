package com.mhl.view2;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.Timer;

import com.mhl.model.OrderModel;
import com.mhl.tools.ImagePanel;
import com.mhl.tools.MyTools;
import com.mhl.view.CostNum;
import com.mhl.view.EmpInfo;
import com.mhl.view.EmpLogin;
import com.mhl.view.MenuInfo;
import com.mhl.view.UserLogin;
import com.mhl.tools.*;

@SuppressWarnings({ "serial", "unused" })
public class Window2 extends JFrame implements ActionListener, MouseListener, Runnable {
	Image titleIcon, timeBg, p1_bg, p2_bg, p3_bg;
	JMenuBar jmb;
	JSplitPane jsp;
	JMenu jm1, jm2, jm3;
	JMenuItem jmi1, jmi2, jmi3, jmi4, jmi5, jmi6;
	ImageIcon jmi1_icon1, jmi2_icon2, jmi3_icon3, jmi4_icon4, jmi5_icon5, jmi6_icon6;
	JToolBar jtb;
	JButton jb1, jb2, jb3, jb4, jb5;
	JPanel jp1, jp2, jp3, jp4;
	JLabel showTime; 
	JLabel p2_jl1, p2_jl2, p2_jl3, p2_jl4, p2_jl5, p2_jl11;
	JLabel p1_jl1, p1_jl2, p1_jl3, p1_jl4, p1_jl5, p1_jl6, p1_jl7, p1_jl8, p1_jl9, p1_jl10, p1_jl11, p1_jl12, p1_jl13,
			p1_jl14, p1_jl15, p1_jl16, p1_jl17, p1_jl18, p1_jl19, p1_jl20, p1_jl21, p1_jl22, p1_jl23, p1_jl24, p1_jl25;
	CardLayout myCard;
	static String name = null;
	static String job = null;
	Timer t; 
	ImagePanel p1_bgImage, p2_bgImage, p3_bgImage;
	@SuppressWarnings("deprecation")
	Cursor myCursor = new Cursor(HAND_CURSOR);

	public static void main(String[] args) {
		Window2 w2 = new Window2(name, job);
		Thread a = new Thread(w2);
		a.start();
	}

	// menu
	public void initMenu() {
		// First menu
		jmi1_icon1 = new ImageIcon("image/jm1_icon1.jpg");
		jmi2_icon2 = new ImageIcon("image/jm1_icon2.jpg");
		jmi3_icon3 = new ImageIcon("image/jm1_icon3.jpg");
		jm1 = new JMenu("System");
		jm1.setFont(MyTools.f3);
		// Second menu
		jmi1 = new JMenuItem("Switch user", jmi1_icon1);
		jmi1.setFont(MyTools.f2);
		jmi1.addActionListener(this);
		jmi2 = new JMenuItem("Switch to the check out interface", jmi2_icon2);
		jmi2.setFont(MyTools.f2);
		jmi2.addActionListener(this);
		jmi3 = new JMenuItem("Exit", jmi3_icon3);
		jmi3.setFont(MyTools.f2);
		jmi3.addActionListener(this);

		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);

		jmi4_icon4 = new ImageIcon("image/toolBar_image/jb4.jpg");
		jm2 = new JMenu("Service");
		jm2.setFont(MyTools.f3);
		jmi4 = new JMenuItem("Customer service", jmi4_icon4);
		jmi4.setFont(MyTools.f2);
		jm2.add(jmi4);

		jmi6_icon6 = new ImageIcon("image/toolBar_image/jb6.jpg");
		jm3 = new JMenu("Help");
		jm3.setFont(MyTools.f3);
		jmi5 = new JMenuItem("System introduction", jmi6_icon6);
		jmi5.setFont(MyTools.f2);
		jm3.add(jmi5);

		jmb = new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);

		this.setJMenuBar(jmb);
	}

	// Tool bar
	public void initToolBar() {
		jtb = new JToolBar();
		jtb.setFloatable(false);
		jb1 = new JButton(new ImageIcon("image/jm1_icon1.jpg"));
		jb2 = new JButton(new ImageIcon("image/jm1_icon2.jpg"));
		jb3 = new JButton(new ImageIcon("image/jm1_icon3.jpg"));
		jb4 = new JButton(new ImageIcon("image/jm1_icon4.jpg"));
		jb5 = new JButton(new ImageIcon("image/toolBar_image/jb5.jpg"));

		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
	}

	public void initCenter() {
		jp1 = new JPanel(new BorderLayout());
		try {
			p1_bg = ImageIO.read(new File("image/orderindex.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		p1_bgImage = new ImagePanel(p1_bg);
		p1_bgImage.setLayout(new BorderLayout());
		try {
			p3_bg = ImageIO.read(new File("image/desk.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		p3_bgImage = new ImagePanel(p3_bg);
		p3_bgImage.setLayout(new GridLayout(5, 5));

		p1_jl1 = new JLabel(new ImageIcon("image/desk/1.jpg"));
		p1_jl2 = new JLabel(new ImageIcon("image/desk/2.jpg"));
		p1_jl3 = new JLabel(new ImageIcon("image/desk/3.jpg"));
		p1_jl4 = new JLabel(new ImageIcon("image/desk/4.jpg"));
		p1_jl5 = new JLabel(new ImageIcon("image/desk/5.jpg"));
		p1_jl6 = new JLabel(new ImageIcon("image/desk/6.jpg"));
		p1_jl7 = new JLabel(new ImageIcon("image/desk/7.jpg"));
		p1_jl8 = new JLabel(new ImageIcon("image/desk/8.jpg"));
		p1_jl9 = new JLabel(new ImageIcon("image/desk/9.jpg"));
		p1_jl10 = new JLabel(new ImageIcon("image/desk/10.jpg"));
		p1_jl11 = new JLabel(new ImageIcon("image/desk/11.jpg"));
		p1_jl12 = new JLabel(new ImageIcon("image/desk/12.jpg"));
		p1_jl13 = new JLabel(new ImageIcon("image/desk/13.jpg"));
		p1_jl14 = new JLabel(new ImageIcon("image/desk/14.jpg"));
		p1_jl15 = new JLabel(new ImageIcon("image/desk/15.jpg"));
		p1_jl16 = new JLabel(new ImageIcon("image/desk/16.jpg"));
		p1_jl17 = new JLabel(new ImageIcon("image/desk/17.jpg"));
		p1_jl18 = new JLabel(new ImageIcon("image/desk/18.jpg"));
		p1_jl19 = new JLabel(new ImageIcon("image/desk/19.jpg"));
		p1_jl20 = new JLabel(new ImageIcon("image/desk/20.jpg"));
		p1_jl21 = new JLabel(new ImageIcon("image/desk/21.jpg"));
		p1_jl22 = new JLabel(new ImageIcon("image/desk/22.jpg"));
		p1_jl23 = new JLabel(new ImageIcon("image/desk/23.jpg"));
		p1_jl24 = new JLabel(new ImageIcon("image/desk/24.jpg"));
		p1_jl25 = new JLabel(new ImageIcon("image/desk/25.jpg"));
		JLabel[] jlables = { p1_jl1, p1_jl2, p1_jl3, p1_jl4, p1_jl5, p1_jl6, p1_jl7, p1_jl8, p1_jl9, p1_jl10, p1_jl11,
				p1_jl12, p1_jl13, p1_jl14, p1_jl15, p1_jl16, p1_jl17, p1_jl18, p1_jl19, p1_jl20, p1_jl21, p1_jl22,
				p1_jl23, p1_jl24, p1_jl25 };

		String status[] = new String[25];
		OrderModel om = new OrderModel();
		boolean[] view = new boolean[25];
		for (int i = 0; i < 25; i++) {
			status[i] = om.geStatusById((i + 1) + "");
			//System.out.println(status[i]);
			if ("0" == status[i]) {
				view[i] = false;
			} else {
				view[i] = true;
			}
			//System.out.println(view[i]);
			jlables[i].setEnabled(view[i]);
			jlables[i].addMouseListener(this);
		}

		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		p3_bgImage.setLocation(width / 4, height / 4);
		p1_bgImage.add(p3_bgImage, "Center");
		jp1.add(p1_bgImage, "Center");
		jp1.add(p3_bgImage, "East");
		
		jp2 = new JPanel(new BorderLayout());
		try {
			p2_bg = ImageIO.read(new File("image/manage.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p2_bgImage = new ImagePanel(p2_bg);
		p2_bgImage.setLayout(new GridLayout(5, 2));
		p2_jl1 = new JLabel(new ImageIcon("image/center_image/label_1.gif"));
		p2_jl11 = new JLabel();
		p2_jl2 = new JLabel("Current user: ");
		p2_jl2.setFont(MyTools.f3);
		p2_jl3 = new JLabel(name);
		p2_jl3.setFont(MyTools.f1);
		p2_jl4 = new JLabel("Position: ");
		p2_jl4.setFont(MyTools.f3);
		p2_jl5 = new JLabel(job);
		p2_jl5.setFont(MyTools.f1);
		jb1 = new JButton("Reserve");
		jb1.setFont(MyTools.f5);
		jb1.setCursor(myCursor);
		jb1.addActionListener(this);
		jb2 = new JButton("Cancel reservation");
		jb2.setFont(MyTools.f5);
		jb2.setCursor(myCursor);
		jb2.addActionListener(this);
		jb3 = new JButton("Order");
		jb3.setFont(MyTools.f5);
		jb3.setCursor(myCursor);
		jb3.addActionListener(this);
		jb4 = new JButton("Check out");
		jb4.setFont(MyTools.f5);
		jb4.setCursor(myCursor);
		jb4.addActionListener(this);
		p2_bgImage.add(p2_jl1, "0");
		p2_bgImage.add(p2_jl11, "1");
		p2_bgImage.add(p2_jl2, "2");
		p2_bgImage.add(p2_jl3, "3");
		p2_bgImage.add(p2_jl4, "4");
		p2_bgImage.add(p2_jl5, "5");
		p2_bgImage.add(jb1, "6");
		p2_bgImage.add(jb2, "7");
		p2_bgImage.add(jb3, "8");
		p2_bgImage.add(jb4, "9");

		jp2.add(p2_bgImage, "Center");
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jp1, jp2);
		jsp.setDividerLocation(Toolkit.getDefaultToolkit().getScreenSize().width * 3 / 4);
		jsp.setDividerSize(0);
	}

	// Status bar
	@SuppressWarnings("deprecation")
	public void initEnd() {
		jp3 = new JPanel(new BorderLayout());
		t = new Timer(1000, this);
		showTime = new JLabel("当前时间：" + Calendar.getInstance().getTime().toLocaleString() + "   ");
		showTime.setFont(MyTools.f1);
		t.start();
		
		try {
			timeBg = ImageIO.read(new File("image/time_bg.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImagePanel ip1 = new ImagePanel(timeBg);
		ip1.setLayout(new BorderLayout());
		ip1.add(showTime, "East");
		jp3.add(ip1);
	}

	public Window2(String empname, String zhiwei) {
		try {
			titleIcon = ImageIO.read(new File("image/title.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		name = empname;
		job = zhiwei;
		
		this.initMenu();	
		this.initToolBar();	
		this.initCenter();	

		this.initEnd();
		Container ct = this.getContentPane();
		ct.add(jtb, "North");
		ct.add(jp3, "South");
		ct.add(jsp, "Center");

		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height - 40);
		this.setIconImage(titleIcon);
		this.setTitle("Man-Han House front desk management system");
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == p1_jl1) {
			this.p1_jl2.setEnabled(true);
		} else if (arg0.getSource() == p1_jl2) {
			this.p1_jl2.setEnabled(true);
		} else if (arg0.getSource() == p1_jl3) {
			this.p1_jl3.setEnabled(true);
		} else if (arg0.getSource() == p1_jl4) {
			this.p1_jl4.setEnabled(true);
		} else if (arg0.getSource() == p1_jl5) {
			this.p1_jl5.setEnabled(true);
		} else if (arg0.getSource() == p1_jl6) {
			this.p1_jl6.setEnabled(true);
		} else if (arg0.getSource() == p1_jl7) {
			this.p1_jl7.setEnabled(true);
		} else if (arg0.getSource() == p1_jl8) {
			this.p1_jl8.setEnabled(true);
		} else if (arg0.getSource() == p1_jl9) {
			this.p1_jl9.setEnabled(true);
		} else if (arg0.getSource() == p1_jl10) {
			this.p1_jl10.setEnabled(true);
		} else if (arg0.getSource() == p1_jl1) {
			this.p1_jl11.setEnabled(true);
		} else if (arg0.getSource() == p1_jl12) {
			this.p1_jl12.setEnabled(true);
		} else if (arg0.getSource() == p1_jl13) {
			this.p1_jl13.setEnabled(true);
		} else if (arg0.getSource() == p1_jl14) {
			this.p1_jl14.setEnabled(true);
		} else if (arg0.getSource() == p1_jl15) {
			this.p1_jl15.setEnabled(true);
		} else if (arg0.getSource() == p1_jl16) {
			this.p1_jl16.setEnabled(true);
		} else if (arg0.getSource() == p1_jl17) {
			this.p1_jl17.setEnabled(true);
		} else if (arg0.getSource() == p1_jl18) {
			this.p1_jl18.setEnabled(true);
		} else if (arg0.getSource() == p1_jl19) {
			this.p1_jl19.setEnabled(true);
		} else if (arg0.getSource() == p1_jl20) {
			this.p1_jl20.setEnabled(true);
		} else if (arg0.getSource() == p1_jl21) {
			this.p1_jl21.setEnabled(true);
		} else if (arg0.getSource() == p1_jl22) {
			this.p1_jl22.setEnabled(true);
		} else if (arg0.getSource() == p1_jl23) {
			this.p1_jl23.setEnabled(true);
		} else if (arg0.getSource() == p1_jl24) {
			this.p1_jl24.setEnabled(true);
		} else if (arg0.getSource() == p1_jl25) {
			this.p1_jl25.setEnabled(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == p1_jl1) {
			this.p1_jl2.setEnabled(false);
		} else if (arg0.getSource() == p1_jl2) {
			this.p1_jl2.setEnabled(false);
		} else if (arg0.getSource() == p1_jl3) {
			this.p1_jl3.setEnabled(false);
		} else if (arg0.getSource() == p1_jl4) {
			this.p1_jl4.setEnabled(false);
		} else if (arg0.getSource() == p1_jl5) {
			this.p1_jl5.setEnabled(false);
		} else if (arg0.getSource() == p1_jl6) {
			this.p1_jl6.setEnabled(false);
		} else if (arg0.getSource() == p1_jl7) {
			this.p1_jl7.setEnabled(false);
		} else if (arg0.getSource() == p1_jl8) {
			this.p1_jl8.setEnabled(false);
		} else if (arg0.getSource() == p1_jl9) {
			this.p1_jl9.setEnabled(false);
		} else if (arg0.getSource() == p1_jl10) {
			this.p1_jl10.setEnabled(false);
		} else if (arg0.getSource() == p1_jl1) {
			this.p1_jl11.setEnabled(false);
		} else if (arg0.getSource() == p1_jl12) {
			this.p1_jl12.setEnabled(false);
		} else if (arg0.getSource() == p1_jl13) {
			this.p1_jl13.setEnabled(false);
		} else if (arg0.getSource() == p1_jl14) {
			this.p1_jl14.setEnabled(false);
		} else if (arg0.getSource() == p1_jl15) {
			this.p1_jl15.setEnabled(false);
		} else if (arg0.getSource() == p1_jl16) {
			this.p1_jl16.setEnabled(false);
		} else if (arg0.getSource() == p1_jl17) {
			this.p1_jl17.setEnabled(false);
		} else if (arg0.getSource() == p1_jl18) {
			this.p1_jl18.setEnabled(false);
		} else if (arg0.getSource() == p1_jl19) {
			this.p1_jl19.setEnabled(false);
		} else if (arg0.getSource() == p1_jl20) {
			this.p1_jl20.setEnabled(false);
		} else if (arg0.getSource() == p1_jl21) {
			this.p1_jl21.setEnabled(false);
		} else if (arg0.getSource() == p1_jl22) {
			this.p1_jl22.setEnabled(false);
		} else if (arg0.getSource() == p1_jl23) {
			this.p1_jl23.setEnabled(false);
		} else if (arg0.getSource() == p1_jl24) {
			this.p1_jl24.setEnabled(false);
		} else if (arg0.getSource() == p1_jl25) {
			this.p1_jl25.setEnabled(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		this.showTime.setText("Current：" + Calendar.getInstance().getTime().toLocaleString() + "   ");
		if (e.getSource() == jb1) {
			new AddOrdered();
		} else if (e.getSource() == jb2) {
			new DelOrdered();
		} else if (e.getSource() == jb3) {
			new BookDish();
		} else if (e.getSource() == jb4) {
			new Accounts();
		} else if (e.getSource() == jmi1) {
			new UserLogin();
			this.dispose();
		} else if (e.getSource() == jmi2) {
			new Accounts();
		} else if (e.getSource() == jmi3) {
			System.exit(EXIT_ON_CLOSE);
		}
	}

	@Override
	public void run() {
		JLabel[] jlables = { p1_jl1, p1_jl2, p1_jl3, p1_jl4, p1_jl5, p1_jl6, p1_jl7, p1_jl8, p1_jl9, p1_jl10, p1_jl11,
				p1_jl12, p1_jl13, p1_jl14, p1_jl15, p1_jl16, p1_jl17, p1_jl18, p1_jl19, p1_jl20, p1_jl21, p1_jl22,
				p1_jl23, p1_jl24, p1_jl25 };
		for (int i = 0; i < jlables.length; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			p3_bgImage.add(jlables[i]);
			jlables[i].setCursor(myCursor);
		}
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
	}
}