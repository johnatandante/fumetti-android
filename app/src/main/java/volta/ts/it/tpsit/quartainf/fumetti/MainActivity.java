package volta.ts.it.tpsit.quartainf.fumetti;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ListView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import volta.ts.it.tpsit.quartainf.fumetti.business.FumettiBusiness;
import volta.ts.it.tpsit.quartainf.fumetti.controller.ClearListClickListener;
import volta.ts.it.tpsit.quartainf.fumetti.controller.NavigateToDetailClickListener;
import volta.ts.it.tpsit.quartainf.fumetti.ui.FumettiListAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView llComics;
    private Button btnAdd, btnClear;
    private FumettiListAdapter mAdapter;
    private final FumettiBusiness business;
    public MainActivity(){
        business = new FumettiBusiness();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        llComics = findViewById(R.id.listView);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new NavigateToDetailClickListener(MainActivity.this));

        btnClear = findViewById(R.id.btnRemoveAll);
        btnClear.setOnClickListener(new ClearListClickListener(business, mAdapter));

        caricaListView();
        popolaListe();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void popolaListe() {
        business.add("batman", "Batman","DC");
        business.add("superman","Superman","DC");
        business.add("spiderman","Spiderman","Marvel");
        //business.Fumetti.add(new Fumetto("fantasticfour","Fantastic Four","Marvel"));
        mAdapter.notifyDataSetChanged();
    }

    public void caricaListView() {
        llComics.setAdapter(null);
        mAdapter = new FumettiListAdapter(business, getResources(),
                getApplicationContext(), (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE));
        llComics.setAdapter(mAdapter);
    }

}