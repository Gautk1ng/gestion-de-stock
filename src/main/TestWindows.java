package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestWindows extends JFrame implements ActionListener {
	
	JButton home;
	
	TestWindows() {
		home = new JButton();
		home.setBounds(0,0,100,100);
		home.addActionListener(this);
		home.setText("go home");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(420,420);
		this.setVisible(true);
		this.add(home);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new MainPage();
		
	}

}
