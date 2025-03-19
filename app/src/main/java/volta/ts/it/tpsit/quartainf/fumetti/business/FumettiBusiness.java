package volta.ts.it.tpsit.quartainf.fumetti.business;

import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;
import volta.ts.it.tpsit.quartainf.fumetti.db.Database;

public class FumettiBusiness {

    private final Database fumetti;

    public FumettiBusiness() {
       fumetti = Database.getInstance();
    }

    public void add(String immagine, String nome, String casa) {
        this.fumetti.insert(new Fumetto(immagine, nome, casa));
    }

    public Fumetto[] getFumetti() {
        return fumetti.selectAll();
    }

    public void clearList() {
        this.fumetti.deleteAll();
    }

    public void remove(Fumetto item) {
        this.fumetti.delete(item);
    }

    public void addCopy(Fumetto item) {
        //this.fumetti.add(item);
        item.aggiungiUno();
    }
    public void removeCopy(Fumetto item) {
        //this.fumetti.remove(item);
        item.rimuoviUno();
    }

    public Fumetto find(String tag) {
        return fumetti.find(tag);
    }
}
