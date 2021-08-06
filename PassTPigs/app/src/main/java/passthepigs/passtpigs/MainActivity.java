package passthepigs.passtpigs;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton Jugar;
    ImageButton Ayuda;
    private MediaPlayer musica;
    private SoundPool sonido;
    int sonido1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Jugar = (ImageButton) findViewById(R.id.imageButton);
        Ayuda = (ImageButton)findViewById(R.id.imageButton2);
        Jugar.setOnClickListener(this);
        Ayuda.setOnClickListener(this);
        musica= MediaPlayer.create(this,R.raw.main);
        musica.setLooping(true);
        musica.start();
        sonido = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        sonido1 = sonido.load(this,R.raw.botones,1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton:
                sonido.play(sonido1,1,1,0,0,1);
                Intent intent2= new Intent(this,MenuJugar.class);
                startActivity(intent2);
                break;
            case R.id.imageButton2:
                sonido.play(sonido1,1,1,0,0,1);
                Intent intent= new Intent(this,Instrucciones.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        //musica.stop();
        super.onPause();
    }

    @Override
    protected  void onDestroy(){
        musica.stop();
        musica.release();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        musica.start();
        super.onResume();
    }

    @Override
    protected void onStop() {
        musica.stop();
        super.onStop();
    }
}
