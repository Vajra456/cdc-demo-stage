package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.annotations.RuleDescriptor;
import in.gov.cdc.cdcdemostage.annotations.RuleDescriptors;
import in.gov.cdc.cdcdemostage.model.User;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * This is a demo validator class to demonstrate the functionality of
 * annotation to filter validation methods during runtime
 */
// TODO: Apply multiple RuleDescriptors to make the class applicable for both E an U type packet
@Slf4j
@RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "U")
@RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "E")
public class NameValidator {


    public NameValidator() {
    }

    @RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "U")
    @RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "E")
    public @NotNull Boolean NameCheck(User user) {
        log.info("Inside NameCheck method");
        return true;
    }

    @RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "U")
    public @NotNull Boolean NameAsPreviousCheck(User user) {
        log.info("Inside NameAsPreviousCheck method");
        return true;
    }

    @RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "U")
    public @NotNull Boolean NameUpdateCountCheck(User user) {
        log.info("Inside NameUpdateCountCheck method");
        return true;
    }

    @RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "U")
    @RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "E")
    public @NotNull Boolean NameLocalLanguageCheck(User user) {
        log.info("Inside NameLocalLanguageCheck method");
        return true;
    }
}
