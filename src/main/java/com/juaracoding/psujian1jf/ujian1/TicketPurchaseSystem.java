// SOAL NO.3 Program pembelian tiket
package com.juaracoding.psujian1jf.ujian1;

import java.util.Scanner;

public class TicketPurchaseSystem {

    private int weekdayPrice, weekendPrice, totalPrice;
    private float discount;
    private Scanner input;
    private String ticketType;

    public TicketPurchaseSystem(float discount, int weekdayPrice, int weekendPrice, int totalPrice) {
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.input = new Scanner(System.in);
    }

    public String inputNamaPembeli(){
        System.out.print("\nMasukkan Nama Pembeli         = ");
        return input.nextLine().trim();

    }

    public int inputJumlahTiket(){
        System.err.print("Masukkan Jumlah Tiket         = ");
        int ticket = input.nextInt();
        input.nextLine();
        return ticket;
    }

    public void countTicket(int ticketCount) {
        if (ticketCount != 0) {

            System.out.println("Pilih hari: Senin(1), Selasa(2), Rabu(3), Kamis(4), Jum'at(5), Sabtu(6), Minggu(7)");
            System.out.print("Masukkan Hari Pembelian   = ");
            int day = input.nextInt();
            input.nextLine();

            if (day >= 1 && day <= 7) {
                // Penetuan harga tiket berdasarkan (hari yg dipilih)
                if (day <= 5) {
                    ticketType = "weakday";
                    totalPrice = ticketCount * weekdayPrice;
                } else {
                    ticketType = "weekend";
                    totalPrice = ticketCount * weekendPrice;
                }

                // Perhitungan diskon (tiket > 5)
                if (ticketCount > 5) {
                    totalPrice = (int) (totalPrice - (totalPrice * discount));
                }
            } else {
                System.out.println("Hari tidak ditemukan, ulangi kembali.");
            }
        } else {
            System.out.println("Anda Tidak Membeli tiket!.");
            ticketType = "-";
        }
    }

    public void startProgram() {
        while (true) {
            System.out.print("Ingin membeli tiket? (Ya/Tidak): ");
            String answer = input.nextLine().trim();

            if (answer.equalsIgnoreCase("Ya")) {
                while (true) {
                    String nama = inputNamaPembeli();
                    int ticket = inputJumlahTiket();
                    countTicket(ticket);

                    System.out.println("\n## Struk Pembelian Tiket ##");
                    System.out.println("Pembeli         = " + nama);
                    System.out.println("Jumlah tiket    = " + ticket + " pcs");
                    System.out.println("Type            = " + this.ticketType);
                    System.out.println("-----------------------------");
                    System.out.println("Total           = Rp." + totalPrice);

                    while (true) {
                        System.out.print("\nApakah masih ingin melanjutkan pembelian tiket? (Ya/Tidak): ");
                        answer = input.nextLine().trim();

                        if (answer.equalsIgnoreCase("Ya")) {
                            break;
                        } else if (answer.equalsIgnoreCase("Tidak")) {
                            System.out.println("Terima Kasih telah menggunakan aplikasi!");
                            input.close();
                            return;
                        } else {
                            System.out.println("Jawaban tidak valid. Silakan masukkan 'Ya' atau 'Tidak'.");
                        }
                    }
                }


                } else if (answer.equalsIgnoreCase("Tidak")) {
                    System.out.println("Terima Kasih telah menggunakan aplikasi!");
                    input.close();
                    return;
                } else {
                    System.out.println("Jawaban tidak valid. Silakan masukkan 'Ya' atau 'Tidak'.");
                }
            }
        }

    public static void main(String[] args) {
        TicketPurchaseSystem obj = new TicketPurchaseSystem(0.1f, 35000, 45000, 0);
        obj.startProgram();
    }}


/*

 * Ketetapan Penjualan Tiket*

    Pembelian Tiket > 5 = diskon 10%
    Pembelian Tiket Pada hari (Senin sd Jumat / 1 sd 5)     = Rp.35.000 (WeakDay)
    Pembelian Tiket Pada hari (Sabtu sd Minggu / 6 sd 7)    = Rp.45.000 (WeekEnd)

 * Case Pengujian Pembelian Tiket *

 Case 1
    Nama Pembeli    = Pembeli 1
    Jumlah Tiket    = 0
    Type            = Tidak Ada
    Total           = 0
 Case 2
    Nama Pembeli    = Pembeli 2
    Jumlah Tiket    = 5
    Type            = WeakDay
    Total           = Rp.175000
 Case 3
    Nama Pembeli    = Pembeli 3
    Jumlah Tiket    = 5
    Type            = WeekEnd
    Total           = Rp.225000
 Case 4
    Nama Pembeli    = Pembeli 4
    Jumlah Tiket    = 6
    Type            = WeakDay
    Total           = 189000
 Case 5
    Nama Pembeli    = Pembeli 5
    Jumlah Tiket    = 6
    Type            = WeekEnd
    Total           = 243000

*/

/*
    Perhitungan Tiket

 Test Case 0 = tiket(0)                           =  Anda Tidak Membeli tiket!
 Test Case 1 = tiket(5) * hari(5) 35000           =  175000
 Test Case 2 = tiket(5) * hari(6) 45000           =  225000
 Test Case 3 = tiket(6) * hari(5) 35000 * 10%     =  189000
 Test Case 4 = tiket(6) * hari(6) 45000 * 10%     =  243000
*/