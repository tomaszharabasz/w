import java.util.ArrayList;
import java.util.Arrays;


public class Runner {

	public static void main(String[] args) {
		
		ArrayList<String> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(//"1101",
									//"1010",
								   //"1100",
								   //"1011",
								   //"1001",
								   //"1000",
								   //"0111",
								   "0110",
								   "0101",
								   "0100",
								   "0011",
								   "0010",
								   "0001"));
		for (String s : lista) {
			for (int i =0; i<20;i++) {
			System.out.println(s + " iteracja : " + i);
				new Driver(s);
			}
			
		}
	}

}
