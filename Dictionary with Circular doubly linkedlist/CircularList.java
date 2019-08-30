

public class CircularList
{
	public static int i=0;
	private Node cursor;
	private int size = 0;
	public static Words obje2;
	

	public CircularList()
	{
		cursor = null;
		size = 0;
	}

	
	public int size() {
		return this.size;
	}
	

	
	public void add(Node newNode)
	{
		if (size == 0)                              
		{
			cursor = newNode;
			newNode.setNext(cursor);	           
			newNode.setPrevious(cursor);            
		}

		if (size == 1)                            
		{
			cursor.setNext(newNode);                
			cursor.setPrevious(newNode);          
			newNode.setNext(cursor);                
			newNode.setPrevious(cursor);            
			cursor = newNode;
		}

		else                                        
		{
			newNode.setNext(cursor.getNext());      
			newNode.setPrevious(cursor);            
			cursor.getNext().setPrevious(newNode);  
			cursor.setNext(newNode);                
			cursor = newNode;
		}
		size++;
	}

	
	public Node remove()
	{
		if (size == 1)                                          
		{
			cursor.setNext(null);                              
			cursor.setPrevious(null);                          
			size--;											   
			return cursor;                                     
		}

		else													
		{
			cursor.getNext().setPrevious(cursor.getPrevious()); 
			cursor.getPrevious().setNext(cursor.getNext());     
			size--;                                             
			return cursor;                                      
		}
	}

	
	
	
	public void sortList() {  
		
		Node current = cursor, index = null;  
		Words temp;  
		if(cursor == null) {  
		System.out.println("List is empty");  
		}  
		else {  
		do{  
		
		index = current.getNext();  
		while(index != cursor) {  
		
		if(current.getData().getId() > index.getData().getId()) {  
		temp =current.getData();  
		current.setData(index.getData());  
		index.setData(temp);; 
		}  
		index= index.getNext();  
		}  
		current =current.getNext();  
		}while(current.getNext()!=cursor);   
		}  
		}  
		
		public void display() {  
		Node current = cursor;  
		if(cursor == null) {  
		System.out.println("List is empty");  
		}  
		else {  
		 do{  
		
		System.out.print(" "+ current.getData());  
		current = current.getNext();  
		}while(current != cursor);  
		System.out.println();}
		}
	
	

	

	public Node search(String key)
	{
		Node CursorClone=cursor;          //birden cok metodda bozabiliyor
	
		for (int i = 0; i < size; i++)
		{
			if (CursorClone.getData().getName().equals(key))  
			{
				
				return CursorClone;                    
			}
			else
				CursorClone = CursorClone.getNext();       
		}
		return null;                            
	}
	
	
	
	public Node search2(int frek)           //FREKANS ARAMAK ICIN
	{
		Node CursorClone2=cursor;
		
		for (int i = 0; i < size; i++)        
		{
			if (CursorClone2.getData().getId()== frek) 
			{
				return CursorClone2;                    
			}
			else
				CursorClone2 = CursorClone2.getNext();       
		}
		return null;                             
	}
	

	
	public String NthPrint(int z)              
	{
		String list2 = "";
		Node cc=cursor;
		
		
		for (int i = 0; i < z; i++)
		{
			list2 = cc.getPrevious().toString();
			cc = cc.getPrevious();
		}
		return list2;
	}
	
	
	

	public String MaxPrint(int y)
	{
		String list2 = "";
		
		int degisim=0;
		
		Node ccc=cursor.getPrevious();
	
		
		
		for (int i = 0; i < size; i++)
		{
			
			
			if(ccc.getData().getId()!=ccc.getPrevious().getData().getId()) {      //degistikce degisimi arttiriyorum
				degisim++;
			}
			
		
			
			System.out.print(ccc.getData());
			
			ccc = ccc.getPrevious();
			
			if(degisim==y) {          //degisim verilen gruplama sayisina esit olursa kod durmali
				
				
				return list2;
			}
			
			
		}
		return list2;
	}
	
	
	
	public String MinPrint(int x)
	{
		int degisim=0;
		Node ccc=cursor;
		Node cccc=ccc;
		String list = "";
		  CircularList theListt = null; 

		for (int i = 0; i < size; i++)
		{
			if(ccc.getData().getId()!=ccc.getNext().getData().getId()) {      //degistikce degisimi arttiriyorum
				degisim++;
			
			}
			
			
			System.out.print(ccc.getData());

			list += ccc.toString() ;
			
			
			ccc = ccc.getNext(); 
			if(degisim==x) {          //degisim verilen gruplama sayisina esit olursa kod durmali
			
			
				return list;
			}
			
		}
		return list;
	}
	
	
	
	
	
	
	public boolean isEmpty()
	{
		return size == 0;
	}

	
	public Node setCursor (Node currentCursor)
	{
		cursor = currentCursor.getNext();
		return currentCursor;
	}

	
	public Node getCursor() {
		return cursor;
		
		
	}
	
	public String toString()
	{
		String list = "";

		for (int i = 0; i < size; i++)
		{
			list += cursor.toString() ;
			cursor = cursor.getNext();
		}
		return list;
	}
}