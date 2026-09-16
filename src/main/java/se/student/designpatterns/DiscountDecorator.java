package se.student.designpatterns;

public class DiscountDecorator extends ProductDecorator {

    private final double discountPercentage;

    public DiscountDecorator(
            Sellable product,
            double discountPercentage
    ) {
        super(product);

        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException(
                    "Discount percentage must be between 0 and 100"
            );
        }

        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        double originalPrice = decoratedProduct.getPrice();

        return originalPrice *
                (1 - discountPercentage / 100.0);
    }
}