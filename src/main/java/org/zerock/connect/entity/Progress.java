package org.zerock.connect.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "orders")
@DynamicUpdate
public class Progress {

    @Id
    @Column(length = 20)
    private Long progressNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderNum")
    private Orders orders;

    @Column
    private Integer progressCount;

    @Column
    private LocalDate progressDate;

}
