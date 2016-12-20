package lt.kvk.i9_2.jauga_dovydas.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Daiktas {
	private StringProperty id;
	private  StringProperty parduotuve;
	private StringProperty pavadinimas;
	private IntegerProperty kiekis;
	private IntegerProperty kiekisUzsak;
	private FloatProperty kaina;
	private StringProperty spalva;

	public Daiktas(String nr,String pard, String pav, int kiek, int kiekisUzs, float kain, String spalv) {
		parduotuve = new SimpleStringProperty(pard);
		id = new SimpleStringProperty(nr);
		pavadinimas = new SimpleStringProperty(pav);
		kiekis = new SimpleIntegerProperty(kiek);
		kiekisUzsak = new SimpleIntegerProperty(kiekisUzs);
		kaina = new SimpleFloatProperty(kain);
		spalva = new SimpleStringProperty(spalv);
	}

	public String getId() {
		return this.id.get();
	}


	public String getParduotuve() {
		return this.parduotuve.get();
	}


	public String getPavadinimas() {
		return this.pavadinimas.get();
	}


	public int getKiekis() {
		return this.kiekis.get();
	}
	
	public StringProperty getIdProperty() {
		return this.id;
	}


	public StringProperty getParduotuveProperty() {
		return this.parduotuve;
	}


	public StringProperty getPavadinimasProperty() {
		return this.pavadinimas;
	}


	public IntegerProperty getKiekisProperty() {
		return this.kiekis;
	}
	public IntegerProperty getKiekisUzsakProperty() {
		return this.kiekisUzsak;
	}
	public FloatProperty getKainaProperty() {
		return this.kaina;
	}
	public StringProperty getSpalvaProperty() {
		return this.spalva;
	}

	
	

}
