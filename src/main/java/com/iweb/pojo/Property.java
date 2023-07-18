package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jxy
 * @date
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Property {
    private int proId;
    private Category category;
    private String proName;

    public Property(Category category, String proName) {
        this.category = category;
        this.proName = proName;
    }
}
