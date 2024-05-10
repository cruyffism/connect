package org.zerock.connect.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

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
    @Column(nullable = false , length = 30)
    private String product_id;
    @Column(nullable = false , length = 30)
    private String product_name;
    @Column(nullable = false , length = 30)
    private int product_count;
    @Column(nullable = false)
    private String product_startdate;
    @Column(nullable = false)
    private String product_enddate;

    @OneToMany(mappedBy = "product_id")
    private List<Item> items;

}
