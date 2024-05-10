package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProcurementPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , length = 20)
    private Long planNum;

    @ManyToOne
    @JoinColumn(name = "itemIndex" , nullable = false)
    private Item itemIndex;

    @Column(nullable = false)
    private LocalDateTime planDate;


    @OneToMany(mappedBy = "planNum")
    private List<Orders> orders = new ArrayList<>();
}
