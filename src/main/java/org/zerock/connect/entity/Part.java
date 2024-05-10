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
public class Part {

    @Id
    @Column(nullable = false , length = 10)
    private String  partCode;

    @Column(nullable = false , length = 20)
    private String partName;

    @OneToMany(mappedBy = "partCode")
    private List<Item> items = new ArrayList<>();



}
