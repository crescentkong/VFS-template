package hk.edu.polyu.comp3222.vfs.core.command;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import hk.edu.polyu.comp3222.vfs.core.FileCommand;

@SuppressWarnings("ALL")
public class CopyFile extends FileCommand {

    public static String reply;

    public CopyFile(){
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

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes)) {
            //System.out.println("Enter the path of the File to be copied: (e.g. happy.doc)");
            //tempDeleteFile = keyRead.readLine(); //happy.doc
            Path ZipFilePath = zipFileSys.getPath(tempDeleteFile);
            //System.out.println("Enter the path of the copied File: (e.g. happy2.doc OR asas/happy.doc)");
            //tempDeleteFile = keyRead.readLine(); //happy2.doc OR asas/happy.doc
            Path ZipFilePath1 = zipFileSys.getPath(tempAddNewFile);
            Files.copy(ZipFilePath, ZipFilePath1);
            reply = tempDeleteFile + " Successfully Copied";
        }
        return "Success";
    }
}