Rgenerate : R {
	
*	new { |size = 0, sum = 0|
		^ super.new.resize (size).regenerate (sum);
	}

	size_ { |newSize = 0|
		super.size_ (newSize).regenerate;
	}

	sum_ { |newSum = 0|
		^ this.regenerate (newSum);
	}

	resum { |newSum = 0|
		^ this.regenerate (newSum);
	}

	resummed { |newSum = 0|
		^ this.regenerated (newSum);
	}

	regenerate { |newSum = 0|
		var oldPhase = phase;
		phase = 0;

		// Repopulating etc destroys the phase implicit in the array,
		// so it needs to be reset and reapplied...

		^ this.repopulate (newSum).redistribute (newSum).rephase (oldPhase);
	}

	regenerated { |newSum = 0|
		^ this.copy.regenerate (newSum);
	}

	repopulate { |newSum = 0|
		^ this.fill (0);
	}

	repopulated { |newSum = 0|
		^ this.copy.repopulate (newSum);
	}

	redistribute { |newSum = 0|
		^ this;
	}

	redistributed { |newSum = 0|
		^ this.copy.redistribute (newSum);
	}

}
