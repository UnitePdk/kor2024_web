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

public class ProductEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_index;

    @Column(columnDefinition = "varchar(31)", nullable = false)
    private String name;

    @Column(columnDefinition = "int")
    @ColumnDefault("0")
    private int price;

    // 이 제품의 카테고리를 가져옴
    @ManyToOne
    @JoinColumn(name = "category_index")
    private CategoryEntity categoryEntity;

    // 이 제품이 들어간 주문들을 탐색할 수 있음
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private List<OrderEntity> orderEntityList = new ArrayList<OrderEntity>();

}
