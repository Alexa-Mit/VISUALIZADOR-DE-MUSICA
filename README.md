# VISUALIZADOR-DE-MUSICA
//Creacion de Visualizador de Música

//Variables a, b
float a;
float b;
 
//Importar musica usando Minim 
import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;

Minim minim;
AudioPlayer musica;

  void setup() {
    
fullScreen(P3D); //para renderizar
//size(1280,720); //para visualizar:
//Sin cursor en la pantalla   
noCursor();
//Suavizar los bordes de toda la geometría   
smooth();
//Fondo negro  
background (0);
//Fotogramas por segundo  
frameRate(24);

//Añadir pista de audio 
  minim = new Minim(this);
  musica = minim.loadFile("Astral.mp3"); 
  musica.play();
}

  void draw() {

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
fill (#000000, 255); 
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
a += 0.01; //0.05
b += 0.01;

  }
