package pt.upt;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, Maven!");
        System.out.println("Introduz números separados por vírgulas (ex: 10, 3.5, -2, 7):");

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println("Não introduziste nada. A sair...");
            return;
        }

        double[] values;
        try {
            values = Arrays.stream(line.split(","))
                    .map(String::trim)
                    .mapToDouble(Double::parseDouble)
                    .toArray();
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Usa apenas números e vírgulas.");
            return;
        }

        DescriptiveStatistics ds = new DescriptiveStatistics();
        for (double v : values) ds.addValue(v);

        System.out.println("Mean: " + ds.getMean());
        System.out.println("Median: " + ds.getPercentile(50));
        System.out.println("Standard Deviation: " + ds.getStandardDeviation());
    }
}

