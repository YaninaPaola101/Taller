package figuras;

import java.util.List;

import com.jogamp.opengl.GL2;

public abstract class Figura {
	
	protected float[] color;
	protected String tipo;
	protected String nombreColor;
	protected List<Punto> listaVertices;
	public abstract void dibujar(GL2 gl);
	
	private float aditivox;
	private float aditivoy;
	private float velocidad =0.005f;
//	
//	public void moverArriba()
//	{   
//	    aditivox = 0.0f;
//	    aditivoy= velocidad;
//	    coordenaday=aditivoy;
//	}
//	public void moverAbajo()
//	{
//	    aditivox = 0.0f;
//	    aditivoy = -velocidad;
//	    coordenadaY=aditivoy;   
//	}
//	public void moverIzquierda()
//	{
//	    aditivoy = 0.0f;
//	    aditivox=-velocidad;
//	    coordenadaX=aditivox;
//	}
//	public void moverDerecha()
//	{
//	    aditivoy=0.0f;
//	    aditivox = velocidad;
//	    coordenadaX=aditivox;   
//	}
//	public void parar()
//	{
//	    aditivox = 0.0f;
//	    aditivoy = 0.0f;
//	}
	
	
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