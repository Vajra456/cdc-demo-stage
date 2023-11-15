package in.gov.cdc.cdcdemostage.annotations;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.*;

/**
 * This annotation defines the custom annotation which would be used to shortlist methods
 * which are applicable for a mask and request type
 */

// This annotation is applciable at the Class Level and as well at the Method level
@Target({ElementType.METHOD, ElementType.TYPE})
// Annotations to be retained in RUNTIME for dynamic filtering of validation rules
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RuleDescriptors.class)
public @interface RuleDescriptor {

    @NotNull String mask() default "11111111111111111111111111111111";
    @NotNull String requestType() default "E";

}
