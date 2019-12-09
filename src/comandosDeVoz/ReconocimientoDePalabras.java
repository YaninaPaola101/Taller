package comandosDeVoz;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;
import listener.ComandosListener;

public class ReconocimientoDePalabras {
	
	private static LiveSpeechRecognizer reconocedor;
	private static String resultadoReconocimientoVoz;
	private static boolean ignorarResultadoReconocimientoVoz = false;
	private static boolean hiloReconomientoVozEjecutando = false;
	private static boolean hiloRecursosEjecutando;
	private static ExecutorService servicioEjecutorEventos = Executors.newFixedThreadPool(2);
	private static ComandosListener comandosListener;
	public static void addListener(ComandosListener comandosListener) {
		ReconocimientoDePalabras.comandosListener = comandosListener;
	}
	public static void reconocimiento(){
		Configuration configuracion = new Configuration();
		
		configuracion.setAcousticModelPath("resource:/cmusphinx-es-5.2/model_parameters/voxforge_es_sphinx.cd_ptm_4000");
		configuracion.setDictionaryPath("resources/libraries/voxforge_es_sphinx.dic");

		configuracion.setGrammarPath("resource:/grammars");
		configuracion.setGrammarName("grammar");
		configuracion.setUseGrammar(true);
		
		try {
			reconocedor = new LiveSpeechRecognizer(configuracion);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		empezarHiloRecursos();
		empezarReconocimientoVoz();
	}
	

	private static synchronized void empezarReconocimientoVoz() {
		
		
		if (hiloReconomientoVozEjecutando)
			System.out.println("Hilo de reconocimiento de voz corriendo...\n");
		else
			//subir al servicio ejecutor
			servicioEjecutorEventos.submit(() -> {
				
				//flags
				hiloReconomientoVozEjecutando = true;
				ignorarResultadoReconocimientoVoz = false;
				
				//empezar reconocimiento
				reconocedor.startRecognition(true);
				
				//Informacion			
				System.out.println("Puedes empezar a hablar...\n");
				
				try {
					while (hiloReconomientoVozEjecutando) {
						/*
						 * Este metodo retornara cuando se llegue al final del habla. Notar que el puntero final determinara el final del habla
						 */
						SpeechResult resultadoVoz = reconocedor.getResult();
						//Revisa si ignoramos el resultado del reconocimiento de voz
						if (!ignorarResultadoReconocimientoVoz) {
							//Revisar resultado
							if (resultadoVoz == null)
								System.out.println("No se entiende lo que dices.\n");
							else {			
								resultadoReconocimientoVoz = resultadoVoz.getHypothesis();			
								tomarDecision(resultadoReconocimientoVoz);							
							}
						} 
						else
							System.out.println("Ignorar resultados del reconocimiento...");
						
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					hiloReconomientoVozEjecutando = false;
				}
				
				System.out.println("Hilo de voz se salio...");
				
			});
	}

	private static void empezarHiloRecursos() {
		
		//Revisar flags
		if (hiloRecursosEjecutando)
			System.out.println("Hilo de recursos corriendo...\n");
		else
			//Submit al servicio ejecturo
			servicioEjecutorEventos.submit(() -> {
				try {
					
					//Lock
					hiloRecursosEjecutando = true;
					
					// Detecta si hay microfono
					while (true) {
						// Dormir un tiempo
						Thread.sleep(350);
					}
					
				} catch (InterruptedException ex) {
					ex.printStackTrace();
					hiloRecursosEjecutando = false;
				}
			});
	}
	

	private static void tomarDecision(String habla ) {
		System.out.println(habla);
		comandosListener.comandoPronunciado(habla);
	}

}