package prac.java;

public class SingleTonStatic {

	private static class SingleTonHolder{
		private static final SingleTonStatic sin = new SingleTonStatic();
	}
	
	public SingleTonStatic getInstance() {
		return SingleTonHolder.sin;
	}
	
}
