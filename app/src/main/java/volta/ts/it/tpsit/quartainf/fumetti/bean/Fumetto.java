package volta.ts.it.tpsit.quartainf.fumetti.bean;

import java.io.Serializable;

public class Fumetto implements Serializable {

    public static final String DEFAULT_TAG = "fumetto";
    public final String Tag;
    public String Immagine;
    public String Nome;
    public String CasaEditrice;

    private int quanti;

    public Fumetto() {
        this.Tag = "fumetto";
    }

    public Fumetto(String immagine, String nome, String casaEditrice) {
        this.Tag = immagine;
        this.Immagine = immagine;
        this.Nome = nome;
        this.CasaEditrice = casaEditrice;
        this.quanti = 1;
    }

    public void aggiungiUno(){
        this.quanti++;
    }

    public int getQuanti() {
        return quanti;
    }

    public void rimuoviUno() {
        this.quanti--;
    }
}
