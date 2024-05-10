package org.zerock.connect.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Part {

    @Id
    @Column(nullable = false , length = 10)
    private String  part_code;

    @Column(nullable = false , length = 20)
    private String part_name;

    @OneToMany(mappedBy = "part_code")
    private List<Item> items;



}
