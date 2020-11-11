package rigelstar.sets;

public interface Sets<E> {
	
	/**
	 * Add element to set.
	 * 
	 * @param e 	Element to add.
	 * @see Sets#remove(int)
	 * */
	void add( E e );
	
	/**
	 * Remove element from set.
	 * 
	 * @param index 	Index of element.
	 * @see Sets#add(Object)
	 * */
	void remove( int index );
	
	/**
	 * Get element at specified index.
	 * 
	 * @param index 	Index of element.
	 * @return 		Element at specified index.
	 * */
	E get( int index );
	
	/**
	 * Check if this set contains specified element.
	 * 
	 * @param e 	Element to check.
	 * @return 		{@code True} if contains either {@code False}.
	 * */
	boolean contains( E e );
	
	/**
	 * Get all elements of set.
	 * @return 		All elements of set in array.
	 * */
	E[] getAll();
	
	/**
	 * Get intersecting elements.
	 * 
	 * @param s 	Set to check intersection with.
	 * @return {@link Sets} of intersections.
	 * */
	Sets<E> intersections( Sets<E> s );
	
	/**
	 * Get union elements.
	 * 
	 * @param s 	Set to check unions with.
	 * @return {@link Sets} of unions.
	 * */
	Sets<E> unions( Sets<E> s );
	
	/**
	 * Get cardinality or also called size of set.
	 * @return 		Cardinality of set.
	 * */
	int cardinality();
	
	/**
	 * Check if specified set is subset of this set.
	 * 
	 * @param s 	Set.
	 * @return 		{@code True} if is subset either {@code false}
	 * */
	boolean isSubset( Sets<E> s );
	
	/**
	 * Difference two sets.
	 * 
	 * @param s 	Another set.
	 * @return 		{@link Sets} of difference elements.
	 * */
	Sets<E> difference( Sets<E> s );
	
	/**
	 * Check if set is empty.
	 * @return		{@code True} if set is empty 
	 * 				either {@code false}.
	 * */
	boolean isNull();
	
	/**
	 * Check if this set is equal i.e. all the elements 
	 * of this set are equal with specified set.
	 * 
	 * @param s 	Another set.
	 * @return {@code True} if set is equal either {@code False}.
	 * */
	boolean isEqual( Sets<E> s );
	
	/**
	 * Check if this set is equivalent i.e. the cardinality 
	 * of this set is equal with specified set.
	 * 
	 * @param s 	Another set.
	 * @return {@code True} if set is equivalent either {@code False}.
	 * */
	boolean isEquivalent( Sets<E> s );
	
	/**
	 * Clear the set.
	 * */
	void clear();
}
