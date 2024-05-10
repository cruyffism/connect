package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    private Long item_index;

    @ManyToOne
    @JoinColumn(name = "product_id" ,nullable = false)
    private Product product_id;

//    @ManyToOne
////    @ColumnDefault("0")
//    @JoinColumn(name = "business_id" , nullable = false)
//    private Company business_id;

    @ManyToOne
    @JoinColumn(name = "unit_code",nullable = false)
    private  Unit unit_code;

    @ManyToOne
    @JoinColumn(name = "assy_code" , nullable = false)
    private Assy assy_code;

    @ManyToOne
    @JoinColumn(name = "part_code" , nullable = false)
    private Part part_code;

    @Column(nullable = false , length = 30)
    private String item_code;

    @Column(nullable = false ,length = 100)
    private String item_name;

    @Column(nullable = false , length = 50)
    private int item_length;

    @Column(nullable = false , length = 50)
    private int item_width;

    @Column(nullable = false , length = 50)
    private int item_height;

    @Column(nullable = false , length = 50)
    private String item_material;

    @Column(nullable = false , length = 200)
    private String item_file;



//    @OneToMany(mappedBy = "con_item_no")
//    private List<Contract_item> contractItems;

    @OneToMany(mappedBy = "item_index")
    private List<Procurement_plan> procurementPlans;


    @OneToMany(mappedBy = "item_index")
    private List<Contract_item> contractItems;
}
