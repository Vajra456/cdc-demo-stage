package in.gov.cdc.cdcdemostage.annotations;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation will help in defining multi-level annotations
 * Applicable for cases when a single validation is applicable
 * for multiple types of packet
 */

// This annotation is applicable at the Class Level and as well at the Method level
@Target({ElementType.METHOD, ElementType.TYPE})
// Annotations to be retained in RUNTIME for dynamic filtering of validation rules
@Retention(RetentionPolicy.RUNTIME)
public @interface RuleDescriptors {
    RuleDescriptor @NotNull [] value() default{};
}
