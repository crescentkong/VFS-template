package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.DirManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("ALL")
public class CopyDir extends DirManager{

    public static String reply;

    public CopyDir(){
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
        tempDeleteDir = b;
        tempAddNewDir = c;

        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes)) {
            //System.out.println("Enter the name of the Directory to be copied: ");
            //tempDeleteDir = keyRead.readLine();
            Path ZipFilePath = zipFileSys.getPath(tempDeleteDir);
            //System.out.println("Enter the new name of the copied Directory: ");
            //tempAddNewDir = keyRead.readLine();
            Path ZipFilePath1 = zipFileSys.getPath(tempAddNewDir);
            Files.createDirectory(ZipFilePath1);
            reply = tempDeleteDir + " Successfully Copied";
        }
        catch (Exception e){
            reply = "Please Try Again";
        }
        return "Success";
    }

}
