/**
 * @ (#) QLThuocRepository.java      10/22/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repositories;

import vn.edu.iuh.fit.backend.entities.Loaithuoc;
import vn.edu.iuh.fit.backend.entities.Thuoc;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/22/2024
 */
public interface QLThuocRepository {

    public List<Thuoc> getAll();
    public List<Loaithuoc> getAllLoaiThuoc();
    public List<Thuoc> getListThuocByLoai(long maLoaiThuoc);
    public boolean save(Thuoc thuoc);
}
