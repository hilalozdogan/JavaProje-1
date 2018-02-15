/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hilal
 */
public class Klavyeden {
    
    Scanner tara=new Scanner(System.in);
    String giris=null;
    int custID,plaka,puan,puan1;
    String ad,soyad,meslek,ulke,sehir;
    int kSay=0; // klavyeden girilen müşteri sayılarını temsil eder
    int fark=0,mutlak,sonuc=0,aranan=0;
    

    
    
    public void KlavyedenGiris(int say,String[] tip,Customer[] musteriDizi,int urunAdedi,String[] urunİsimleri,int[][] puanDizi,int[][] klavyePuanDizi)
    {  
            int klavyePuanGiris[]=new int[urunAdedi-1]; //klavyeden girilen puanları tutar
            int benzerlik[]=new int[200]; // benzerlik formulünün sonuçlarını tutar
            Customer klavyeMusteri[]=new Customer[200]; //klavyeden girilen müşteri nesnelerini tutar
            
            System.out.println("Müşteri tipini giriniz (Çıkış için 'n' ve 'i' den farklı bir harf giriniz ):");
            giris=tara.next();
            
            
        
           while("n".equals(giris) || "i".equals(giris))
        {   
            
            tip[say]=giris;
            System.out.println("\nMüşterinin müşteri numarasını giriniz:");
            custID=tara.nextInt();

            System.out.println("\nMüşterinin adını giriniz:");
            tara.nextLine();
            ad=tara.nextLine();
            System.out.println("\nMüşterinin soyadını giriniz:");
            soyad=tara.nextLine();
            
            if("n".equals(giris))
            {
                System.out.println("\nMüşterinin plaka numarasını giriniz:");
                plaka=tara.nextInt();
                System.out.println("\nMüşterinin mesleğini giriniz:");
                tara.nextLine();
                meslek=tara.nextLine();
                System.out.println("\n");
                NationalCustomer musteriler=new NationalCustomer(custID,ad,soyad,plaka,meslek);
                musteriDizi[say]=musteriler; // toplam musterileri tuttuğumuz diziye klavyeden girilenleri de ekliyoruz
                klavyeMusteri[kSay]=musteriler; // sadece klavyeden girilen müşterileri bu dizide tutuyoruz
               
                
                
                
            }
            if("i".equals(giris))
            {
                System.out.println("\nMüşterinin ülkesini giriniz:");
                
                ulke=tara.nextLine();
                System.out.println("\nMüşterinin şehrini giriniz:");
                sehir=tara.nextLine();
                System.out.println("\n");
                InternationalCustomer musteriler=new InternationalCustomer(custID,ad,soyad,ulke,sehir);
                musteriDizi[say]=musteriler;
                klavyeMusteri[kSay]=musteriler;
               
                
               
            }
            
            for(int i=0;i<urunAdedi-1;i++)
            {   
                System.out.println(urunİsimleri[i]+" ürününe verdiğiniz puanı giriniz:");
                puan=tara.nextInt();
                puanDizi[say][i]=puan; // klavyeden girilen müşteri puanlamalarını da bu diziye ekliyoruz
                klavyePuanDizi[kSay][i]=puan; // sadece klavyeden girilen müşterilerin puanlarını bu dizide tutuyoruz
                klavyePuanGiris[i]=puan; // benzerlik formülündeki hesaplamalarda kullanmak için girilen puanları tek boyutlu bu dizide tuttuk
            }
             
            
            
            for(int m=0;m<say;m++)
            {   
                for(int n=0;n<urunAdedi-1;n++)
                {
                  fark=(klavyePuanGiris[n]-puanDizi[m][n]); // Benzerlik Değeri=| Ak – Ad| + | Bk – Bd| + | Ck – Cd| + | Dk – Dd| 
                  mutlak=Math.abs(fark);                    //  işlemini bu satırlarda yaptık
                  sonuc+=mutlak;
                }
                
                benzerlik[m]=sonuc;  // her müşteri için benzerlik değeri denkleminin sonucunu bu diziye atadık
                sonuc=0;
                }
               
                int[] kopya = benzerlik.clone(); // benzerlik dizisinin kopyasını alarak sıraladık
                Arrays.sort(kopya,0,say);   // kopya dizinin küçükten büyüğe sıraladık
                aranan=kopya[0];    // en küçük elemanı aranan eleman yaptık
                linearSearch(benzerlik,aranan,say,urunAdedi,puanDizi,klavyePuanDizi,kSay); // linear search metodu ile 7. soruda 
                                                                                           // istenilen işlemleri yaptık                             
                
                
           System.out.println("\nMüşteri tipini giriniz (Çıkış için n ve i den farklı bir harf giriniz ):");
           giris=tara.next();
            say++;
            kSay++;
            
        }
         if(kSay>0) 
         {
             System.out.println("\nKlavyeden Girilen Müşterilerin Bilgileri:");
             System.out.println("*******************************************");
             
             for(int i=0;i<kSay;i++)
            {
             System.out.println(klavyeMusteri[i]+ "\n");
         
            } 
        }
      
         
        
        
        
    } 
    private static void linearSearch(int[] liste, int arananSayi,int say,int urunAdedi,int[][] puanDizi,int[][] klavyePuan,int kSay) { //linearSearch metotumuz
       int sayac=0;
       int puantop=0;
       int atananpuan=0;
        for (int i = 0; i <say; i++){  //döngümüz toplam musteri sayısı kadar dönüyor
            if(liste[i] == arananSayi){  //sırası ile tüm elemanlara bakıyoruz
                sayac++;                 //en küçük elemandan kaç tane olduğunu bulmak için sayaç kullandık
            }
        }
        if(sayac==1) // Eğer en küçük benzerlik değerinden bir tane varsa
        {  for (int i = 0; i <say; i++) {  
             if(liste[i] == arananSayi) { //en küçük elemanın benzerlik dizisindek indisini bulup puanDizisinde bu indise karşılık gelen
               
               puanDizi[say][urunAdedi-1]=puanDizi[i][urunAdedi-1];  // puanı tahmini istenen son ürün puanı olarak atadık
               klavyePuan[kSay][urunAdedi-1]=puanDizi[i][urunAdedi-1]; // sonucu sadece klavyeden girilen müşterilerden oluşan diziyede atadık
                                                                                
               
              }
            }
        }else  // eğer birden fazla en küçük benzerlik değeri varsa
        {
     
        { for (int i = 0; i<say; i++){
            
            if (liste[i] == arananSayi){ 
                
                puantop+= puanDizi[i][urunAdedi-1]; //indislere karşılık gelen son ürün puanlarını topluyoruz
              }
            
                
            }
        }
       
        atananpuan=puantop/sayac; // toplanan puanı sayacımıza böldüğümüzde son ürüne atanacak tahmini puanı buluyoruz
        puanDizi[say][urunAdedi-1]=atananpuan;
        klavyePuan[kSay][urunAdedi-1]=atananpuan;
       
       
    }
        
    }
   
 
    
   
    
}
