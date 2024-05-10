package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Procurement_plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , length = 20)
    private Long plan_num;

    @ManyToOne
    @JoinColumn(name = "item_index" , nullable = false)
    private Item item_index;

    @Column(nullable = false)
    private String plan_date;


    @OneToMany(mappedBy = "plan_num")
    private List<Orders> orders;
}
