/**
 * @ (#) QLThuocRepositoryImpl.java      10/22/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.entities.Loaithuoc;
import vn.edu.iuh.fit.backend.entities.Thuoc;
import vn.edu.iuh.fit.backend.repositories.QLThuocRepository;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/22/2024
 */
public class QLThuocRepositoryImpl implements QLThuocRepository {

    @PersistenceContext(unitName = "mariadb")
    private EntityManager entityManager;

    @Override
    public List<Thuoc> getAll() {
        String query = "SELECT t FROM Thuoc t";
        return entityManager.createQuery(query, Thuoc.class).getResultList();
    }

    @Override
    public List<Loaithuoc> getAllLoaiThuoc() {
        String query = "SELECT lt FROM Loaithuoc lt";
        return entityManager.createQuery(query, Loaithuoc.class).getResultList();
    }

    @Override
    public List<Thuoc> getListThuocByLoai(long maLoaiThuoc) {
        String query = "SELECT t FROM Thuoc t WHERE t.loaiThuoc.maLoaiThuoc = :maLoaiThuoc";
        return entityManager.createQuery(query, Thuoc.class).setParameter("maLoaiThuoc", maLoaiThuoc).getResultList();
    }

    @Override
    public boolean save(Thuoc thuoc) {
        try {
            entityManager.persist(thuoc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
