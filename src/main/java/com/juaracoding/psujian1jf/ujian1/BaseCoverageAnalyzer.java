// SOAL NO.1 Progran Base Coverage (Aritmatika)
package com.juaracoding.psujian1jf.ujian1;
import java.util.Scanner;

public class BaseCoverageAnalyzer {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            int cmy40ml = 7500;
            int k = 4500;
            int constantBaseCoverage = 5;      // 5%
            int price = 216860;

            System.out.println("## Progran Base Coverage ##");
            System.out.println("Botol 40ML CMY              = " + cmy40ml +" hal");
            System.out.println("Botol 40ML K                = " + k +" hal");
            System.out.println("Based Coverage (constant)   = " + constantBaseCoverage +"%");

            // Input baseCoverage (sesuai permintaan customer)
            System.out.print("MASUKKAN BaseCoverage       : ");
            int baseCoverage = input.nextInt();

            // Menghitung Perbandingan Base Coverage
            int resultBaseCoverage = baseCoverage / constantBaseCoverage;

            // Menghitung rata-rata halaman yang dapat dicetak dengan tinta warna dan hitam.
            int cmyk = (cmy40ml + k) / 2;

            // Menghitung Jumlah Halaman yang Dapat Dicetak
            int pageDiv = cmyk / resultBaseCoverage;

            // Menghitung Total pembayaran per-pages
            int totalCount = price / pageDiv;

            // Output
            System.out.println("\n## Data Akhir ##");
            System.out.println("Based Coverage (Request)    = " + baseCoverage +"%");
            System.out.println("------------------------------------------------");
            System.out.println("Total                       = Rp." + totalCount+"/pages");

            input.close();
        }
    }



// cmyk = 6000
// total = price / (cmyk / resultBaseCoverage)

// Test Case 0 (10%)    = 216860 / (6000 / 2 )  = 72/pages
// Test Case 1 (30%)    = 216860 / (6000 / 6 )  = 216/pages
// Test Case 2 (80%)    = 216860 / (6000 / 16 ) = 578/pages


