package app.panele;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PanelPodsumowanie extends JPanel {

	private static final long serialVersionUID = 1L;
	private int punktyGracza;
	private int punktyKomputera;
	private JLabel eWynik;
	private JLabel ePunkty;
	private JLabel eOpis;
	
	public PanelPodsumowanie() {
		ustaw("KNPKP", "KNPKP");
	}
	
	public PanelPodsumowanie(String wyboryGracza, String wyboryKomputera) {
		ustaw(wyboryGracza, wyboryKomputera);
	}

	private void ustaw(String wyboryGracza, String wyboryKomputera) {
		setBackground(Color.GRAY);
		setLayout(new BorderLayout(0, 0));
		
		eWynik = new JLabel("");
		eWynik.setFont(new Font("Tahoma", Font.BOLD, 20));
		eWynik.setHorizontalAlignment(SwingConstants.CENTER);
		add(eWynik, BorderLayout.NORTH);
		
		ePunkty = new JLabel("");
		ePunkty.setHorizontalAlignment(SwingConstants.CENTER);
		ePunkty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(ePunkty, BorderLayout.SOUTH);
		
		eOpis = new JLabel("");
		eOpis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(eOpis, BorderLayout.CENTER);
	}
	
	private String wynikRundy(String wybor) {
		String wynik = "";
		switch(wybor) {
			case "KP":
				wynik = "papier owjija kamien";
				punktyKomputera += 3;
				break;
			case "KN":
				wynik = "kamien tempi nozyczki";
				punktyGracza += 3;
				break;
			case "PK":
				wynik = "papier owjija kamien";
				punktyGracza += 3;
				break;
			case "PN":
				wynik = "nozyczki tna papier";
				punktyKomputera += 3;
				break;
			case "NK":
				wynik = "kamien tempi nozyczki";
				punktyKomputera += 3;
				break;
			case "NP":
				wynik = "nozyczki tna papier";
				punktyGracza += 3;
				break;
			default:
				wynik = "remis";
				punktyGracza += 1;
				punktyKomputera += 1;
				break;
		}
		return wynik;
	}
	
	private String nazwa(char znak) {
		String wynik = "";
		switch(znak){
			case 'K':
				wynik = "kamien";
				break;
			case 'P':
				wynik = "papier";
				break;
			case 'N':
				wynik = "nozyczki";
				break;				
		}
		return wynik;
	}

	public void pokazPodsumowanie(String wyboryGracza, String wyboryKomputera) {
		punktyGracza = 0;
		punktyKomputera = 0;
		String opis = "";
		for(int i = 0; i < 5; i++) {
			opis += "<br>" + nazwa(wyboryGracza.charAt(i)) + " vs " + nazwa(wyboryKomputera.charAt(i)) + " = " +  wynikRundy("" + wyboryGracza.charAt(i) + wyboryKomputera.charAt(i)); 
		}
		String wynik = "";
		if(punktyGracza > punktyKomputera) {
			wynik = "Wygrana Gracza";
			setBackground(Color.GREEN);
		} else if(punktyGracza < punktyKomputera) {
			wynik = "Wygrana Komputera";
			setBackground(Color.RED);
		} else {
			wynik = "Remis";
			setBackground(Color.GRAY);
		}
		eWynik.setText(wynik);
		eOpis.setText("<html>" + opis + "</html>");
		ePunkty.setText(punktyGracza + " : " + punktyKomputera);
		this.updateUI();
	}
}
