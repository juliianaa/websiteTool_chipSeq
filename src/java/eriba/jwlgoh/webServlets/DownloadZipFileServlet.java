/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.webServlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;
 
/**
 *
 * @author Eriba
 */
public class DownloadZipFileServlet extends HttpServlet {
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            //gets the path of where the exported result files of R are
            String zipFilePath = request.getParameter("zipPath");
            
            
            File directory = new File(zipFilePath);
            String[] files = directory.list();
 
            // Checks to see if the directory contains some files.
            if (files != null && files.length > 0 ) {
                
                // Call the zipFiles method for creating a zip stream.
                byte[] zip = zipFiles(directory, files);
 
                // Sends the response back to the browser for the user. 
                ServletOutputStream sos = response.getOutputStream();
                // The content for zip file type is "application/zip". 
                response.setContentType("application/zip");
                // Sends the content as an attachmnet for the browser to show a 
                // dialog that will let the user choose where to save the zip file.
                response.setHeader("Content-Disposition", "attachment; filename=\"chromstaR_results.zip\"");
 
                sos.write(zip);
                sos.flush();
                
                sos.print(Arrays.toString(zip));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
 
    /**
     * Compress the given directory with all the files that starts with export in 
     * file name.
     */
    private byte[] zipFiles(File directory, String[] files) throws IOException {
        
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