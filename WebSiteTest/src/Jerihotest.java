
import java.io.BufferedReader;
import java.io.File;
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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;

public class Jerihotest {

	public Jerihotest(File file, String s) throws IOException {
		Document doc = Jsoup.parse(file, "UTF-8","");
		//Elements ps = doc.select("p");
		System.out.println(doc.text());
	
		PrintWriter writer = new PrintWriter("/home/tomasz/Dokumenty/witek/parsed.txt", "UTF-8");
		writer.println(doc.text());
		writer.close();
		
		zwrocPrawde(s);
		}
	
	private void zwrocPrawde(String s1) {
		Path path = Paths.get("/home/tomasz/Dokumenty/witek/parsed.txt");
		Charset charset = StandardCharsets.UTF_8;
		
		try {
		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceAll("Frage", "\nFrage");
		Files.write(path, content.getBytes(charset));
		
		
		FileReader plik = new FileReader("/home/tomasz/Dokumenty/witek/parsed.txt");
		BufferedReader buffer = new BufferedReader(plik);
		for (String line = buffer.readLine(); line!=null; line = buffer.readLine()) {
			String templine=line;
			String templine1=buffer.readLine();
			try{
				if (templine1.contains("korrekt")) {
					System.out.println(templine);
					System.out.println(templine1);
					if (s1.equals("1100")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_1_1100.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("1011")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_2_1011.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("1010")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_3_1010.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("1001")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_4_1001.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("1000")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_1_1000.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("0111")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_2_0111.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("0110")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_3_0110.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("0101")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_4_0101.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("0100")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_1_0100.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("0011")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_2_0011.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("0010")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_3_0010.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					} else if (s1.equals("0001")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_4_0001.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					}	else if (s1.equals("1101")) {
						Files.write(Paths.get("/home/tomasz/Dokumenty/witek/goodqa_4_1101.txt"), (templine +"\n"+templine1+"\n").getBytes(), StandardOpenOption.APPEND);
					}	
					
					
				} 
			} catch (NullPointerException e) {
				System.out.println("jebac to");
			}
		}	
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
