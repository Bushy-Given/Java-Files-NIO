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

        final Path path = Path.of("C:\\Users\\bushy\\Documents\\Git\\projects\\Java-Files-NIO\\temp");
        try (Stream<Path> list = Files.list(path)){
            list.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("---------walk-------");
        //Files.walk
        try(final Stream<Path> walk = Files.walk(path)){
            walk.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("---------walk max depth 1");
        //Files.walk
        try(final Stream<Path> walk = Files.walk(path,1)){
            walk.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("");




    }
}
