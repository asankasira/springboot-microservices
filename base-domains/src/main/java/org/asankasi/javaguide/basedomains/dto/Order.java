package org.asankasi.javaguide.basedomains.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
    private String orderId;
    private String name;
    private int quantity;
    private double price;
}
