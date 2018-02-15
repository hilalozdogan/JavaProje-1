# JavaProje-1

### Genel Problem Tanımı:
Çeşitli ürünler satan bir firmanın ulusal ve uluslararası müşterileri bulunduğu ve firmanın ürünleri
hakkında müşterilerinden topladığı derecelendirmeleri (ratings) bir dosyada sakladığı
varsayılmaktadır. Firma bu derecelendirmeler ile ilgili olarak çeşitli hesaplamalar, işlemler,
raporlamalar yapmak istemektedir. Bu bağlamda aşağıda detaylı olarak verilen gereksinimleri
karşılayacak Java kodlarını yazınız.

### Gereksinimler:
Müşterileri temsilen kalıtım kullanılarak bir sınıf hiyerarşisi oluşturulacaktır:
“Customer” sınıfı, müşteri numarasını temsil etmek için int tipinde “CustomerID” değişkeni ile, ad
ve soyadı temsilen String tipinde “Name” ve “Surname” değişkenlerine sahiptir. “Customer” sınıfı
için; parametresiz “constructor”, tüm değişkenleri kullanan “constructor” ve “copy constructor”
metotları ile “toString” metodunu yazınız. Get ve Set metotlarını otomatik olarak oluşturunuz.
Ulusal müşterileri temsil etmek için “Customer” sınıfından kalıtım ile “NationalCustomer” isimli bir
sınıf türetiniz. “NationalCustomer” sınıfında il trafik plaka kodunu temsilen int tipinde
“LicencePlateNumber” değişkeni ile müşterinin mesleğini temsilen String tipinde “Occupation”
değişikenleri bulunmaktadır. “NationalCustomer” sınıfı için ayrıca, yukarıda söz edilen üç adet
“constructor” metot ve “toString” metodu yazılmalıdır. Get ve Set metotlarını otomatik olarak
oluşturunuz.
Uluslararası müşterileri temsil etmek için “Customer” sınıfından kalıtım ile “InternationalCustomer”
isimli bir sınıf türetiniz. “InternationalCustomer” sınıfında ülkeyi temsilen String tipinde “Country”
değişkeni ile şehri temsilen String tipinde “City” değişkenleri bulunmaktadır.
“InternationalCustomer” sınıfı için ayrıca, yukarıda söz edilen üç adet “constructor” metot ve
“toString” metodu yazılmalıdır. Get ve Set metotlarını otomatik olarak oluşturunuz.
Not: Müşteri hiyerarşisindeki sınıflarda veriler ile ilgili hata kontrollerine gerek yoktur.

Bu noktada, istenen işlemlere geçmeden önce, firmanın dosya formatının anlaşılması önem
taşımaktadır ve aşağıda bu metin dosyası içeriği örnek üzerinde açıklanmaktadır.

- Firma.txt dosyası içeriği:
- 5,A,B,C,D,E
- n,101,Ali,Ceviz,32,Bilgisayar Muhendisi
- 3,4,3,5,1
- i,201,John,Smith,USA,New Jersey
- 5,2,1,4,3
- n,102,Veli,Tuz,35,Doktor
- 4,3,4,4,2
- n,103,Zeynep,Demir,06,Hemsire
- 3,2,4,3,2
- i,202,Mario,Gomez,Almanya,Wolfsburg
- 4,1,3,2,1

Dosyanın ilk satırında, kaç adet ürün olduğu bilgisi ile ürün adları yer almaktadır. Örneğin, 5 adet
ürün derecelendirilmiş olup, bu ürünlerin adları A, B, C, D ve E ürünleri olarak verilmiştir.
İzleyen satırlar ise şu şekilde düzenlenmiştir: Önce müşteri bilgileri yer almakta (n:ulusal,
i:uluslararası anlamında), hemen bir alt satırında ilgili müşterinin ürünler için yaptığı
derecelendirmeler bulunmaktadır. Örneğin, dosyanın 2. ve 3. satırı açıklanacak olursa; 101
numaralı, Ali isimli, Ceviz soyadlı, 32 trafik koduna sahip ilde oturan ve mesleği bilgisayar
mühendisi olan ulusal müşteri A ürününe 3, B ürününe 4, C ürününe 3, D ürününe 5 ve E ürününe
1 puan vermiştir. Benzer şekilde, diğer müşteriler ve yaptıkları ürün derecelendirmeleri dosya
içeriğinden de görüldüğü gibi izleyen satırlarda yer almaktadır.

