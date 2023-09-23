package org.asankasi.javaguide.basedomains.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderEvent {
    private String status;
    private String message;
    private Order order;
}
