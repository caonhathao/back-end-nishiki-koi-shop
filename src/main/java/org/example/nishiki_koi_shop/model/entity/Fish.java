package org.example.nishiki_koi_shop.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "fishes")
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fishId;
    private String name;
    private BigDecimal price;
    private String description;
    private String image;
    private long size;
    private Integer quantity;

    @Column(updatable = false)
    private LocalDate createdDate;

    @PrePersist
    private void onCreate() {
        this.createdDate = LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(name = "fish_type_id", nullable = false)
    private FishType fishType;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    @OneToMany(mappedBy = "fish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderFishDetail> orderFishDetail;

    @OneToMany(mappedBy = "fish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItem;

    @OneToMany(mappedBy = "fish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feedback> feedbackList;
}
