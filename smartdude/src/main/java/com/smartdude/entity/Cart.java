/*
 * package com.smartdude.entity;
 * 
 * import java.io.Serializable; import java.util.List;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.FetchType; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.OneToMany; import javax.persistence.Table;
 * 
 * import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 * 
 * import lombok.AllArgsConstructor; import lombok.Data; import
 * lombok.NoArgsConstructor;
 * 
 * @Entity
 * 
 * @Data
 * 
 * @Table(name="cart")
 * 
 * @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor public class Cart implements Serializable {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "cardid") private Integer cardId;
 * 
 * @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name = "cartitemid", nullable = false)
 * 
 * @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) private
 * List<CartItem> cartItem; }
 */