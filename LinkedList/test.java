import java.util.*;

class Node{
	private String Data;
	private Node next;
	
	public Node(){
		Data = null;
		next = null;
	}
	public Node(String d, Node n){
		Data = d;
		next = n;
	}
	
	public void setData(String d){
		Data = d;
	}
	public void setNext(Node n){
		next = n;
	}
	
	public String getData(){
		return(Data);
	}
	public Node getNext(){
		return(next);
	}
}

class LinkedList{
	private int size;
	private Node start;
	
	public LinkedList(){
		size = 0;
		start = null;
	}
	
	public void insertAtFirst(String val){
		Node n;
		n = new Node();
		n.setData(val);
		n.setNext(start);
		start = n;
		size++;
	}
	public void insertAtLast(String val){
		Node n, t;
		n = new Node();
		n.setData(val);
		t = start;
		if(t == null)
			start = n;
		else{
			while(t.getNext() != null)
				t = t.getNext();
			t.setNext(n);
		} 
		size++;
	}
	public void insertAtPos(String val, int pos){
		if(pos == 1)
			insertAtFirst(val);
		else if(pos == size+1)
			insertAtLast(val);
		else if(pos > 1 || pos < size){ //  uses  &&
			Node n, t;
			n = new Node(val, null);
			t = start;
			for(int i=1; i<= pos-1; i++)
				t = t.getNext();
			n.setNext(t.getNext());
			t.setNext(n);
			size++;
		}
		else
			System.out.println("insertion not possible at "+pos+"value");
		
	}
	
	public void deleteFirst(){
		if(start == null)
			System.out.println("List is alredy empty");
		else {
			start = start.getNext();
			size--;
		}
			
	}
	public void deleteLast(){
		if(start == null)
			System.out.println("List is already empty");
		else if(size == 1){
			start = null;
			size--;
		}
		else{
			Node t;
			t = start;
			for(int i=1; i <= size-1; i++)   //--------- condition i<size-1 try
				t = t.getNext();
			t.setNext(null);
			size--;
		}
			
	}
	public void deleteAtPos( int  pos){
		if(start == null)
			System.out.println("List is already empty");
		else if(pos == 1)
			deleteFirst();
		else if(pos < 1 || pos > size)
			System.out.println("deletion not possible for "+pos+" this position");
		else if(pos == size)
			deleteLast();
		else{
			Node t,t1;
			t = start;
			for(int i=1; i< pos-1;i++)
				t = t.getNext();
			t1 = t.getNext();
			t.setNext(t1.getNext());
					
		}
	}
	
	public boolean isEmpty(){
		if(start == null)
			return(true);
		else
			return(false);
	}
	
	public int getSize(){
		return(size);
	}
	
	public void viewList(){
		Node t;
		t = start;
		if(isEmpty()){
			System.out.println("List is Empty");
		}
		else{
			for(int i =1; i <= size; i++){
				System.out.print(" "+t.getData());
				t = t.getNext();
			}
		}
	}
}
public class test{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		while(true){
			System.out.println("\n1. Add item to the list at start ");
			System.out.println("2. Add item to the list at Last");
			System.out.println("3. Add item to the list at position");
			System.out.println("4. Delete First item from the list");
			System.out.println("5. Delete Last item from the list ");
			System.out.println("6. Delete item from the list given position");
			System.out.println("7. View List");
			System.out.println("8. exit");
			System.out.println("Enter your choice");
			int choice =sc.nextInt();
			int position;
			String val;
			switch(choice){
				case 1: 
						System.out.println("Enter Message");
						val = sc.next();
						list.insertAtFirst(val);
						break;
						
				case 2: 
						System.out.println("Enter Message");
						val = sc.next();
						list.insertAtLast(val);
						break;
						
				case 3: 
						System.out.println("Enter Position");
						position = sc.nextInt();
						System.out.println("Enter Message");
						val = sc.next();
						list.insertAtPos(val, position);
						break;
					
				case 4: 
						list.deleteFirst();
						break;
						
				case 5: 
						list.deleteLast();
						break;
						
				case 6: 
						System.out.println("Enter Position ");
						position = sc.nextInt();
						list.deleteAtPos(position);
						break;
						
				case 7:
						list.viewList();
						break;
				
				case 8:
						System.exit(0);
						break;		
						
				default :System.out.println("wrong Choice.");
			}
		}
		
	}
}
		
		