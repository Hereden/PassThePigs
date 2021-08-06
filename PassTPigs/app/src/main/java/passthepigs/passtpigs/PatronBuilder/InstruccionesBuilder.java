package passthepigs.passtpigs.PatronBuilder;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


import passthepigs.passtpigs.R;

/**
 * Created by Hereden on 13/03/2016.
 */
public abstract class InstruccionesBuilder {


    public void construir(ImageView uno, ImageView dos, TextView descripcion){
        construirUno(uno);
        construirDos(dos);
        construirDescripcion(descripcion);
    }

    public abstract void construirUno(ImageView uno);
    public abstract void construirDos(ImageView dos);
    public abstract void construirDescripcion(TextView descripcion);



}
