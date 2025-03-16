package volta.ts.it.tpsit.quartainf.fumetti.bean;

public class Fumetto {

    public final String Tag;
    public String Immagine;
    public String Nome;
    public String CasaEditrice;

    public Fumetto(String immagine, String nome, String casaEditrice) {
        this.Tag = immagine;
        this.Immagine = immagine;
        this.Nome = nome;
        this.CasaEditrice = casaEditrice;

    }
}
