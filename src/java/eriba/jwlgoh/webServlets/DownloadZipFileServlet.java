/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriba.jwlgoh.webServlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import java.util.zip.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
/**
 *
 * @author Eriba
 */
public class DownloadZipFileServlet extends HttpServlet {
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            
            
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            String zipFilePath = null;

            if (items != null && items.size() > 0) {
                 // iterates over form's fields
                for (FileItem item : items) {

                        if (item.isFormField()){
                            zipFilePath = zipFilePath + item.getString();
                        }
                }
            }
            
 
            File directory = new File(zipFilePath);
            String[] files = directory.list();
 
            // Checks to see if the directory contains some files.
            if (files != null && files.length > 0) {
 
                // Call the zipFiles method for creating a zip stream.
                byte[] zip = zipFiles(directory, files);
 
                // Sends the response back to the user / browser. The
                // content for zip file type is "application/zip". We
                // also set the content disposition as attachment for
                // the browser to show a dialog that will let user 
                // choose what action will he do to the sent content.
                ServletOutputStream sos = response.getOutputStream();
                response.setContentType("application/zip");
                response.setHeader("Content-Disposition", "attachment; filename=\"chromstaR_results.zip\"");
 
                sos.write(zip);
                sos.flush();
                response.getWriter().print(sos.toString());
            }
        }
        catch (FileUploadException | IOException e) {
            System.out.println(e);
        }
    }
 
    /**
     * Compress the given directory with all its files.
     */
    private byte[] zipFiles(File directory, String[] files) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);
        byte bytes[] = new byte[2048];
 
        for (String fileName : files) {
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
        zos.flush();
        baos.flush();
        zos.close();
        baos.close();
 
        return baos.toByteArray();
    }
}