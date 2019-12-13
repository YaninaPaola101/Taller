package figuras;



import com.jogamp.opengl.GL2;
public class Cuadrado extends Figura{
	private Punto puntoa;
	private Punto puntob;
	private Punto puntoc;
	private Punto puntod;
	public Cuadrado() {
		this.puntoa = new Punto(-1.0f, 1.0f, 0.0f);
		this.puntob = new Punto(1.0f, 1.0f, 0.0f);
		this.puntoc = new Punto(1.0f, -1.0f, 0.0f);
		this.puntod = new Punto(-1.0f, -1.0f, 0.0f);
	}
	public void dibujar(GL2 gl)
	{ 	//implementar coordenadas punto ,get
//	    gl.glTranslatef(1.5f, 0.0f, -6.0f); 
	    gl.glBegin(GL2.GL_QUADS); 
        gl.glVertex3f(puntoa.getCoordenadax(), puntoa.getCoordenaday(), puntoa.getCoordenadaz());
        gl.glVertex3f(puntob.getCoordenadax(), puntob.getCoordenaday(), puntob.getCoordenadaz());
        gl.glVertex3f(puntoc.getCoordenadax(), puntoc.getCoordenaday(), puntoc.getCoordenadaz());
        gl.glVertex3f(puntod.getCoordenadax(), puntod.getCoordenaday(), puntod.getCoordenadaz());

        gl.glEnd();
	}
	@Override
	public void moverArriba() {
		// TODO Auto-generated method stub
		
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
