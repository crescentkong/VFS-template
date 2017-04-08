package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FunctionManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Fiona on 4/8/2017.
 */
public class Searching extends FunctionManager {

    public Searching(){
        super();
    }

    @Override
    public void ope() throws IOException {
        System.out.println("Search File or Folder?");
        tempSearchFileFolder = keyRead.readLine();

        System.out.println("Enter the file/folder you want to Search: ");
        tempSearchWord = keyRead.readLine();

        System.out.println("1- Case Sensitive; 2- Insensitive");
        tempCaseSensitive = keyRead.readLine();

        System.out.println("3- Match All Keywords; 4- Match Any Keywords");
        tempMatchAllKeywords = keyRead.readLine();

        System.out.println("Enter the path: ");
        tempSearchPath = keyRead.readLine();
        searchPath = "jar:file:" + tempSearchPath;
        System.out.println(searchPath);


        //Path searchFile = Paths.get("a.doc");
        Path searchFile = Paths.get(tempSearchWord);
        Search walk = new Search(searchFile);

        ZipFile zipFile = new ZipFile(tempSearchPath);

        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        ArrayList<String> ar = new ArrayList<String>();

        while(entries.hasMoreElements()) {

            ZipEntry entry = entries.nextElement();
            tempEntry = entry.toString();
            if (tempEntry.matches("(.*)" + ("/") )){
                //System.out.println("q");
                ar.add(tempEntry);
            }

            //for (String ent : ar) {
            //System.out.println(ent);
            //}

            InputStream stream = zipFile.getInputStream(entry);

        }

        if (tempSearchFileFolder.equals("Folder")) {
            //for (String ent : ar) {
            for (int i = 0; i < ar.size(); i++) {

                if (tempCaseSensitive.equals("1")) {
                    if (tempMatchAllKeywords.equals("3")) {
                        if (ar.get(i).equals(tempSearchWord + "/")) {
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + ar.get(i));
                            walk.file_found_flag = true;
                        }

                    }

                    if (tempMatchAllKeywords.equals("4")) {
                        if (ar.get(i).matches("(.*)" + tempSearchWord + "(.*)" + "(/)")) {
                            //if (i > 0) {
                            //for (int j = 0; j < (ar.size() - 1); j++) {
                            //if (!ar.get(i).matches(ar.get(j) + "(.*)")) {
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + ar.get(i));
                            walk.file_found_flag = true;
                            //}
                            //}
                            //}
                        }
                    }
                }

                if (tempCaseSensitive.equals("2")) {
                    if (tempMatchAllKeywords.equals("3")) {
                        if (ar.get(i).toLowerCase().matches((tempSearchWord + "/").toLowerCase())) {
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + ar.get(i));
                            walk.file_found_flag = true;
                        }


                    }
                    if (tempMatchAllKeywords.equals("4")) {
                        if (ar.get(i).toLowerCase().matches("(.*)".toLowerCase() + tempSearchWord.toLowerCase() + "(.*)".toLowerCase() + "(/)")) {
                            System.out.println("ZIP File Contains " + searchFile +
                                    " at " + ar.get(i));
                            walk.file_found_flag = true;
                        }
                    }
                }

            }
        }

            /* Define ZIP File System Properies in HashMap */
        //URI zip_disk = URI.create("jar:file:/Users/Public/COMP3222/home2.zip");
        URI zip_disk = URI.create(searchPath);
        FileSystem zipfs = FileSystems.newFileSystem(zip_disk, attributes);

        Iterable<Path> dirs = zipfs.getRootDirectories();

        for (Path root : dirs) {
            if (!walk.file_found_flag) {
                Files.walkFileTree(root, walk);
            }
        }
        if (!walk.file_found_flag) {
            System.out.println("ZIP File does not contain " + searchFile );
        }

    }
}
