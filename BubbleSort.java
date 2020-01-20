package claseInterfaz;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


public class interf extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JPanel panelPrinc;
	private JLabel label1;
	private Integer stepTime = 100;
	private boolean comenzar = false;
	
	
	public interf(String name){
		
		super(name);
		this.setSize(600,600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.LIGHT_GRAY);
		this.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panelPrinc = new JPanel();
		panelPrinc.setBackground(Color.LIGHT_GRAY);
		panelPrinc.setVisible(true);
		panelPrinc.setLayout(null);
		this.add(panelPrinc);
		
		
		boton1 = new JButton();
		boton1.setText("<<<<");
		boton1.setBounds(145, 100, 100, 30);
		boton1.setEnabled(true);
		boton1.setVisible(true);
		boton1.setLayout(null);
		boton1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (stepTime >= 10)
					stepTime = stepTime - 10;
				label1.setText(stepTime.toString());
			}
		});
		
		
		boton2 = new JButton();
		boton2.setText(">>>>");
		boton2.setBounds(330, 100, 100, 30);
		boton2.setEnabled(true);
		boton2.setVisible(true);
		boton2.setLayout(null);
		boton2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (stepTime <= 1990)
					stepTime = stepTime + 10;
				label1.setText(stepTime.toString());
			}
		});
		
		
		boton3 = new JButton();
		boton3.setText("Salir");
		boton3.setBounds(300, 500, 100, 30);
		boton3.setEnabled(true);
		boton3.setVisible(true);
		boton3.setLayout(null);
		boton3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				cerrar();
			}
		});
		
		boton4 = new JButton();
		boton4.setText("Ordenar");
		boton4.setBounds(175, 500, 100, 30);
		boton4.setEnabled(true);
		boton4.setVisible(true);
		boton4.setLayout(null);
		boton4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				comenzar = true;
				repaint();
			}
		});
		
		label1 = new JLabel();
		label1.setText(stepTime.toString());
		label1.setBounds(270, 100, 50, 30);
		label1.setLayout(null);
		label1.setFont(new Font("Arial", 20, 20));
		
		panelPrinc.add(label1);
		panelPrinc.add(boton1);
		panelPrinc.add(boton2);
		panelPrinc.add(boton3);
		panelPrinc.add(boton4);
		this.repaint();
	}
	
	private void cerrar(){
		super.dispose();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawRect(96,196, 404, 204);
		
		
		int[] arr = new int[50];
		for (int index = 0; index < arr.length; index++){
			arr[index] = (int) (Math.random() * 200);
		}	
		
		
		while(comenzar == true){
			int aux = 0;
			for(int z = 1; z < arr.length; ++z) {
				for(int v = 0; v < (arr.length - z); ++v) {
					
					//MOSTRAR EL ARREGLO 
				  	int ind = 0;
				  	g.setColor(Color.LIGHT_GRAY);
		        	g.fillRect(97,197,402,202);
				  	for (int index = 0; index < arr.length; index++){
				  		if (index == v){
				  			g.setColor(Color.RED);
				  			g.fillRect(100 + ind, 200, 5, arr[index]);
				  			g.fillRect(100 + ind + 8, 200, 5, arr[index + 1]);
				  		}
				  		else{ 
				  			if (index - 1 != v ){
				  				g.setColor(Color.BLUE);
				  				g.fillRect(100 + ind, 200, 5, arr[index]);
				  			}
				  		}
				  		
				  		ind = ind + 8;
				  	} 
				  	
				  	//INTERCAMBIO DEL ALGORITMO
				  	
			        if(arr[v] > arr[v+1]){
			        	aux = arr[v];
			            arr[v] = arr[v + 1];
			            arr[v + 1] = aux;
			        }
			        
			        // PARO LA EJECUCION EL TIEMPO INDICADO EN EL LABEL (ENTRE LOS BOTONES)
			        try {
			        	Thread.sleep(stepTime);
			        }
			        catch (Exception e) {
			        	
			        }
			    }
			}
			comenzar = false;
		}
			int ind = 0;
			for (int h = 0; h < arr.length ; h++){
				g.fillRect(100 + ind, 200, 5, arr[h]);
				ind = ind + 8;
			}
}
	
	
	public static void main( String[] args ) {
		new interf("Bubble Sort");
	}

}
