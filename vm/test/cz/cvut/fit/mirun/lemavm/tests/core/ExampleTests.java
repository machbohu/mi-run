package cz.cvut.fit.mirun.lemavm.tests.core;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VirtualMachine;
import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;

public class ExampleTests {

	@BeforeClass
	public static void setUpBeforeClass() {
		VMMemoryManager.resetMemoryManager();
	}

	@Test
	public void testKnapsack() throws IOException {
		String[] args = { "../example/knap_04.inst.dat",
				"../example/knap_04.inst.sol" };

		VirtualMachine.initAndLaunch("../example/knapsack.lema", args);
	}
}
