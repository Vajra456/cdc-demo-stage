package in.gov.cdc.cdcdemostage;

import com.google.common.reflect.ClassPath;
import com.uidai.enu.common.model.*;
import in.gov.cdc.cdcdemostage.validationHelper.impl.DataValidator;
import in.gov.cdc.cdcdemostage.validators.address.validationStarter.AddressValidator;
import in.gov.cdc.cdcdemostage.validators.dob.DobObjectValidator;
import in.gov.cdc.cdcdemostage.validators.document.DocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class CdcDemoStageApplication implements CommandLineRunner {

	private DataValidator dataValidator;


	@Autowired
	DocumentValidator documentValidator;

	@Autowired
	AddressValidator addressValidator;

	@Autowired
	DobObjectValidator dobValidator;

	public record ResidentRecord(ExtractedPacket extractedPacket) {}

	public CdcDemoStageApplication(DataValidator dataValidator) {
		this.dataValidator = dataValidator;
	}

	public static void main(String[] args) {
		SpringApplication.run(CdcDemoStageApplication.class, args);

		// Create a User instance
//		User user = new User("John Doe", "test", "test@test.com", OffsetDateTime.now());
//		Event event = new Event(UUID.randomUUID().toString(), "296836293865829356",
//				"U", "11100010101010000001010101010101", OffsetDateTime.now().toString(), 01);

//		ValidatorFactory factory = new ValidatorFactory();
//
//		// Register different ValidatorVisitor implementations
//		// Here we can scan the componet and build all the validations
//		factory.registerValidatorVisitor("UserValidator", new UserValidator.UserValidatorVisitor());
//		factory.registerValidatorVisitor("EmailValidators", new EmailValidators.EmailValidatorVisitor());
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
//		doProcess(event, user);
	}

//
//	public static void doProcess(@NotNull Event event, User user) {
//		for (int i = 0; i < 100; i++) {
//			final int index = i;
//			new Thread(() -> {
//				System.out.println(Thread.currentThread().getName());
//				ruleFilter(event, user);   // Pass each list for printing
//			}).start();
//		}
//	}
//
//	public static void ruleFilter(@NotNull Event event, User user) {
//		try {
//			// Get all the Validation Classes from the package
//			List<Class> clazzzz = getClassList("in.gov.cdc.cdcdemostage.validators");
//
//
//			for (Class<?> clazz : clazzzz) {
//				// Assuming the class has a default (no-argument) constructor
//				Object instance = clazz.getDeclaredConstructor().newInstance();
//
//				for (Method method : clazz.getDeclaredMethods()) {
//
//
//					RuleDescriptor[] annotations = method.getAnnotationsByType(RuleDescriptor.class);
//
//					// If the annotation is not null
//					if (annotations != null) {
//						for (RuleDescriptor ruleDescriptor : annotations) {
//							if (ruleDescriptor.requestType().equals(event.getRequestType())
//									&& ruleDescriptor.mask().equals(event.getBitmap()))
//								try {
//									method.invoke(instance, user);
//								} catch (Throwable ex) {
//									ex.printStackTrace(); // Print the full stack trace for better debugging
//								}
//						}
//					}
//				}
//			}
//		}catch (Exception e) {
//			e.printStackTrace(); // Handle the exception appropriately
//		}
//	}

	public static List<Class> getClassList(String packageName) throws IOException {

			return ClassPath.from(ClassLoader.getSystemClassLoader())
					.getAllClasses()
					.stream()
					.filter(clazz -> clazz.getPackageName()
							.equalsIgnoreCase(packageName))
					.map(clazz -> clazz.load())
					.collect(Collectors.toList());
	}

	@Override
	public void run(String... args) throws Exception {
		EventMessage eventMessage = new EventMessage();
		ResidentProfile residentProfile=new ResidentProfile();
		residentProfile.setPoName("Tildanga");
		residentProfile.setPincode("742212");
		residentProfile.setResName("abhin");
		residentProfile.setDistrict("00324");residentProfile.setDistrictName("Murshidabad");
		residentProfile.setVtc("1234");residentProfile.setVtcName("Dohitpur");
		residentProfile.setState("19");residentProfile.setStateName("West Bengal");
		ExtractedPacket extractedPacket=new ExtractedPacket();
		EnrollmentPacket enrollmentPacket=new EnrollmentPacket();
		enrollmentPacket.setResidentProfile(residentProfile);
		extractedPacket.setPacket(enrollmentPacket);
		dobValidator.validate(extractedPacket,eventMessage);
//		documentValidator.validate(extractedPacket);
		addressValidator.validate(extractedPacket,eventMessage);
//		ExtractedPacket extractedPacket = new ExtractedPacket();
//		extractedPacket.getPacket().getResidentProfile().setResName("Rushabh Chordiya");
//		extractedPacket.getPacket().getResidentProfile().setDob(new Dob(true,2,2023,31,null,new Status(),true,true,true));
//		ResidentRecord residentRecord = new ResidentRecord(extractedPacket);
//		BitSet updateBits = new BitSet(32);
//
//		// resident name & resident local name update
//		updateBits.set(1,true);
////		updateBits.set(2, true);
//		updateBits.set(3,true);
////		updateBits.set(8, true);
//
//		BitSet rejectBits = new BitSet(32);
//		eventMessage.setRejectBits(rejectBits.toString());
//		eventMessage.getPacketMetaData().setBitMap(updateBits.toString());
//
//		List<Optional<ValidationError>> ve = this.dataValidator.validate(eventMessage, residentRecord.extractedPacket);
//
//		ve.stream().filter(Optional::isPresent).forEach(v -> System.out.println(v.get().getErrorMessage()));
	}
}

