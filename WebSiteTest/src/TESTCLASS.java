import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;



public class TESTCLASS {

	public static void main(String[] args) {			
		
		
		Path path = Paths.get("/home/tomasz/Dokumenty/witek/parsedtoTest.txt");
		Charset charset = StandardCharsets.UTF_8;
		
		try {
		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceAll("Frage", "\nFrage");
		Files.write(path, content.getBytes(charset));
		
		
		FileReader plik = new FileReader("/home/tomasz/Dokumenty/witek/parsedtoTest.txt");
		BufferedReader buffer = new BufferedReader(plik);
		for (String line = buffer.readLine(); line!=null; line = buffer.readLine()) {
			String templine=line;
			String templine1=buffer.readLine();
			if (templine1.contains("korrekt")) {
				System.out.println(templine);
				System.out.println(templine1);
			    Files.write(Paths.get("/home/tomasz/Dokumenty/witek/good.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
			}
		}	
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
