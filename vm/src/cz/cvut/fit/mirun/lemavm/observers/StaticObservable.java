package cz.cvut.fit.mirun.lemavm.observers;

import java.util.ArrayList;
import java.util.List;

public abstract class StaticObservable {
	private static List<ConsoleObserver> observers = new ArrayList<>();
	
	protected static void notifyObservers(String val){
		for(ConsoleObserver o : observers){
			o.update(val);
		}
	}
	
	public static void addObserver(ConsoleObserver o){
		observers.add(o);
	}
}
