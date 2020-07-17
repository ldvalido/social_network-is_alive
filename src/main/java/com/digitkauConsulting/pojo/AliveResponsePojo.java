package pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class AliveResponsePojo {

    @Getter @Setter private int userId;
    @Getter @Setter private LocalDateTime lastAccess;

}
