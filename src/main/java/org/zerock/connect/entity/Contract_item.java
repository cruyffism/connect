package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Contract_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long con_item_no;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Company business_id;

    @ManyToOne
    @JoinColumn(name = "item_index")
    private Item item_index;

    @Column(nullable = false , length = 200)
    private String contract_file;

    @Column(nullable = false)
    private String contract_date;

    @Column(nullable = false , length = 5)
    private String contarct_YN;

    @Column(nullable = false , length = 50)
    private String contract_info;

    @Column(nullable = false , length = 20)
    private String contract_price;


}
