

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main extends odev3olustur {
    
  public static ArrayList<String> dosyalar=new ArrayList<>();
  

	public static  File f=null;


	public static 	 MyHashTable<String, String> table2=new MyHashTable<String,String>();

	
	
	
public static String kelime="";


public static void main(String[ ] args) throws IOException, ClassNotFoundException
{
	   Scanner keyboard = new Scanner(System.in);




System.out.println("Dosya yolunu giriniz(Ornek food_txt)");

String dosya = keyboard.next();
	      
		   File dir = new File(dosya);
       try {                                                    // dosya  da bulunan (orn food_txt)   tum filelarin pathlerini arrayliste at
		   for (File file : dir.listFiles()) {
		       Scanner s = new Scanner(file);
			   String c=file.getCanonicalPath();

		       dosyalar.add(c);    
		     
		       s.close();
		   }
	   
       }
       
       catch (Exception e) {
    	   System.out.println("Dosya bulunamadi");
    	   System.exit(0);
	}
       
       
       
       
       
       
		   MyHashTable<String, String> table = new MyHashTable<String,String>(); //tabloyu olusturduk

		   
		   DosyalariOku(table,dosyalar);         //tablo olusacak 

	    
	   
   
		  
			   
			   
			   
		   BelgeyeYaz(table,f);   //table i txt olarak yazdim
 
			      System.out.println("Olusturulan invertedindex txt dosyasina yazildi");


			   BelgedenOku(table2);   //table2 bos bir hashmapken texte yazdigimiz mapi okuyarak donecek
			    
			      System.out.println("Olusturulan invertedindex txt dosyasindan okundu");

			      
			      
			      
			      
			      
			    while(!kelime.equals("-1")) {  //-1 girmedikce deger alacak
					   
					   
				      System.out.println("aranacak kelimeyi giriniz (cikis icin -1 giriniz)");

				      kelime = keyboard.next();
				      
				   if(kelime.equals("-1")) {
					   System.out.println("hoscakalin");
					   continue;
					   
				   }
				   
				   
				   kelime=kelime.toLowerCase();  //Bread bread 

				      
				   
				   long start_time = System.nanoTime();        //zaman olcumleri 

			      
				   
			      StringtoInt(table2.get(kelime),kelime);

			      
			      
			      long end_time = System.nanoTime();

			      double difference = (end_time - start_time) / 1e6;
			      
   
	   

   
   
			      	System.out.println("Gecen zaman: "+difference+"  mili seconds");      
   
	   }
}
}