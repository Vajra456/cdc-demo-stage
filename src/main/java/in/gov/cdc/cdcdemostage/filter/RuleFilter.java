package in.gov.cdc.cdcdemostage.filter;

import in.gov.cdc.cdcdemostage.annotations.RuleDescriptor;
import in.gov.cdc.cdcdemostage.validators.NameValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * This class will filter applicable validation rules during runtime
 */
public class RuleFilter {

    public void ruleFilter() {
        Class<NameValidator> nameValidator = NameValidator.class;

        for (Method method : nameValidator.getDeclaredMethods()) {

            Annotation annotation = method.getAnnotation(RuleDescriptor.class);
            RuleDescriptor test = (RuleDescriptor) annotation;

            // If the annotation is not null
            if (test != null) {
                try {
                    method.invoke(nameValidator
                            .getDeclaredConstructor()
                            .newInstance());
                } catch (Throwable ex) {
                    System.out.println(ex.getCause());
                }

            }
        }
    }
}

