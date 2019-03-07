public class Fcfs {
	
	LinkedList myprocs; //their own personal copy of processes to work with
	Queue running = new Queue();
	Queue blocked = new Queue();
	Queue ready = new Queue();
	boolean found = false;
	boolean done = false;
	//I can have the queue separate from thing that puts it in the queue
	
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
		if(running.getFirst()==null){System.out.println("nothing running");}
		else{System.out.println("running" + running.print());}
		
		found = false;
		while(cur.hasNext()){
			cycleNode(cur);
			cur = cur.next;
		}
		cycleNode(cur);
		
		//after all nodes, add one to running
		System.out.println("Ready to be ran: " + ready.getFirst().proc.print());
		if(ready.getFirst()!=null){
			Process readyer = ready.remove();
			System.out.println("About to add to running:" + readyer.print());
			readyer.state = 1; //now it is running
			running.add(readyer);//run one process that is ready per cycle
			running.add(readyer);
			System.out.println("Now running" + running.print());
		}
		//so I can cycle and label, and the run queue once, one process, but they can be queued
	}
	
	//if it gets blocked it just gets popped and immediately pushed
	public void cycleNode(Node n){
		//what is this node doing
		System.out.println("cycle: " + n.proc.print() );
		System.out.println("state: " + n.proc.state );
		int state = n.proc.state;
		switch(state){
			case 1: //running
				Process temp = running.remove();
				System.out.println("running but about to blocking:" + temp.print());
				ready.add(temp);
				//determine cpu boost
				n.proc.state = 2;
				break;
			case 0: //waiting/ready
				if(n.proc.arrivalTime>0){n.proc.tempwait--;}//counting down until ready
				else{//if it is ready now
					ready.add(n.proc);//add to queue
					System.out.println("ready and about to add to ready:" + n.proc.print()); 
					n.proc.state = -1;
				}break;
			case 2: //blocked
				ready.add(blocked.remove());
				n.proc.state= -1;
				n.proc.tempcpu--;
				if(n.proc.tempcpu==0){//finished running
					n.proc.state = 3;	
					running.remove();
				}
				break;
		}//end of switch	
	}//end of cyclenode
}//end of fcfs
