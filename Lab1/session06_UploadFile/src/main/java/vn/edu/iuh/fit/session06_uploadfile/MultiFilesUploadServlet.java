/**
 * @ (#) MultiFilesUploadServlet.java      8/31/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.session06_uploadfile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 8/31/2024
 */
@WebServlet(name = "MultiFilesUploadServlet", value = "/upload")
@MultipartConfig(
        location = "E:\\Worksapce\\Java\\Java(WWW)\\Lab1\\session06_UploadFile\\file",
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10)
public class MultiFilesUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String uploadPath = null;

    @Override
    public void init() throws ServletException {
        uploadPath = getServletContext().getInitParameter("upload.path");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            for (Part filePath : req.getParts()) {
                if(filePath == null || filePath.getSubmittedFileName() == null ||
                        filePath.getSubmittedFileName().isEmpty()) {
                    continue;   // Skip if no file is selected
                }
                String fileName = filePath.getSubmittedFileName();

                InputStream fileContent = filePath.getInputStream();
                Files.copy(fileContent, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);

            }
//            resp.getWriter().println("Upload file successfully!");

        } catch (Exception e) {
//            resp.getWriter().println("Upload file fail!");
            e.printStackTrace();
        }


    }
}
