package figuras;

public class Punto {

	private float coordenadax;
	private float coordenaday;
	private float coordenadaz;
	private float velocidad =0.005f;
	private float aditivox = 0.0f;
    private float aditivoy = 0.0f;
	public Punto(float coordenadax, float coordenaday, float coordenadaz ){
		this.coordenadax = coordenadax;
		this.coordenaday = coordenaday;
		this.coordenadaz = coordenadaz;
	}
	public float getCoordenadax(){
		return coordenadax;
	}
	public float getCoordenaday(){
		return coordenaday;
	}
	public float getCoordenadaz(){
		return coordenadaz;
	}
	public void setCoordenadax(float coordenadax){
		this.coordenadax = coordenadax;
	}
	public void setCoordenaday(float coordenaday){
		this.coordenaday = coordenaday;
	}
	public void setCoordenadaz(float coordenadaz){
		this.coordenadaz = coordenadaz;
	}
	public void moverArriba()
	{   
		aditivox = 0.0f;//
        aditivoy= velocidad;
        coordenaday=aditivoy;
	}
	public void moverAbajo()
	{
	    aditivox = 0.0f;
	    aditivoy = -velocidad;
        coordenaday=aditivoy;   
    }
	public void moverIzquierda()
    {
		aditivoy = 0.0f;
		aditivox=-velocidad;
		coordenadax=aditivox;
	}
    public void moverDerecha()
    {
   	    aditivoy=0.0f; 
   	    aditivox = velocidad;
   	    coordenadax=aditivox;   
	}
    public void parar()
    {
 	   aditivox = 0.0f;
 	   aditivoy = 0.0f;
    }
}
