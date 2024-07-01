package alessiovulpinari.u2_w3_d1_Java.payloads;

import java.time.LocalDateTime;

public record ErrorPayload(String errorMessage, LocalDateTime dateTime) {
}
