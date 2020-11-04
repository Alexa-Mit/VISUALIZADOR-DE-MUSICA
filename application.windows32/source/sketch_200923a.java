import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import com.hamoid.*; 
import ddf.minim.*; 
import ddf.minim.analysis.*; 
import ddf.minim.effects.*; 
import ddf.minim.signals.*; 
import ddf.minim.spi.*; 
import ddf.minim.ugens.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_200923a extends PApplet {



//Creacion de Visualizador de Música

//Variables a, b
float a;
float b;
 
//Importar musica usando Minim 







Minim minim;
AudioPlayer musica;

  public void setup() {
    
 //para renderizar
//size(1280,720); //para visualizar:
//Sin cursor en la pantalla   
noCursor();
//Suavizar los bordes de toda la geometría   

//Fondo negro  
background (0);
//Fotogramas por segundo  
frameRate(24);

//Añadir pista de audio 
  minim = new Minim(this);
  musica = minim.loadFile("Astral.mp3"); 
  musica.play();
}

  public void draw() {

fill(0,50);  
noStroke();
rect(0, 0, width, height);
translate(width/2, height/2); // poner en el centro

for(int i = 0; i<musica.bufferSize()-1; i++) {

 float angulo = sin(a+i)*6; //la trayectoria de la figura geometrica
 float angulo2 = cos(b+i)*700; //creacion de los puntos  //tan(b)* 70

 float x=sin(radians(i))*(angulo2*10); 
 float y=cos(radians(i))*(angulo2*10);

 float x2=sin(radians(i))*(angulo*50); 
 float y2=cos(radians(i))*(angulo*50);

//Color, forma y tamaño de los puntos
fill (0xff000000, 255); 
 ellipse(x, y, musica.left.get(i)*5, musica.left.get(i)*5);

fill (216, 0, 255);
 ellipse(x, y, musica.right.get(i)*12, musica.left.get(i)*12);

//Color,forma y tamaño de la figura geometrica
fill (79, 23, 255); 
 ellipse(x2, y2, musica.left.get(i)*10, musica.left.get(i)*10);

fill(152, 28, 255);
 ellipse(x2, y2, musica.right.get(i)*12, musica.right.get(i)*12);

}

//Intervalo de tiempo con lo que se gira la figura geometrica
a += 0.01f; //0.05
b += 0.01f;

  }
  public void settings() { 
fullScreen(P3D); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "sketch_200923a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
