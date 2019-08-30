
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class odev3ara {
    public static boolean aa = false;

	  public static void StringtoInt(String st,String kelime) {                   
		  
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
		   
		   print(siralanmismap,kelime);
		  }
		
	}
	  
	  
	  
	  public static void BelgedenOku(MyHashTable<String, String> table2) throws IOException {      //Onceden olusturup yazdigimiz invertedindex iceren table i ordan okur yeni table a atar
			
		  String filePath = "invertedindex.txt";

		    String line;
		    BufferedReader reader = new BufferedReader(new FileReader(filePath));
		    while ((line = reader.readLine()) != null)
		    {
		        String[] parts = line.split("   ", 2);  //2 Bosluk aralik sonrasi  2 parcaya ayirir ki keyler ve valuelari boyle parcalamistim
		        if (parts.length >= 2)
		        {
		            String key = parts[0];
		            String value = parts[1];
		

		            table2.put(key, value);     //yeni tabloyu  txtden okuyarak dolduruyoruz
		        }  
		    }

		    
		    reader.close();
		}
	  
	    
	   private static void print(Map<String, Integer> mp,String kelime) {            
		   
		   
		   int sayac=0;
		   
		   
		      System.out.println(kelime);
		   
		      for(String word : mp.keySet( ))
		      {
		    	  if(sayac==5) {                                        //ilk 5 i basmak icin siralanmis kodu bastirdim hashtable da olan ve aranan satiri  rahat islemek icin mape atmistim.
		    		  
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
	                   return o1.getValue().compareTo(o2.getValue());                             //siraladim
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
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
