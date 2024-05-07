package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainHub extends JFrame implements ActionListener {
	
	JButton produitButton;
	JButton fournisseurButton;
	JButton ventesButton;
	JButton rapportsButton;
	JButton quitButton;
	
	MainHub(){
		produitButton = new JButton();
		produitButton.setBounds(160, 130, 140, 45);
		produitButton.addActionListener(this);
		produitButton.setText("Produit");
		produitButton.setFont(new Font("Ariel",Font.BOLD,24));
		
		fournisseurButton = new JButton();
		fournisseurButton.setBounds(330,130,185,45);
		fournisseurButton.addActionListener(this);
		fournisseurButton.setText("Fournisseur");
		fournisseurButton.setFont(new Font("Ariel",Font.BOLD,24));
		fournisseurButton.setEnabled(false);
		
		ventesButton = new JButton();
		ventesButton.setBounds(160,190,135,45);
		ventesButton.addActionListener(this);
		ventesButton.setText("Ventes");
		ventesButton.setFont(new Font("Ariel",Font.BOLD,24));
		ventesButton.setEnabled(false);

		rapportsButton = new JButton();
		rapportsButton.setBounds(330,190,140,45);
		rapportsButton.addActionListener(this);
		rapportsButton.setText("Rapports");
		rapportsButton.setFont(new Font("Ariel",Font.BOLD,24));
		rapportsButton.setEnabled(false);
		
		quitButton = new JButton();
		quitButton.setBounds(250, 350, 140, 45);
		quitButton.addActionListener(this);
		quitButton.setText("Quitter");
		quitButton.setFont(new Font("Ariel",Font.BOLD,24));

		this.setTitle("Gestion de Stock");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(640,480);
		this.setVisible(true);
		this.add(produitButton);
		this.add(fournisseurButton);
		this.add(ventesButton);
		this.add(rapportsButton);
		this.add(quitButton);
	}

	public static void main(String[] args) {
		new MainHub();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==produitButton) {
			this.dispose();
			new Produit();
		}
		
		if(e.getSource()==quitButton) {
			this.dispose();
		}	
		
	}

}
