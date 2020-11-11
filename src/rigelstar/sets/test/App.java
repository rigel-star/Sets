package rigelstar.sets.test;

import java.util.Arrays;
import java.util.Collection;

import rigelstar.sets.Set;
import rigelstar.sets.UniversalSet;

public class App {
	
	/**
	 * TODO:: CreateSubset(args) function for sets.
	 * */ 
	public App() {
		
		//TEST
		//Super set = "a", "b", "c", "d", "e", "f", "g", "h", "i"
		//Sub set = "a", "c", "e", "g", "i"
		Collection<String> strs = Arrays.asList( "a" );
		
		UniversalSet<String> set = new UniversalSet<>( strs );
		
		Collection<String> strs1 = Arrays.asList( "z" );
		
		Set<String> set1 = new Set<>( strs1 );
		
		System.out.println( set.isEqual( set1 )); //false
		System.out.println( set.isEquivalent( set1 )); //true
	}
	
	public static void main(String[] args) {
		new App();
	}
}
