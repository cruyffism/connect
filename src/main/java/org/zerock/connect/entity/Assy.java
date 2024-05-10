package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Assy {

    @Id
    @Column(nullable = false ,length = 10)
    private String assy_code;


    @Column(nullable = false ,length = 20)
    private String assy_name;

    @OneToMany(mappedBy = "assy_code")
    private List<Item> items;
}
