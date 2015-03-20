/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.webServlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.zip.*;
 
/**
 *  A JavaServlet implementation class DownloadZipFileServlet
 * 
 * @author Eriba
 */
public class DownloadZipFileServlet extends HttpServlet {

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
 
    /**
     * 
     * Upon receiving the path of the temporary directory where the result file(s) are stored,
     * a zip file will be created, where all the results will be compressed for the user to download.
     * 
     * @param request 
     * @param response
     * @throws ServletException States something went wrong with the JavaServlet
     * @throws java.io.IOException Catches the exception if the previous exception was not catch.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            
            //Gets the path of the temporary directory where the exported result files are.
            String zipFilePath = request.getParameter("zipPath");
            
            
            File directory = new File(zipFilePath);
            
            //Saves all the files in the temporary directory as a list
            String[] files = directory.list();
 
            // Checks if the temporary directory is not empty.
            if (files != null && files.length > 0 ) {
                
                // Calls the zipFiles method for creating a zip stream.
                byte[] zip = zipFiles(directory, files);
 
                // Sends the response back to the browser for the user. 
                ServletOutputStream sos = response.getOutputStream();
                // The content for zip file type is "application/zip". 
                response.setContentType("application/zip");
                // Sends the content as an attachmnet for the browser to show a dialog that will let 
                //the user choose where to save the zip file.
                response.setHeader("Content-Disposition", "attachment; filename=\"chromstaR_results.zip\"");
 
                sos.write(zip);
                sos.flush();
            }
        }catch (IOException e) {
            System.out.println(e);
        }
    }
 
    /**
     * Compress the results file(s) into a zip file, if the filename starts with "export". 
     * 
     * @param directory
     * @param files
     * @return boas
     * @throws java.io.IOException something went wrong
     */
    public byte[] zipFiles(File directory, String[] files) throws IOException {
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);
        //Byte is used as the length of the input section is not known.
        byte bytes[] = new byte[2048];
 
        for (String fileName : files) {
            //will only compress the files to zip that starts with the name export.
            if (fileName.startsWith("export")){
                FileInputStream fis = new FileInputStream(directory.getPath() + 
                    DownloadZipFileServlet.FILE_SEPARATOR + fileName);
                BufferedInputStream bis = new BufferedInputStream(fis);

                zos.putNextEntry(new ZipEntry(fileName));

                int bytesRead;
                while ((bytesRead = bis.read(bytes)) != -1) {
                    zos.write(bytes, 0, bytesRead);
                }
                zos.closeEntry();
                bis.close();
                fis.close();
            }
        }
        zos.flush();
        baos.flush();
        zos.close();
        baos.close();
 
        return baos.toByteArray();
    }
}