package org.zerock.connect.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamicUpdate //값이 있는 것만 업데이트

public class member {

    @Id
    @Column
    private String MemberId;

    @Column
    private String MemberDep;

    @Column
    private String MemberPw;


}
