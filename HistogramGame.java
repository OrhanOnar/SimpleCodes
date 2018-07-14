import java.util.Random;
	import java.util.Scanner;
public class HistogramGame{


	 

	
	   	public static void main(String[] args)
		{
			Scanner k=new Scanner(System.in);
			
		
			System.out.println("dizi boyutunu  giriniz");
		int boyut=k.nextInt();
		System.out.println("hamle sayisini giriniz");
			int hamle=k.nextInt();
int sayac1=1;
int sayac2=1;
int sayac3=1;
int sayac4=1;
int sayac5=1;          //ust uste geldiginde birden fazla yildiz basmasi icin,ust uste gelmeyi sayacak
int sayac6=1;
int sayac7=1;
int sayac8=1;
String yýldýz1="*";
String yýldýz2="*";
String yýldýz3="*";
String yýldýz4="*";    //ust uste geldiginde birden fazla yildiz basmasi icin
String yýldýz5="*";
String yýldýz6="*";
String yýldýz7="*";
String yýldýz8="*";
			
			 String[][] tablo = new String[boyut][boyut];		
				
				
				
				int x=0;
				int degiskenn=boyut/2-1;
				int degiskennn=boyut/2-1;
int random=0;
for (int i = 0; i < boyut; i++) {
    for (int j = 0; j <boyut; j++) {
    	 tablo[i][j]=" ";
    	 
 
    
    }

}

tablo[boyut/2-1][boyut/2-1]="*";


				while(x<hamle){
			 random = (int) (Math.random()*7+1);

					 if(random==1){
						 if(degiskenn+1==boyut || degiskennn+1==boyut || degiskenn-1==-1 || degiskennn-1==-1){   //sinir gecince oyun bitti diyecek
			    				System.out.println("Oyun bitti");
			    				break;}
						 for(int i=0;i<sayac1;i++)
	            		 tablo[degiskenn][degiskennn-1] +=yýldýz1;       //ust uste geldigi kadar yildiz ekle gelmezse zaten 1 yildiz bas. 
	    			
	    				 degiskennn=degiskennn-1;
	    				 	 sayac1++;
	    				 	 
	    			 }
	            	 if(random==2){
	            		 if(degiskenn+1==boyut || degiskennn+1==boyut || degiskenn-1==-1 || degiskennn-11==-1){
			    				System.out.println("Oyun bitti");
			    				break;}
	            		 for(int i=0;i<sayac2;i++)
	            		 tablo[degiskenn][degiskennn+1] +=yýldýz2;
	            		 degiskenn=degiskenn;
	    				 degiskennn=degiskennn+1;
	    				 sayac2++;
	    			 }
	            	 if(random==3){
	            		 if(degiskenn+1==boyut || degiskennn+1==boyut || degiskenn-1==-1 || degiskennn-11==-1){
			    				System.out.println("Oyun bitti");
			    				break;}
	            		 for(int i=0;i<sayac3;i++)
	            		 tablo[degiskenn-1][degiskennn] +=yýldýz3;
	            		 degiskenn=degiskenn-1;
	    				
	    				 sayac3++;
	    			 }
	            	 if(random==4){
	            		 if(degiskenn+1==boyut || degiskennn+1==boyut || degiskenn-1==-1 || degiskennn-11==-1){
			    				System.out.println("Oyun bitti");
			    				break;}
	            		 for(int i=0;i<sayac4;i++)
	            		 tablo[degiskenn+1][degiskennn] +=yýldýz4;
	            		
	            		 degiskenn=degiskenn+1;
	            		 
	            		 sayac4++;
	    			    
	    			 }
	            	 if(random==5){
	            		 if(degiskenn+1==boyut || degiskennn+1==boyut || degiskenn-1==-1 || degiskennn-1==-1){
			    				System.out.println("Oyun bitti");
			    				break;}
	            		 for(int i=0;i<sayac5;i++)
	            		 tablo[degiskenn-1][degiskennn-1] +=yýldýz5;
	            		
	            		 degiskenn=degiskenn-1;
	            		 degiskennn=degiskennn-1;
	            		 sayac5++;
	    			    
	    			 }
	            	 if(random==6){
	            		 if(degiskenn+1==boyut || degiskennn+1==boyut || degiskenn-1==-1 || degiskennn-11==-1){
			    				System.out.println("Oyun bitti");
			    				break;}
	            		 for(int i=0;i<sayac6;i++)
	            		 tablo[degiskenn-1][degiskennn+1] +=yýldýz6;
	            		
	            		 degiskenn=degiskenn-1;
	            		 degiskennn=degiskennn+1;
	            		 sayac6++;
	    			    
	    			 }
	            	 if(random==7){
	            		 if(degiskenn+1==boyut || degiskennn+1==boyut || degiskenn-1==-1 || degiskennn-11==-1){        
			    				System.out.println("Oyun bitti");
			    				break;}
	            		 
	            		 for(int i=0;i<sayac7;i++)
	            		 tablo[degiskenn+1][degiskennn-1] +=yýldýz7;
	            		
	            		 degiskenn=degiskenn+1;
	            		 degiskennn=degiskenn-1;
	            		 sayac7++;
	    			    
	    			 }
	            	 if(random==8){
	            		 if(degiskenn+1==boyut || degiskennn+1==boyut || degiskenn-1==-1 || degiskennn-11==-1){
			    				System.out.println("Oyun bitti");
			    				break;}
	            		 for(int i=0;i<sayac8;i++)
	            		 tablo[degiskenn+1][degiskennn+1] +=yýldýz8;
	            		
	            		 degiskenn=degiskenn+1;
	            		 degiskennn=degiskennn+1;
	            		 sayac8++;
	    			   
	    			 }
	            	 x++;}
				System.out.println("Histogram");
				  for (int i = 0; i < boyut; i++) {
			            for (int j = 0; j <boyut; j++) {       //Histogrami bastir
			          
			            	 
			          System.out.println(i+""+j+"  :  "+tablo[i][j]);
			            
			            }
			     
			        }
			 
			
				


			
			
			
			
			
			
			
			
		}}