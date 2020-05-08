package files;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Bushy-Netshidaulu
 * on 5/8/2020
 */
public class _PathsExample {
    public static void main(String[] args) {

        // relativize
        String uri = "C:\\Users\\bushy\\Documents\\Git\\projects\\Java-Files-NIO\\relativize";
        Path path = Paths.get(uri);
        Path passedpath = Paths.get(uri, "equinox\\p2\\core\\cache\\binary");

        System.out.println("This path : " + path);
        System.out.println("Given Path : " + passedpath);

        Path relativice = path.relativize(passedpath);
        System.out.println("relativize Path : " + relativice);

        //resolve
        String passedPath1 = "projects";
        //takes a string arg
        Path resolvedPath = path.resolve(passedPath1);
        System.out.println("ResolvedPath : " + resolvedPath);

        Path passedPath2 = passedpath;

        //takes Path as arg
        Path resolve = path.resolve(passedPath2);
        System.out.println("ResolvedPath2 : " + resolve);
    }

}
