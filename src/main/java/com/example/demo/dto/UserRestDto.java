package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRestDto {
    private int result;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("level_id")
    private int levelId;
}
