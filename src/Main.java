import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Main {

	public static void main(String[] args)  {
		try {
			URL path = Main.class.getResource("input.txt");
			File f = new File(path.getFile());
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String str;
			while ((str = reader.readLine()) != null) {
				// Parse input
				System.out.println(str);
			}
			System.out.println(str);
		}
		catch (IOException e) {
		}
	}
}

