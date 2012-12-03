package cz.cvut.fit.mirun.lemavm.structures.classes;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public class VMInstanceEnvironment extends VMEnvironment {

	private final VMObject owner;

	public VMInstanceEnvironment(VMObject owner) {
		super();
		this.owner = owner;
		init();
	}

	public VMInstanceEnvironment(VMEnvironment parent, VMObject owner) {
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
		// TODO
	}
}
