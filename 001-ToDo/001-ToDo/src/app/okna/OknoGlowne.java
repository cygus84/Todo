package app.okna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.menagery.MenagerZadan;
import app.modele.Zadanie;
import app.popupy.PoupZadanie;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OknoGlowne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTresc;
	private MenagerZadan zadania;
	
	public OknoGlowne() {
		setTitle("ToDo-001");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		
		JPanel panelFormularza = new JPanel();
		contentPane.add(panelFormularza, BorderLayout.SOUTH);
		panelFormularza.setLayout(new BorderLayout(0, 0));
		
		JButton bDodaj = new JButton("Dodaj");
		bDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajZadanie();
			}
		});
		panelFormularza.add(bDodaj, BorderLayout.EAST);
		
		tfTresc = new JTextField();
		tfTresc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelFormularza.add(tfTresc, BorderLayout.CENTER);
		tfTresc.setColumns(10);
		
		JScrollPane spZadania = new JScrollPane();
		contentPane.add(spZadania, BorderLayout.CENTER);
		
		JList<Zadanie> lZadania = new JList<Zadanie>();
		lZadania.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kliknietoWZadanie();
			}
		});
		zadania = new MenagerZadan(lZadania);
		lZadania.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spZadania.setViewportView(lZadania);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void dodajZadanie() {
		String tresc = tfTresc.getText();
		if(tresc.length() > 3) {
			zadania.add(tresc);
			tfTresc.setText("");
		}
	}
	
	private void kliknietoWZadanie() {
		int indeks = zadania.getIndeks();
		if(indeks >= 0) {
			PoupZadanie poup = new PoupZadanie(zadania.get(indeks));
			if(poup.getCzyUsunac()) {
				zadania.usunZadanie(indeks);
			}
		}
	}
	
}
