package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
public class Product {

    @Id
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

    @OneToMany(mappedBy = "product")
    private List<Item> items = new ArrayList<>();

}
