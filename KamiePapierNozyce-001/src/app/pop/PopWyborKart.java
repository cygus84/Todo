package app.pop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.etykiety.EtykietaKarta;
import app.panele.PanelKart;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopWyborKart extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private PanelKart panelKart;

	public PopWyborKart() {
		setBounds(100, 100, 808, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("Wybierz karty");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
			panelKart = new PanelKart(Color.ORANGE, mouseAdapterKarty());
			contentPanel.add(panelKart, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Zatwierdz");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						zatwierdzWybor();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		setModal(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private MouseAdapter mouseAdapterKarty() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((EtykietaKarta) e.getSource()).aktulizacjaWyboru();
				panelKart.updateUI();
				System.out.println("Kliknieto w etykiete!");
			}
		};
	}
	
	private void zatwierdzWybor() {
		dispose();
	}
	
	public String getWybor() {
		return panelKart.getWybor();
	}

}
