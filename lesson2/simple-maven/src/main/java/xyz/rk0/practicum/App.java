package xyz.rk0.practicum;

import com.google.common.base.Joiner;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        Joiner joiner = Joiner.on("-");
        var names = Files.readLines(new File("text.txt"), Charset.defaultCharset());
        System.out.println(joiner.join(names));
    }
}
