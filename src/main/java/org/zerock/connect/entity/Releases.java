package org.zerock.connect.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Releases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long releaseNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="receiveNum")
    private Receive receive;

    @Column
    private Integer releaseCount;

    @Column
    private LocalDateTime releaseDate;
}
