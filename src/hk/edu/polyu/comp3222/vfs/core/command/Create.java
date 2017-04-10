package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.VDCommand;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

@SuppressWarnings("ALL")
public class Create extends VDCommand {

    public static String reply;

    public Create(){
        super();
    }

    @Override
    public void ope() throws IOException{
    }

    public String ope(String parameter) throws IOException{
        System.out.print("para"+ parameter);
        //String b = getFieldData(parameter,2," ");
        VirDiskPath = "jar:file:" + parameter;

        URI zipFile = URI.create(VirDiskPath);
        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(zipFileSys.getPath("/"));) {
                for (Path file : directoryStream) {
                    System.out.println(file.getFileName());
                }
                //ZipOutputStream emptyzip = new ZipOutputStream(new FileOutputStream(new FileOutputStream(tempVirDiskPath)));
                //emptyzip.close();
            }
            reply = parameter + " Successfully Created";
        }
        catch (Exception e){
            reply = "Please Try Again";
        }
    return "Success";
    }
}