/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.ImplementR;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Eriba
 */
public class createTempDir {
    
    /**
     *
     * @param uploadPath
     * @return
     * @throws IOException
     */
    public Path createDir(String uploadPath) throws IOException {
        
        //throw a check if File is a BED or BAM
        //If YES -> make temporary directory and let it save on disk 
        //NO -> then give message that fil is wrong and cannot be used

        final Path basedir = FileSystems.getDefault().getPath(uploadPath);
        final String tmp_dir_prefix = "HistoneHMM_";

        final Path tmp_dir = Files.createTempDirectory(basedir, tmp_dir_prefix);
        
        return tmp_dir;

    }
        
}
