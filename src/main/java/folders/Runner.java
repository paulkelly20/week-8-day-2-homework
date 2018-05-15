import folders.db.DBFolder;
import folders.db.DBHelper;
import folders.db.DBOwner;
import folders.models.File;
import folders.models.Folder;
import folders.models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {


        Owner owner = new Owner("Paul", "pkelly20");
        Folder folder2 = new Folder("New Files", owner);
        Folder folder1 = new Folder("Old Files", owner);
        File file1 = new File("test", "Java", 100, folder2);
        File file2 = new File("new", "Ruby", 300, folder1);
        File file3 = new File("program", "Python", 200, folder2);

        DBHelper.save(owner);
        DBHelper.save(folder2);
        DBHelper.save(folder1);
        DBHelper.save(file1);
        DBHelper.save(file2);
        DBHelper.save(file3);
        List<Folder> folders = DBHelper.getAll(Folder.class);
        List<File> files = DBHelper.getAll(File.class);

        file3.setExtension("Javascript");
        DBHelper.save(file3);
        File updatedFile = DBHelper.find(File.class, file3.getId());

        List<File> filesByFolder = DBFolder.findAllFiles(folder2);

        List<Folder> foldersByOwner = DBOwner.allFoldersByOwner(owner);
    }
}
