import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
	
	public static    FloorCutTree<Ýcerik> bTree = new FloorCutTree<>();

	public static void main(String[] args) {
		
	
	  try {
					        Scanner a = new Scanner (new FileInputStream ("test-hw3.txt"));            
				
					        while (a.hasNext()){
					        	
					        	
					        	 String line = a.nextLine();	 
					        	 String[] splited = line.split(" ");           //Kontrol icin   space ayrimina gore  arraye attim

	        	 
	        	 
    if(splited[0].equals("create-root")) {
    	
    	   String letter=splited[1];
			
    	   for (int j = 0; j < letter.length(); j++) {
    			if(!Character.isLetter(letter.charAt(j))) {                                               //Sadece letter oldugunu kontrol ediyor
    				System.out.println("gecersiz rootname  tamamen letter olmalýdýr.");
    				throw new IllegalArgumentException("Only Letter!");

    			}
    				
		}
    
    	   
    	   
   		 bTree.CreateRoot(letter);
    	
    }
	        
    
    

    else if(splited[0].equals("assign-w")) {
    	String letter=splited[1];
    	
    	  for (int j = 0; j < letter.length(); j++) {
  			if(!Character.isLetter(letter.charAt(j))) {                                                          
  				System.out.println("gecersiz assign edilecek eleman  tamamen letter olmalýdýr.");
  				throw new IllegalArgumentException("Only Letter!");

  			}}
    	
    		int sayiw = Integer.parseInt(splited[2].replaceAll(" " ,""));		
    			bTree.assign_width(letter,sayiw);

    }
	        
	        
	        
	        
    else  if(splited[0].equals("assign-h")) { 
	        	String letter=splited[1].replaceAll(" ","");
	        	
	        	  for (int j = 0; j < letter.length(); j++) {
	        			if(!Character.isLetter(letter.charAt(j))) {          
	        				System.out.println("gecersiz assign edilecek eleman  tamamen letter olmalýdýr.");
	        				throw new IllegalArgumentException("Only Letter!");

	        			}}
	          	
	        	
	        	
	        		int sayiw = Integer.parseInt(splited[2]);		  
	    				bTree.assign_height(letter,sayiw);
			        }
	        
	        
	        
	        
    else      if(splited[0].equals("cut-v")) {		        
	        
    	for (int i = 1; i < splited.length; i++) {                        //3 degisken icinde kontrol edilecek ondan fazladan for var
					String letter=splited[i];
		                  
    	  for (int j = 0; j < letter.length(); j++) {
    			if(!Character.isLetter(letter.charAt(j))) {
    				System.out.println("gecersiz assign edilecek eleman  tamamen letter olmalýdýr.");
    				throw new IllegalArgumentException("Only Letter!");

    			}}
      	
    	}
    	
    	
	        			bTree.cut_vertical(splited[1], splited[2], splited[3]);
	        }
	        
    else      if(splited[0].equals("cut-h")) {		        

    	for (int i = 1; i < splited.length; i++) {
			String letter=splited[i];

  for (int j = 0; j < letter.length(); j++) {
		if(!Character.isLetter(letter.charAt(j))) {
			System.out.println("gecersiz assign edilecek eleman  tamamen letter olmalýdýr.");
			throw new IllegalArgumentException("Only Letter!");

		}}
	
}
    	
    	
	    		bTree.cut_horizontal(splited[1], splited[2], splited[3]);
	        
	        }
	          
	        
    else       if(splited[0].equals("compact")) {		 
	               
	        		bTree.compact();
	        	
	        }
	        
	        
    else       if(splited[0].equals("display")) {		 
	               System.out.println(     );
	               System.out.println(     );
	               System.out.println(     );
	        		bTree.display();
        }
	        
	        
    else      if(splited[0].equals("quit")) {		 
	               
        		System.exit(0);
        
        }

    else {
    	
    	System.out.println("yanlis girdi yok sayiliyor.");
    	
    	
    }
    
    
	        }
	        
	        
	        
	        
	        a.close();

	    }catch (FileNotFoundException e){
	        System.out.println("File not found");
	    }
}

	
}