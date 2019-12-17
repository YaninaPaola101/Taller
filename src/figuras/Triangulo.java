package figuras;

import static com.jogamp.opengl.GL.GL_TRIANGLES;

import com.jogamp.opengl.GL2;


public class Triangulo extends Figura {
	private Punto puntoa;
	private Punto puntob;
	private Punto puntoc;
	public Triangulo(String color){
		puntoa = new Punto(0.0f, 1.0f, 0.0f);
		puntob = new Punto(-1.0f, -1.0f, 0.0f);
		puntoc = new Punto(1.0f, -1.0f, 0.0f);
		asignarColor(color);
	}
	public void dibujar(GL2 gl){  
		
//	   gl.glTranslatef(6.5f, 0.0f, -6.0f); //
	   gl.glBegin(GL_TRIANGLES);  
	   gl.glColor3f(color[0],color[1],color[2]);
       gl.glVertex3f(puntoa.getCoordenadax(), puntoa.getCoordenaday(), puntoa.getCoordenadaz());
       gl.glVertex3f(puntob.getCoordenadax(), puntob.getCoordenaday(), puntob.getCoordenadaz());
       gl.glVertex3f(puntoc.getCoordenadax(), puntoc.getCoordenaday(), puntoc.getCoordenadaz());
       gl.glEnd();
	}

	@Override
	public void moverArriba() {
		
		
	}
	@Override
	public void moverDerecha() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moverAbajo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moverIzquierda() {
		// TODO Auto-generated method stub
		
	}

}
