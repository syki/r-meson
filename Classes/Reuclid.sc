Reuclid : Rrun {

	redistribute { |m = 0|
		var divisor = this.size, remainder = m;
		var buckets = [this];
		if (1 === m) { ^ this };
		while { (1 < remainder) && (remainder < divisor) } {
			divisor = remainder;
			buckets = buckets.flip.clump (divisor);
			remainder = buckets.last.size;
		};
		this.putAll (buckets.flip.reverse.flat);
		// Or this.array = ???
	}
	
}
