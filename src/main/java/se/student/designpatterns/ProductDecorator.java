package se.student.designpatterns;

import java.util.Objects;

public abstract class ProductDecorator implements Sellable {

    protected final Sellable decoratedProduct;

    protected ProductDecorator(Sellable decoratedProduct) {
        this.decoratedProduct = Objects.requireNonNull(
                decoratedProduct,
                "Decorated product cannot be null"
        );
    }

    @Override
    public String getName() {
        return decoratedProduct.getName();
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice();
    }

    @Override
    public String getId() {
        return decoratedProduct.getId();
    }
}