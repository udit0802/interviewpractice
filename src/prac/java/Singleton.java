package prac.java;

import java.io.Serializable;

public class Singleton implements Cloneable,Serializable{

	private static volatile Singleton sin = null;
	
	private Singleton() throws Exception {
		//to prevent reflection
		if(null != sin)
			throw new Exception("Singleton class");
	}
	
	public static Singleton getInstance() throws Exception {
		
		if(null == sin) {
			synchronized (Singleton.class) {
				if(null == sin) {
					//this is a compound statment
					//construct an empty resource object
					//assign fields value
					//assign the variable to sin
					//volatile tells not to reorder the instructions
					sin = new Singleton();
				}
			}
		}
		return sin;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return sin;
	}
	
	protected Object readResolve() 
    { 
        return sin; 
    }
	
}
