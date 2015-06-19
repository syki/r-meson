Reuclid : Rrun {

	/**************************************************************************\

	Given an R of the following form:

		R[1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]

	Performs the Euclidean algorithm described in the following paper:

		Toussaint, G.
		The Euclidean Algorithm Generates Traditional Musical Rhythms (2005).
		In the proceedings of BRIDGES: Mathematical Connections in Art, Music and Science. Alberta, Canada. p47-56.

	Conveniently, `clump` already provides something analogous to
	divide & remainder for arrays, e.g.:

	    ((1 ! 5) ++ (0 ! 7)).clump (5).flip
	    // -> [[1, 0, 0], [1, 0, 0], [1, 0], [1, 0], [1, 0]]

	So we only need to iteratively apply this along with `flip`
	(the non-wrapping `flop`, defined in http://github.com/tosyx/plasma):

	    ((1 ! 5) ++ (0 ! 7)).clump (5).flip.clump (3).flip
	    // -> [[[1, 0, 0], [1, 0]], [[1, 0, 0], [1, 0]], [[1, 0]]]

	\**************************************************************************/

	redistribute { |sum|
		var divisor = this.size, remainder = sum ?? { this.sum };
		var buckets = [this];
		if (1 === sum) { ^ this };
		while { (1 < remainder) && (remainder < divisor) } {
			divisor = remainder;
			buckets = buckets.flip.clump (divisor);
			remainder = buckets.last.size;
		};
		this.putAll (buckets.flip.reverse.flat);
		// Or this.array = ???
	}
	
}
