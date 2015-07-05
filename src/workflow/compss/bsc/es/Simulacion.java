package workflow.compss.bsc.es;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import workflow.compss.bsc.es.coreelements.SimulacionImpl;

public class Simulacion{
	
	public static int NUM_STEPS=0;
	public static int SIZE_STEPS=0;
	
	private static boolean[][] matriu;
	private static String carpeta = "./data/";
	private static List<String> pasos = new ArrayList<String>();
	
	
	public static void main(String[] args){

		if ( args.length != 2 ) {
			System.out.println("Usage: java Simulacion <num_steps> <size_step>  \n");
			return;
		}	
		
		NUM_STEPS = Integer.parseInt(args[0]);
		SIZE_STEPS = Integer.parseInt(args[1]);
		
			for (int i = 0; i < NUM_STEPS; i++){
				for (int j = 0; j < SIZE_STEPS; j++){
					String fileName = carpeta+"sim_"+i+"." + j; 
					try{
						SimulacionImpl.simulaPaso(fileName+".in", fileName+".out");
					}catch(SimulacionAppException e){
						e.printStackTrace();
						continue;
					}
					if ( i != 0 && (i+1) % 2 == 0){
						try{
						SimulacionImpl.analiza(carpeta+"sim_"+(i-1)+"."+j+".out", carpeta+"sim_"+i+"."+j+".out", carpeta+"analisis_"+(i-1)+"."+i);
						}catch(SimulacionAppException e){
							e.printStackTrace();
							continue;
						}
					}
				}
			}
			int num_analisis_validos = 0;
			for (int i = 0; i < NUM_STEPS; i++){
				boolean conclusion = false;
				try{
					SimulacionImpl.extraeConclusiones(carpeta+"analisis_"+(i-1)+"."+i,conclusion);
				}catch(SimulacionAppException e){
					e.printStackTrace();
					conclusion = false;
				}
				if(conclusion){
					num_analisis_validos++;
				}
			}
			if(num_analisis_validos > (float)NUM_STEPS / 2.0f){
				System.out.println("Analisis valido");
			}			
		
	}
	
	public static void initialize(String filename, int ii, int jj) throws SimulacionAppException {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filename);
		}
		catch (FileNotFoundException fnfe) {
			throw new SimulacionAppException(fnfe.getMessage());
		}
			
		try {
			double initVal = 1325;
			for ( int i = 0; i < Block.BLOCK_SIZE; i++ ) {	
				for(int j = 0; j < Block.BLOCK_SIZE; j++) {
					initVal = (3125 * initVal) % 65536;
					double cellValue = 0.0001;
					if (ii == jj) {
						if (i == j)
							cellValue = -20000;
						if ((i - 1 == j) || (i == j - 1))
							cellValue = 10000;
					}
					fos.write((cellValue + " ").getBytes());
				}
				fos.write("\n".getBytes());
			}
			fos.close();
		}
		catch (IOException ioe) {
			throw new SimulacionAppException(ioe.getMessage());
		}		
	}
}
