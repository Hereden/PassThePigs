package passthepigs.passtpigs.PatronBuilder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import passthepigs.passtpigs.R;

/**
 * Created by Hereden on 13/03/2016.
 */
public class Lados extends InstruccionesBuilder {
    @Override
    public void construirUno(ImageView uno) {
        uno.setImageResource(R.drawable.chuletapuntos);
        uno.setVisibility(View.VISIBLE);
    }

    @Override
    public void construirDos(ImageView dos) {
        dos.setImageResource(R.drawable.chuletapuntos);
        dos.setVisibility(View.VISIBLE);
    }

    @Override
    public void construirDescripcion(TextView descripcion) {
        descripcion.setText(R.string.lados);
    }
}
