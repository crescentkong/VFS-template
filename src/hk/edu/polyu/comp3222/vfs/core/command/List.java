package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FunctionManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

@SuppressWarnings("ALL")
public class List extends FunctionManager {

    public static String reply;

    public List(){
        super();
    }

    @Override
    public void ope() throws IOException {
    }

    public String ope(String parameter) throws IOException {
        System.out.print("para"+ parameter);
        VirDiskPath = "jar:file:" + parameter;
        String resultString="";
        URI zipFile = URI.create(VirDiskPath);
        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributesFalse);) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(zipFileSys.getPath("/"));) {
                for (Path file : directoryStream) {
                    System.out.println(file.getFileName());
                    resultString += file.getFileName() + " ; ";
                }
                //System.out.println(resultString);
                reply = resultString;
            }
        }

        catch (Exception e){
            reply = "Please Try Again";
        }return "Success";
    }

}