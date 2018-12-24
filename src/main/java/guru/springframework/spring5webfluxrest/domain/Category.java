package guru.springframework.spring5webfluxrest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data   // Lombok
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document   // for mongo
public class Category {

    @Id
    private String id;

    private String description;
}


