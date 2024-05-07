package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class Produit extends JFrame implements ActionListener {
	
	private JButton hubButton;
	private JButton addButton;
	private JButton modButton;
	private JButton delButton;
	
	private JTextField idField;
	private JTextField nameField;
	private JTextField stockField;
	private JTextField prixField;
	
	Produit(){
		
		addButton = new JButton();
		addButton.setBounds(10,10,75,30);
		addButton.setText("Ajouter");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct();
			}
		});
		
		modButton = new JButton();
		modButton.setBounds(90,10,85,30);
		modButton.setText("Modifier");
		modButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modProduct();
			}
		});
		
		delButton = new JButton();
		delButton.setBounds(180,10,100,30);
		delButton.setText("Supprimer");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delProduct();
			}
		});
		
		hubButton = new JButton();
		hubButton.setBounds(555,10,60,30);
		hubButton.addActionListener(this);
		hubButton.setText("Exit");
		
		JLabel idLabel = new JLabel();
		JLabel nameLabel = new JLabel();
		JLabel stockLabel = new JLabel();
		JLabel prixLabel = new JLabel();
		
		idField = new JTextField();
		idField.setBounds(100,105,150,40);
		idLabel.setText("ID Number :");
		idLabel.setBounds(100,70,100,40);
		
		nameField = new JTextField();
		nameField.setBounds(375,105,150,40);
		nameLabel.setText("Produit Nom :");
		nameLabel.setBounds(375,70,100,40);
		
		stockField = new JTextField();
		stockField.setBounds(100,245,150,40);
		stockLabel.setText("Nb Stock :");
		stockLabel.setBounds(100,210,100,40);
		
		prixField = new JTextField();
		prixField.setBounds(375,245,150,40);
		prixLabel.setText("Prix :");
		prixLabel.setBounds(375,210,100,40);
		
		
		this.setLayout(null);
		
		this.add(hubButton);
		this.add(addButton);
		this.add(modButton);
		this.add(delButton);
		
		this.add(idField);
		this.add(nameField);
		this.add(stockField);
		this.add(prixField);
		
		this.add(idLabel);
		this.add(nameLabel);
		this.add(stockLabel);
		this.add(prixLabel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640,480);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==hubButton) {
			this.dispose();
			new MainHub();
		}
	
	}
	
	private void addProduct() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/gestion_de_stock", "root", "");
			
			String query = "INSERT INTO produits (ID_Produits, Nom_produit, Stock, Prix) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			int id = Integer.parseInt(idField.getText());
			String name = nameField.getText();
			int stock = Integer.parseInt(stockField.getText());
			float prix = Float.parseFloat(prixField.getText());
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, stock);
			pstmt.setFloat(4, prix);
			
			int rowsAffected = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(this, "Produit, stock et prix ajouté avec succès");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout: " + ex.getMessage());
		}
	}
	
	private void modProduct() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/gestion_de_stock", "root", "");
			
			String query = "UPDATE produits set Nom_produit=?, Stock=?, Prix=? WHERE ID_Produits=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			int id = Integer.parseInt(idField.getText());
			String name = nameField.getText();
			int stock = Integer.parseInt(stockField.getText());
			float prix = Float.parseFloat(prixField.getText());
			
			pstmt.setInt(4, id);
			pstmt.setString(1, name);
			pstmt.setInt(2, stock);
			pstmt.setFloat(3, prix);
			
			int rowsAffected = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(this, "Produit, stock et prix modifié avec succès");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erreur lors du modification: " + ex.getMessage());
		}
	}
	
	private void delProduct() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/gestion_de_stock", "root", "");
			
			String query = "DELETE FROM produits WHERE ID_Produits=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			int id = Integer.parseInt(idField.getText());
			
			pstmt.setInt(1, id);
			
			int rowsAffected = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(this, "Le Produit à était suprimée avec succès");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erreur lors du suppresion: " + ex.getMessage());
		}
	}

}
