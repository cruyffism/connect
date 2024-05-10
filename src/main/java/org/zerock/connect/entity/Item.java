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

    @ManyToOne
//    @ColumnDefault("0")
    @JoinColumn(name = "businessId" , nullable = false)
    private Company businessId;

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


    @ColumnDefault("0")
    @Column
    private String contractFile;

    @ColumnDefault("0")
    @Column
    private LocalDateTime contractDate;

    @ColumnDefault("0")
    @Column
    private String contractYn;

    @ColumnDefault("0")
    @Column
    private String contractInfo;

    @ColumnDefault("0")
    @Column
    private String contractPrice;

//    @OneToMany(mappedBy = "con_item_no")
//    private List<Contract_item> contractItems;

    @OneToMany(mappedBy = "itemIndex")
    private List<Procurement_plan> procurementPlans = new ArrayList<>();

}
