package com.yen.TddPlayGround.MockitoDemo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    private Integer id;
    private String name;

}
