package figuras;

import com.jogamp.opengl.GL2;

public abstract class Figura {
	
	protected float[] color;
	
	public static float[] ROJO = {0.0f,0.0f,0.0f};
	public abstract void dibujar(GL2 gl);
	public abstract void moverArriba();
	public abstract void moverDerecha();
	public abstract void moverAbajo();
	public abstract void moverIzquierda();
	
	public void asignarColor(String color){
		switch(color){
			case "rojo":this.color = Color.ROJO;break;
			default :System.out.println("color no reconocido");break;
		}
	}
}