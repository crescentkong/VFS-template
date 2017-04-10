package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FileCommand;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("ALL")
public class ImportFile extends FileCommand {

    public static String reply;

    public ImportFile(){
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

        sourcePath = a;
        VirDiskPath = "jar:file:" + b;
        tempAddNewFile = c;
        File source = new File(sourcePath);
        Path ZipFilePath1;
        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            //System.out.println("Enter the directory that you want to import to: (e.g.allweeks.png)");
            //tempAddNewFile = keyRead.readLine(); //happy.doc OR a/happy.doc
            ZipFilePath1 = zipFileSys.getPath(tempAddNewFile);
            Files.copy(source.toPath(), ZipFilePath1);
            reply = tempAddNewFile + " Successfully Imported";
        }
        catch (Exception e){
            reply = "Please Try Again";
        }return "Success";
    }

}