package hk.edu.polyu.comp3222.vfs.core.command;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.*;
import java.io.IOException;

/**
 *
 */
@SuppressWarnings("ALL")
public class SearchMethod implements FileVisitor {
    /* This flag holds the Path to the searched file */

    public static String reply;

    private final Path searchedFile;
    /* This flag is set to true if the file is found */
    public boolean file_found_flag;

    public SearchMethod(Path searchedFile) {
        this.searchedFile = searchedFile;
        this.file_found_flag = false;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        Path incoming_file=(Path) file;
        Path name = incoming_file.getFileName();
        String filename = name.toString();
        String source = searchedFile.toString();

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