Rrun : Rgenerate {

	repopulate { |newSum|
		this.fillWith { |i| (i < newSum).asInteger };
	}
	
}
