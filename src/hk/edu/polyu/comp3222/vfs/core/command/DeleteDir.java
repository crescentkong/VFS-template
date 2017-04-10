package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.DirManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("ALL")
public class DeleteDir extends DirManager {

    public static String reply;

    public DeleteDir(){
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
        VirDiskPath = "jar:file:" + a;

        tempDeleteDir = b;

        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            //System.out.println("Enter the name of Directory to be deleted: (e.g. reasas)"); //cannot delete directory with files inside
            //tempDeleteVDisk = keyRead.readLine();
            //Path path = zipFileSys.getPath("docs");
            Path pathInZipfile = zipFileSys.getPath(tempDeleteDir);
            System.out.println("About to delete a directory from ZIP File" + pathInZipfile.toUri() );
                    /* Execute DeleteVD */
            Files.delete(pathInZipfile);
            System.out.println("Directory successfully deleted");
            reply = tempDeleteDir + " Successfully Deleted";
        }
        catch (Exception e){
            reply = "Please Try Again";
        }
        return "Success";
    }
}