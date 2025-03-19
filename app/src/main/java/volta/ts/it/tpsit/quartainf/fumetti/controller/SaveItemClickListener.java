package volta.ts.it.tpsit.quartainf.fumetti.controller;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;
import volta.ts.it.tpsit.quartainf.fumetti.bean.FumettoDto;
import volta.ts.it.tpsit.quartainf.fumetti.business.FumettiBusiness;

public class SaveItemClickListener implements View.OnClickListener{

    FumettiBusiness business;
    EditText nome, editore;
    ImageView image;
    TextView quanti;

    public SaveItemClickListener(EditText nome, EditText editore, ImageView image, TextView quanti, FumettiBusiness business) {
        this.business = business;
        this.nome = nome;
        this.editore = editore;
        this.image = image;
        this.quanti = quanti;
    }

    private FumettoDto getDto() {
        FumettoDto dto = new FumettoDto();
        dto.CasaEditrice = editore.getText().toString();
        dto.Nome = nome.getText().toString();
        dto.Immagine = image.getTag().toString();
        dto.Quanti = Integer.parseInt(quanti.getText().toString());

        return dto;
    }
    @Override
    public void onClick(View v) {
        FumettoDto dto = getDto();
        Fumetto fumetto = business.find(dto.Immagine);
        if(fumetto == null) {
            fumetto = business.add(dto.Immagine, dto.Nome, dto.CasaEditrice);
        } else {
            int i = fumetto.getQuanti();
            while(i < dto.Quanti) {
                business.addCopy(fumetto);
                i++;
            }
            while(i > dto.Quanti) {
                business.removeCopy(fumetto);
                i--;
            }

            fumetto.Nome = dto.Nome;
            fumetto.CasaEditrice = dto.CasaEditrice;
            fumetto.Immagine = dto.Immagine;

        }

        Toast.makeText(v.getContext(),
                String.format("Dati salvati per %s", fumetto.Nome), Toast.LENGTH_LONG).show();

    }
}
