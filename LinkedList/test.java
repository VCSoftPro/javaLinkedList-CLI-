import java.util.*;
/*
  Author Name : Vishnu Choudhary
  First Linked List Program in java.
  Subject : Study for 5th/6th sem VCSoftPro Uploaded.
*/

//Node Class is store a data and linked pointer.
class Node{
	//Only access for the node class and sotre data.
	private String Data; 
	private Node next; 
	
	//This constructor is init. value for the data and next pointer is not to reuired for writen but you can set the value.
	public Node(){
		Data = null;
		next = null;
	}
	//PeraMeterrize constructor is recive to type value and init for swap to data and next variable.
	public Node(String d, Node n){
		Data = d;
		next = n;
	}
	
	//This function is set to data in node for recive parameter value.
	public void setData(String d){
		Data = d;
	}
	//This function is set to pointer pint value for recive parameter value.
	public void setNext(Node n){
		next = n;
	}
	
	//This function return to data value.
	public String getData(){
		return(Data);
	}
	//This function return to next pointer value.
	public Node getNext(){
		return(next);
	}
}

//This class in store a operation for linked list, And call the node class by linked list class.
class LinkedList{
	private int size; //size variable is count and store the total node value.
	private Node start;//start is a first pointer to point the first node.
	
	//This constructor is init. the value for size and start in first time for calling this class. 
	public LinkedList(){
		size = 0;
		start = null;
	}
	
	// This function is inserted the value for node data member.
	public void insertAtFirst(String val){
		Node n; //create new node type pointer.
		n = new Node(); // create a new object for node class.
		n.setData(val); // set new node value.
		n.setNext(start);
		start = n;
		size++;
	}
	//This function is insert to last node in new node.
	public void insertAtLast(String val){
		Node n, t; // create new two node.
		n = new Node();//create a new object for node class.
		n.setData(val);//set new node value.
		t = start; //node t is point to start pointer point node.
		if(t == null)
			start = n;
		else{
			while(t.getNext() != null)//check  who is node pointer is null.
				t = t.getNext();
			t.setNext(n); // set null pointer to point to new node.
		} 
		size++;//count new node.
	}
	//This function is insert a particular position.
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
		
		
