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
		String[] palabras = comando.split(" ");
		
		if(comando.startsWith("mover")){
			
		}else {
			if(comando.startsWith("parar")) {
			
			}else {
				if(comando.startsWith("crear")) {
					crearFigura(palabras);
				}
				else {
					System.out.println("No se reconocio comando ");
				}
				
			}
		}
//		switch(comando) {
//			case "mover triangulo arriba":ventana.moverArriba();break;
//			case "mover triangulo abajo":ventana.moverAbajo();break;
//			case "mover triangulo derecha":ventana.moverDerecha();break;
//			case "mover triangulo izquierda":ventana.moverIzquierda();break;
//			case "crear triangulo":ventana.crearTriangulo();break; 
//			case "crear cuadrado":ventana.crearCuadrado();break; 
//			case "crear circulo":ventana.crearCirculo();break; 
//			
//			case "parar":ventana.parar();break;
//		}
	}
	//{"crear","triangulo","rojo"}
	public void crearFigura(String[] palabras) {
		String figura = palabras[1];
		String color = palabras[2];
				
		ventana.dibujarFigura(figura,color);		
		
		
	}
	public void setVentana(Figura2D f) {
		ventana = f;
		ventana.dibujarVentana();
	}
}
