package volta.ts.it.tpsit.quartainf.fumetti;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

//import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;
import volta.ts.it.tpsit.quartainf.fumetti.bean.FumettoDto;
import volta.ts.it.tpsit.quartainf.fumetti.business.FumettiBusiness;
import volta.ts.it.tpsit.quartainf.fumetti.controller.MainActivityOnBackPressedCallback;
import volta.ts.it.tpsit.quartainf.fumetti.controller.SaveItemClickListener;

public class FumettoDetail extends AppCompatActivity {

    private Fumetto detail;
    private final FumettiBusiness business;

    private ImageView image;
    private EditText editore, nome;
    private TextView quanti;
    private Button plus, minus, save, back;

    int tot_quanti = 0;

    public FumettoDetail() {
        super();
        business = new FumettiBusiness();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fumetto_detail);

        Intent intent = getIntent();
        detail = (Fumetto)intent.getSerializableExtra("detail");

        String tag = Fumetto.DEFAULT_TAG, immagine = Fumetto.DEFAULT_TAG;

        image = findViewById(R.id.imgComicDetail);
        if(detail != null){
            tag = detail.Tag;
            immagine = detail.Immagine;
        }

        int res = getResources().getIdentifier(immagine, "drawable", this.getPackageName());
        image.setImageResource(res);
        image.setTag(tag);

        editore = findViewById(R.id.txtCasaEditriceDetail);
        if(detail != null){
            editore.setText(detail.CasaEditrice);
        }

        nome = findViewById(R.id.txtNomeDetail);
        if(detail != null){
            nome.setText(detail.Nome);
        }

        quanti = findViewById(R.id.txtQuantiDetail);
        if(detail != null){
            tot_quanti = detail.getQuanti();
        } else {
            tot_quanti = 1;
        }
        quanti.setText(Integer.toString(tot_quanti));

        minus = findViewById(R.id.btnMinusOneDetail);
        minus.setOnClickListener( (v) -> {
            if(tot_quanti > 1) tot_quanti--;
            quanti.setText(Integer.toString(tot_quanti));
        });

        plus = findViewById(R.id.btnPlusOneDetail);
        plus.setOnClickListener( (v) -> {
            quanti.setText(Integer.toString(++tot_quanti));
        });

        save = findViewById(R.id.btnSaveDetail);
        save.setOnClickListener( new SaveItemClickListener(nome, editore, image, quanti, business));

        this.getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {

            @Override
            public void handleOnBackPressed() {
                endUp();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void endUp() {
        this.finish();
    }

}