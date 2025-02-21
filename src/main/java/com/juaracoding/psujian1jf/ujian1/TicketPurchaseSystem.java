// SOAL NO.3 Program pembelian tiket
package com.juaracoding.psujian1jf.ujian1;

import java.util.Scanner;

public class TicketPurchaseSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float discount = 0.1f; // 10% discount
        int weekdayPrice = 35000;
        int weekendPrice = 45000;
        int totalPrice = 0;
        String ticketType = " ";

        // Input Data (pembeli & tiket)
        System.out.println("## Program PERCABANGAN (TIKET PEMBELIAN) ##");
            System.err.print("Masukkan Nama Pembeli         = ");
        String name = input.nextLine();
            System.err.print("Masukkan Jumlah Tiket         = ");
        int ticketCount = input.nextInt();

        if (ticketCount != 0) {
            System.out.println("Pilih hari: Senin(1), Selasa(2), Rabu(3), Kamis(4), Jum'at(5), Sabtu(6), Minggu(7)");
                System.out.print("Masukkan Hari Pembelian   = ");
            int day = input.nextInt();

            if (day >= 1 && day <= 7) {
                System.out.println("\n## Struk Pembelian Tiket ##");
                System.out.println("Pembeli         = " + name);
                System.out.println("Jumlah tiket    = " + ticketCount + " pcs");

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

                System.out.println("Type            = " + ticketType);
                System.out.println("-----------------------------");
                System.out.println("Total           = Rp." + totalPrice);
            } else {
                System.out.println("Hari tidak ditemukan, ulangi kembali.");
            }
        } else {
            System.out.println("Anda Tidak Membeli tiket!.");
        }

        input.close();
    }}

// Tiket > 5        = diskon 10%
// hari (1 sd 5)    = weakday (35000)
// hari (6 dst ...) = weekend (45000)

// Test Case 0 = tiket(0)                           =  Anda Tidak Membeli tiket!
// Test Case 1 = tiket(5) * hari(5) 35000           =  175000
// Test Case 2 = tiket(5) * hari(6) 45000           =  225000
// Test Case 3 = tiket(6) * hari(5) 35000 * 10%     =  189000
// Test Case 4 = tiket(6) * hari(6) 45000 * 10%     =  243000
