package com.jiat.mvcproject.annotations;

import jakarta.ws.rs.NameBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//jersey can recognize this as an annotation for usage. Annotation can get bind
// with anybody who uses the annotation
@NameBinding
//generally annotation run in compile time. this way, we can say it to run at runtime as well.
//we change the retention policy to runtime.
@Retention(RetentionPolicy.RUNTIME)
public @interface IsUser {

}
