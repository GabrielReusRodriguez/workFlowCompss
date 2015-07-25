package workflow.compss.bsc.es;

import integratedtoolkit.types.annotations.Method;
import integratedtoolkit.types.annotations.Parameter;
import integratedtoolkit.types.annotations.Parameter.Direction;
import integratedtoolkit.types.annotations.Parameter.Type;

public interface SimulacionItf{

	@Method(declaringClass = "workflow.compss.bsc.es.SimulacionImpl")
	public void simulaPaso(@Parameter(type = Type.FILE, direction = Direction.IN)  String v,  @Parameter(type = Type.FILE, direction = Direction.OUT)  String out) throws SimulacionAppException;

	@Method(declaringClass = "workflow.compss.bsc.es.SimulacionImpl")
	public void analiza(@Parameter(type = Type.FILE ,direction = Direction.IN)  String v1, @Parameter(type = Type.FILE, direction = Direction.IN)  String v2, @Parameter( type = Type.FILE, direction = Direction.INOUT)  String out) throws SimulacionAppException;
	
	@Method(declaringClass = "workflow.compss.bsc.es.SimulacionImpl")
	//public void extraeConclusiones(@Parameter(type = Type.FILE ,direction = Direction.IN)  String v1, @Parameter(type = Type.BOOLEAN, direction = Direction.OUT) Boolean conclusiones) throws SimulacionAppException;
	public void extraeConclusiones(@Parameter(type = Type.FILE ,direction = Direction.IN)  String v1, 
			@Parameter (direction = Direction.INOUT)
			Resultado conclusiones) throws SimulacionAppException;
	
	
	@Method(declaringClass = "workflow.compss.bsc.es.SimulacionImpl")
	//public void escribeConclusion(@Parameter(type = Type.FILE ,direction = Direction.OUT) String fichero, @Parameter(type = Type.INT, direction = Direction.IN) Integer num_analisis_validos, @Parameter(type = Type.INT, direction = Direction.IN)Integer NUM_STEPS) throws SimulacionAppException;
	public void escribeConclusion(@Parameter(type = Type.FILE ,direction = Direction.OUT) String fichero, 
			@Parameter
			Integer num_analisis_validos, 
			@Parameter
			Integer NUM_STEPS) throws SimulacionAppException;
	
}
