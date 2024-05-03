package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainHub extends JFrame implements ActionListener {
	
	JButton button;
	JButton button2;
	
	MainHub(){
		button = new JButton();
		button.setBounds(0, 0, 100, 100);
		button.addActionListener(this);
		button.setText("Produit");
		
		button2 = new JButton();
		button2.setBounds(255, 0, 100, 100);
		button2.addActionListener(this);
		button2.setText("Quit");

		this.setTitle("Gestion de Stock");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(640,480);
		this.setVisible(true);
		this.add(button);
		this.add(button2);
	}

	public static void main(String[] args) {
		new MainHub();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			this.dispose();
			new TestWindows();
		}
		
		if(e.getSource()==button2) {
			this.dispose();
		}	
		
	}

}
