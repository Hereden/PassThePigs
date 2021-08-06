package passthepigs.passtpigs;

import android.annotation.TargetApi;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import passthepigs.passtpigs.MVC.Jugar;

public class JugadorVsJugador extends AppCompatActivity implements View.OnTouchListener{
    private ImageView uno;
    private ImageView dos;
    private ImageButton hand;
    private ImageButton pasar;
    private ImageButton ganaste;
    private TextView p1;
    private TextView p2;
    private TextView obtuviste;
    private Jugar jugar;
    private int a;
    private SoundPool sonido;
    private int sonido1,sonido2,sonido3;
    private AnimationDrawable animacion,animacion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugador_vs_jugador);
        hand= (ImageButton)findViewById(R.id.imageButton11);
        pasar = (ImageButton)findViewById(R.id.imageButton8);
        p1 = (TextView)findViewById(R.id.textView2);
        p2= (TextView)findViewById(R.id.textView3);
        obtuviste= (TextView)findViewById(R.id.textView6);
        uno=(ImageView)findViewById(R.id.imageView4);
        dos=(ImageView)findViewById(R.id.imageView5);
        ganaste= (ImageButton)findViewById(R.id.imageButton10);
        hand.setOnTouchListener(this);
        pasar.setOnTouchListener(this);
        ganaste.setOnTouchListener(this);
        jugar = new Jugar(uno,dos,hand,pasar,p1,p2,obtuviste,ganaste);
        animacion = new AnimationDrawable();
        animacion2=new AnimationDrawable();
        Drawable imagen1= getResources().getDrawable(R.drawable.chuleta,null);
        Drawable imagen2= getResources().getDrawable(R.drawable.chuletapuntos,null);
        Drawable imagen3= getResources().getDrawable(R.drawable.solomillo,null);
        Drawable imagen4= getResources().getDrawable(R.drawable.oinker2,null);
        Drawable imagen5= getResources().getDrawable(R.drawable.trompa,null);
        Drawable imagen6= getResources().getDrawable(R.drawable.cachete,null);
        Drawable imagen7= getResources().getDrawable(R.drawable.pata,null);
        Drawable imagen8= getResources().getDrawable(R.drawable.chuleta,null);
        Drawable imagen9= getResources().getDrawable(R.drawable.chuletapuntos,null);
        Drawable imagen10= getResources().getDrawable(R.drawable.solomillo,null);
        Drawable imagen11= getResources().getDrawable(R.drawable.oinker2,null);
        Drawable imagen12= getResources().getDrawable(R.drawable.trompa,null);
        Drawable imagen13= getResources().getDrawable(R.drawable.cachete,null);
        Drawable imagen14= getResources().getDrawable(R.drawable.pata,null);
        animacion.addFrame(imagen1,100);
        animacion.addFrame(imagen2,100);
        animacion.addFrame(imagen3,100);
        animacion.addFrame(imagen4,100);
        animacion.addFrame(imagen5,100);
        animacion.addFrame(imagen6,100);
        animacion.addFrame(imagen7,100);
        animacion2.setOneShot(false);
        animacion2.addFrame(imagen8,100);
        animacion2.addFrame(imagen9,100);
        animacion2.addFrame(imagen10,100);
        animacion2.addFrame(imagen11,100);
        animacion2.addFrame(imagen12,100);
        animacion2.addFrame(imagen13,100);
        animacion2.addFrame(imagen14,100);
        animacion2.setOneShot(false);
        uno.setBackgroundDrawable(animacion);
        //uno.setImageDrawable(animacion);
        //dos.setImageDrawable(animacion2);
        dos.setBackgroundDrawable(animacion2);
        sonido = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        sonido1 = sonido.load(this, R.raw.botones, 1);
        sonido2 = sonido.load(this, R.raw.oink,1);
        sonido3 = sonido.load(this, R.raw.win,1);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                if(v.getId()==R.id.imageButton8){
                    sonido.play(sonido1,1,1,0,0,1);
                    jugar.pasar();
                }
                else if(v.getId()==R.id.imageButton10){
                    sonido.play(sonido3,1,1,0,0,1);
                    jugar.pasar();
                }else if(v.getId()==R.id.imageButton11){
                    if(animacion.isRunning()){
                        sonido.play(sonido2,1,1,0,0,1);
                        animacion.stop();
                        animacion2.stop();
                        //uno.setImageDrawable(null);
                        //dos.setImageDrawable(null);
                        uno.setBackgroundDrawable(null);
                        dos.setBackgroundDrawable(null);
                        jugar.tirar();
                    }else{
                        sonido.play(sonido1,1,1,0,0,1);
                        //uno.setImageDrawable(animacion);
                        //dos.setImageDrawable(animacion2);
                        uno.setBackgroundDrawable(animacion);
                        dos.setBackgroundDrawable(animacion2);
                        uno.setImageResource(R.drawable.vacio);
                        dos.setImageResource(R.drawable.vacio);
                        animacion.start();
                        animacion2.start();
                    }

                }else{
                    break;
                }
            default:
                break;
        }
        return true;
    }
}