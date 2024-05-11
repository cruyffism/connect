package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DynamicUpdate
public class ContractItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long conitemNo;

    @ManyToOne
    @JoinColumn(name = "businessId")
    private Company businessId;

    @ManyToOne
    @JoinColumn(name = "itemIndex")
    private Item itemIndex;

    @Column(nullable = false , length = 200)
    private String contractFile;

    @Column(nullable = false)
    private String contractDate;

    @Column(nullable = false , length = 5)
    private String contractYn;

    @Column(nullable = false , length = 50)
    private String contractInfo;

    @Column(nullable = false , length = 20)
    private String contractPrice;


}
