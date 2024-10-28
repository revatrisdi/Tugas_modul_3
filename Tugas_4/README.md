/**
* Kelas Employee merepresentasikan seorang karyawan dengan data gaji dan metode
* untuk menghitung gaji kotor, potongan, dan gaji bersih.
*
* @since 1.0
  */
  public class Employee {
  private String name;
  private double baseSalary;
  private double allowance;
  private double bonus;
  private double taxRate;
  private double insuranceDeduction;

  /**
    * Konstruktor untuk membuat objek Employee.
    *
    * @param name Nama karyawan
    * @param baseSalary Gaji pokok karyawan
    * @param allowance Tunjangan karyawan
    * @param bonus Bonus karyawan
    * @param taxRate Persentase pajak
    * @param insuranceDeduction Persentase potongan asuransi
      */
      public Employee(String name, double baseSalary, double allowance, double bonus, double taxRate, double insuranceDeduction) {
      this.name = name;
      this.baseSalary = baseSalary;
      this.allowance = allowance;
      this.bonus = bonus;
      this.taxRate = taxRate;
      this.insuranceDeduction = insuranceDeduction;
      }

  /**
    * Menghitung gaji kotor karyawan.
    *
    * @return Gaji kotor
      */
      public double calculateGrossSalary() {
      return baseSalary + allowance + bonus;
      }

  /**
    * Menghitung total potongan untuk karyawan, termasuk pajak dan asuransi.
    *
    * @return Total potongan
      */
      public double calculateDeductions() {
      double grossSalary = calculateGrossSalary();
      double tax = grossSalary * taxRate;
      double insurance = grossSalary * insuranceDeduction;
      return tax + insurance;
      }

  /**
    * Menghitung gaji bersih setelah dikurangi total potongan.
    *
    * @return Gaji bersih
      */
      public double calculateNetSalary() {
      return calculateGrossSalary() - calculateDeductions();
      }

  /**
    * Menampilkan rincian gaji karyawan.
      */
      public void printSalaryDetails() {
      System.out.println("Nama: " + name);
      System.out.println("Gaji Pokok: Rp " + baseSalary);
      System.out.println("Tunjangan: Rp " + allowance);
      System.out.println("Bonus: Rp " + bonus);
      System.out.println("Gaji Kotor: Rp " + calculateGrossSalary());
      System.out.println("Potongan: Rp " + calculateDeductions());
      System.out.println("Gaji Bersih: Rp " + calculateNetSalary());
      }
      }
