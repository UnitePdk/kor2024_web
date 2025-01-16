package day64task.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_index;

    @Column(columnDefinition = "varchar(31)", nullable = false)
    private String name;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

}
