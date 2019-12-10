package comandosDeVoz;

import geometria.Figura2D;
import listener.ComandosListener;

public class ManejarComandos implements ComandosListener{
	@Override
	public void comandoPronunciado(String comando) {
		//comando = analizarExpresion(comando);
		switch(comando) {
			case "mover triangulo arriba":Figura2D.moverArriba();break;
			case "mover triangulo abajo":Figura2D.moverAbajo();break;
			case "mover triangulo derecha":Figura2D.moverDerecha();break;
			case "mover triangulo izquierda":Figura2D.moverIzquierda();break;
			case "crear triangulo":Figura2D.crearTriangulo();break; 
			case "crear cuadrado":Figura2D.crearCuadrado();break; 
			case "crear circulo":Figura2D.crearCirculo();break; 
			
			case "parar":Figura2D.parar();break;
		}
	}
}
