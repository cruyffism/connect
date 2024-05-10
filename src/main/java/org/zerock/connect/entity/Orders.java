package org.zerock.connect.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , length = 20)
    private Long order_num;

    @ManyToOne
    @JoinColumn(name = "plan_num" ,nullable = false)
    private Procurement_plan plan_num;

    @Column(nullable = false,length = 50)
    private int order_count;

    @Column(nullable = false ,length = 50)
    private String order_info;

    @Column(nullable = false,length = 5)
    private String order_YN;



}
