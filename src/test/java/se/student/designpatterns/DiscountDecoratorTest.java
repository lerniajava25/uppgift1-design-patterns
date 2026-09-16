package se.student.designpatterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountDecoratorTest {

    @Test
    void shouldApplyTwentyPercentDiscount() {

        Product laptop = new Product.Builder()
                .id("laptop1")
                .name("Laptop")
                .category(Category.ELECTRONICS)
                .rating(9)
                .price(1000.0)
                .build();

        Sellable discountedLaptop =
                new DiscountDecorator(laptop, 20);

        assertEquals(1000.0, laptop.getPrice(), 0.001);
        assertEquals(800.0, discountedLaptop.getPrice(), 0.001);
        assertEquals("Laptop", discountedLaptop.getName());
        assertEquals("laptop1", discountedLaptop.getId());
    }

    @Test
    void shouldAllowZeroPercentDiscount() {

        Product product = new Product.Builder()
                .id("p1")
                .name("Product")
                .category(Category.TOOLS)
                .rating(5)
                .price(500.0)
                .build();

        Sellable decorated =
                new DiscountDecorator(product, 0);

        assertEquals(500.0, decorated.getPrice(), 0.001);
    }

    @Test
    void shouldAllowHundredPercentDiscount() {

        Product product = new Product.Builder()
                .id("p2")
                .name("Product")
                .category(Category.TOOLS)
                .rating(5)
                .price(500.0)
                .build();

        Sellable decorated =
                new DiscountDecorator(product, 100);

        assertEquals(0.0, decorated.getPrice(), 0.001);
    }

    @Test
    void shouldRejectNegativeDiscount() {

        Product product = new Product.Builder()
                .id("p3")
                .name("Product")
                .category(Category.TOOLS)
                .rating(5)
                .price(500.0)
                .build();

        assertThrows(
                IllegalArgumentException.class,
                () -> new DiscountDecorator(product, -10)
        );
    }

    @Test
    void shouldRejectDiscountAboveHundredPercent() {

        Product product = new Product.Builder()
                .id("p4")
                .name("Product")
                .category(Category.TOOLS)
                .rating(5)
                .price(500.0)
                .build();

        assertThrows(
                IllegalArgumentException.class,
                () -> new DiscountDecorator(product, 120)
        );
    }

    @Test
    void shouldRejectNullProduct() {

        assertThrows(
                NullPointerException.class,
                () -> new DiscountDecorator(null, 20)
        );
    }
}