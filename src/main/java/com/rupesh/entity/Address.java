package com.rupesh.entity;

import com.rupesh.abstracts.AbstractEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address")
@DynamicUpdate
public class Address extends AbstractEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq_gen")
    @SequenceGenerator(name = "address_id_seq_gen", sequenceName = "address_id_seq_gen", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    private String country;
    private String zone;
    private String city;
    private String street;
    private String userId;

}
