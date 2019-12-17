package figuras;

import com.jogamp.opengl.GL2;

public class Circulo extends Figura{

	public Circulo(String color) {
		super.asignarColor(color);
	}
	public void dibujar(GL2 gl){
	    int numVertices = 30;
        double radius = 1;

        gl.glColor3f(color[0],color[1],color[2]); 

        gl.glBegin(GL2.GL_POLYGON);
        {
            double angle = 0;
            double angleIncrement = 2 * Math.PI / numVertices;
            for (int i = 0; i < numVertices; i++) {
                angle = i * angleIncrement;
                Punto temp = new Punto((float)(radius * Math.cos(angle)), (float)(radius * Math.sin(angle)), 0.0f);

                gl.glVertex2d(temp.getCoordenadax(),temp.getCoordenaday());
            }
        }
        gl.glEnd();
	}


}
