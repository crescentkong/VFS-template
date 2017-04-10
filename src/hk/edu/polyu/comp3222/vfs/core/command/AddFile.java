package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FileManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

@SuppressWarnings("ALL")
public class AddFile extends FileManager {

    public static String reply;

    public AddFile(){
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

        tempAddNewFile = b;

        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes)) {
            /* Create a Path in ZIP File */
            //System.out.println("Enter the path of the new File: (e.g. abc.doc OR a123/abc.doc) ");
            //tempAddNewFile = keyRead.readLine();
            //Path ZipFilePath = zipFileSys.getPath("TESTER.doc");
            Path ZipFilePath = zipFileSys.getPath(tempAddNewFile);
            /* Path where the file to be added resides */
            //Path addNewFile = Paths.get("C:/Users/Public/COMP3222/home2.zip");
            Path addNewFile = Paths.get("C:" + a);
            /* Append file to ZIP File */
            Files.copy(addNewFile, ZipFilePath);
            reply = tempAddNewFile + " Successfully Added";
        }
        catch (Exception e){
            reply = "Please Try Again";
        }
        return "Success";
    }
}