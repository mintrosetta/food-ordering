package com.zosh.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zosh.dtos.RestaurantDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private USER_ROLE role;

    @JsonIgnore // ทำให้ไม่ถูกนำไปประมวลผลเป็น json
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    // ใช้สำหรัับ mapping ไปหา collection ของ element เช่น list โดยที่ class นั้นไม่ใช่ entity
    // ในตอนนี้ jpa จะสร้างตารางที่ชื่อว่า user_favorites เผื่อจัดของข้อมูล collection นี้
    @ElementCollection 
    private List<RestaurantDto> favorites = new ArrayList<>();

    // orphanRemoval ใช้จัดการความสัมพันธ์ระหว่าง parent และ child โดยเมื่อ child ถูกลบออกจาก list ของ instance ที่อยู่ใน parent, child จะถูกลบออกจาก database ด้วย
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();
}
