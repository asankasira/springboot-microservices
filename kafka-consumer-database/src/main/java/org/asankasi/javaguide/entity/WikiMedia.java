package org.asankasi.javaguide.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wikimedia_recent")
@Getter
@Setter
public class WikiMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Lob https://stackoverflow.com/a/66178645/3660710
    @Column(columnDefinition = "text")
    private String wikData;
}
