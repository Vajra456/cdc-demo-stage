package in.gov.cdc.cdcdemostage;

import in.gov.cdc.cdcdemostage.model.User;
import in.gov.cdc.cdcdemostage.validators.EmailValidator;
import in.gov.cdc.cdcdemostage.validators.UserValidator;
import in.gov.cdc.cdcdemostage.validators.Validator;
import in.gov.cdc.cdcdemostage.validators.ValidatorFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.OffsetDateTime;
import java.util.Date;

@SpringBootApplication
public class CdcDemoStageApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CdcDemoStageApplication.class, args);

		// Create a User instance
		User user = new User("John Doe", "test", "test@test.com", OffsetDateTime.now());

		ValidatorFactory factory = new ValidatorFactory();

		// Register different ValidatorVisitor implementations
		// Here we can scan the componet and build all the validations
		factory.registerValidatorVisitor("UserValidator", new UserValidator.UserValidatorVisitor());
		factory.registerValidatorVisitor("EmailValidator", new EmailValidator.EmailValidatorVisitor());

		// During runtime, determine the criteria and select the appropriate ValidatorVisitor
		String criteria = "UserValidator";
		Validator.ValidatorVisitor visitor = factory.getValidatorVisitor(criteria);

		// Configure or interact with the selected ValidatorVisitor
		if (visitor != null) {

			if (visitor instanceof UserValidator.UserValidatorVisitor) {
				// Create an instance of the UserValidator
				UserValidator userValidator = new UserValidator();

				// Invoke the visit method to configure or interact with the User. Here we should pass an instance of the User.
				visitor.visit(userValidator);

			} else {
				// Handle the case where no matching ValidatorVisitor is found
				// ...
			}
		}
	}
}

