package com.may.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component("competence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competence {
    private Integer id;
    private String name;
}
