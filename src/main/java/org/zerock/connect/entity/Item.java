package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , length = 20)
    private Long itemIndex;

    @ManyToOne
    @JoinColumn(name = "productId" ,nullable = false)
    private Product productId;

//    @ManyToOne
////    @ColumnDefault("0")
//    @JoinColumn(name = "business_id" , nullable = false)
//    private Company business_id;

    @ManyToOne
    @JoinColumn(name = "unitCode",nullable = false)
    private  Unit unitCode;

    @ManyToOne
    @JoinColumn(name = "assyCode" , nullable = false)
    private Assy assyCode;

    @ManyToOne
    @JoinColumn(name = "partCode" , nullable = false)
    private Part partCode;

    @Column(nullable = false , length = 30)
    private String itemCode;

    @Column(nullable = false ,length = 100)
    private String itemName;

    @Column(nullable = false , length = 50)
    private int itemLength;

    @Column(nullable = false , length = 50)
    private int itemWidth;

    @Column(nullable = false , length = 50)
    private int itemHeight;

    @Column(nullable = false , length = 50)
    private String itemMaterial;

    @Column(nullable = false , length = 200)
    private String itemFile;



//    @OneToMany(mappedBy = "con_item_no")
//    private List<Contract_item> contractItems;

    @OneToMany(mappedBy = "itemIndex")
    private List<Procurement_plan> procurementPlans = new ArrayList<>();


    @OneToMany(mappedBy = "itemIndex")
    private List<Contract_item> contractItems = new ArrayList<>();
}
