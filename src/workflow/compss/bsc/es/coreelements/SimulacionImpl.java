package workflow.compss.bsc.es.coreelements;

import workflow.compss.bsc.es.SimulacionAppException;
import workflow.compss.bsc.es.VectorFile;


public class SimulacionImpl{

	public static void simulaPaso(double[] v1, double[]  out){
	
	}

	public static void analiza(double[] v1, double[] v2, double[] out){
	
	}
	
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
	
	public static void extraeConclusiones(String v1, Boolean positive) throws SimulacionAppException{
		VectorFile data1 = new VectorFile(v1);
		boolean conclusion = data1.extraeConclusiones();
		positive = conclusion;
	}
}
