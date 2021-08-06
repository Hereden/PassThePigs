package passthepigs.passtpigs;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MenuJugar extends AppCompatActivity implements OnClickListener{
    ImageButton pvp,pvm;
    private SoundPool sonido;
    private int sonido1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jugar);
        pvp=(ImageButton)findViewById(R.id.imageButton6);
        pvm=(ImageButton)findViewById(R.id.imageButton7);
        pvp.setOnClickListener(this);
        pvm.setOnClickListener(this);
        sonido = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        sonido1 = sonido.load(this, R.raw.botones, 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton6:
                sonido.play(sonido1,1,1,0,0,1);
                intent= new Intent(this,JugadorVsJugador.class);
                startActivity(intent);
                break;
            case R.id.imageButton7:
                sonido.play(sonido1,1,1,0,0,1);
                intent= new Intent(this, JugadorVsPc.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
