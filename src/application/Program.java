package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String ars[]) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        for (int i = 1; i <=n ; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0); // pega a primeira posição do char
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual Income: ");
            double annualIncome = sc.nextDouble();
            // Polimorfismo. Mesmo TIPO de obj TaxPayer, com instanciamentos diferentes
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, annualIncome, healthExpenditures));
            }else{
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }
        Double totalTaxes = 0.0;
        System.out.println("TAXES PAID:");
        for (TaxPayer c : list) {
            System.out.print(c.getName() + ": $ " + String.format("%.2f\n",c.tax()));
            totalTaxes += c.tax();
        }
        System.out.print("TOTAL PAID:"+ " $ " + String.format("%.2f\n",totalTaxes));
        sc.close();

    }
}
