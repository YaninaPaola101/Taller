package figuras;

import java.util.List;

import com.jogamp.opengl.GL2;

public abstract class Figura {
	
	protected float[] color;
	protected String tipo;
	protected String nombreColor;
	protected List<Punto> listaVertices;
	public abstract void dibujar(GL2 gl);
	public boolean[] movimientos= {false,false,false,false,false};
	public static final int ARRIBA=0;
	public static final int DERECHA=1;
	public static final int ABAJO=2;
	public static final int IZQUIERDA=3;
	public static final int PARAR=4;
	private float aditivox;
	private float aditivoy;
	private float velocidad =0.005f;
	
	private void movimientox() {
		for(Punto p:listaVertices)
			p.setCoordenadax(p.getCoordenadax()+aditivox);
	}
	private void movimientoy() {
		for(Punto p:listaVertices)
			p.setCoordenaday(p.getCoordenaday()+aditivoy);
	}
	public void mover() {
		moverArriba();
		moverAbajo();
		moverIzquierda();
		moverDerecha();
	}

	public void moverArriba()
	{   
		if(movimientos[ARRIBA]) {
			aditivox = 0.0f;
		    aditivoy= velocidad;
		    movimientoy();
		}
	}
	
	public void moverAbajo()
	{
		if(movimientos[ABAJO]) {
		    aditivox = 0.0f;
		    aditivoy = -velocidad;
		    movimientoy();
	    }
	}
	public void moverIzquierda()
	{
		if(movimientos[IZQUIERDA]) {
		    aditivoy = 0.0f;
		    aditivox=-velocidad;
	//	    coordenadaX=aditivox;
		    movimientox();
		}
	}
	public void moverDerecha()
	{
		if(movimientos[DERECHA]) {
		    aditivoy=0.0f;
		    aditivox = velocidad;
	//	    coordenadaX=aditivox;
		    movimientox();
		}
	}
	public void parar()
	{
	    aditivox = 0.0f;
	    aditivoy = 0.0f;
	    movimientos[ARRIBA]=false;
	    movimientos[ABAJO]=false;
	    movimientos[DERECHA]=false;
	    movimientos[IZQUIERDA]=false;
	}
	
	
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