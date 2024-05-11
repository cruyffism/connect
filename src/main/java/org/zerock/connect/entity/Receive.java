package org.zerock.connect.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
public class Receive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long receiveNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="progressNum")
    private Progress progress;

    @OneToMany(mappedBy = "receive", fetch = FetchType.LAZY)
    private List<Releases> releases = new ArrayList<>();

    @Column
    private Integer receiveCount;

    @Column
    private String receiveYn;

    @Column
    private String receiveInfo;

    @Column
    private LocalDateTime receiveDate;


}
