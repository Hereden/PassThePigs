package passthepigs.passtpigs.MVC;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import passthepigs.passtpigs.R;

/**
 * Created by Etsu Hen on 14/03/2016.
 */

public class Jugar {
    private int jugador;
    private int puntaje;
    private int puntajeturno;
    private int acumuladorTiro;
    private ImageView uno;
    private ImageView dos;
    private ImageButton hand;
    private ImageButton pasar;
    private ImageButton ganaste;
    private TextView puntaje1;
    private TextView puntaje2;
    private TextView obtuviste;
    private ArrayList<Jugador> jugadores;
    private Jugador jugador1;
    private Jugador jugador2;

    public Jugar(ImageView uno, ImageView dos, ImageButton hand, ImageButton pasar,
                 TextView puntaje1, TextView puntaje2, TextView obtuviste, ImageButton ganaste){
        jugador=0;
        this.uno=uno;
        this.dos=dos;
        this.hand=hand;
        this.pasar=pasar;
        this.puntaje1 = puntaje1;
        this.puntaje2 = puntaje2;
        jugador1 = new Jugador(1, puntaje1);
        jugador2 = new Jugador(2, puntaje2);
        jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        this.obtuviste=obtuviste;
        this.ganaste= ganaste;
    }

    public boolean pasar(){
        if(jugador==0){
            jugador=1;
            puntajeturno=0;
            return true;
        }else {
            jugador = 0;
            puntajeturno=0;
            return true;
        }
    }

