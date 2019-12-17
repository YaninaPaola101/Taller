package comandosDeVoz;

import figuras.Figura;
import geometria.Figura2D;
import listener.ComandosListener;

public class ManejarComandos implements ComandosListener{
	
	private Figura2D ventanaFiguras ;
	
	public ManejarComandos() {
		ventanaFiguras = new Figura2D();
	}
	
	//metodo principal de todo 
	@Override
	public void comandoPronunciado(String comando) {
		String[] palabras = comando.split(" ");
		
		if(comando.startsWith("mover")){//{"mover","triangulo","rojo","arriba"}
			moverFigura(palabras[1],palabras[2],palabras[3]);
		}else {
			if(comando.startsWith("parar")) {//{"parar","triangulo","rojo"}
				pararFigura(palabras[1],palabras[2]);
			}else {
				if(comando.startsWith("crear")) {
					crearFigura(palabras);
				}
				else {
					System.out.println("No se reconocio comando ");
				}
			}
		}
	}
	private void pararFigura(String figura,String color) {
		Figura figuraBuscada= ventanaFiguras.identificarFigura(figura, color);
		figuraBuscada.parar();
	}
	private void moverFigura(String figura,String color,String direccion) {
		Figura figuraBuscada= ventanaFiguras.identificarFigura(figura, color);
		if(figuraBuscada == null)
			System.out.println("figura no encontrada");
		else {
			switch(direccion) {
				case "arriba":figuraBuscada.moverArriba();break;
				case "abajo":figuraBuscada.moverAbajo();break;
				case "derecha":figuraBuscada.moverDerecha();break;
				case "izquierda":figuraBuscada.moverIzquierda();break;
//				case "parar":figuraBuscada.parar();break;
				default : System.out.println("movimiento no encontrado");break;
				
			}
		}
	}
	//{"crear","triangulo","rojo"}
	public void crearFigura(String[] palabras) {
		String figura = palabras[1];
		String color = palabras[2];
				
		ventanaFiguras.dibujarFigura(figura,color);		
		
		
	}
	public void setVentana(Figura2D f) {
		ventanaFiguras = f;
		ventanaFiguras.dibujarVentana();
	}
}
