package se.student.designpatterns;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductBuilderTest {

    @Test
    void shouldCreateProductUsingBuilder() {

        Product product = new Product.Builder()
                .id("id1")
                .name("SuperWidget")
                .category(Category.TOOLS)
                .rating(8)
                .price(1000.0)
                .build();

        assertEquals("id1", product.getId());
        assertEquals("SuperWidget", product.getName());
        assertEquals(Category.TOOLS, product.getCategory());
        assertEquals(8, product.getRating());
        assertEquals(1000.0, product.getPrice(), 0.001);

        assertNotNull(product.getCreatedDate());
        assertNotNull(product.getModifiedDate());
    }

    @Test
    void shouldUseCustomDates() {

        LocalDate createdDate =
                LocalDate.of(2026, 1, 10);

        LocalDate modifiedDate =
                LocalDate.of(2026, 2, 15);

        Product product = new Product.Builder()
                .id("id2")
                .name("Test Product")
                .category(Category.ELECTRONICS)
                .rating(5)
                .price(500.0)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .build();

        assertEquals(
                createdDate,
                product.getCreatedDate()
        );

        assertEquals(
                modifiedDate,
                product.getModifiedDate()
        );
    }

    @Test
    void shouldRejectEmptyName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Product.Builder()
                        .id("id3")
                        .name("")
                        .category(Category.TOOLS)
                        .rating(5)
                        .price(100.0)
                        .build()
        );
    }

    @Test
    void shouldRejectNullName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Product.Builder()
                        .id("id4")
                        .category(Category.TOOLS)
                        .rating(5)
                        .price(100.0)
                        .build()
        );
    }

    @Test
    void shouldRejectNegativePrice() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Product.Builder()
                        .id("id5")
                        .name("Invalid Product")
                        .category(Category.TOOLS)
                        .rating(5)
                        .price(-100.0)
                        .build()
        );
    }
}