package eriba.jwlgoh.webServlets;

import eriba.jwlgoh.ImplementR.createTempDir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploader
 */
public class FileUploadServlet extends HttpServlet {
   
    private static final long serialVersionUID = 1L;
     /**
    * Constructs the directory path to store upload file
    **/
    private final String uploadPath = "C:\\Users\\Eriba\\Documents\\temp_chromstaR\\"; // Path to temporary files
    /**
    * This string contains the path of the file.
    **/
    private String filePath;
    /**
    * This File contains the stored file.
    **/
    private File storeFile;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

            Path tmp_dir = null;

            try {
                    List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                    
                    createTempDir tmpDir = new createTempDir();
                    tmp_dir = tmpDir.createDir(uploadPath);
                    
                    //receive check...tmp_dir receives either a path or an error 
                    //for example FileNotValid -> if this is the case, program 
                    //stops and client will get a message on the website that 
                    //the file given is not a BAM or BED format.
                    //If file is valid then file will be saved in the temporary 
                    //directory that had been made and given in tmp_dir
                    if (items != null && items.size() > 0) {
                         // iterates over form's fields
                        for (FileItem item : items) {
                                
                                if (!item.isFormField()) {
                                    String fileName = new File(item.getName()).getName();


                                    filePath = tmp_dir + File.separator + fileName;
                                    storeFile = new File(filePath);

                                    // saves the file on disk
                                    item.write(storeFile);       
                                }
                        }
                    }
            } catch (FileUploadException e) {
                    throw new ServletException("Parsing file upload failed.", e);
            } catch (Exception ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

            response.getWriter().print(tmp_dir);
    }

}
