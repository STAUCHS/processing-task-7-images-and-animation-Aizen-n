import processing.core.PApplet;
import processing.core.PImage; //import the PImage library



public class Sketch extends PApplet {

  // global variables  

  PImage imgRico;
  PImage imgBullet;
  PImage imageSmallRico;
  PImage imagePrimo;
  PImage imageCross;

  // bullet x & y variables 

  float fltBulletX = 265;
  float fltBulletY = 520;

  // speed values 

  float fltXSpeed = 10;
  float fltYSpeed = 10;

  // rect variables 

  float fltRectX = 250;
  float fltRectY = 20;
  float fltRectXDIM = 100;

  public void settings() {
    size(600, 600);
  }

  public void setup() {
    
    background(0, 0, 0);

    // loading image onto the screen 

    imgRico = loadImage("NewBrawl (3).png"); 
    imgBullet = loadImage("768px-Eo_circle_red_blank.svg.png");
    imageSmallRico = loadImage("Rico_Skin-Default.png");
    imagePrimo = loadImage("primo.png");
    imageCross = loadImage("cross.png");

    
    // resizing 

    imgRico.resize(height*2, width*1);
    imgBullet.resize(height/9, width/9);
    imageSmallRico.resize(height/3, width/3);
    imagePrimo.resize(height/4, width/4);
    imageCross.resize(height/4, width/4);
  }

  public void draw() {

    // draws the image of the following png's on the screen with the set coordinates and dimensions 

    image(imgRico,0,0 );               
    image(imgBullet, fltBulletX, fltBulletY);   
    image(imageSmallRico,225,430);
    image(imagePrimo,240,40);

    // anamation of the bullet png + bouncing effect 
    
    fltBulletX -= fltXSpeed;
    fltBulletY -= fltYSpeed;

    if (fltBulletX > width - imgBullet.width || fltBulletX < 0 ) {

      fltXSpeed *= -1;
    }

    if (fltBulletY > height - imgBullet.height || fltBulletY < 0 ) {

      fltBulletX = 265;
      fltBulletY = 520;
    }

    // healthbar that slowly reaches 0 

    rect(fltRectX, fltRectY, fltRectXDIM, 16);

    fill(0,255,0);

     fltRectXDIM -= 0.2; 

     // Once the 'healthbar' reaches 0, the bullet image and healthbar shape is shifted outside of the window . 

    if (fltRectXDIM < 0) {

      fltRectX = 9999;

      fltBulletX = 9999; 

      image(imageCross,225,40);
    }
  }
}