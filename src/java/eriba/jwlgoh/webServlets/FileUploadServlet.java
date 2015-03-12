package eriba.jwlgoh.webServlets;

import eriba.jwlgoh.JavaRIntegration.JavaRIntegration;
import eriba.jwlgoh.JavaRIntegration.createTempDir;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

            String tmp_dir = null;
        
            Map<String, Object> args = new HashMap<>();
            ArrayList<String> checkedFunctions = new ArrayList<>();

            try {
                    List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                    
                    createTempDir tmpDir = new createTempDir();
                    tmp_dir = tmpDir.createDir(uploadPath);

                    if (items != null && items.size() > 0) {
                         // iterates over form's fields
                        for (FileItem item : items) {
                                
                                if (!item.isFormField()) {

                                    String fileName = new File(item.getName()).getName();

                                    filePath = tmp_dir + File.separator + fileName;
                                    storeFile = new File(filePath);

                                    // saves the file on disk
                                    item.write(storeFile);       
                                }if (item.isFormField()){
                                    checkedFunctions.add(item.getString());
                                }
                        }
                    }
            } catch (FileUploadException e) {
                    throw new ServletException("Parsing file upload failed.", e);
            } catch (Exception ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            args.put("pathToTempDir", tmp_dir);
            args.put("advancedOptions", checkedFunctions);


            System.out.println(args);
            try{
                System.out.println("call Java R integration START OF PROGRAM");
                JavaRIntegration calculateWithR = new JavaRIntegration();
                calculateWithR.start(args);
                response.getWriter().print(calculateWithR.getZipFile());
            }catch(NullPointerException e){
                System.out.println("error servlet: " + e);
            }
            
            //results will be send here 
//            response.getWriter().print(calculateWithR.getResults());

            

    }

}
