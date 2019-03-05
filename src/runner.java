import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class runner {

	public static void main(String[] args){
		
		//error if no file input
		if(args.length < 1) { 
	        System.out.println("Error, no input file specified");
	        System.exit(1);
	    }
		
		//input files
		File randomints, input; 
		Scanner c = null, sc = null;
		input = new File(args[0]);
		
		try { 
			c = new Scanner(input);
		} catch (FileNotFoundException e1) {
			System.out.println("input file not found.");
		}try {
			randomints = new File("random-numbers.txt");
			sc = new Scanner(randomints);
		} catch (FileNotFoundException e) {
			System.out.println("random integer file not found.");
		}
		
		int numproc = c.nextInt();
		System.out.printf("\n%d processes", numproc);
		
		//this wild hold the processes 
		LinkedList processes = new LinkedList();
		
		//put input into a linked list
		for(int i=0; i<numproc; i++){
			int a = c.nextInt();
			int b = c.nextInt();
			int cpu = c.nextInt();
			int io = c.nextInt();
			Process p = new Process(a, b, cpu, io);
			System.out.println(p.print());
			processes.add(p);
		}
		
		System.out.println(processes.print());
		
		Fcfs fcfsrunner = new Fcfs(processes, numproc);
	
		
		int ran = sc.nextInt();
		System.out.println(ran);
		int ranint = randomOS(1, ran);	//sc.nextInt();
		System.out.printf("\nRandom int: %d", ranint);

	}//end of main
	
	public static int randomOS(int x, int ranint){
		return (1+(ranint/x));	
	}

}
