package heroes.backend;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record Hero(Integer id, String name) {
}