    public void tirar(){
        Random a = new Random();
        int tirada = a.nextInt(100);
        int tirada2 = a.nextInt(100);
        int oinker = a.nextInt(100);

        if(oinker == 53){
            uno.setImageResource(R.drawable.oinker);
            dos.setImageResource(R.drawable.oinker);
            obtuviste.setText(R.string.obtuviste_oinker);
            puntaje0(jugador);
            puntajeturno=0;
            pasar();
            uno.setVisibility(View.VISIBLE);
            dos.setVisibility(View.INVISIBLE);
            obtuviste.setVisibility(View.VISIBLE);
            return;
        }else{
            /** chuleta Rosa = 0-35
             *  chuleta Punto = 36-65
             *  solomillo = 66-85
             *  pata = 86 -95
             *  trompa = 96-99
             *  cachete = 100
             */
            if((tirada <=35) && (tirada2>35) && (tirada2<=65)){
                uno.setImageResource(R.drawable.chuleta);
                dos.setImageResource(R.drawable.chuletapuntos);
                obtuviste.setText(R.string.obtuviste_cerdos_fuera);
                jugadores.get(jugador).Cambiar_puntaje(-puntajeturno);
                puntajeturno=0;
                pasar();
            }else if(tirada>35 && tirada<=65 && tirada2<35){
                uno.setImageResource(R.drawable.chuletapuntos);
                dos.setImageResource(R.drawable.chuleta);
                obtuviste.setText(R.string.obtuviste_cerdos_fuera);
                jugadores.get(jugador).Cambiar_puntaje(-puntajeturno);
                puntajeturno=0;
                pasar();

            }else if(tirada <=35 && tirada2<=35 ){
                uno.setImageResource(R.drawable.chuleta);
                dos.setImageResource(R.drawable.chuleta);
                obtuviste.setText(R.string.obtuviste_lados);
                puntajeturno++;
                jugadores.get(jugador).Cambiar_puntaje(1);
            }else if(tirada>35 && tirada <=65 && tirada2>35 && tirada2<=65){
                uno.setImageResource(R.drawable.chuletapuntos);
                dos.setImageResource(R.drawable.chuletapuntos);
                obtuviste.setText(R.string.obtuviste_lados);
                puntajeturno++;
                jugadores.get(jugador).Cambiar_puntaje(1);
            }else if(tirada>65 && tirada<=85 && tirada2>65 && tirada2<=85){
                uno.setImageResource(R.drawable.solomillo);
                dos.setImageResource(R.drawable.solomillo);
                obtuviste.setText(R.string.obtuviste_dos_solomillo);
                puntajeturno += 20;
                jugadores.get(jugador).Cambiar_puntaje(20);
            }else if(tirada>85 && tirada<=95 && tirada2>85 && tirada2<=95){
                uno.setImageResource(R.drawable.pata);
                dos.setImageResource(R.drawable.pata);
                obtuviste.setText(R.string.dos_pata);
                puntajeturno+=20;
                jugadores.get(jugador).Cambiar_puntaje(20);
            }else if(tirada>95 && tirada<=99 && tirada2>95 && tirada2<=99){
                uno.setImageResource(R.drawable.trompa);
                dos.setImageResource(R.drawable.trompa);
                obtuviste.setText(R.string.dos_trompa);
                puntajeturno+=40;
                jugadores.get(jugador).Cambiar_puntaje(40);
            }else if(tirada ==100 && tirada2==100){
                uno.setImageResource(R.drawable.cachete);
                dos.setImageResource(R.drawable.cachete);
                obtuviste.setText(R.string.dos_cachete);
                puntajeturno+=60;
                jugadores.get(jugador).Cambiar_puntaje(60);
            }else{
                acumuladorTiro =0;
                obtuviste.setText(R.string.combo);
                if(tirada<=35){
                    uno.setImageResource(R.drawable.chuleta);
                    acumuladorTiro +=1;
                }else if(tirada>35 && tirada<=65){
                    uno.setImageResource(R.drawable.chuletapuntos);
                    acumuladorTiro +=1;
                }else if(tirada>65 && tirada<=85){
                    uno.setImageResource(R.drawable.solomillo);
                    acumuladorTiro +=5;
                }else if(tirada>85 && tirada<=95){
                    uno.setImageResource(R.drawable.pata);
                    acumuladorTiro +=5;
                }else if(tirada>95 && tirada<=99){
                    uno.setImageResource(R.drawable.trompa);
                    acumuladorTiro +=10;
                }else{
                    uno.setImageResource(R.drawable.cachete);
                    acumuladorTiro +=15;
                }
                if(tirada2<=35){
                    dos.setImageResource(R.drawable.chuleta);
                    acumuladorTiro +=1;
                }else if(tirada2>35 && tirada2<=65){
                    dos.setImageResource(R.drawable.chuletapuntos);
                    acumuladorTiro +=1;
                }else if(tirada2>65 && tirada2<=85){
                    dos.setImageResource(R.drawable.solomillo);
                    acumuladorTiro +=5;
                }else if(tirada2>85 && tirada2<=95){
                    dos.setImageResource(R.drawable.pata);
                    acumuladorTiro +=5;
                }else if(tirada2>95 && tirada2<=99){
                    dos.setImageResource(R.drawable.trompa);
                    acumuladorTiro +=10;
                }else {
                    dos.setImageResource(R.drawable.cachete);
                    acumuladorTiro +=15;
                }
                puntajeturno+= acumuladorTiro;
                jugadores.get(jugador).Cambiar_puntaje(acumuladorTiro);
            }
        }
        uno.setVisibility(View.VISIBLE);
        dos.setVisibility(View.VISIBLE);
        obtuviste.setVisibility(View.VISIBLE);
        ganaste();
    }

    private void ganaste(){
        if(Integer.parseInt(jugadores.get(jugador).getPuntaje().getText().toString())>=100){
            ganaste.setVisibility(View.VISIBLE);
            acumuladorTiro =0;
            puntajeturno=0;
            puntaje0(1);
            puntaje0(0);
        }
    }

    private void puntaje0(int jug){
        puntaje = Integer.parseInt(jugadores.get(jug).getPuntaje().getText().toString());
        jugadores.get(jug).Cambiar_puntaje(-puntaje);
    }
}
