package MeanMedianMode;
/**
 * This class represents the import and output management.
 * @author Marius Haueis
 * @version 30 03 2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
	public Scanner sc;
	public MeanMedianModeCalculator mmc;
	double t =0;
	
	public GUI() {
		mmc = new MeanMedianModeCalculator();
		sc = new Scanner(System.in);
	}
	
	
	protected void action() {
		t = sc.nextInt();
		ArrayList<Integer> numbers = new ArrayList<Integer>((int) t);
		for (int i = 0; i < t; i++) {
			int k = sc.nextInt();
			numbers.add(k);
		}
		System.out.println("the mean of your numbers: " +mmc.meanHelper(numbers));
		System.out.println("the median of your numbers: " +mmc.medianHelper(numbers, t));
		System.out.println("the mode of your numbers: " +(int) mmc.modeHelper(numbers));
		sc.close();
	}
}
