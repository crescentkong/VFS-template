package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FileCommand;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("ALL")
public class MoveFile extends FileCommand {

    public static String reply;

    public MoveFile(){
        super();
    }

    @Override
    public void ope() throws IOException {
    }

    public String ope(String parameter) throws IOException {
        System.out.println("para:"+ parameter);
        String a = getFieldData(parameter,1," ");
        System.out.println("a:"+ a);
        String b = getFieldData(parameter,2," ");
        System.out.println("b:"+ b);
        String c = getFieldData(parameter,3," ");
        System.out.println("c:"+ c);
        VirDiskPath = "jar:file:" + a;
        tempDeleteFile = b;
        tempAddNewFile = c;

        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            //System.out.println("Enter the path of the File to be moved: (e.g. reallweeks.png)");
            //tempDeleteFile = keyRead.readLine();
            Path ZipFilePath = zipFileSys.getPath(tempDeleteFile);
            //System.out.println("Enter the new path of the File: (e.g. a/reallweeks.png)");
            //tempAddNewFile = keyRead.readLine();
            Path ZipFilePath1 = zipFileSys.getPath(tempAddNewFile);
            Files.copy(ZipFilePath, ZipFilePath1);
            Files.delete(ZipFilePath);
            reply = tempDeleteFile + " Successfully Moved";
        }return "Success";
    }

}