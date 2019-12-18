package figuras;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class Circulo extends Figura{

	public Circulo(String color) {
		super.asignarColor(color);
		super.setTipo("circulo");
		super.setNombreColor(color);
		super.listaVertices= new ArrayList<Punto>();
		llenarVertices();
	}
	private void llenarVertices()
	{
		int numVertices = 30;
	    double radius = 1;
	    double angle = 0;
        double angleIncrement = 2 * Math.PI / numVertices;
        for (int i = 0; i < numVertices; i++) {
            angle = i * angleIncrement;
            Punto temp = new Punto((float)(radius * Math.cos(angle)), (float)(radius * Math.sin(angle)), 0.0f);
            super.listaVertices.add(temp);
        }
	}
	public void dibujar(GL2 gl){
	  
        gl.glColor3f(color[0],color[1],color[2]); 

        gl.glBegin(GL2.GL_POLYGON);
        {
        	for(Punto p:super.listaVertices)
                gl.glVertex2d(p.getCoordenadax(),p.getCoordenaday());
            
        }
        gl.glEnd();
        super.mover();
	}


}
