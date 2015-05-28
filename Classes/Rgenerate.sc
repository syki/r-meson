Rgenerate : R {
	
*	new { |size = 0, sum = 0|
		^ super.new.resize (size).regenerate (sum);
	}

	size_ { |size|
		super.size_ (size).regenerate (this.sum);
	}

	sum_ { |sum|
		^ this.regenerate (sum);
	}

	resum { |sum|
		^ this.regenerate (sum);
	}

	resummed { |sum|
		^ this.regenerated (sum);
	}

	regenerate { |sum = 0|
		var k = phase; phase = 0;
		// Repopulating etc destroys the phase implicit in the array,
		// so it needs to be reapplied...
		^ this.repopulate (sum).redistribute (sum).rephase (k);
	}

	regenerated { |sum = 0|
		^ this.copy.regenerate (sum);
	}

	repopulate { |sum = 0|
		^ this.fill (0);
	}

	repopulated { |sum = 0|
		^ this.copy.repopulate (sum);
	}

	redistribute { |sum = 0|
		^ this;
	}

	redistributed { |sum = 0|
		^ this.copy.redistribute (sum);
	}

}
