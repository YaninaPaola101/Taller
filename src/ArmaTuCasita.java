import comandosDeVoz.ManejarComandos;
import comandosDeVoz.ReconocimientoDePalabras;
import geometria.Figura2D;



public class ArmaTuCasita {

	public static void main(String args[])
	{
		
		ManejarComandos manejarComandos = new ManejarComandos();
		ReconocimientoDePalabras.addListener(manejarComandos);
		ReconocimientoDePalabras.reconocimiento();
		
		Figura2D.dibujarVentana();
		
		
	}

}

