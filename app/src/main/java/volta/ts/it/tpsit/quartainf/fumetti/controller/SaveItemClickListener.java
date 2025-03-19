package volta.ts.it.tpsit.quartainf.fumetti.controller;

import android.view.View;

import volta.ts.it.tpsit.quartainf.fumetti.bean.Fumetto;
import volta.ts.it.tpsit.quartainf.fumetti.bean.FumettoDto;
import volta.ts.it.tpsit.quartainf.fumetti.business.FumettiBusiness;

public class SaveItemClickListener implements View.OnClickListener{

    FumettoDto dto;
    FumettiBusiness business;

    public SaveItemClickListener(FumettoDto dto, FumettiBusiness business) {
        this.dto = dto;
        this.business = business;
    }
    @Override
    public void onClick(View v) {
        if(dto.Quanti == 1) {
            business.add(dto.Immagine, dto.Nome, dto.CasaEditrice);
        } else {
            Fumetto fumetto = business.find(dto.Immagine);
            int i = fumetto.getQuanti();
            while(i < dto.Quanti) {
                business.addCopy(fumetto);
                i++;
            }
            while(i > dto.Quanti) {
                business.removeCopy(fumetto);
                i--;
            }

        }

    }
}
