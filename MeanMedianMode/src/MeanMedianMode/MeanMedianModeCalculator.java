package MeanMedianMode;
/**
 * In this class the calculations of the mean, median and mode are made.
 * @author Marius Haueis
 * @version 30.03.2021
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MeanMedianModeCalculator {

	protected double meanHelper(ArrayList<Integer> numbers) {
		double meanHelper = numbers.stream().reduce(0, (a, c) -> (a + c));
		double mean = meanHelper / numbers.size();
		return mean;
	}

	protected double medianHelper(ArrayList<Integer> numbers, double t) {
		List<Integer> numi = numbers.stream().sorted().collect(Collectors.toList());
		double b =0.0;
		double hepl = 0.0;
		int tf = (int) t;
		if (t % 2 == 0) {
			hepl = (numi.get(tf / 2) + numi.get((tf / 2) - 1));
			b= hepl / 2;
		} else {
			b = numi.get((int) Math.ceil(t / 2));
		}
		 return b;
	}
	protected int modeHelper(ArrayList<Integer> numbers) {
		HashMap<Integer, Integer> numbersHash = new HashMap<Integer, Integer>();
		int mode =0;
		for (Integer numb : numbers) {
			if (numbersHash.containsKey(numb)) {
				numbersHash.replace(numb, numbersHash.get(numb) + 1);
			} else {
				numbersHash.put(numb, 1);
			}
		}
		double modeHelper = numbersHash.values().stream().max((m, n) -> Integer.compare(m, n)).get();
		if (modeHelper <= 1) {
			mode = numbersHash.keySet().stream().min((m, n) -> Integer.compare(m, n)).get();
		} else {
			for (Entry<Integer, Integer> entry : numbersHash.entrySet()) {
				if (Objects.equals((int) modeHelper, entry.getValue())) {
					mode = entry.getKey();
				}
			}
		}
		return mode;
	}
	
}
