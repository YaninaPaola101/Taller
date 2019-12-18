package figuras;


import java.util.ArrayList;

import com.jogamp.opengl.GL2;
public class Cuadrado extends Figura{

	public Cuadrado(String color) {
		super.listaVertices = new ArrayList<Punto>();

		super.listaVertices.add(new Punto(-1.0f, 1.0f, 0.0f));
		super.listaVertices.add(new Punto(1.0f, 1.0f, 0.0f));
		super.listaVertices.add(new Punto(1.0f, -1.0f, 0.0f));
		super.listaVertices.add(new Punto(-1.0f, -1.0f, 0.0f));
		this.nombreColor = color;
		asignarColor(color);
		super.setTipo("cuadrado");
	}
	public void dibujar(GL2 gl)
	{ 	
//	    gl.glTranslatef(1.5f, 0.0f, -6.0f); 
	    gl.glBegin(GL2.GL_QUADS); 
        
	    gl.glVertex3f(super.listaVertices.get(0).getCoordenadax(),
	        		super.listaVertices.get(0).getCoordenaday(),
	        		super.listaVertices.get(0).getCoordenadaz());
        
        gl.glVertex3f(super.listaVertices.get(1).getCoordenadax(), 
		   		super.listaVertices.get(1).getCoordenaday(), 
		   		super.listaVertices.get(1).getCoordenadaz());
        
        gl.glVertex3f(super.listaVertices.get(2).getCoordenadax(), 
		   		super.listaVertices.get(2).getCoordenaday(), 
		   		super.listaVertices.get(2).getCoordenadaz());
        
        gl.glVertex3f(super.listaVertices.get(3).getCoordenadax(), 
		   		super.listaVertices.get(3).getCoordenaday(), 
		   		super.listaVertices.get(3).getCoordenadaz());
        
        gl.glEnd();
        super.mover();
	}

	
}
