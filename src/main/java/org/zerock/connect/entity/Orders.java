package org.zerock.connect.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    private Long orderNum;

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<Progress> progresses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "planNum" ,nullable = false)
    private ProcurementPlan planNum;

    @Column(nullable = false,length = 50)
    private Integer orderCount;

    @Column(nullable = false ,length = 50)
    private String orderInfo;

    @Column(nullable = false,length = 5)
    private String orderYn;



}
