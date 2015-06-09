import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Zipf {

	final static Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public static void main(String[] args) throws IOException {

		StringBuilder allBooks = new StringBuilder();

		if (args.length == 0) {
			throw new RuntimeException("No files to read, add files paths to arguments");
		} else {
			System.out.println("Reading files with UTF-8 from: ");
			for (String p : args) {
				System.out.print(p + " ");

				List<String> input;
				
				input = Files.readAllLines(Paths.get(p), DEFAULT_CHARSET);

				String text = input.stream().collect(Collectors.joining());
				
				allBooks.append(text);

				String output = WordCounter.zipify(text);

				Files.write(Paths.get(p.replace(".txt", ".csv")), output.getBytes());
			}
		}

		Files.write(Paths.get("./total.csv"), WordCounter.zipify(allBooks.toString()).getBytes());
		System.out.println("Total words read: " + WordCounter.ALL_BOOKS_TOTAL);
	}
}
