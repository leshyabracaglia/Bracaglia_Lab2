public class Node {
	
	Process proc;
	Node next;
	
	public Node(Process inp){
		proc = inp;
		next = null;
	}
	
	public boolean hasNext(){
		if(this.next==null){
			return false;
		}else{
			return true;
		}
	}

}