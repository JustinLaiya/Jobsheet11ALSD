package Tugas10Jobsheet10;
import java.util.Scanner;
public class MainKRS {

    public static void menu() {
        System.out.println("\n=== Menu Antrian KRS ===");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Proses KRS (2 mahasiswa)");
        System.out.println("3. Tampilkan Semua Antrian");
        System.out.println("4. Tampilkan 2 Antrian Terdepan");
        System.out.println("5. Tampilkan Antrian Terakhir");
        System.out.println("6. Tampilkan Informasi Antrian");
        System.out.println("7. Kosongkan Antrian");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS();
        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch(pilih) {
                case 1:
                    System.out.print("NIM       : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama      : ");
                    String nama = sc.nextLine();
                    System.out.print("No Telp   : ");
                    String noTelp = sc.nextLine();
                    antrian.enqueue(new Mahasiswa(nim, nama, noTelp));
                    break;
                case 2:
                    antrian.prosesKRS();
                    break;
                case 3:
                    antrian.printAll();
                    break;
                case 4:
                    antrian.printFirst2();
                    break;
                case 5:
                    antrian.printLast();
                    break;
                case 6:
                    antrian.printInfo();
                    break;
                case 7:
                    antrian.clear();
                    break;
                case 0:
                    System.out.println("Terimakasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih !=0);
        sc.close(); 
    }
}