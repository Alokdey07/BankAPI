package com.easybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Customer",
description = "Schema to hold customer and account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "EasyByte"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5,max = 30, message = "The Length of the name should be between 5 and 30")
    private String name;
    @Schema(
            description = "Email of the customer", example = "alokdeykv@gmail.com"
    )
    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;
    @Schema(
            description = "Mobile Number of the customer", example = "9874524XXX"
    )
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNumber;
    @Schema(
            description = "Account Details of the customer"
    )
   private AccountsDto accountsDto;
}
