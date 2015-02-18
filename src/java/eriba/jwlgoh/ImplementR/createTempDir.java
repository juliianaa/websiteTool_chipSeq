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

    public Path createDir(String uploadPath) throws IOException {
        final Path basedir = FileSystems.getDefault().getPath(uploadPath);
        final String tmp_dir_prefix = "HistoneHMM_";

        final Path tmp_dir = Files.createTempDirectory(basedir, tmp_dir_prefix);    
        
        return tmp_dir;
    }
    
}
