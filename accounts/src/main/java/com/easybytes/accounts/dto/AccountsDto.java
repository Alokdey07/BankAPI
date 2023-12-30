package com.easybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Accounts",
        description = "Schema to hold the account information"
)
public class AccountsDto {

    @Schema(
            description = "Account number of the EasyBank account"
    )
    @NotEmpty(message = "Account Number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Account number must be 10 digits")
    private long accountNumber;
    @Schema(
            description = "Account type of the EasyBank account"
    )
    @NotEmpty(message = "Account Type cannot be a null or empty")
    private String accountType;
    @Schema(
            description = "Branch address of the EasyBank account"
    )
    @NotEmpty(message = "Branch Address cannot be a null or empty")
    private String branchAddress;
}
