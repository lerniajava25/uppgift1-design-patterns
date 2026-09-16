package se.student.designpatterns;

import java.time.LocalDate;

public final class Product implements Sellable {

    private final String id;
    private final String name;
    private final Category category;
    private final int rating;
    private final LocalDate createdDate;
    private final LocalDate modifiedDate;
    private final double price;

    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.rating = builder.rating;
        this.createdDate = builder.createdDate;
        this.modifiedDate = builder.modifiedDate;
        this.price = builder.price;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public static class Builder {

        private String id;
        private String name;
        private Category category;
        private int rating;
        private LocalDate createdDate;
        private LocalDate modifiedDate;
        private double price;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder createdDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder modifiedDate(LocalDate modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Product build() {

            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(
                        "Product name cannot be empty"
                );
            }

            if (price < 0) {
                throw new IllegalArgumentException(
                        "Price cannot be negative"
                );
            }

            if (createdDate == null) {
                createdDate = LocalDate.now();
            }

            if (modifiedDate == null) {
                modifiedDate = createdDate;
            }

            return new Product(this);
        }
    }
}