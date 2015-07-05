package workflow.compss.bsc.es;

import integratedtoolkit.types.annotations.Method;
import integratedtoolkit.types.annotations.Parameter;
import integratedtoolkit.types.annotations.Parameter.Direction;
import integratedtoolkit.types.annotations.Parameter.Type;

public interface SimulacionItf{

	@Method(declaringClass = "workflow.compss.bsc.es.coreelements.SimulacionImpl", isModifier = true, isInit = false, priority = false)
	public void simulaPaso(@Parameter(type = Type.FILE, direction = Direction.IN)  String v,  @Parameter(type = Type.FILE, direction = Direction.OUT)  String out);

	@Method(declaringClass = "workflow.compss.bsc.es.coreelements.SimulacionImpl", isModifier = true, isInit = false, priority = false)
	public void analiza(@Parameter(type = Type.FILE ,direction = Direction.IN)  String v1, @Parameter(type = Type.FILE, direction = Direction.IN)  String v2, @Parameter( type = Type.FILE, direction = Direction.INOUT)  String out);
	
	@Method(declaringClass = "workflow.compss.bsc.es.coreelements.SimulacionImpl", isModifier = true, isInit = false, priority = false)
	public void extraeConclusiones(@Parameter(type = Type.FILE ,direction = Direction.IN)  String v1, @Parameter(direction = Direction.OUT) Boolean positive);
	
}
