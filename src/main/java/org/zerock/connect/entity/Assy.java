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
    private String assyCode;


    @Column(nullable = false ,length = 20)
    private String assyName;

    @OneToMany(mappedBy = "assy_code")
    private List<Item> items;
}
