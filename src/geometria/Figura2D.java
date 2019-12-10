package geometria;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import figuras.Circulo;
import figuras.Cuadrado;
import figuras.Rectangulo;
import figuras.Triangulo;
import static com.jogamp.opengl.GL.*;  
import static com.jogamp.opengl.GL2.*;
import static com.jogamp.opengl.GL2ES3.GL_QUADS; 

@SuppressWarnings("serial")
public class Figura2D extends GLCanvas implements GLEventListener {
   public static String TITLE = "Figura2D";
   public static final int CANVAS_ANCHO = 640;  
   public static final int CANVAS_ALTURA = 480; 
   public static final int FPS = 60; 
   private Triangulo  tri = new Triangulo(); 
   private Cuadrado cua = new Cuadrado();
   private Circulo cir = new Circulo();
   public static void dibujarVentana() {
	   Figura2D canvas = new Figura2D();
	   SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            canvas.setPreferredSize(new Dimension(CANVAS_ANCHO, CANVAS_ALTURA));

            final FPSAnimator animator = new FPSAnimator(canvas, FPS, true);
            
            final JFrame frame = new JFrame(); 
            frame.getContentPane().add(canvas);
            frame.addWindowListener(new WindowAdapter() {
               @Override 
               public void windowClosing(WindowEvent e) {
                  new Thread() {                	  
                     @Override
                     public void run() {
                        if (animator.isStarted()) animator.stop();
                        System.exit(0);
                     }
                  }.start();
               }
            });
            frame.setTitle(TITLE);
            frame.pack();
            frame.setVisible(true);
            animator.start(); 
         }
      });
	    
	    
	    
      
   }
   
   private GLU glu;  
   
   public Figura2D() {
      this.addGLEventListener(this);
      
   }
   
   @Override
   public void init(GLAutoDrawable drawable) {
      GL2 gl = drawable.getGL().getGL2();      
      glu = new GLU();                         
      gl.glClearColor(255f, 255f, 0.0f, 0.0f); 
      gl.glClearDepth(1.0f);      
      gl.glEnable(GL_DEPTH_TEST); 
      gl.glDepthFunc(GL_LEQUAL);  
      gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST); 
      gl.glShadeModel(GL_SMOOTH); 
   }

   @Override
   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
      GL2 gl = drawable.getGL().getGL2();  

      if (height == 0) height = 1;   
      float aspect = (float)width / height;

      gl.glViewport(0, 0, width, height);

      gl.glMatrixMode(GL_PROJECTION);  
      gl.glLoadIdentity();             
      glu.gluPerspective(45.0, aspect, 0.1, 100.0); 

      gl.glMatrixMode(GL_MODELVIEW);
      gl.glLoadIdentity(); 
   }
   static float coordenadaX = 0.0f;
   static float coordenadaY = 0.0f;

   static float velocidad =0.005f;
   
   static float aditivoX = 0.0f;
   static float aditivoY = 0.0f;
   
   boolean cuadrado = false;
   boolean triangulo= false;
   @Override
   public void display(GLAutoDrawable drawable) {
	   System.out.println("olis");
	    GL2 gl = drawable.getGL().getGL2();  
	      gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
	      gl.glLoadIdentity();  

	      gl.glTranslatef(-1.5f, 0.0f, -6.0f); 
	      
	      dibujarFiguras(gl);
	      //implementar metodo dibujar
	      //sgl.glTranslatef(3.0f, 0.0f, 0.0f);
	    
	      coordenadaX += aditivoX;
	      coordenadaY += aditivoY;
   }
//   public void dibujar(GL2 gl)
//   {
//	   if(cuadrado == true)
//		   if(triangulo  == true)
//			   	dibujarFiguras(gl);
//	   
//		  
//   }
   public void dibujarFiguras(GL2 gl)
   {
	  tri.dibujar(gl);
	   //cua.dibujar(gl);
	   //cir.dibujar(gl);
   }
   
   
   public static void moverArriba()
   {   
	   aditivoX = 0.0f;
	   aditivoY= velocidad;
	   coordenadaY=aditivoY;
   }
   public static void moverAbajo()
   {
	   aditivoX = 0.0f;
	   aditivoY = -velocidad;
	   coordenadaY=aditivoY;   
   }
   public static void moverIzquierda()
   {
	   aditivoY = 0.0f;
	   aditivoX=-velocidad;
	   coordenadaX=aditivoX;
   }
   public static void moverDerecha()
   {
	   aditivoY=0.0f;
	   aditivoX = velocidad;
	   coordenadaX=aditivoX;   
   }
   public static void parar()
   {
	   aditivoX = 0.0f;
	   aditivoY = 0.0f;
   }
   public static void crearTriangulo()
   {
	   
   }
   public static void crearCuadrado()
   {
	   
   }
   public static void crearCirculo()
   {
	   
   }
   @Override
   public void dispose(GLAutoDrawable drawable) { }
   
}
