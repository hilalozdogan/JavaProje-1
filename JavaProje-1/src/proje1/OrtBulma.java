/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje1;

/**
 *
 * @author hilal
 */
public class OrtBulma {
    public int topla=0;
    public float ort=0;
    String arananTip=null;
   
   public void EkranaYaz(int topMusteriSay,String[] urunAd,int m )
   {  
       ort=(float)topla/topMusteriSay;
       System.out.println(urunAd[m]+" ürününün ortalama derecelendirme puanı:"+ String.format("%.2f",ort));
       topla=0;
       ort=0;
   }
       
    
    
   public void OrtHesapla(int adet,int topMusteriSay,int[][] puanArray, String[] urunAd,float[] ortArray)
    {
        
        for(int m=0;m<adet;m++)
            {
              for(int l=0;l<topMusteriSay;l++)
                {
                    topla+=puanArray[l][m];
                    
                }
               
               ort=(float)topla/topMusteriSay;
               ortArray[m]=ort; // diğer sorularda kullanmak için ortalama bilgilerini diziye atadık
               System.out.println(urunAd[m]+" ürününün ortalama derecelendirme puanı:"+ String.format("%.2f",ort));
               topla=0;
               ort=0;
              
                
             }
            
    }
     public void aramaMetodu(String arananTip,String[] tip,int j,int urunAdedi,int[][] dizi2,String[] urunİsimleri,float[] ortDizisi)
     {
        
        int a=0,m=0,b=0,musterisay=0;
        
        for(a=0;a<urunAdedi;a++)
         {    
         for(b=0;b<j;b++) // 
         {
             if(tip[b].equals(arananTip)) // aranan müşteri tipine göre puanları toplar
             {     
                 topla+=dizi2[b][m];
                 musterisay++;
             }
             
                 
         }
        
         EkranaYaz(musterisay,urunİsimleri,m);
         musterisay=0;
         m++;
        
         }
       
     }
     
       
    public void aramaMetodu2(String arananTip,String[] tip,int j,int urunAdedi,int[][] dizi2,String[] urunİsimleri,Customer[] dizi)
     {
         int a=0,m=0,b=0,musterisay=0;
         String meslek2=null;
       
        for(a=0;a<urunAdedi;a++)
         {    
         for(b=0;b<j;b++) // j toplam müşteri sayısı
         {
             if(tip[b].equals(arananTip))
             {   
                 NationalCustomer musteriler2= (NationalCustomer)dizi[b]; // downcasting( customer'ı national customer tipine çevirme)
                 meslek2=musteriler2.getOccupation();
                 if(meslek2.equals("Doktor"))
                         
               {   
                     topla+=dizi2[b][m];
                     musterisay++;
                } 
             }
                 
         }
         EkranaYaz(musterisay,urunİsimleri,m);
         m++;
         musterisay=0;
         }
         
     }
     
     public void Ortİslem(String arananTip,Customer[] musteriDizi,String[] tip, int urunAdedi,int j,float[] ortDizisi,int[][] puanDizi,String[] urunİsimleri)
     {   int a,b,m=0;
     
            for(a=0;a<urunAdedi;a++)
            { 
                System.out.println("\n"+urunİsimleri[a]+" ürününe ortalamanın altında puan verenler:");
                System.out.println("---------------------------------------------\n");
             
                for(b=0;b<j;b++)
             {
             if(tip[b].equals(arananTip))
             {    
                 if(ortDizisi[m]>puanDizi[b][m])
                 {  
                    
                    System.out.println(musteriDizi[b]+"\n");
                 } 
             }
         }
             m++;
     } 
            

     }
     
     
     
}


