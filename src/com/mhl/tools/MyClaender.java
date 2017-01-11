package com.mhl.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyClaender extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		MyClaender claender = new MyClaender();
	}

	private Date date = new Date();

	private GregorianCalendar gregorianCalendar = new GregorianCalendar();

	private String[] stringWeek = new String[] { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

	private String[] stringWeekCn = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	private String[] stringMonth = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct",
			"Nov", "Dec" };
	private String[] strSysTime = new String[6];

	private String[] strSysNowTime = new String[6];

	private JButton[] buttonDay = new JButton[42];
	private JButton[] buttonWeek = new JButton[7];
	private JLabel labelMonth = new JLabel();
	private JButton buttonToday = new JButton();
	private JButton buttonLastMonth = new JButton();
	private JButton buttonNextMonth = new JButton();
	@SuppressWarnings("rawtypes")
	private JComboBox comboYear = new JComboBox();
	@SuppressWarnings("rawtypes")
	private JComboBox comboMonth = new JComboBox();

	@SuppressWarnings({ "unchecked" })
	public MyClaender() {
		super("Claender");
		getContentPane().setLayout(new GridLayout(8, 7, 3, 5));
		setBounds(250, 200, 530, 360);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		comboYear.setForeground(new Color(0, 0, 255));
		comboYear.setFont(new Font("", Font.PLAIN, 14));
		for (int y = 1900; y < 2101; y++) {
			comboYear.addItem("  " + new Integer(y).toString());
		}
		getContentPane().add(comboYear);
		comboYear.addItemListener(this);

		final JLabel labelYear = new JLabel();
		labelYear.setForeground(Color.BLUE);
		labelYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(labelYear);
		labelYear.setText("    year");

		comboMonth.setForeground(new Color(0, 0, 255));
		comboMonth.setFont(new Font("", Font.PLAIN, 14));
		for (int m = 1; m < 13; m++) {
			comboMonth.addItem("    " + new Integer(m).toString());
		}
		getContentPane().add(comboMonth);
		comboMonth.addItemListener(this);

		getContentPane().add(labelMonth);
		labelMonth.setForeground(Color.BLUE);
		labelMonth.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelMonth.setText("    month");

		getContentPane().add(buttonLastMonth);
		buttonLastMonth.setForeground(Color.BLUE);
		buttonLastMonth.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonLastMonth.setText("Last month");
		buttonLastMonth.addActionListener(this);

		getContentPane().add(buttonToday);
		buttonToday.setForeground(Color.BLUE);
		buttonToday.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonToday.setText("Today");
		buttonToday.addActionListener(this);

		getContentPane().add(buttonNextMonth);
		buttonNextMonth.setForeground(Color.BLUE);
		buttonNextMonth.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonNextMonth.setText("Next month");
		buttonNextMonth.addActionListener(this);

		for (int i = 0; i < 7; i++) {
			buttonWeek[i] = new JButton();
			if (i == 0 || i == 6) {
				buttonWeek[i].setForeground(Color.RED);
			} else {
				buttonWeek[i].setForeground(Color.BLUE);
			}
			buttonWeek[i].setFont(new Font("Times New Roman", Font.PLAIN, 12));
			buttonWeek[i].setText(stringWeekCn[i]);
			getContentPane().add(buttonWeek[i]);
		}

		for (int i = 0; i < 42; i++) {
			buttonDay[i] = new JButton();
			buttonDay[i].setText("");
			getContentPane().add(buttonDay[i]);
		}
		this.setResizable(false);
		getSysNowTimeInfo();
		setNowDate();
		setNowDate();
		this.setSize(800, 450);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
	}

	public void setSysDate(int year, int month) {
		gregorianCalendar.set(year, month, 1);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == buttonToday) {
			setNowDate();
			//setNowDate();
		} else if (ae.getSource() == buttonLastMonth) {
			setDate(-1);
		} else {
			setDate(1);
		}
	}

	public void itemStateChanged(ItemEvent arg0) {
		setDate(0);
	}

	public void getSysNowTimeInfo() {
		date = gregorianCalendar.getTime();
		strSysNowTime = (date + "").split(" ");
	}

	public void getSysTimeInfo() {
		date = gregorianCalendar.getTime();
		strSysTime = (date + "").split(" ");
	}

	public int getNowMonth() {
		int month = 0;
		for (int i = 0; i < 12; i++) {
			if (strSysNowTime[1].equalsIgnoreCase(stringMonth[i])) {
				month = i;
				break;
			}
		}
		return month;
	}

	public int weekStrat(String strWeek) {
		int strat = 0;
		for (int i = 0; i < 7; i++) {
			if (strWeek.equalsIgnoreCase(stringWeek[i])) {
				strat = i;
				break;
			}
		}
		return strat;
	}

	public void setNowDate() {
		setSysTime(getNowYear(), getNowMonth());
		getSysTimeInfo();
		setDayNull();
		getDay(getMonthDays(getNowYear(), getNowMonth() - 1), getMonthDays(getNowYear(), getNowMonth()),
				weekStrat(strSysTime[0]), getNowDay());
		comboYear.setSelectedIndex(getNowYear() - 1900);
		comboMonth.setSelectedIndex(getNowMonth());
	}

	public void setDate(int move) {
		setSysTime(getYear(), getMonth() + move);
		getSysTimeInfo();
		setDayNull();
		getDay(getMonthDays(getYear(), getMonth() + move - 1), getMonthDays(getYear(), getMonth() + move),
				weekStrat(strSysTime[0]), -1);
		if (move != 0) {
			if (getMonth() == 0 && move < 0) {
				move = 11;
				comboYear.setSelectedIndex(getYear() - 1901);
			} else if (getMonth() == 11 && move > 0) {
				move = -11;
				comboYear.setSelectedIndex(getYear() - 1899);
			} else {
				comboYear.setSelectedIndex(getYear() - 1900);
			}
			comboMonth.setSelectedIndex(getMonth() + move);
		}
	}

	public void setSysTime(int year, int month) {
		gregorianCalendar.set(year, month, 1);
	}

	public int getNowYear() {
		return Integer.parseInt(strSysNowTime[5]);
	}

	public int getNowDay() {
		return Integer.parseInt(strSysNowTime[2]);
	}

	public int getYear() {
		return comboYear.getSelectedIndex() + 1900;
	}

	public int getMonth() {
		return comboMonth.getSelectedIndex();
	}

	public void setDayNull() {
		for (int d = 0; d < 42; d++) {
			buttonDay[d].setText("");
		}
	}

	public void getDay(int lastMonDays, int monthDays, int startWeek, int day) {
		for (int d = 0; d < startWeek + 1; d++) {
			buttonDay[d].setForeground(Color.GRAY);
			buttonDay[d].setText((lastMonDays - startWeek) + d + 1 + "");
		}
		for (int d = startWeek; d < startWeek + monthDays; d++) {
			if ((d - startWeek + 1) == day) {
				buttonDay[d].setForeground(Color.blue);
			} else if (d % 7 == 0 || d % 7 == 6) {
				buttonDay[d].setForeground(Color.RED);
			} else {
				buttonDay[d].setForeground(Color.BLACK);
			}

			buttonDay[d].setText(d - startWeek + 1 + "");
		}
		for (int d = monthDays + startWeek; d < 42; d++) {
			buttonDay[d].setForeground(Color.GRAY);
			buttonDay[d].setText(d - (monthDays + startWeek) + 1 + "");
		}
	}

	public int getMonthDays(int year, int month) {
		switch (month) {
		case 3:
		case 5:
		case 8:
		case 10:
			return 30;
		case 1:
			if (gregorianCalendar.isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		default:
			return 31;
		}
	}
}