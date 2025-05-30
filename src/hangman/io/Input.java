package hangman.io;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {}

    public static List<String> readLinesFromFile(String path) {
        URL url = Input.class.getResource(path);
        if (url == null) {
            throw new RuntimeException("File not found " + path);
        }

        try {
            return Files.readAllLines(Paths.get(url.toURI()), UTF_8);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("Error loading dictionary", e);
        }
    }

    public static String readFromKeyboard(String message) {
        if (!Objects.isNull(message)) {
            Output.writeToConsole(message + ": ", false);
        }

        return SCANNER.nextLine();
    }

}
