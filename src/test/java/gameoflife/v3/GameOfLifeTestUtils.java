package gameoflife.v3;

import gameoflife.v3.cartesian.CartesianBoard;
import gameoflife.v3.cartesian.CartesianBoardRenderer;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static gameoflife.v3.cartesian.CartesianBoardRenderer.LINE;
import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTestUtils {

    public static String getFile(Class<?> clazz, String fileName) {
        try {
            URL url = clazz.getResource(fileName);
            Path path = Paths.get(url.toURI());
            return Files.readAllLines(path).stream().collect(Collectors.joining(LINE));
        } catch (Exception e) {
            throw new RuntimeException("Cannot read file" + fileName, e);
        }
    }

}
