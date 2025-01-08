package day56;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestDto {
    private String key1;
    private String key2;

    public RestDto() {}
    public RestDto(String key1, String key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    @Override
    public String toString() {
        return "RestDto{" +
                "key1='" + key1 + '\'' +
                ", key2='" + key2 + '\'' +
                '}';
    }
}
