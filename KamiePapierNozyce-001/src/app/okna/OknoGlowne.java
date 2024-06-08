package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.narzedzia.Genrator;
import app.panele.PanelKart;
import app.panele.PanelPodsumowanie;
import app.pop.PopWyborKart;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoGlowne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelKart panelKartGracza;
	private PanelKart panelKartKomputera;
	private PanelPodsumowanie panelPodsumowanie;

	public OknoGlowne() {
		setTitle("PapierNozyceKamien-001");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1153, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAkcji = new JPanel();
		panelAkcji.setBackground(new Color(255, 255, 0));
		contentPane.add(panelAkcji, BorderLayout.NORTH);
		
		JButton pPojedynek = new JButton("Pojedynek");
		pPojedynek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowyPojedynek();
			}
		});
		panelAkcji.add(pPojedynek);
		
		JPanel panelGlowny = new JPanel();
		panelKartGracza = new PanelKart(Color.ORANGE);
		panelKartKomputera = new PanelKart(Color.YELLOW);
		panelGlowny.add(panelKartGracza);
		panelGlowny.add(panelKartKomputera);
		contentPane.add(panelGlowny, BorderLayout.CENTER);
		panelGlowny.setLayout(new GridLayout(2, 0, 5, 5));
		
		panelPodsumowanie = new PanelPodsumowanie();
		contentPane.add(panelPodsumowanie, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	private void nowyPojedynek() {
		PopWyborKart popWyborKart = new PopWyborKart();
		String wyboryGracza = popWyborKart.getWybor();
		String wyboryKomputera = Genrator.wyboryKomputera();
		System.out.println("Wybor gracza: " + wyboryGracza);
		System.out.println("Wybory komputera: " + wyboryKomputera);
		panelKartGracza.pokazWybory(wyboryGracza);
		panelKartKomputera.pokazWybory(wyboryKomputera);
		panelPodsumowanie.pokazPodsumowanie(wyboryGracza, wyboryKomputera);
	}
}
