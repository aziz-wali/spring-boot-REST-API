package com.shop.model;

import javax.persistence.*;





@Entity
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String image;
    private String price;
    private String beschreibung;
	@Column(nullable = false, updatable = false)
    private String productCode;

//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name="category_cid")
//	private Category category;
	
//    public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public Product() {}

    public Product(String name, String email, String image, String price, String productCode) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.productCode = productCode;
    }

    public String getProductCode() {
		return productCode;
	}
    public void setProductCode(String productCode) {
		// TODO Auto-generated method stub
		this.productCode=productCode;
	}
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                ",beschreibung='"+beschreibung+'\''+
                '}';
    }

	
}
