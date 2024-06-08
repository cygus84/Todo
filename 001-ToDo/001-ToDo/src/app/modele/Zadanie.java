package app.modele;

public class Zadanie {

	private String tresc;

	public Zadanie() {
		ustaw("Zadanie0");
	}

	public Zadanie(String tresc) {
		ustaw(tresc);
	}

	private void ustaw(String tresc) {
		this.tresc = tresc;
	}

	public String getTresc() {
		return tresc;
	}

	@Override
	public String toString() {
		return "Zadanie [tresc=" + tresc + "]";
	}

}
