package app.renderery;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import app.modele.Zadanie;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

@SuppressWarnings("serial")
public class RendererZadanie01 extends JLabel implements ListCellRenderer<Zadanie>{
	
	public RendererZadanie01() {
		super();
		setOpaque(true);
		setBackground(new Color(255, 128, 64));
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Tahoma", Font.PLAIN, 14));
		setText("Zadanie001");
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Zadanie> list, Zadanie zadanie, int index,
			boolean isSelected, boolean cellHasFocus) {
		if(isSelected) {
			setBackground(Color.GRAY);
		} else {
			setBackground(new Color(255, 128, 64));
		}
		setText(zadanie.getTresc());
		return this;
	}

}
