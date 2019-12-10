package figuras;

import com.jogamp.opengl.GL2;

public class Circulo {

	public void dibujar(GL2 gl){
	    int numVertices = 20;
        double radius = 0.5;

        // clear the window
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

//        gl.glColor3f(0, 0, 0); //set pen color to black
        // approximate  a circle with a polygon
        gl.glBegin(GL2.GL_POLYGON);
//        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        {
            double angle = 0;
            double angleIncrement = 2 * Math.PI / numVertices;
            for (int i = 0; i < numVertices; i++) {
                angle = i * angleIncrement;
                double x = radius * Math.cos(angle);
                double y = radius * Math.sin(angle);
                gl.glVertex2d(x, y);
            }
        }
        gl.glEnd();
	}
}
