package odev3;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;   
   
public class odev3
{
	
	
    public static boolean aa = false;
    

    
  public static ArrayList<String> dosyalar=new ArrayList<>();
  
  
public static String kelime="";


   public static void main(String[ ] args) throws IOException
   {
	

int dosyasay=0;
	  
	      
		   File dir = new File("food_txt");

		   for (File file : dir.listFiles()) {
		       Scanner s = new Scanner(file);
			   String c=file.getCanonicalPath();

		       dosyalar.add(c);   // dosyalarýn hepsini arrayliste attým
		       dosyasay++;
		       s.close();
		   }
	   
	   
		   MyHashMap<String, String> table = new MyHashMap<String,String>(dosyasay);
   
		   DosyalariOku(table);
      
      
      Scanner keyboard = new Scanner(System.in);
 
      
	   
      
	   while(!kelime.equals("-1")) {
	   
	   
      System.out.println("aranacak kelimeyi giriniz (cikis icin -1 giriniz)");

      kelime = keyboard.next();
      
   if(kelime.equals("-1")) {
	   System.out.println("hoscakalin");
	   continue;
	   
   }
   kelime=kelime.toLowerCase();

   long start_time = System.nanoTime();
      
      
      StringtoInt(table.get(kelime));
      
      long end_time = System.nanoTime();

      
      double difference = (end_time - start_time) / 1e6;
      
	   

      
      
System.out.println("Gecen zaman: "+difference+"  mili seconds");      
      
	   }
   }
   
  
   
  public static void StringtoInt(String st) {                   
	  
	  if(st==null) {
		  System.out.println("key not found");
		  
	  }
	  else {
		  String []ar = st.split("\\s");
		  
		  
	   Map<String, Integer> map2= new HashMap<String, Integer>();  //Tabledaki aranan satiri kolay islem yapmak icin mape attým.
	   int count=0;

	   
	   for(int i=0;i<ar.length;i++){
	       count=0;
 
	       for(int j=0;j<ar.length;j++){
	           if(ar[i].equals(ar[j])){
	           count++;                
	           }
	       }

	       map2.put(ar[i], count);
	   }
	   
	   
	   
	   Map<String, Integer> siralanmismap = sortByComparator(map2, aa);
	   
	   print(siralanmismap);
	  }
	
}
  
  
  
  
  
    
   private static void print(Map<String, Integer> mp) {            
	   
	   
	   int sayac=0;
	   
	   
	      System.out.println(kelime);
	   
	      for(String word : mp.keySet( ))
	      {
	    	  if(sayac==5) {                                        //ilk 5 i basmak icin
	    		  
	    		  break;
	    	  }
	    	  
	         System.out.println(word+" : "+mp.get(word));
	         sayac++;
	      }
	   
	      System.out.println("");

	   
	   
	      
	   
}
   
   
   
   
   
   private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)       //girilen kelimenin degerlerini ana 
   // table dan alip tutan mapimi en yuksek 5 i basmasi icin siraladim
   {

       List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

       Collections.sort(list, new Comparator<Entry<String, Integer>>()
       {
           public int compare(Entry<String, Integer> o1,
                   Entry<String, Integer> o2)
           {
               if (order)
               {
                   return o1.getValue().compareTo(o2.getValue());
               }
               else
               {
                   return o2.getValue().compareTo(o1.getValue());

               }
           }
       });

       Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
       for (Entry<String, Integer> entry : list)
       {
           sortedMap.put(entry.getKey(), entry.getValue());
       }

       return sortedMap;
   }
   
   
   
   
   
public static String sayici (String word, MyHashMap<String, String> table)
   {
      if (table.contains(word))
      {  

    	  	return table.get(word); 
      }
      else
      { 
         return "";
      }
   }
   
    
   public static void DosyalariOku(MyHashMap<String, String> table)
   {
      Scanner wordFile;
      String word;     
      String  bilgi;   
   
      
      	for (int j=0; j<dosyalar.size(); j++)
{ 

      try
      {
    	  
    	  	wordFile = new Scanner(new FileReader(dosyalar.get(j)));  //arraylistten cekicek
    	  	wordFile.useDelimiter( "[^a-zA-Z]+" );                     //duzgun karakterleri ayiklamak icin
      } 
      catch (FileNotFoundException e)
      {
    	  	System.err.println(e);
 return;
      }
   
      	while (wordFile.hasNext( ))
      {
 
    	  
    	  
      			     word = wordFile.next( );
      				word = word.toLowerCase();      //Bread bread i dogru almasi icin
  
  
  
 
  
  	bilgi = sayici(word, table) +dosyalar.get(j)+" ";
        
  	
  	table.put(word, bilgi);

      }
   
     } 
   }
   
 
 
}