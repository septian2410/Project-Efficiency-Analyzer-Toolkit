// SOAL NO.1 Program Base Coverage (Aritmatika)
package com.juaracoding.psujian1jf.ujian1;

import java.util.Scanner;

public class BaseCoverageAnalyzer {
    private int cmy40ml, k, constantBaseCoverage, price;
    private int resultBaseCoverage, cmyk, pageDiv, totalCount, totalPrice;

    public BaseCoverageAnalyzer(int cmy40ml, int k, int constantBaseCoverage, int price) {
        this.cmy40ml = cmy40ml;
        this.k = k;
        this.constantBaseCoverage = constantBaseCoverage;
        this.price = price;
    }

        // Menghitung Perbandingan Base Coverage
    public int countComparisonBaseCoverage(int baseCoverage) {
        resultBaseCoverage = baseCoverage / constantBaseCoverage;
        return resultBaseCoverage;
    }

        // Menghitung rata-rata halaman yang dapat dicetak dengan tinta warna dan hitam
    public int countCmyk() {
        cmyk = (cmy40ml + k) / 2;
        return cmyk;
    }

        // Menghitung jumlah halaman yang dapat dicetak
    public int countPageDiv() {
        pageDiv = cmyk / resultBaseCoverage;
        return pageDiv;
    }

        // Menghitung total pembayaran per halaman
    public int totalPricePages() {
        totalCount = price / pageDiv;
        return totalCount;
    }

        // Menghitung total Pembayaran
    public int totalPrice(int totalCount, int paper) {
        return totalPrice = totalCount * paper;
    }

    public void setBaseCoverage() {
        Scanner input = new Scanner(System.in);
        String answer;

        while (true) {
            System.out.print("\nIngin melakukan perhitungan Biaya Cetak Per-Halaman? (Ya/Tidak): ");
            answer = input.nextLine().trim();

            if (answer.equalsIgnoreCase("Ya")) {
                while (true) {
                    System.out.print("MASUKKAN BaseCoverage: ");
                    int baseCoverage = input.nextInt();
                    input.nextLine();

                    System.out.print("MASUKKAN Banyak Halaman yang ingin di cetak: ");
                    int paper = input.nextInt();
                    input.nextLine();

                    countComparisonBaseCoverage(baseCoverage);
                    countCmyk();
                    countPageDiv();
                    totalPricePages();
                    totalPrice(totalCount, paper);

                    System.out.println("\n## Perhitungan Akhir Biaya Cetak Per-Halaman ##");
                    System.out.println("Based Coverage (Request)        = " + baseCoverage + "%");
                    System.out.println("Total Pembayaran per-halaman    = Rp." + totalCount + "/pages");
                    System.out.println("Total Pembayaran                = Rp." + totalPrice);

                    while (true) {
                        System.out.print("\nApakah masih ingin melanjutkan perhitungan? (Ya/Tidak): ");
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

        } // AKHIR LOOP UTAMA
    }

    public static void main(String[] args) {
        BaseCoverageAnalyzer obj = new BaseCoverageAnalyzer(7500, 4500, 5, 216860);

        System.out.println("## Daftar Ketetapan ##");
        System.out.println("Botol 40ML CMY              = " + obj.cmy40ml + " hal");
        System.out.println("Botol 40ML K                = " + obj.k + " hal");
        System.out.println("Based Coverage (constant)   = " + obj.constantBaseCoverage + "%");

        obj.setBaseCoverage();
    }
}



/*

 * Ketetapan Perhitungan*

 cmyk                 = 6000
 resultBaseCoverage   = baseCoverage (Permintaan) / constantBaseCoverage (Konstan = 5);
 total Price          = price / (cmyk / resultBaseCoverage)

 * Case Pengujian Base Coverage *

 Case 1 (Permintaan 10% BaseCoverage) & (Permintaan 200 page)
      Total Price = 216860 / (6000 / 2 )  = 72/pages * 200     = RP. 14.400

 Case 2 (Permintaan 30% BaseCoverage) & (Permintaan 200 page)
      Total Price = 216860 / (6000 / 6 )  = 216/pages * 200    = Rp. 43.200

 Case 3 (Permintaan 80% BaseCoverage) & (Permintaan 200 page)
      Total Price = 216860 / (6000 / 16 ) = 578/pages * 200    = Rp.115.600

*/

