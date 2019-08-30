
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; 

public class CircularListApp
{
	public static CircularList theList;
	public static CircularList theListR;
	public static CircularList theList2;
	public static int size=0;
	public static Words obje;
	public static int i=0;
	public static String secim;
	public static  ArrayList<String> tempo;
	public static String [ ] KelimeArray= new String [50] ;
	public static int genelsayac=0;
	
	public static void main(String[] args) throws IOException
	{
		
		
		
		Scanner scan = new Scanner(System.in);


		 theList = new CircularList(); 

		
	
		
	
								
								genelsayac=8;
								
								size=theList.size();
					
			
	
			Scanner keyboard = new Scanner(System.in);
   
		
	
			


 			while(0<1) {
 				
 				
 		System.out.println("secenek yapiniz");
 		
 		

 		secim= keyboard.nextLine();
 		
 		
 		
 		if(secim.contains("load")) {
 	 		
 			
 		   String dosya=secim.substring(secim.indexOf("d") + 2);
 			
			loadfile(dosya);

			
			
			
			while((i<tempo.size())) {
				
				 String cc=tempo.get(i);
			
				 
				 Node ccc=theList.search(tempo.get(i));
				 
				 
				 if((ccc!=null)) {
			
				
					 Node temp=theList.search((tempo.get(i)));
					 Words update = new Words();
					 update.setName(temp.getData().getName());        //varsa olani guncelle yeni ekleme
					 update.setFrekans(temp.getData().getId());
				
					 temp.setData(update);
					 
				 i++;
				 continue;
					
				 }
				 obje = new Words();

					obje.Frekans();
					obje.setName(tempo.get(i));
					Node ND = new Node(obje);
					theList.add(ND);	
					
					i++;
				
			
			}
			
			
			 size=theList.size();
				theList.sortList();  //siraladik 
			
			System.out.println(theList);
			
			
			
			
			
 		}
		
 		
 		if(secim.contains("max")) {
 		
 		   String sayii=secim.substring(secim.indexOf(" ") + 1);
 			
 		  int sayi = Integer.parseInt(sayii);		
 		  
 			 Max(sayi);
 			 
 		}
 		
 		
 		if (secim.contains("min")) {
 			
 			 String sayii=secim.substring(secim.indexOf(" ") + 1);
  			
 	 		  int sayi = Integer.parseInt(sayii);		
 	 		  
 	 			 
 			  Min(sayi);
		}
 		
		 if(secim.contains("freq")) {
			 
			 String word=secim.substring(secim.indexOf(" ") + 1);
	  			
	 				
			 
			  Freq(word);
		 }
			   
			 
		if (secim.contains("range")) {
			
			 String sayi1=secim.substring(secim.indexOf(" ") + 1,secim.lastIndexOf(" "));
			 
			 String sayi2=secim.substring(secim.lastIndexOf(" ")+1);

		
			 
						System.out.println(Range(1,2));   
						
		}
		
			   
			
			   
 		if(secim.contains("truncate")) {
 			
 			 String sayii=secim.substring(secim.indexOf(" ") + 1);
  			
 	 		  int sayi = Integer.parseInt(sayii);	
 	 		  
 			 System.out.println(Truncate(sayi));
 			
 		}
 		

			if(secim.contains("nth")) {
				 String sayii=secim.substring(secim.indexOf(" ") + 1);
		  			
	 	 		  int sayi = Integer.parseInt(sayii);	
	 	 		  
				Nth(sayi);
			}
	
 			
if(secim=="quit") {
	System.out.println("gorusuruz");
	break;
}
				
		System.out.println("Quit yazana kadar devam,ancak yanlis girersen cikti alamazsin");
							
					
 			}
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		

	}
	
	  
	  
	  
	  public static String Max(int N) {
		  
		 
		
		
		  
		  Node cursor=theList.getCursor();
		  if(N>size) {
			  System.out.println(theList);
		  }
		  else {
			  
			  
				  
			theList.MaxPrint(N);  	
			  
		  }
		return "";
		  
		  
	  }
	  
	  
	  
  public static String Min(int N) {
		  
	 int sayac=0;
	 
	  
	  Node cursor=theList.getCursor();
	  if(N>size) {
		  System.out.println(theList);
	  }
	  else {
		 
			  
		theList.MinPrint(N);  	
		  
	  }
	return "";

		  
	  }  
	  
  
  
  
  public static void Freq(String word) {
	  
	  
	  theList2 = new CircularList();
	  
	  theList2=theList;
	  
	 Node a=theList.search(word);
	 
	 System.out.println(a.getData().getId());
	  
	  
  }
  
  
  
  public static String Range(int a,int b) {
	  
	  Node cursor2 = theList.getCursor();
	  boolean anahtar = false;
	  String listr = "";

		for (int i = 0; i < size; i++)
		{
			System.out.println(cursor2.getData().getId());
			if(cursor2.getData().getId()<b+1 && cursor2.getData().getId()>a-1) {
			listr += cursor2.toString() + "\n";
			cursor2 = cursor2.getNext();
			anahtar=true;
		}
		}
		
		if(anahtar==false)
			return "Yok";
		
	return listr;
	 
	  
  }
  
  
  public static String Nth(int N) {
	  
		 
		
	 
	  
	  Node cursor=theList.getCursor();
	  
	  if(N>genelsayac) {
		 System.out.println("oyle bir eleman olamaz");
	  }
	  else {
		  
		  
			  
		theList.NthPrint(N);  	
		  
	  }
	return "";
	  
	  
  }
  
  
  
 public static String Truncate(int  sayi) {
	  
	  
	 Node cursor2 = theList.getCursor();
	  boolean anahtar = false;
	  String listr = "";

		for (int i = 0; i < size; i++)                                                
		{
			
		
			
			if(cursor2.getData().getId()>sayi) {               
				listr += cursor2.toString() ;       
			anahtar=true;
		}
			cursor2 = cursor2.getNext();
		}
		
		if(anahtar==false)
			theList=null;
		
	return listr;
	 
	  
	  
  }
  
  
  
  public static void loadfile(String dosya) {
	  
	  try {
	        Scanner a = new Scanner (new FileInputStream (dosya));

	        while (a.hasNext()){
	        	 String line = a.nextLine();
	        	 
	        	 for (int j = 0; j < line.length(); j++) {
	        		 line=line.toLowerCase();
	        		 char cc=line.charAt(j);
	        		 int value = (int) (cc);
	        		 
	        		 if (value!=44 && (value < 97 || value > 122))              //virgul degilse ve harf degilse silecek
		        	  {
		        	 
		        	line=  line.replaceAll(cc+"", "");
		        	  }
				}
	        	
	        	 
	        	 
	        	 
	        	 
	             String[] temp = line.split(",");
	          
	             
	             tempo=new ArrayList<String>(Arrays.asList(temp));                 //basta fileio suz yazmistim fileio ekleyince tum metodlari equals yapmam gerekti anlayana kadar kelimeleri en son arraylist tutmusum

	        }
	        a.close();

	    }catch (FileNotFoundException e){
	        System.out.println("File not found");
	    }
	  
	  
	
}
  
  
  
  
	  
	  
	
}
