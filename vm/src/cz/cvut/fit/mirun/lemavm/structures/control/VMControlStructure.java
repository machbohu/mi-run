package cz.cvut.fit.mirun.lemavm.structures.control;

import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

public abstract class VMControlStructure implements Evaluable {

	private ObjectType type;

	public VMControlStructure(ObjectType type) {
		this.type = type;
	}

	public ObjectType getType() {
		return type;
	}
}
