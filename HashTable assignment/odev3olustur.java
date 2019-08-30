
import java.util.*;
import java.util.Map.Entry;
import java.io.*;   
   
public class odev3olustur extends odev3ara
{
	

   
   
   
public static String sayici (String word, MyHashTable<String, String> table)  //Kelimeleri sayar
   {
      if (table.containsKey(word))
      {  

    	  	return table.get(word);            
      }
      else
      { 
         return "";
      }
   }



public static void BelgeyeYaz(MyHashTable<String, String> table,File f) throws ClassNotFoundException, FileNotFoundException      //Olusturulan Hashtable i txt dosyasina yaziyor
{
	 PrintWriter out = new PrintWriter(new File("invertedindex.txt"));

 

     for (MyHashTable.Entry<String,String> entry : table.entrySet()) {
         out.println(entry.getKey() + "   " + entry.getValue());
     }

     out.close();
	

	
}


   public static void DosyalariOku(MyHashTable<String, String> table,ArrayList<String> dosyalar)   //verilen dizindeki txtleri okur ve kelimesayacini cagirarak table a ekler
   {
      Scanner wordFile;
      String word;     
      String  bilgi;   
   
      
for (int j=0; j<dosyalar.size(); j++)          //arrayliste attigimiz dosyalari tek tek okuyoruz
      {  

      try
      {
    	  
    	wordFile = new Scanner(new FileReader(dosyalar.get(j)));  //arraylistten cekicek
    	  	
    	  	
    	wordFile.useDelimiter( "[^a-zA-Z]+" );                     //duzgun karakterleri ayiklamak icin ( (?=). benzeri isaret ve  sayilari eleyerek )
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
  
  
  
 
  
  	bilgi = sayici(word, table) +dosyalar.get(j)+" ";    //value buldukca   surekli guncellenecek
        
  	
  	table.put(word, bilgi);   //tabloya ekle

      }
   
     } 




   }
   
 
 
}