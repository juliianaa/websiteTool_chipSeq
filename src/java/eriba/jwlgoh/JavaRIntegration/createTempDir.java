/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.JavaRIntegration;

import java.io.IOException;
import java.nio.file.*;

/**
 * 
 * This class only contains one method which is the createDir, where a temporary directory will 
 * be created for saving the uploaded file(s) of the client.
 *
 * @author jwlgoh
 */
public class createTempDir {
    
    /**
     * Creates an temporary directory where the uploaded files of the client will be saved
     *
     * @param uploadPath
     * @return path of temporary directory
     * @throws IOException
     */
    public String createDir(String uploadPath) throws IOException {
        
        //throw a check if File is a BED or BAM
        //If YES -> make temporary directory and let it save on disk 
        //NO -> then give message that fil is wrong and cannot be used
        
        //Gets the path of where the temporary directory will be saved
        final Path basedir = FileSystems.getDefault().getPath(uploadPath);
        //How the temporary directory name will start
        final String tmp_dir_prefix = "HistoneHMM_";
        //Creates the temporary directory in the given path with the name of the directory.
        final Path tmp_dir = Files.createTempDirectory(basedir, tmp_dir_prefix);
        
        //returns the path of the temporary directory
        return tmp_dir.toString();

    }
        
}
