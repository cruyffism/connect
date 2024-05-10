package org.zerock.connect.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

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
    private String business_id;

    @Column(nullable = false ,length = 50)
    private String com_name;

    @Column(nullable = false ,length = 100)
    private String com_add;

    @Column(nullable = false ,length = 30)
    private String com_manager;

    @Column(nullable = false ,length = 30)
    private String phone;

    @Column(nullable = false ,length = 50)
    private String com_email;

    @Column(nullable = false ,length = 50)
    private String com_account;

    @OneToMany(mappedBy = "business_id")
    private List<Contract_item> contractItems;

}
