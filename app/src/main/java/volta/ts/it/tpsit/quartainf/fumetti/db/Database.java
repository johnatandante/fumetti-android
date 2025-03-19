package volta.ts.it.tpsit.quartainf.fumetti.db;

import java.util.ArrayList;
import java.util.List;

import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;

public class Database {

    private final List<Fumetto> list;
    private static Database instance;

    public static Database getInstance() {

        if(instance == null) instance = new Database();
        return instance;
    }

    public Database(){
        list = new ArrayList<>();
    }

    public Fumetto insert(Fumetto fumetto) {
        list.add(fumetto);
        return fumetto;
    }

    public Fumetto[] selectAll() {
        return list.toArray(new Fumetto[0]);
    }

    public void deleteAll() {
        this.list.clear();
    }

    public void delete(Fumetto item) {
        if(item.getQuanti() > 1) {
            item.rimuoviUno();
        } else {
            this.list.remove(item);
        }
    }

    public void add(Fumetto item) {
        if(this.list.stream().anyMatch( i -> i.Tag.equals(item.Tag))){
            item.aggiungiUno();
        } else {
            this.add(item);
        }

    }

    public Fumetto find(String tag) {
        return this.list.stream().filter( item -> item.Tag.equals(tag) ).findFirst().orElse(null);
    }
}
