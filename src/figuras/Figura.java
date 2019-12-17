package figuras;

import com.jogamp.opengl.GL2;

public abstract class Figura {
	
	protected float[] color;
	protected String tipo;
	protected String nombreColor;
	
	public abstract void dibujar(GL2 gl);
	public abstract void moverArriba();
	public abstract void moverDerecha();
	public abstract void moverAbajo();
	public abstract void moverIzquierda();
	public abstract void parar();
	
	
	public void asignarColor(String color){
		switch(color){
			case "rojo":this.color = Color.ROJO;break;
			case "amarillo":this.color = Color.AMARILLO;break;
			case "verde":this.color = Color.VERDE;break;
			case "azul":this.color = Color.AZUL;break;
			case "negro":this.color = Color.NEGRO;break;
			default :System.out.println("color no reconocido");break;
		}
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombreColor() {
		return nombreColor;
	}
	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}

}