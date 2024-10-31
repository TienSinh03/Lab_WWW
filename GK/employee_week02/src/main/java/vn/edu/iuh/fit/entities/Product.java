/**
 * @ (#) Product.java      9/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import vn.edu.iuh.fit.week2_phantiensinh.converters.ProductStatusConverter;
import vn.edu.iuh.fit.week2_phantiensinh.enums.ProductStatus;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/18/2024
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select p from Product p"),
        @NamedQuery(name = "Product.getPrice", query = "select pp.price from Product p join ProductPrice pp on p.id = pp.product.id where p.id = :id"),
})

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(length = 25, nullable = false)
    private String unit;

    @Convert(converter = ProductStatusConverter.class)
    @Column(nullable = false)
    private ProductStatus status;

    @Column(name = "manufacturer_name",length = 100, nullable = false)
    private String manufacturer;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 250, nullable = false)
    private String description;

    @JsonbTransient
    @OneToMany(mappedBy = "product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<OrderDetail> orderDetails;

    @JsonbTransient
    @OneToMany(mappedBy = "product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductImage> productImageList;

    @JsonbTransient
    @OneToMany(mappedBy = "product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductPrice> productPrices;

    public Product(String name, String description, String unit, String manufacturer_name, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer_name;
        this.status = status;
    }

    public Product(long id, String name, String description, String unit, String manufacturer, ProductStatus status, List<ProductImage> productImageList, List<OrderDetail> orderDetails, List<ProductPrice> productPrices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer= manufacturer;
        this.status = status;
        this.productImageList = productImageList;
        this.orderDetails = orderDetails;
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer+ '\'' +
                ", status=" + status +
                ", productImages=" + productImageList +
                ", orderDetails=" + orderDetails +
                ", productPrices=" + productPrices +
                '}';
    }
}
