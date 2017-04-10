package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FileCommand;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("ALL")
public class DeleteFile extends FileCommand {

    public static String reply;

    public DeleteFile(){
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

        tempDeleteFile = b;

        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipfs = FileSystems.newFileSystem(zipFile, attributesFalse)) {

            //System.out.println("Enter the name of the File to be deleted: (e.g. happy.doc OR asas/happy.doc)");
            //tempDeleteFile = keyRead.readLine();

            /* Get the Path inside ZIP File to delete the ZIP Entry */
            //Path pathInZipfile = zipfs.getPath("TESTER.doc");
            Path pathInZipfile = zipfs.getPath(tempDeleteFile);
            System.out.println("About to delete an entry from ZIP File" + pathInZipfile.toUri());
            /* Execute DeleteVD */
            Files.delete(pathInZipfile);
            System.out.println("File successfully deleted");

            reply = tempDeleteFile + " Successfully Deleted";
        }
        catch (Exception e){
            reply = "Please Try Again";
        }
        return "Success";}

}