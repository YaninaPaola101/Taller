	package geometria;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
import figuras.Figura;
import figuras.Rectangulo;
import figuras.Triangulo;
import static com.jogamp.opengl.GL.*;  
import static com.jogamp.opengl.GL2.*;
import static com.jogamp.opengl.GL2ES3.GL_QUADS; 
import java.util.List;
@SuppressWarnings("serial")
public class Figura2D extends GLCanvas implements GLEventListener {
   public static String TITLE = "Figura2D";
   public static final int CANVAS_ANCHO = 640;  
   public static final int CANVAS_ALTURA = 480; 
   public static final int FPS = 60; 

   
   private static List<Figura> listaFiguras;

   
   private static boolean cuadrado = false;
   private boolean triangulo= false;
   private static boolean circulo = false;
   public  void dibujarVentana() {
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
	   listaFiguras = new ArrayList<Figura>();
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
   
   @Override
   public void display(GLAutoDrawable drawable) {
	    GL2 gl = drawable.getGL().getGL2();  
	      gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
	      gl.glLoadIdentity();  

	      gl.glTranslatef(-1.5f, 0.0f, -6.0f); 
	      
	      dibujarFiguras(gl);
	    
   }

   public void dibujarFiguras(GL2 gl)
   {  
	  for(Figura f:listaFiguras)
		  f.dibujar(gl);

   }
   public void dibujarFigura(String figura,String color) {
	   
	   switch(figura) {
	   	case "triangulo":listaFiguras.add(new Triangulo(color));break;
	   	case "cuadrado":listaFiguras.add(new Cuadrado(color));break;
	   	case "rectangulo":listaFiguras.add(new Rectangulo(color));break;
	   	case "circulo":listaFiguras.add(new Circulo(color));break;
	   	default : System.out.println("figura no reconocida");
	   
	   }
	   
   }
   
   public Figura identificarFigura(String figura,String color) {
	 
	   for(Figura f:listaFiguras) {
		   if(f.getTipo().equals(figura) &&  f.getNombreColor().equals(color))
			   return f;
	   }
	   System.out.println("figura no encontrada");
	   return null;
   }
   @Override
   public void dispose(GLAutoDrawable drawable) { }
   
}
