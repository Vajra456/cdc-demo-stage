package in.gov.cdc.cdcdemostage.validators;

public class UsernameUniquenessValidatorVisitor {
//        implements ValidatorVisitor {
//
//    private final UserRepository userRepository;
//
//    public UsernameUniquenessValidatorVisitor(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void visit(Validator validator) {
//        UserNameValidator usernameValidator = (UserNameValidator) validator;
//
//        usernameValidator.addRule("username", (user) -> {
//            if (userRepository.existsByUsername(user.getUsername())) {
//                return Optional.of("Username is already taken");
//            } else {
//                return Optional.empty();
//            }
//        });
//    }
}

