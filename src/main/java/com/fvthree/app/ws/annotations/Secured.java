package com.fvthree.app.ws.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.ws.rs.NameBinding;


/**
 * @author Felipe Villanueva III
 *
 */

@NameBinding
@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Secured {

}
