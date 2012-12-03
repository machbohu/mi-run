package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.Collection;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.utils.ParsingUtils;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public class VMInstanceEnvironment extends VMEnvironment {

	private final VMClassInstance owner;
	
	// TODO Do visibility checking

	public VMInstanceEnvironment(VMClassInstance owner) {
		super();
		this.owner = owner;
		init();
	}

	public VMInstanceEnvironment(VMEnvironment parent, VMClassInstance owner) {
		super(parent);
		this.owner = owner;
		init();
	}

	public VMObject getOwner() {
		return owner;
	}

	/**
	 * Initialize this environment with default field values as defined by the
	 * owner's class.
	 */
	private void init() {
		final VMClass cls = owner.getVMClass();
		final Collection<VMField> fields = cls.getFields().values();
		for (VMField f : fields) {
			if (ParsingUtils.isTypePrimitive(f.getType())) {
				if (f.getVal() != null) {
					addPrimitiveBinding(f.getName(), f.getVal(), f.getType());
				} else {
					addPrimitiveBinding(f.getName(),
							VMUtils.getTypeDefaultValue(f.getType()),
							f.getType());
				}
			} else {
				if (f.getVal() != null) {
					addBinding(f.getName(), (VMObject) f.getVal(), f.getType());
				} else {
					addBinding(f.getName(), VMNull.getInstance(), f.getType());
				}
			}
		}
	}
}
