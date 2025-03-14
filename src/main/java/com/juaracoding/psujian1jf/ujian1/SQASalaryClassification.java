// SOAL NO.2 Program menentukan Salary Employee SQA (kondisiIf)
package com.juaracoding.psujian1jf.ujian1;

import java.util.Scanner;

public class SQASalaryClassification {

    private int standardCompanyQA, standardSeniorAutomation, standardSeniorManual;
    private Scanner input;
    private String divisi, level, nama;
    private int salary;

    public SQASalaryClassification(int standardCompanyQA, int standardSeniorAutomation, int standardSeniorManual) {
        this.standardCompanyQA = standardCompanyQA;
        this.standardSeniorAutomation = standardSeniorAutomation;
        this.standardSeniorManual = standardSeniorManual;
        this.input = new Scanner(System.in);
    }

    public void classificationSalarySQA(int myValueSQA) {
        if (myValueSQA >= 1) {
            if (myValueSQA > standardCompanyQA) {
                divisi = "QA Automation";
                if (myValueSQA >= standardSeniorAutomation) {
                    level = "Senior";
                    salary = 10000000;
                } else {
                    level = "Junior";
                    salary = 8000000;
                }
            } else {
                divisi = "QA Manual";
                if (myValueSQA == standardSeniorManual) {
                    level = "Senior";
                    salary = 8000000;
                } else {
                    level = "Junior";
                    salary = 6000000;
                }
            }
        } else {
            System.out.println("Maaf, kompetensi Anda belum terpenuhi.");
            divisi = "Tidak ada";
            level = "Tidak Punya Level";
            salary = 0;
            return;
        }
    }

    public String inputNamaKandidat() {
        System.out.print("MASUKKAN NAMA KANDIDAT        : ");
        return input.nextLine();
    }

    public int inputValueSQA() {
        System.out.print("MASUKKAN NILAI KANDIDAT (0-10): ");
        int myValueSQA = input.nextInt();
        input.nextLine();
        return myValueSQA;
    }

    public void startProgram() {
        while (true) {
            System.out.print("Ingin mencari tahu posisi QA yang cocok untuk kamu? (Ya/Tidak): ");
            String answer = input.nextLine().trim();

            if (answer.equalsIgnoreCase("Ya")) {
                while (true) {
                    System.out.println("\n## Program Menentukan Salary Employee SQA ##");
                    nama = inputNamaKandidat();
                    int myValueSQA = inputValueSQA();
                    classificationSalarySQA(myValueSQA);

                    System.out.println("\n## Data Akhir Kandidat ##");
                    System.out.println("NAMA              = " + nama);
                    System.out.println("DIVISI            = " + divisi);
                    System.out.println("LEVEL             = " + level);
                    System.out.println("SALARY/MONTH      = IDR " + salary);

                    while (true) {
                        System.out.print("\nApakah masih ingin melanjutkan pencarian posisi? (Ya/Tidak): ");
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
        SQASalaryClassification obj = new SQASalaryClassification(6, 8, 6);
        obj.startProgram();
    }
}


/*

 * Ketetapan Standar Value seorang QA*

  standardCompanyQA         = 6 (QA Manual, Junior);
  standardSeniorAutomation  = 8 (QA Automation, Senior);

 * Case Pengujian Salary Classification QA *

 Case 1 (myValueSQA Pelamar = 0)
      DIVISI        = Tidak ada
      LEVEL         = Tidak Punya Level
      SALARY/MONTH  = 0

 Case 2 (myValueSQA Pelamar = 1 sd 5)
      DIVISI        = QA Manual
      LEVEL         = Junior
      SALARY/MONTH  = Rp.6.000.000

 Case 3 (myValueSQA Pelamar = 6)
      DIVISI        = QA Manual
      LEVEL         = Senior
      SALARY/MONTH  = Rp.8.000.000

 Case 4 (myValueSQA Pelamar = 7)
      DIVISI        = QA Automation
      LEVEL         = Junior
      SALARY/MONTH  = Rp.8.000.000

 Case 5 (myValueSQA Pelamar = 8 sd dst ...)
      DIVISI        = QA Automation
      LEVEL         = Senior
      SALARY/MONTH  = Rp.10.000.000

*/

