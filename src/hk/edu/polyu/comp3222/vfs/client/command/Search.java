package hk.edu.polyu.comp3222.vfs.client.command;
import java.io.InputStream;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class Search implements FileVisitor {
    /* This flag holds the Path to the searched file */
    private final Path searchedFile;
    /* This flag is set to true if the file is found */
    public boolean file_found_flag;

    public Search(Path searchedFile) {
        this.searchedFile = searchedFile;
        this.file_found_flag = false;
    }


    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs)
            throws IOException {
        Path incoming_file=(Path) file;
        Path name = incoming_file.getFileName();
        String filename = name.toString();
        String source = searchedFile.toString();

        String caseSensitive = Searching.tempCaseSensitive;
        String matchAllKeywords = Searching.tempMatchAllKeywords;

        if (caseSensitive.equals("1")) {
            if (matchAllKeywords.equals("3")) {
                if (name != null && filename.equals(source)) {
                    System.out.println("ZIP File Contains " + searchedFile +
                            " at " + incoming_file.toRealPath().toString());
                    file_found_flag = true;
                }


            }
            if (matchAllKeywords.equals("4")) {
                if (name != null && filename.matches("(.*)" + source + "(.*)")) {
                    System.out.println("ZIP File Contains " + searchedFile +
                            " at " + incoming_file.toRealPath().toString());
                    file_found_flag = true;
                }
            }

        }

        if (caseSensitive.equals("2")) {
            if (matchAllKeywords.equals("3")) {
                if (name != null && filename.toLowerCase().matches(source.toLowerCase())) {
                    System.out.println("ZIP File Contains " + searchedFile +
                            " at " + incoming_file.toRealPath().toString());
                    file_found_flag = true;
                }


            }
            if (matchAllKeywords.equals("4")) {
                if (name != null && filename.toLowerCase().matches("(.*)" + source.toLowerCase() + "(.*)")) {
                    System.out.println("ZIP File Contains " + searchedFile +
                            " at " + incoming_file.toRealPath().toString());
                    file_found_flag = true;
                }
            }
        }

        if (!file_found_flag) {
            return FileVisitResult.CONTINUE;
        } else {
            // Terminates search on first match. set this to CONTINUE to find all matches
            return FileVisitResult.CONTINUE;
        }



    }
    /* We don't use these, so just override them */
    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc)
            throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs)
            throws IOException {
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc)
            throws IOException {
        return FileVisitResult.CONTINUE;
    }
}