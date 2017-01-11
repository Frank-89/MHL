package com.mhl.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import com.mhl.tools.*;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Chart extends JPanel {
	JPanel p1;
	Image chart;

	public Chart() {
		try {
			chart = ImageIO.read(new File("image/chart.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImagePanel ip = new ImagePanel(chart);
		p1.add(ip);
		this.setLayout(new BorderLayout());
		this.add(p1, "Center");
		this.setVisible(true);
	}
}