package files;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Created by Bushy-Netshidaulu
 * on 4/29/2020
 */
public class _Files {
    public static void main(String[] args) {

        final Path path = Path.of("C:\\Users\\bushy\\Documents\\Git\\projects\\Java-Files-NIO\\temp");
        final Path newPath = Path.of("C:\\Users\\bushy\\Documents\\Git\\projects\\Java-Files-NIO\\play");
        final boolean exists = Files.exists(path);
        System.out.println(exists);

        try{
            Path dir = Files.createDirectory(newPath);
        }catch(FileAlreadyExistsException e){
            System.out.println("dir already exist");
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("-----Files.copy -----");


        Path source = Path.of(path + "/Ability.txt");
        Path destination = Path.of(newPath + "/new.txt");

        // to override existing file we add extra param ->StandardCopyOption.REPLACE_EXISTING
        try {
            Files.createFile(Path.of("C:\\Users\\bushy\\Documents\\Git\\projects\\Java-Files-NIO\\temp\\art\\art.txt"));
            final Path copy = Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path s = Path.of("C:\\Users\\bushy\\Documents\\Git\\projects\\Java-Files-NIO\\temp\\art\\art.txt");
        Path d = Path.of(newPath + "/moved.txt");


        try {
            final Path move = Files.move(s, d, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.delete(d);
        }catch (Exception e){
            e.printStackTrace();
        }





    }
}
