package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jxy
 * @date
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValue {
    private int pvId;
    private Product product;
    private Property property;
    private String value;

    public PropertyValue(Product product, Property property, String value) {
        this.product = product;
        this.property = property;
        this.value = value;
    }
}
