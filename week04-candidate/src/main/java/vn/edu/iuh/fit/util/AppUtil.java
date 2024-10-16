/**
 * @ (#) AppUtil.java      10/17/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.util;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/17/2024
 */
public class AppUtil {
    public static String[] splitName(String fullName) {
        String firstName = "";
        String middleName = "";
        String lastName = "";

        // Tách tên bằng dấu cách
        String[] nameParts = fullName.trim().split("\\s+");

        if (nameParts.length == 1) {
            firstName = nameParts[0]; // Chỉ có tên
        } else if (nameParts.length == 2) {
            lastName = nameParts[0]; // Họ
            firstName = nameParts[1];  // Tên
        } else if (nameParts.length > 2) {
            lastName = nameParts[0]; // Họ
            firstName = nameParts[nameParts.length - 1]; // Tên
            middleName = String.join(" ", java.util.Arrays.copyOfRange(nameParts, 1, nameParts.length - 1)); // Tên đệm
        }

        return new String[] { firstName, middleName, lastName };


    }
}
