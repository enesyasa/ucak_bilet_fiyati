import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  Scanner nesnesi oluşturuldu
        Scanner scanner = new Scanner(System.in);

        // Mesafe (KM), yaş ve yolculuk tipi bilgilerini kullanıcıdan alınması
        System.out.print("Mesafe (KM): ");
        int mesafe = scanner.nextInt();

        System.out.print("Yaşınız: ");
        int yas = scanner.nextInt();

        System.out.print("Yolculuk Tipi (1: Tek Yön, 2: Gidiş-Dönüş): ");
        int yolculukTipi = scanner.nextInt();

        // Geçerli veri kontrolü yapılır.
        if (mesafe > 0 && yas > 0 && (yolculukTipi == 1 || yolculukTipi == 2)) {
            // Mesafe başına ücret
            double birimFiyat = 0.10;

            // Uçuşun toplam fiyatı hesaplanır.
            double normalTutar = mesafe * birimFiyat;

            // Yaş indirimi hesaplanır.
            double yasIndirimi = 0;

            if (yas < 12) {
                // 12 yaşından küçükse %50 indirim
                yasIndirimi = normalTutar * 0.50;
            } else if (yas >= 12 && yas <= 24) {
                // 12-24 yaş arası ise %10 indirim
                yasIndirimi = normalTutar * 0.10;
            } else if (yas >= 65) {
                // 65 yaşından büyükse %30 indirim
                yasIndirimi = normalTutar * 0.30;
            }

            // İndirimli Tutar hesaplanır.
            double indirimliTutar = normalTutar - yasIndirimi;

            // Gidiş-Dönüş Bilet İndirimi hesaplanır.
            double gidisDonusIndirimi = (yolculukTipi == 2) ? indirimliTutar * 0.20 : 0;

            // Toplam Tutar hesaplanır.
            double toplamTutar = (indirimliTutar - gidisDonusIndirimi) * (yolculukTipi == 2 ? 2 : 1);

            // Sonuçları ekrana yazdır.
            System.out.println("Toplam Bilet Fiyatı: " + toplamTutar + " TL");
        } else {
            System.out.println("Hatalı Veri Girdiniz!");
        }
    }
}
