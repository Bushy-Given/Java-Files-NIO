package files;

import java.io.File;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
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

        System.out.println("---------Visitor Option-----");

        try(final Stream<Path> walk =
                    Files.walk(path,2, FileVisitOption.FOLLOW_LINKS)){
            walk.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("---------files.find------------");

        BiPredicate<Path, BasicFileAttributes> predicate =
                (paths, attrs) -> attrs.isDirectory();

        int maxDepth = 2;

        try(final Stream<Path> find = Files.find(path, maxDepth, predicate)){
            find.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("------Files.lines() ---");

        try (final Stream<String> lines = Files.lines(Path.of(path + "/Ability.txt"))){
            lines.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Set<String> listFiles(Path dir){
        return Arrays.stream(dir.toFile().listFiles())
                .filter(file -> !file.isDirectory())
                .sorted()
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public static Set<Path> listOfPaths(Path path, int maxDepth){
        try(Stream<Path> find = Files.find(path, maxDepth,  (paths, attrs) -> attrs.isDirectory())){
            return find.collect(Collectors.toSet());
        }catch (Exception e){
            e.printStackTrace();
        }
        return new HashSet<>();
    }
}
