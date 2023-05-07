import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/***
 * 
 * @author steve12512 The purpose of this class is to demonstrate a simple
 *         scenario of a JFreeChart XYLine chart when reading a txt file with some integer grades as a command line argument.
 * @since April 2023
 */

public class HistogramGenerator {
	/***
	 * main class
	 */
	
	public static void main(String[] args) {
		
		int[] frequency = create_array();
		edit_frequencies(frequency,args[0]);
		print_frequencies(frequency);
	}

	
	private static int[] create_array() {
		/***
		 * creates an array that counts the frequency of each grade starting at number 0
	 */
		int[] frequency = new int[10];
		for (int i: frequency) {
			i = 0;
		}
		return frequency;
	}
	
	
	private static void edit_frequencies(int[] a, String text) {
		/***
		iterates through the file given as a command line argument. if there is no file given the program ends with error status 1
		if the integer given file is correct, it iterated through it, reads every element and increases the number of times it has occured on the frequency array created previously
		if there is any exception, it produces an exception message
		*/

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
	
	private static void print_frequencies(int[] frequency) {
		/***
		 * creates and initialises the XYSeries objects required to portray the numbers of the frequency array in an XYSERIES chart
	 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries data = new XYSeries("frequencies");
		for (int i = 0; i < frequency.length; i++) {
			data.add(i, frequency[i]);
		}
		dataset.addSeries(data);
		boolean legend = false; 
		boolean tooltips = false; 
		boolean urls = false; 
		JFreeChart chart = ChartFactory.createXYLineChart("Frequencies", "X", "Y", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		frame.setVisible(true);
	}
}
