package figuras;

import static com.jogamp.opengl.GL.GL_TRIANGLES;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;


public class Triangulo extends Figura {
	
	public Triangulo(String color){
		super.listaVertices = new ArrayList<Punto>();
		super.listaVertices.add(new Punto(0.0f, 1.0f, 0.0f));
		super.listaVertices.add(new Punto(-1.0f, -1.0f, 0.0f));
		super.listaVertices.add(new Punto(1.0f, -1.0f, 0.0f));
		this.nombreColor = color;
		asignarColor(color);
		super.setTipo("triangulo");
	
	}
	public void dibujar(GL2 gl){  
		
	
//	   gl.glTranslatef(6.5f, 0.0f, -6.0f); //
	   gl.glBegin(GL_TRIANGLES);  
	   gl.glColor3f(color[0],color[1],color[2]);
       
	   gl.glVertex3f(super.listaVertices.get(0).getCoordenadax(),
    		   		super.listaVertices.get(0).getCoordenaday(), 
    		   		super.listaVertices.get(0).getCoordenadaz());
       
       gl.glVertex3f(super.listaVertices.get(1).getCoordenadax(), 
    		   		super.listaVertices.get(1).getCoordenaday(), 
    		   		super.listaVertices.get(1).getCoordenadaz());
      
       gl.glVertex3f(super.listaVertices.get(2).getCoordenadax(), 
    		   		super.listaVertices.get(2).getCoordenaday(), 
    		   		super.listaVertices.get(2).getCoordenadaz());
       gl.glEnd();
       super.mover();
	}
	


}
