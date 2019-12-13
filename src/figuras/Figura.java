package figuras;

import com.jogamp.opengl.GL2;

public abstract class Figura {
	public abstract void dibujar(GL2 gl);
	public abstract void moverArriba();
	public abstract void moverDerecha();
	public abstract void moverAbajo();
	public abstract void moverIzquierda();
}
