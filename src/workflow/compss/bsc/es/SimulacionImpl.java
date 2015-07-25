package workflow.compss.bsc.es;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class SimulacionImpl{
	
	public static void simulaPaso(String v1, String out) throws SimulacionAppException{
		VectorFile data1 = new VectorFile(v1);
		data1.simula();
		data1.toDisk(out);
	}
	
	public static void analiza(String v1, String v2, String out) throws SimulacionAppException{
		VectorFile data1 = new VectorFile(v1);
		VectorFile data2 = new VectorFile(v2);
		data1.analiza(data2,out);
	}

	public static void extraeConclusiones(String v1, Resultado resultado) throws SimulacionAppException{
		VectorFile data1 = new VectorFile(v1);
		boolean conclusion = data1.extraeConclusiones();
		resultado.setResultadoValido(conclusion);
	}
	
	public static void escribeConclusion(String fichero,Integer num_analisis_validos, Integer NUM_STEPS) throws SimulacionAppException{
		
		FileOutputStream fConclusion = null;
		String conclusion = "";
		try{
			fConclusion = new FileOutputStream(fichero);
			
			if( num_analisis_validos.floatValue() > NUM_STEPS.floatValue() / 4.0f){
				conclusion = "Analisis valido";
			}else{
				conclusion = "Analisis NO valido";
			}
			
			fConclusion.write(String.valueOf(conclusion).getBytes());
			fConclusion.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
			throw new SimulacionAppException(e.getMessage());
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new SimulacionAppException(e.getMessage());
		}
	}
}
