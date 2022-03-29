package comp3350.iRecipe;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import comp3350.iRecipe.Presentation.MainActivity;

public class CopyDB {

    private static final File DB_SRC = new File("src/main/assets/db/SC.script");


    public static File copy_real_db()  throws IOException
    {
        final File temp_file = File.createTempFile("temp" , ".script");
        Files.copy(DB_SRC.toPath() , temp_file.toPath() , REPLACE_EXISTING);

        MainActivity.setDBPathName(temp_file.getAbsolutePath().replace(".script" , ""));
        return temp_file;
    }
}
