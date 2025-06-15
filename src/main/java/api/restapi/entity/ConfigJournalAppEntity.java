package api.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
@Document(collection = "config_journal_app")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ConfigJournalAppEntity {
    @Id
    private ObjectId id;

    @Field("key")
    private String key;

    @Field("value")
    private String value;
}
