package workflow.compss.bsc.es;

public class SimulacionAppException extends Exception {

	public SimulacionAppException() {
		super("unknown");
	}
	
	public SimulacionAppException( String _s ) {
		super(_s);
	}
}
