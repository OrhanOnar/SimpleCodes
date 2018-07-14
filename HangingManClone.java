import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class HangingManClone
{
   	public static void main(String[] args)
	{
		Scanner k=new Scanner(System.in);
		
		String a="";
		String abuzer="";
		System.out.println("cumleyi giriniz");
	String cumle=k.nextLine();
	System.out.println("uzunlugu giriniz");
		int uzunluk=k.nextInt();

   		int sayac=0;
	

		String kelime="";
		

		String[] dizi=cumle.split(" ");

		for (String i : dizi) {

	if(i.length()==uzunluk){
			abuzer+=i;
		  kelime=i;
		  
		}
	
		if(i.length()==(i+1).length()){
	           
			  kelime=i+1;}
		}
	
	

   		
   		
   	
   		ArrayList<String> kelimea =new ArrayList<String>();
   		kelimea.clear();
   	 	for(int i =0;i<uzunluk;i++){
   	   		
   	 	kelimea.add(i,"-");
   	   		
   	   	}
   	   		
   		
   	
  
   		
   				int index=0;
   		
   		
   		

   		
   		


   		
   			int kalanhak=kelime.length()/2+1;
   		

  

   		
   	for(int i=0;i<999;i++){
   	System.out.println("Lutfen harfi giriniz");
		String tahmin=k.nextLine();
   		if(tahmin.length()>1){
   			System.out.println("gecersiz tahmin");
   		System.exit(0);}
		if(kelime.indexOf(tahmin)==-1){
		
			System.out.println("bilemedin ucgunum");
			kalanhak--;
   	}
   		
		if(kelime.indexOf(tahmin)!=-1){
			
		index=	kelime.indexOf(tahmin);
		
		kelimea.set(index, tahmin);
	   	System.out.println(kelimea);
   	}
   		
		if(kelimea.indexOf("-")==-1){
   		
			System.out.println("bildiniz tebrikler");
   		System.exit(0);
   		
   		
		}
		if(kalanhak==0){
	   		
			System.out.println("kaybettiniz");
   		System.exit(0);
   		
   		
		}
   		
   		
   	}}
   		
   		
	
	
	}