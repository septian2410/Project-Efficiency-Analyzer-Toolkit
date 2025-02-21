// SOAL NO.2 Program menentukan Salary Employee SQA (kondisiIf)
package com.juaracoding.psujian1jf.ujian1;

import java.util.Scanner;

public class SQASalaryClassification {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String divisi = "";
        String level = "";
        int salary = 0;
        int standardCompanyQA = 6;
        int standardSeniorAutomation = 8;
        int standardSeniorManual = standardCompanyQA;

        // Input Data Kandidat (Nama & Nilai Kandidat)
        System.out.println("## Program menentukan Salary Employee SQA ##" );
        System.out.print("MASUKKAN NAMA KANDIDAT        : ");
        String nama = input.nextLine();
        System.out.print("MASUKKAN NILAI KANDIDAT (0-10): ");
        int myValueSQA = input.nextInt();


        if (myValueSQA >= 1){
            if (myValueSQA > standardCompanyQA) {
                divisi = "QA Automation";

                if (myValueSQA >= standardSeniorAutomation) {     // value 8 sd ...
                    level = "Senior";
                    salary = 10000000;
                } else {
                    level = "Junior";                               // value == 7
                    salary = 8000000;
                }
            } else {
                divisi = "QA Manual";

                if (myValueSQA == standardSeniorManual) {
                    level = "Senior";                             // value == 6
                    salary = 8000000;
                } else {
                    level = "Junior";                             // value 1 sd 5
                    salary = 6000000;
                }
            }

            // Output
            System.out.println("\n## Data Akhir Kandidat ##");
            System.out.println("NAMA              = " + nama);
            System.out.println("DIVISI            = " + divisi);
            System.out.println("LEVEL             = " + level);
            System.out.println("SALARY/MONTH      = IDR. " + salary);

        } else {
            System.out.println("Maaf kompetensi anda belum terpenuhi.");
        }

        input.close();
    }}

//  standardCompanyQA         = 6;
//  standardSeniorAutomation  = 8;

// Test Case 0 = myValueSQA(0)         =  Maaf kompetensi anda belum terpenuhi
// Test Case 1 = myValueSQA(1 sd 5)    =  QA Manual ; Junior ; 6000000
// Test Case 2 = myValueSQA(6)         =  QA Manual ; Senior ; 8000000
// Test Case 3 = myValueSQA(7)         =  QA Automation ; Junior ; 8000000
// Test Case 4 = myValueSQA(8 dst ..)  =  QA Automation ; Senior ; 10000000

