package rigelstar.sets;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Set<E> implements Sets<E> {
	
	private List<E> elems = new ArrayList<>();
	
	public Set() {}
	
	public Set( Collection<E> data ) {
		elems.addAll( data );
	}
	
	@Override
	public void add( E e ) {
		if ( !elems.contains( e ))
			elems.add( e );
	}

	@Override
	public void remove( int index ) {
		elems.remove( index );
	}
	
	@Override
	public E get( int index ) {
		return elems.get( index );
	}
	
	@Override
	public boolean contains( E e ) {
		return elems.contains( e );
	}
	
	@SuppressWarnings( "unchecked" )
	@Override
	public E[] getAll() {
		
		Class<E> clazz = null;
		
		if ( !isNull() )
			clazz = (Class<E>) elems.get( 0 ).getClass();
			
		E[] all = (E[]) Array.newInstance( clazz, elems.size() );
		
		for( int i = 0; i< elems.size(); i++ )
			all[i] = elems.get( i );
		
		return all;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Sets<E> intersections( Sets<E> s ) {
		Set<E> intr = new Set<>();
		
		E[] another = s.getAll();
		
		for( E e: elems )
			for( E ee: another )
				if ( e.equals( ee ))
					intr.add( ee );
		
		if( intr.cardinality() == 0 )
			intr.add( (E) "{NULL}" );
		
		return intr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Sets<E> unions( Sets<E> s ) {
		Set<E> intr = new Set<>();
		
		for( E e: elems )
			intr.add( e );
		
		for( E e: s.getAll() )
			intr.add( e );
		
		if( intr.cardinality() == 0 )
			intr.add( (E) "{NULL}" );
		
		return intr;
	}
	
	@Override
	public boolean isSubset( Sets<E> s ) {
		
		E[] all = s.getAll();
		
		int size = s.cardinality();
		int count = 0;
		
		for( E e: all ) {
			if ( elems.contains( e ))
				count++;
		}
		
		return size == count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Sets<E> difference( Sets<E> s ) {
		
		Set<E> ret = new Set<>();
		
		for( E e: elems ) {
			if( !s.contains( e ))
				ret.add( e );
		}
		
		if( ret.cardinality() == 0 )
			ret.add( (E) "{NULL}" );
		
		return ret;
	}
	
	@Override
	public int cardinality() {
		return elems.size();
	}

	@Override
	public boolean isNull() {
		return elems.isEmpty();
	}
	
	@Override
	public boolean isEqual( Sets<E> s ) {
		
		int size = this.cardinality();
		int len = 0;
		
		if ( isEquivalent( s )) {
			
			for( E e: s.getAll() )
				if( elems.contains( e )) 
					++len;
		}
		
		return size == len;
	}
	
	@Override
	public boolean isEquivalent( Sets<E> s ) {
		return elems.size() == s.getAll().length;
	}

	@Override
	public void clear() {
		elems.clear();
	}
	
	/**
	 * Complements of this set with given {@link UniversalSet}.
	 * 
	 * @param us 	{@link UniversalSet } to check complement with.
	 * @return 		Complements.
	 * */
	public Sets<E> complement( UniversalSet<E> us ) {
		Set<E> compls = new Set<>();
		
		for( E e: us.getAll() ) 
			if ( !elems.contains( e ))
				compls.add( e );
		
		return compls;
	}
}
