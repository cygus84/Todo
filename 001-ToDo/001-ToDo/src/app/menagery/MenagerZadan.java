package app.menagery;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import app.modele.Zadanie;
import app.renderery.RendererZadanie01;

@SuppressWarnings("serial")
public class MenagerZadan extends DefaultListModel<Zadanie> {
	
	private JList<Zadanie> lista;

	public MenagerZadan(JList<Zadanie> lista) {
		super();
		// dodanie renderera
		lista.setCellRenderer(new RendererZadanie01());
		lista.setModel(this);
		this.lista = lista;
	}
	
	public void add(String tresc) {
		this.addElement(new Zadanie(tresc));
		lista.updateUI();// aktulizacja listy
	}

	public int getIndeks() {
		return lista.getSelectedIndex();
	}

	public void usunZadanie(int indeks) {
		this.remove(indeks);
		lista.updateUI();
	}
	
	
}
