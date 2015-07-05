package workflow.compss.bsc.es.coreelements;

import workflow.compss.bsc.es.Block;
import workflow.compss.bsc.es.SimulacionAppException;


public class SimulacionImpl{

	public static void simulaPaso(double[] v1, double[]  out){
	
	}

	public static void analiza(double[] v1, double[] v2, double[] out){
	
	}
	
	public static void simulaPaso(String v1, String out) throws SimulacionAppException{
		Block a = new Block(v1);
		//a.lu0();
		a.printBlock();
		a.blockToDisk(v1);
	}
	
	public static void analiza(String v1, String v2, String out) throws SimulacionAppException{
		
	}
	
	public static void extraeConclusiones(String v1, Boolean positive) throws SimulacionAppException{
		
	}
	
	
}
