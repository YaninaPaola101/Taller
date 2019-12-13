package comandosDeVoz;

import geometria.Figura2D;
import listener.ComandosListener;

public class ManejarComandos implements ComandosListener{
	
	private Figura2D ventana ;
	
	public ManejarComandos() {
		ventana = new Figura2D();
	}
	@Override
	public void comandoPronunciado(String comando) {

		switch(comando) {
			case "mover triangulo arriba":Figura2D.moverArriba();break;
			case "mover triangulo abajo":Figura2D.moverAbajo();break;
			case "mover triangulo derecha":Figura2D.moverDerecha();break;
			case "mover triangulo izquierda":Figura2D.moverIzquierda();break;
			case "crear triangulo":ventana.crearTriangulo();break; 
			case "crear cuadrado":ventana.crearCuadrado();break; 
			case "crear circulo":ventana.crearCirculo();break; 
			
			case "parar":Figura2D.parar();break;
		}
	}
	public void setVentana(Figura2D f) {
		ventana = f;
		ventana.dibujarVentana();
	}
}
