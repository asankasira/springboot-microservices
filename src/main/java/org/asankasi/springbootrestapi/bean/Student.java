package org.asankasi.springbootrestapi.bean;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private final int id;
    private String firstName;
    private String lastName;
}
