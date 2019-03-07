import java.util.NoSuchElementException;

public class Queue implements Cloneable{
	
	private Node first;
	private Node position = null;
	
	public Queue(){
		first = null;
	}
	
	public Queue(Process c){
		this.addFirst(c);
	}
	
	public void add(Process c){  
		if(position==null){
			this.addFirst(c);
		}else{
			Node newn = new Node(c);
			newn.next = position.next;
			position.next = newn;
			position = newn;
		}
	}
	
	public void addFirst(Process c){
		Node newnode = new Node(c);
		newnode.next = null;
		this.first = newnode;
		position = newnode;
	}
	
	public Node getFirst(){
		return this.first;
	}
	
	public Process remove(){
		if(first==null){
			throw new NoSuchElementException();
		}
		Process c  = first.proc;
		first = first.next;
		return c;
	}
	
	public Process peek(){
		if(first==null){
			throw new NoSuchElementException();
		}
		Process c  = first.proc;
		return c;
	}
	
	public String print(){
		String s = "\nQueue:";
		Node counter = this.first;
		if(counter==null){
			return "";
		}
		s+=counter.proc.print();
		while(counter.next!=null){
			s+="next: " + counter.next.proc.print();
			counter = counter.next;
			s+="\nhi"+counter.proc.print();
		}
		
		return s;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {

	    return super.clone();
	}
	
	
	
}