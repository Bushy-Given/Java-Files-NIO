package files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Bushy-Netshidaulu
 * on 4/29/2020
 */
public class Main {
    public static void main(String[] args) {

        final String url = "C:\\Users\\bushy\\Documents\\Git\\projects\\Java-Files-NIO\\temp";
        try (Stream<Path> list = Files.list(Path.of(url))){
            list.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