- **NOT-1: Derecelendirmeler 1 ile 5 arasında yapılmakta olup, 1 puan “çok kötü”, 5 puan ise “çok iyi”
anlamındadır.**

Yukarıda tanıtılan dosya okunurken, ilgili müşteri nesnelerinin oluşturulup “Customer” tipinde bir
dizi içinde biriktirilmesi, derecelendirme bilgilerinin ise iki boyutlu bir dizi içine aktarılması
gerekmektedir. Bu iki boyutlu dizide, bir boyut müşteriler için, diğer boyut ürünler içindir ve bu
dizinin müşteri boyutundaki indeksler ile “Customer” tipindeki tek boyutlu dizinin ilgili müşteri
nesnesinin indeksi uyumludur. Sistemde en fazla 200 adet müşteri olabileceğini düşünebilirsiniz.

Aşağıda belirtilen işlemleri, dosyayı ilgili dizilere aktardıktan sonra bu dizileri kullanarak yapınız:

1) Her bir ürün için o ürüne ait ortalama derecelendirme puanını hesaplayarak yazdırınız.

2) Her bir ürün için sadece ulusal müşterileri dikkate alarak elde edilen ortalama derecelendirme
puanını hesaplayarak yazdırınız.

3) Her bir ürün için sadece uluslararası müşterileri dikkate alarak elde edilen ortalama
derecelendirme puanını hesaplayarak yazdırınız.

4) Her bir ürün için sadece ulusal müşterilerden mesleği doktor olanlar dikkate alınarak elde edilen
ortalama derecelendirme puanını hesaplayarak yazdırınız.

5) Her bir ürün için, o ürüne ait ortalama derecelendirmenin altında puan vermiş olan ulusal
müşterilerin bilgilerini yazdırınız.

6) Her bir ürün için, o ürüne ait ortalama derecelendirmenin altında puan vermiş olan uluslararası
müşterilerin bilgilerini yazdırınız.

7) Yukarıdaki raporlamalar bittikten sonra programınıza aşağıdaki işlevselliği de ekleyiniz:
Klavyeden girilen belli bir harf veya rakam ile çıkış yapılana veya 200 olarak varsayılan müşteri
sayısına ulaşılana dek bir döngü içinde;
Klavyeden, ilk önce müşteri tipi (daha önce söz edildiği gibi “n” veya “i”) aldıktan sonra, buna göre
gerekli diğer verileri de alarak ilgili müşteri nesnesini oluşturup müşterilerin tutulduğu diziye
ekleyiniz. Daha sonra bu müşteri için, ilk (ürün_sayısı-1) adet kadar ürün için (örneğin, 5 ürün
derecelendiriliyor ise ilk dört ürün için) derecelendirme puanlarını klavyeden alınız. Son ürün için
olan puanı ise aşağıda anlatılan yöntemle tahmin ettikten sonra ilgili müşterinin derecelendirme
puanlarını da iki boyutlu diziye ekleyiniz.
İlk (n-1) adet ürün puanlaması alınan müşteriye, en çok benzeyen müşterinin bulunabilmesi için
aşağıdaki formülü kullanınız (eğer A, B, C, D, E ürünleri var ise):
Benzerlik Değeri=| Ak – Ad| + | Bk – Bd| + | Ck – Cd| + | Dk – Dd|
Burada, k indeksi ile gösterilen klavyeden girilen değer, d indeksi ile gösterilen ise dosyadaki
(dizideki) bir diğer müşteriye ait olan değerdir. Bu farkların mutlak değeri alınarak toplanmaktadır.
Düşük bir değer çıkması çok benzerlik var, büyük bir değer çıkması az benzerlik var anlamını
taşımaktadır. Buna göre, klavyeden giriş yapılan müşteri için girilen ilk (n-1) adet puanlama
değerini kullanarak yukarıdaki formül ile bu müşteriye en çok benzeyen müşteri(ler) bulunmalı,
hakkında veri girişi yapılmayan son ürünün puanı benzer müşteri(ler) dikkate alınarak (aynı
benzerlik değerine sahip birden fazla müşteri varsa ortalama alınarak, aynı benzerlik değerinde
sadece bir müşteri varsa da o müşterinin son ürün için verdiği puan baz alınarak) belirlenmelidir.

8) Klavyeden giriş yapılan müşterilerin bilgilerini yazdırınız. Daha sonra sadece bu müşterilerin
puanlamalarını kullanarak her bir ürün için ortalama derecelendirme puanını hesaplayarak
yazdırınız
