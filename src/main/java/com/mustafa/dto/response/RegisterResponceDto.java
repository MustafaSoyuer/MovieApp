package com.mustafa.dto.response;


import com.mustafa.utility.enums.EStatus;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponceDto {
    String name;
    String surname;
    String email;
    EStatus status;
}
