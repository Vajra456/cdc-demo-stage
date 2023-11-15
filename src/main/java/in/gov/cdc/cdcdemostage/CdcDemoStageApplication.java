package in.gov.cdc.cdcdemostage;

import com.google.common.reflect.ClassPath;
import in.gov.cdc.cdcdemostage.annotations.RuleDescriptor;
import in.gov.cdc.cdcdemostage.model.Event;
import in.gov.cdc.cdcdemostage.model.User;
import in.gov.cdc.cdcdemostage.validators.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@SpringBootApplication
public class CdcDemoStageApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CdcDemoStageApplication.class, args);

		// Create a User instance
		User user = new User("John Doe", "test", "test@test.com", OffsetDateTime.now());
		Event event = new Event(UUID.randomUUID().toString(), "296836293865829356",
				"U", "11100010101010000001010101010101", OffsetDateTime.now().toString(), 01);

//		ValidatorFactory factory = new ValidatorFactory();
//
//		// Register different ValidatorVisitor implementations
//		// Here we can scan the componet and build all the validations
//		factory.registerValidatorVisitor("UserValidator", new UserValidator.UserValidatorVisitor());
//		factory.registerValidatorVisitor("EmailValidator", new EmailValidator.EmailValidatorVisitor());
//
//		// During runtime, determine the criteria and select the appropriate ValidatorVisitor
//		String criteria = "UserValidator";
//		Validator.ValidatorVisitor visitor = factory.getValidatorVisitor(criteria);
//
//		// Configure or interact with the selected ValidatorVisitor
//		if (visitor != null) {
//
//			if (visitor instanceof UserValidator.UserValidatorVisitor) {
//				// Create an instance of the UserValidator
//				UserValidator userValidator = new UserValidator();
//
//				// Invoke the visit method to configure or interact with the User. Here we should pass an instance of the User.
//				visitor.visit(userValidator);
//
//			} else {
//				// Handle the case where no matching ValidatorVisitor is found
//				// ...
//			}
//		}
//		ruleFilter(event, user);
		doProcess(event, user);
	}


	public static void doProcess(@NotNull Event event, User user) {
		for (int i = 0; i < 100; i++) {
			final int index = i;
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName());
				ruleFilter(event, user);   // Pass each list for printing
			}).start();
		}
	}

	public static void ruleFilter(@NotNull Event event, User user) {
		try {
			// Get all the Validation Classes from the package
			List<Class> clazzzz = getClassList("in.gov.cdc.cdcdemostage.validators");


			for (Class<?> clazz : clazzzz) {
				// Assuming the class has a default (no-argument) constructor
				Object instance = clazz.getDeclaredConstructor().newInstance();

				for (Method method : clazz.getDeclaredMethods()) {


					RuleDescriptor[] annotations = method.getAnnotationsByType(RuleDescriptor.class);

					// If the annotation is not null
					if (annotations != null) {
						for (RuleDescriptor ruleDescriptor : annotations) {
							if (ruleDescriptor.requestType().equals(event.getRequestType())
									&& ruleDescriptor.mask().equals(event.getBitmap()))
								try {
									method.invoke(instance, user);
								} catch (Throwable ex) {
									ex.printStackTrace(); // Print the full stack trace for better debugging
								}
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
	}

	public static List<Class> getClassList(String packageName) throws IOException {

			return ClassPath.from(ClassLoader.getSystemClassLoader())
					.getAllClasses()
					.stream()
					.filter(clazz -> clazz.getPackageName()
							.equalsIgnoreCase(packageName))
					.map(clazz -> clazz.load())
					.collect(Collectors.toList());
	}
}

