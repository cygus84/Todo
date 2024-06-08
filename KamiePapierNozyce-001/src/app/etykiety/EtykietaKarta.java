package app.etykiety;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class EtykietaKarta extends JLabel {
	private String[] wybory = {"K", "P", "N"};
	private int indeks;
	
	public EtykietaKarta() {
		ustaw(Color.YELLOW, null);
	}
	
	public EtykietaKarta(Color kolor) {
		ustaw(kolor, null);
	}
	
	public EtykietaKarta(Color kolor, MouseAdapter mouseAdapter) {
		ustaw(kolor, mouseAdapter);
	}
	
	private void ustaw(Color kolor, MouseAdapter mouseAdapter) {
		addMouseListener(mouseAdapter);
		indeks = 0;
		setOpaque(true);
		setBackground(kolor);
		setHorizontalAlignment(SwingConstants.CENTER);
		aktulizacjaWyboru();
		setFont(new Font("Tahoma", Font.BOLD, 99));
		setPreferredSize(new Dimension(150, 200));
	}
	
	public void aktulizacjaWyboru() {
		int tmp = indeks + 1;
		if(tmp >= wybory.length) {
			indeks = 0;
		} else {
			indeks = tmp;
		}
		setText(wybory[indeks]);
	}

}
