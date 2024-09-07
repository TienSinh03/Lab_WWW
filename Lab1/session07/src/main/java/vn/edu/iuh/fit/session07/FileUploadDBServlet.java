/**
 * @ (#) FileUploadDBServlet.java      9/1/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.session07;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.edu.iuh.fit.session07.dao.ContactDao;
import vn.edu.iuh.fit.session07.entities.Contact;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Random;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/1/2024
 */
@WebServlet(name = "FileUploadDBServlet", value = "/fileUploadDB")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContactDao contactDao;

    @Override
    public void init() throws ServletException {
        contactDao = new ContactDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        // luong du lieu cua file upload
        InputStream inputStream = null;
        // lấy thông tin tập tin upload trong form, form này gồm nhiều phần dữ liệu text và file (multipart request)
        Part part = req.getPart("photo");
        String fileUploadName = "";
        Random random = new Random();
        if (part != null) {
            fileUploadName = part.getName() + random.nextInt(100);
            inputStream = part.getInputStream();
            System.out.println("fileUploadName: " + fileUploadName);
        }

        // tao doi tuong contact
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        if (inputStream != null) {
            byte[] image = new byte[inputStream.available()]; // tao mang byte de luu anh
            inputStream.read(image); // doc anh tu file upload
            contact.setImage(image);
        }

        // luu vao database
        boolean result = contactDao.insert(contact);
        if (result) {
            System.out.println("File uploaded and saved into database");
        } else {
            System.out.println("File upload and save into database fail");
        }

        //doc file tu database
        String filePath = "E:/" + fileUploadName + ".jpg";
        byte[] photo = contactDao.getImageByFullName(firstName, lastName);
        if (photo != null) {
            try {
                OutputStream outputStream = new FileOutputStream(filePath);
                outputStream.write(photo);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
