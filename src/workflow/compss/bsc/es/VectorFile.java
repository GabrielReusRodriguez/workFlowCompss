package workflow.compss.bsc.es;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

public class VectorFile {

	private double[] data;
	private int size = 0;

	private VectorFile(int size) {
		this.size = size;
		this.data = new double[this.size];
	}

	public VectorFile(String filename) {
		try {
			FileReader filereader = new FileReader(filename);
			BufferedReader br = new BufferedReader(filereader); // Get a
																// buffered
																// reader. More
																// Efficient
			StringTokenizer tokens;
			String nextLine;

			nextLine = br.readLine();
			tokens = new StringTokenizer(nextLine);
			int i = 0;
			while (tokens.hasMoreTokens()) {
				if (this.size == 0) {
					this.size = Integer.parseInt(tokens.nextToken());
					this.data = new double[this.size];
				} else {
					this.data[i] = Double.parseDouble(tokens.nextToken());
					i++;
				}
			}
			br.close();
			filereader.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void printBlock() {
		for (int i = 0; i < this.size; i++) {
			System.out.print(data[i] + " ");

		}
		System.out.println();
	}

	public void toDisk(String filename) throws SimulacionAppException {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			String init = (new Integer(this.size)).toString() + " ";
			fos.write(init.getBytes());
			for (int i = 0; i < this.size; i++) {
				String str = (new Double(data[i])).toString() + " ";
				fos.write(str.getBytes());
			}
			fos.write("\n".getBytes());
			fos.close();

		} catch (FileNotFoundException fnfe) {
			throw new SimulacionAppException(fnfe.getMessage());
		} catch (IOException ioe) {
			throw new SimulacionAppException(ioe.getMessage());
		}
	}

	public void simula() {
		Random random = new Random();
		double rand = 0.0f;
		for (int i = 0; i < this.size; i++) {
			rand = random.nextDouble();
			data[i] = data[i] / rand;
		}
	}

	protected int getSize() {
		return this.size;
	}

	protected double[] getData() {
		return this.data;
	}

	protected void setData(double[] data) {
		this.data = data;
	}

	public void analiza(VectorFile data, String out) throws SimulacionAppException {
		VectorFile vout = new VectorFile(data.getSize());
		double[] datos = vout.getData();
		for(int i=0;i<datos.length;i++){
			datos[i]=0.0d;
		}
		for (int i = 0; i < this.size; i++) {
			if (i < datos.length) {
				if (datos[i] < this.data[i]) {
					datos[i] = 1.0d;
				}
			}
		}
		vout.setData(datos);
		vout.toDisk(out);
	}
	
	public boolean extraeConclusiones(){
		int num_valido =0;
		for (int i = 0; i < data.length; i++) {
			if(data[i] > 10.0f){
				num_valido++;
			}else{
				
			}
		}
		
		if((float)num_valido > (float)data.length/2.0f ){
			return true;
		}else{
			return false;
		}
	}
}
