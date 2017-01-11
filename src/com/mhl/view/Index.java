package com.mhl.view;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Index extends JWindow implements Runnable {
	// define components about progress bar
	JProgressBar jpb;		
	JLabel jl1;				
	int width, height;		// get the size of screen

	public static void main(String[] args) {
		Index index = new Index();
		Thread t = new Thread(index);		// create index thread
		t.start();							// start the thread
	}

	// constructor
	public Index() {
		// create a JLabel jl1 with image
		jl1 = new JLabel(new ImageIcon("image/index/index.gif"));
		// create a JProgerssBar jpb
		jpb = new JProgressBar();
		// set jpb's attributes
		jpb.setStringPainted(true);			
		jpb.setIndeterminate(false);		
		jpb.setBorderPainted(false);		
		jpb.setBackground(Color.pink);		
		// add components
		this.add(jl1, BorderLayout.NORTH);
		this.add(jpb, BorderLayout.SOUTH);
		// set window's attributes
		this.setSize(400, 263);
		// set window's display location
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 200, height / 2 - 150);

		this.setVisible(true);
	}


	public void run() {
		int[] progressValue = { 0, 1, 5, 8, 14, 17, 26, 35, 38, 43, 49, 56, 65, 71, 75, 78, 86, 94, 98, 99, 100 };
		for (int i = 0; i < progressValue.length; i++) {
			try {
				Thread.sleep(1000);		// sleep 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jpb.setValue(progressValue[i]);		
		}
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new UserLogin();
			this.dispose();
			break;
		}
	}
}