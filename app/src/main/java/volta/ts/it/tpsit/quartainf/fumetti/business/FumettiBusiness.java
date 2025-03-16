package volta.ts.it.tpsit.quartainf.fumetti.business;

import java.util.ArrayList;
import java.util.List;

import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;

public class FumettiBusiness {

    public final List<Fumetto> Fumetti;

    public FumettiBusiness() {
       Fumetti = new ArrayList<>();
    }

    public void add(String immagine, String nome, String casa) {
        this.Fumetti.add(new Fumetto(immagine, nome, casa));

    }
}
