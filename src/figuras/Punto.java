package figuras;

public class Punto {

	private float coordenadax;
	private float coordenaday;
	private float coordenadaz;
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
}
