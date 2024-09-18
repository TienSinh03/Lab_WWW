/**
 * @ (#) EmployeeStatus.java      9/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week02.enums;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/18/2024
 */
public enum EmployeeStatus {
    TERMINATED(-1),  ACTIVE(0),IN_ACTIVE(1);
    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
