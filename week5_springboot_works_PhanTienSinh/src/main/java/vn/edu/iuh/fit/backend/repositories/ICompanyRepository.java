/**
 * @ (#) ICompanyRepository.java      11/2/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.backend.models.Company;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 11/2/2024
 */
public interface ICompanyRepository extends JpaRepository<Company, Long> {
}
