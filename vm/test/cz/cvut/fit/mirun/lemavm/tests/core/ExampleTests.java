package cz.cvut.fit.mirun.lemavm.tests.core;

import java.io.IOException;

import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VirtualMachine;

public class ExampleTests {
	@Test
	public void testKnapsack() throws IOException{
		String[] args = {"../example/knap_04.inst.dat",};
		
		VirtualMachine.initAndLaunch("../example/knapsack.lema", args);
	}
}
