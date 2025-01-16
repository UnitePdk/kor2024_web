package day64task.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_index;

    @Column(columnDefinition = "varchar(31)", nullable = false)
    private String name;

    @Column(columnDefinition = "int")
    @ColumnDefault("0")
    private int price;


}
