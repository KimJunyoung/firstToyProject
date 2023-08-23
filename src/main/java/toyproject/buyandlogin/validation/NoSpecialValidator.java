package toyproject.buyandlogin.validation;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class NoSpecialValidator implements ConstraintValidator<NoSpecialValid,String> {
    @Override
    public void initialize(NoSpecialValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("result ={}",RegexUtils.hasSpecialChar(value));
        if(RegexUtils.isEmpty(value)){
            return true;
        }
        return RegexUtils.hasSpecialChar(value) &&  !RegexUtils.isNumeric(value);
    }
}
