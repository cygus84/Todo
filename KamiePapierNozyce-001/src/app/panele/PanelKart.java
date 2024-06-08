package app.panele;

import javax.swing.JPanel;

import app.etykiety.EtykietaKarta;

import java.awt.Color;
import java.awt.event.MouseAdapter;

public class PanelKart extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelKart() {
		ustaw(Color.DARK_GRAY, null);
	}
	
	public PanelKart(Color kolor) {
		ustaw(kolor, null);
	}
	
	public PanelKart(Color kolor, MouseAdapter mouseAdapter) {
		ustaw(kolor, mouseAdapter);
	}
	
	private void ustaw(Color kolor, MouseAdapter mouseAdapter) {
		setBackground(new Color(128, 255, 255));
		for(int i = 0; i < 5; i++) {
			add(new EtykietaKarta(kolor, mouseAdapter));
		}
	}

	public String getWybor() {
		String wybor = "";
		for(int i = 0; i < 5; i++) {
			wybor += ((EtykietaKarta) this.getComponent(i)).getText();
		}
		return wybor;
	}

	public void pokazWybory(String wyboryGracza) {
		for(int i = 0; i < 5; i++) {
			((EtykietaKarta) this.getComponent(i)).setText(wyboryGracza.charAt(i) + "");
		}
	}

}
