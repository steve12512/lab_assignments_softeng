import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class HistogramGenerator {
	
	
	public static void main(String[] args) {
		
		int[] frequency = create_array();
		edit_frequencies(frequency,args[0]);
	}

	
	private static int[] create_array() {
		int[] frequency = new int[10];
		for (int i: frequency) {
			i = 0;
		}
		return frequency;
	}
	
	
	private static void edit_frequencies(int[] a, String text) {
		if (text == null) {
            System.err.println("Please provide the file name as an argument.");
            System.exit(1);
        }
        String fileName = text;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                a[num]++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid integer: " + e.getMessage());
        }
	}
	
}
