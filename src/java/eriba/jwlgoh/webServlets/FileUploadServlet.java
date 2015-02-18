/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.webServlets;

import eriba.jwlgoh.ImplementR.JavaRIntegration;
import eriba.jwlgoh.ImplementR.createTempDir;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Eriba
 */
public class FileUploadServlet extends HttpServlet {
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


    /**
     * Upon receiving file upload submission, parses the request to read upload
     * data and saves the file on disk.
     *
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }

         // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        JavaRIntegration r = new JavaRIntegration();
        createTempDir tmpDir = new createTempDir();
        Path tmp_dir = tmpDir.createDir(uploadPath);

        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields in this case the file
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();

                        filePath = tmp_dir + File.separator + fileName;
                        storeFile = new File(filePath);

                        // saves the file on disk
                        item.write(storeFile);
                    }
                }
                
               //Calls the script that checks the file

                
                //gets an number back as result. The number indicates how many correct answers the program found in the user file


                //If size is not the same, this will then be shown in the jsp
//                request.setAttribute("results", "hallo");
                
                


            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
        
//         //delete file once done
//        if(!storeFile.delete()){
//            request.setAttribute("message",
//                    "There was an error: file could not be deleted");
//        }
        
        // redirects client to page
//        RequestDispatcher view = request.getRequestDispatcher("/html/results.jsp");
//        view.forward(request, response);
        
       

    }
    
}
