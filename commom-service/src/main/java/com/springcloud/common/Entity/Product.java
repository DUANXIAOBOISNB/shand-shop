package com.springcloud.common.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private long uid;
    private int bid;
    /**
     * 1有效，0无效
     */
    private int status;
}
