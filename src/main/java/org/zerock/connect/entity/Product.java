package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , length = 30)
    private String productId;

    @Column(nullable = false , length = 30)
    private String productName;

    @Column(nullable = false , length = 30)
    private Integer productCount;

    @Column(nullable = false)
    private LocalDateTime productStartdate;

    @Column(nullable = false)
    private LocalDateTime productEnddate;

    @OneToMany(mappedBy = "productId")
    private List<Item> items = new ArrayList<>();

}
