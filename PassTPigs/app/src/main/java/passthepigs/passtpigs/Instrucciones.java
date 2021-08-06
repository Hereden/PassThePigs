package passthepigs.passtpigs;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import passthepigs.passtpigs.PatronBuilder.InstruccionesBuilder;
import passthepigs.passtpigs.PatronBuilder.cachete;
import passthepigs.passtpigs.PatronBuilder.cerdo_fuera;
import passthepigs.passtpigs.PatronBuilder.combo;
import passthepigs.passtpigs.PatronBuilder.DosCachete;
import passthepigs.passtpigs.PatronBuilder.DosPata;
import passthepigs.passtpigs.PatronBuilder.DosSolomillo;
import passthepigs.passtpigs.PatronBuilder.DosTrompa;
import passthepigs.passtpigs.PatronBuilder.Lados;
import passthepigs.passtpigs.PatronBuilder.Objetivo;
import passthepigs.passtpigs.PatronBuilder.Oinker;
import passthepigs.passtpigs.PatronBuilder.pata;
import passthepigs.passtpigs.PatronBuilder.solomillo;
import passthepigs.passtpigs.PatronBuilder.trompa;


public class Instrucciones extends AppCompatActivity implements View.OnClickListener{
    private ImageButton atras;
    private ImageButton sig;
    private ImageView uno;
    private ImageView dos;
    private TextView descripcion;
    private ArrayList<InstruccionesBuilder> ib;
    private int i;
    private SoundPool sonido;
    private int sonido1;
    private int sonido2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);
        atras=(ImageButton)findViewById(R.id.imageButton3);
        sig=(ImageButton)findViewById(R.id.imageButton5);
        uno = (ImageView)findViewById(R.id.imageView2);
        dos = (ImageView)findViewById(R.id.imageView3);
        descripcion = (TextView)findViewById(R.id.textView);
        atras.setOnClickListener(this);
        sig.setOnClickListener(this);
        ib= new ArrayList<>();
        ib.add(new Objetivo());
        ib.add(new cerdo_fuera());
        ib.add(new Lados());
        ib.add(new pata());
        ib.add(new solomillo());
        ib.add(new trompa());
        ib.add(new cachete());
        ib.add(new DosSolomillo());
        ib.add(new DosPata());
        ib.add(new DosTrompa());
        ib.add(new DosCachete());
        ib.add(new combo());
        ib.add(new Oinker());
        i=0;
        sonido = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        sonido1 = sonido.load(this,R.raw.botones,1);
        sonido2 = sonido.load(this,R.raw.oinkhome,2);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageButton3:
                sonido.play(sonido1,1,1,0,0,1);
                if(i==0){
                    i=ib.size()-1;
                    ib.get(i).construir(uno, dos, descripcion);
                    break;
                }else{
                    i--;
                    ib.get(i).construir(uno,dos,descripcion);
                    break;
                }
            case R.id.imageButton5:
                sonido.play(sonido1,1,1,0,0,1);
               if(i==ib.size()-1){
                    i=0;
                   ib.get(i).construir(uno, dos, descripcion);
                   break;
                }else{
                   i++;
                   ib.get(i).construir(uno, dos, descripcion);
                   break;
                }
            default:
                break;
        }
    }
}
