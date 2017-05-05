package third.party.lombok.simple;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class SimpleExample {
    private final String name;

    @Setter(AccessLevel.PACKAGE)
    private int age;
    private double score;
    private String[] tags;
}

