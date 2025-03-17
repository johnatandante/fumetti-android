package volta.ts.it.tpsit.quartainf.fumetti;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.widget.ListView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import volta.ts.it.tpsit.quartainf.fumetti.R;
import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;
import volta.ts.it.tpsit.quartainf.fumetti.business.FumettiBusiness;
import volta.ts.it.tpsit.quartainf.fumetti.ui.FumettiListAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView llComics;
    private FumettiListAdapter mAdapter;
    private final FumettiBusiness business;
    public MainActivity(){
        business = new FumettiBusiness();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R
                .layout.activity_main);

        llComics = findViewById(R.id.listView);

        popolaListe();
        caricaListView();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void popolaListe() {
        business.Fumetti.add(new Fumetto("batman", "Batman","DC"));
        business.Fumetti.add(new Fumetto("superman","Superman","DC"));
        business.Fumetti.add(new Fumetto("spiderman","Spiderman","Marvel"));
        business.Fumetti.add(new Fumetto("fantasticfour","Fantastic Four","Marvel"));
    }

    public void caricaListView() {
        llComics.setAdapter(null);
        mAdapter = new FumettiListAdapter(business, getResources(),
                getApplicationContext(), (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE));
        llComics.setAdapter(mAdapter);
    }

}