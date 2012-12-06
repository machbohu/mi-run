package cz.cvut.fit.mirun.lemavm.tests;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.mirun.lemavm.observers.ConsoleObserver;

public class TestOutput implements ConsoleObserver{
	private List<String> vals;
	
	public TestOutput(){
		vals = new ArrayList<>();
	}
	
	@Override
	public void update(Object o) {
	}

	@Override
	public void update(String val) {
		vals.add(val);
	}

	public String getVal(int i) {
		return vals.get(i);
	}
	
	public void clearVals(){
		vals.clear();
	}
}
