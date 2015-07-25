package workflow.compss.bsc.es;

import java.io.Serializable;

public class Resultado implements Serializable{

	private boolean resultado = false;

	public Resultado(){
		
	}
	public Resultado(boolean res){
		this.resultado = res;
	}
	
	public boolean isResultadoValido() {
		return resultado;
	}

	public void setResultadoValido(boolean resultado) {
		this.resultado = resultado;
	}
	
	
	
	
}
