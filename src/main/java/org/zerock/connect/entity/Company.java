package org.zerock.connect.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Company {
    @Id
    @Column(nullable = false ,length = 50)
    private String businessId;

    @Column(nullable = false ,length = 50)
    private String comName;

    @Column(nullable = false ,length = 100)
    private String comAdd;

    @Column(nullable = false ,length = 30)
    private String comManager;

    @Column(nullable = false ,length = 30)
    private String phone;

    @Column(nullable = false ,length = 50)
    private String comEmail;

    @Column(nullable = false ,length = 50)
    private String comAccount;

    @OneToMany(mappedBy = "businessId")
    private List<Contract_item> items = new ArrayList<>();

}
