public class Fcfs {
	
	LinkedList myprocs; //their own personal copy of processes to work with
	Node running;
	boolean found;
	boolean done = false;
	
	public Fcfs(LinkedList processes, int numproc){
		myprocs = processes;
		System.out.println(myprocs.print());
		//no sort
		int counter = 0;
		while(counter<7){
			cycle(counter);
			counter++;
		}
	}

	public void cycle(int cycnum){ //cycnum keeps track of how many cycles
		
		Node cur = myprocs.getFirst();
		System.out.printf("\nBefore cycle %d:\n", cycnum);
		found = false;
		while(cur.hasNext()){
			cycleNode(cur);
			cur = cur.next;
		}
		cycleNode(cur);
	}
	
	
	//
	//if something is ready, it needs to run then
	//
	public void cycleNode(Node n){
		System.out.println("cycle: " + n.proc.print() );
		System.out.println("state: " + n.proc.state );
		//I can do a switch statement here
		if(n.proc.state==1){
			n.proc.state = -1;
		}else if(n.proc.state==-1){
			n.proc.state=1;
			n.proc.tempcpu--;
			found = true;
			running = n;
			if(n.proc.tempcpu==0){//finished running
				n.proc.state = 3;					
			}
		}else if(n.proc.state==0 && n.proc.arrivalTime>0){ //if it has to wait
			n.proc.tempwait--;
		}else if(!found && (n.proc.state==0 || n.proc.state==2)){ //first one to be found
			n.proc.state = 1;
			found = true;
			running = n;
		}
	}//end of cyclenode
}//end of fcfs
