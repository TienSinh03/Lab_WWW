/**
 * @ (#) Contact.java      8/31/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.session07.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

import java.sql.Blob;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 8/31/2024
 */
@Data
@NoArgsConstructor

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @Column(name = "contact_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", columnDefinition = "NVARCHAR(45)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "NVARCHAR(45)")
    private String lastName;

    @Lob
    @Column(name = "photo", columnDefinition = "image")
    private byte[] image;

    public Contact(String firstName, String lastName, byte[] image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }
}
