package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.DirManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("ALL")
public class AddDir extends DirManager {

    public static String reply;

    public AddDir(){
        super();
    }

    @Override
    public void ope() throws IOException {
    }

    public String ope(String parameter) throws IOException {
        String a = getFieldData(parameter,1," ");
        String b = getFieldData(parameter,2," ");
        VirDiskPath = "jar:file:" + a;

        tempAddNewDir = b;

        URI zipFile = URI.create(VirDiskPath);
        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes)) {
            //System.out.println("Enter the name of the New Directory: (e.g. new OR asas/new)");
            //tempAddNewDir = keyRead.readLine();
            //Path path = zipFileSys.getPath("docs");
            Path path = zipFileSys.getPath(tempAddNewDir);
            Files.createDirectory(path);
            reply = tempAddNewDir + " Successfully Added";
        }
        catch (Exception e){
            reply = "Please Try Again";
        }
    return "Success";
    }
}