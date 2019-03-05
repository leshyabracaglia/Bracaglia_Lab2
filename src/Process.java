public class Process {

	public int arrivalTime;
	public int bTime;
	public int cpuTime;
	public int ioTime;
	//******************
	//for state, -1=waiting, 0=ready, 1=running, 2=blocked, 3=finished
	public int state; 
	public int totalIoTime;
	public int tempwait;
	public int tempio;
	public int tempcpu;
	
	
	public Process(){ //empty constructor
		arrivalTime = 0;
		bTime = 0;
		cpuTime = 0;
		ioTime = 0;
		state = 0;
	}
	
	public Process(int a, int b, int c, int io){ //constructor
		arrivalTime = a;
		bTime = b;
		cpuTime = c;
		ioTime = io;
		state = 0;
		tempwait = a;
		tempio = io;
		tempcpu = c;
	}
	
	public String print(){
		String s = "";
		s+= ("\n" + arrivalTime + ", " + bTime + ", " + cpuTime + ", " + ioTime);
		return s;
	}
	
	
}
