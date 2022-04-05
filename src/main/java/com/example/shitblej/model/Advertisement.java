package com.example.shitblej.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

  @Entity
  @Table(name = "AD", schema = "SHITBLEJ")
  public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    private User user;

    private String title;

    private String description;

    private int price;

    private String location;

    @CreationTimestamp
    private Date created;

    public enum Type {Offer, Request}

    public Advertisement() {

    }

    public Advertisement(Type type, Category category, User user, String title,
        String description, int price, String location) {
      this.type = type;
      this.category = category;
      this.user = user;
      this.title = title;
      this.description = description;
      this.price = price;
      this.location = location;
    }

    public Long getId() {
      return id;
    }

    public Type getType() {
      return type;
    }

    public Category getCategory() {
      return category;
    }

    public User getUser() {
      return user;
    }

    public String getTitle() {
      return title;
    }

    public String getDescription() {
      return description;
    }

    public int getPrice() {
      return price;
    }

    public String getLocation() {
      return location;
    }

    public Date getCreated() {
      return created;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public void setType(Type type) {
      this.type = type;
    }

    public void setCategory(Category category) {
      this.category = category;
    }

    public void setUser(User user) {
      this.user = user;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public void setPrice(int price) {
      this.price = price;
    }

    public void setLocation(String location) {
      this.location = location;
    }

    public void setCreated(Date created) {
      this.created = created;
    }

    @Override
    public String toString() {
      return "Advertisement{" +
          "id=" + id +
          ", type=" + type +
          ", category=" + category +
          ", user=" + user +
          ", title='" + title + '\'' +
          ", description='" + description + '\'' +
          ", price=" + price +
          ", location='" + location + '\'' +
          ", created=" + created +
          '}';
    }
  }
