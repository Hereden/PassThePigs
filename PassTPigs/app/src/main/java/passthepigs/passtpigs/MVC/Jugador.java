package passthepigs.passtpigs.MVC;

import android.widget.TextView;

/**
 * Created by Etsu Hen on 14/03/2016.
 */

public class Jugador {
    private int id;
    private TextView puntaje;

    public TextView getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(TextView puntaje) {
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Jugador(int id, TextView puntaje){
        this.id=id;
        this.puntaje=puntaje;
    }

    public void Cambiar_puntaje(int i){
        int a = Integer.parseInt((puntaje.getText().toString()));
        int res= a+i;
        puntaje.setText(""+ res);
    }
}
