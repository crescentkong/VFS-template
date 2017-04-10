package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.DirManager;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImportDir extends DirManager {

    public static String reply;

    public ImportDir(){
        super();
    }

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

        //System.out.println("Enter the path of source Directory: (e.g. C:\\Users\\Public\\COMP3222/forImport)");
        //sourcePath = keyRead.readLine(); //C:\Users\Public\happy.doc
        File source = new File(sourcePath);
        Path ZipFilePath1;

        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            //System.out.println("Enter the directory that you want to import to: (e.g.forImport)");
            //tempAddNewFile = keyRead.readLine(); //happy.doc OR a/happy.doc
            ZipFilePath1 = zipFileSys.getPath(tempAddNewFile);
            //Files.copy(source.toPath(), ZipFilePath1);
            Files.createDirectory(ZipFilePath1);
            reply = tempAddNewFile + " Successfully Imported";
        }
        catch (Exception e){
            reply = "Please Try Again";
        }return "Success";
    }

}