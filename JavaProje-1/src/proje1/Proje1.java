/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1;

import java.io.BufferedReader;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;
/**
 *
 * @author hilal
 */

public class Proje1 {

  
   

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
    
      
      File file = new File("Firma.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        
        int custID=0,plaka=0,satirNumarasi=0,say=0,y=0,x=0,k=0,urunAdedi=0;
        String karakter=",";
        String customerType=null,ad=null,soyad=null,meslek=null,ulke=null,sehir=null;
        
        String[] tip=new String[200];
        Customer[] musteriDizi=new Customer[200];
        
            String satir = reader.readLine();
            StringTokenizer st1 = new StringTokenizer(satir,karakter);
            urunAdedi=Integer.parseInt(st1.nextToken());
            float[] ortDizisi=new float[urunAdedi];
            String[] urunİsimleri=new String[urunAdedi];
            int[][] puanDizi=new int[200][urunAdedi]; // ürünlere verilen puanların tutulduğu dizi
            int[][] klavyePuan=new int [200][urunAdedi] ; // sadece klavyeden girilenlerin puanlarını tutar
            
            for(k=0;k<urunAdedi;k++)
            {
                urunİsimleri[k]=st1.nextToken();
            }
            
          
            
            
            while (satir!=null) {
                
               StringTokenizer st = new StringTokenizer(satir,karakter); 
                
                satirNumarasi++;
                
                if(satirNumarasi%2==0)
                {
                    while (st.hasMoreTokens())
                    {
                        customerType=st.nextToken();
                        custID=Integer.parseInt(st.nextToken());
                        ad=st.nextToken();
                        soyad=st.nextToken();
                        
                        
                        if("n".equals(customerType))
                            
                        {   
                            plaka=Integer.parseInt(st.nextToken());
                            meslek=st.nextToken();
                            NationalCustomer musteriler=new NationalCustomer(custID,ad,soyad,plaka,meslek);
                            musteriDizi[say]=musteriler; 
                            tip[say]="n"; 
                            say++; // müşteri sayısını artır
                            
                            
                            
                        }
                        else if("i".equals(customerType))
                        {
                            ulke=st.nextToken();
                            sehir=st.nextToken();
                            InternationalCustomer musteriler=new InternationalCustomer(custID,ad,soyad,ulke,sehir);
                            musteriDizi[say]=musteriler;
                            tip[say]="i";
                            say++;  // müşteri sayısını artır
                        }
                    }
                    
                    
                }else if(satirNumarasi!=1)
                {
                  
                    while(y<say) 
                    { 
                        for(x=0;x<urunAdedi;x++)
                        
                    {   
                        puanDizi[y][x]=Integer.parseInt(st.nextToken());
                        
                    }
                        y++;
                        
                    }
                    
                    
                }
                   
                satir = reader.readLine();
               
            }
            
            System.out.println("Her Bir Ürün İçin O Ürüne Ait Ortalama Derecelendirme Puanları:");
            System.out.println("***************************************************************\n");
            OrtBulma soru1=new OrtBulma();
            soru1.OrtHesapla( urunAdedi,say,puanDizi,urunİsimleri,ortDizisi);
            
            System.out.println("\nHer Bir Ürün İçin Sadece ULUSAL Müşterileri Dikkate Alarak Elde Edilen Ortalama:");
            System.out.println("**********************************************************************************\n");
            OrtBulma soru2=new OrtBulma();
            soru2.aramaMetodu("n", tip,say, urunAdedi,puanDizi, urunİsimleri,ortDizisi);
            
            System.out.println("\nHer Bir Ürün İçin Sadece ULUSLARARASI Müşterileri Dikkate Alarak Elde Edilen Ortalama:");
            System.out.println("****************************************************************************************\n");
            OrtBulma soru3=new OrtBulma();
            soru3.aramaMetodu("i", tip,say, urunAdedi,puanDizi, urunİsimleri,ortDizisi);
            
            System.out.println("\nHer Bir Ürün İçin Sadece ULUSAL Müşterilerden Mesleği DOKTOR Olanlar Dikkate Alınarak Elde Edilen Ortalama:");
            System.out.println("*************************************************************************************************************\n");
            OrtBulma soru4=new OrtBulma();
            soru4.aramaMetodu2("n", tip,say, urunAdedi,puanDizi, urunİsimleri,musteriDizi);
            
            System.out.println("\n\nOrtalama Derecelendirmenin Altında Puan Vermiş Olan ULUSAL Müşterilerin Bilgileri:");
            System.out.println("************************************************************************************");
            OrtBulma soru5=new OrtBulma();
            soru5.Ortİslem("n", musteriDizi, tip, urunAdedi, say, ortDizisi,puanDizi, urunİsimleri);
            
            System.out.println("\n\nOrtalama Derecelendirmenin Altında Puan Vermiş Olan ULUSLARARASI Müşterilerin Bilgileri:");
            System.out.println("********************************************************************************************");
            OrtBulma soru6=new OrtBulma();
            soru6.Ortİslem("i", musteriDizi, tip, urunAdedi, say, ortDizisi,puanDizi, urunİsimleri);
            
            
            Klavyeden soru7=new Klavyeden();
            soru7.KlavyedenGiris(say, tip,musteriDizi, urunAdedi, urunİsimleri,puanDizi,klavyePuan);
            int klavyeSayi=0;
            klavyeSayi=soru7.kSay;
           
           if(klavyeSayi>0)
           { System.out.println("\nKlavyeden Girilen Müşterilerin Her Bir Ürün İçin Ortalama Derecelendirme Puanları:");
           System.out.println("***********************************************************************************");
           OrtBulma soru8=new OrtBulma();
           soru8.OrtHesapla(urunAdedi,klavyeSayi,klavyePuan,urunİsimleri,ortDizisi);
           }
       
            
            
            
           
           
            
            

}
}
      
      
       
              
      
  
    

