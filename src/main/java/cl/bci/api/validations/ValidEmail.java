package cl.bci.api.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {

    String message() default "Error formato email: Formato aceptado ejemplo@dominio.cl";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
