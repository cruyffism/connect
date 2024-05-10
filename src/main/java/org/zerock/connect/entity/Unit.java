package org.zerock.connect.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Unit {

    @Id
    @Column(nullable = false ,length = 10)
    private String  unit_code;

    @Column(nullable = false ,length = 20)
    private String unit_name;

    @OneToMany(mappedBy = "unitCode")
    private List<Item> items = new ArrayList<>();

}
