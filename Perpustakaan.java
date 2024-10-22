import java.util.Scanner;

class Buku {
    String judul;
    String penulis;
    int harga;

    public Buku(String judul, String penulis, int harga) {
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
    }
}

class Diskon {
    int nominal;

    public Diskon(int nominal) {
        this.nominal = nominal;
    }
}

class Peminjaman {
    Buku buku;
    int jmlHari;
    Diskon diskon;

    public Peminjaman(Buku buku, int jmlHari, Diskon diskon) {
        this.buku = buku;
        this.jmlHari = jmlHari;
        this.diskon = diskon;
    }

    public int hitungTotalHarga() {
        return buku.harga * jmlHari;
    }

    public int hitungHargaSetelahDiskon() {
        int totalHarga = hitungTotalHarga();
        if (diskon != null) {
            return totalHarga - diskon.nominal;
        }
        return totalHarga;
    }
}

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Judul buku: ");
        String judul = scanner.nextLine();
        System.out.print(" Penulis buku: ");
        String penulis = scanner.nextLine();
        System.out.print(" Harga sewa buku per hari: ");
        int harga = scanner.nextInt();

        System.out.print(" Jumlah hari peminjaman: ");
        int jmlHari = scanner.nextInt();

        System.out.print(" Diskon (0 jika tidak ada): ");
        int nominalDiskon = scanner.nextInt();

        Buku buku = new Buku(judul, penulis, harga);
        Diskon diskon = nominalDiskon > 0 ? new Diskon(nominalDiskon) : null;
        Peminjaman peminjaman = new Peminjaman(buku, jmlHari, diskon);

        System.out.println("Total Harga Setelah Diskon: " + peminjaman.hitungHargaSetelahDiskon());
    }
}