package net.karanbhogle.springbootproject.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusinessException extends RuntimeException{
	/**
	 * In Java, when you create a class (let's say it's like your toy), 
	 * sometimes you want to make sure that if your friend (another part 
	 * of your program or someone else's program) wants to use the exact 
	 * same class, they get the same version, no surprises.So, the 
	 * serialVersionUID is like a secret code that helps Java make sure 
	 * that when you share your class (toy) with your friend (another part 
	 * of the program or another program), they both understand it in the 
	 * same way. It's like saying, "Hey, this is the version of the toy 
	 * we're all going to play with, so let's make sure we're on the same page."
	 * 
	 * The static final part is just Java's way of saying, "This secret code 
	 * is going to be the same for every version of the toy, and it's not 
	 * going to change while we're playing with it."
	 * 
	 * In simple terms, it's a way for Java to keep things organized and 
	 * make sure that everyone using the same class knows they're talking 
	 * about the same thing. It's like having a special code for your 
	 * favorite toy that never changes, so everyone can enjoy playing 
	 * with it in the same way.
	 */
	private static final long serialVersionUID = 3254429294682479461L;
	private final transient List<ErrorModel> errors;
}
