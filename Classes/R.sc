R : List {

	var < phase = 0;

*	copyInstance { |instance|
		var currentPhase = instance.phase;

		// Reapply the current phase (`rotate` and `phase_` work in opposite directions).

		^ this.new.array_ (instance.array.rotate (currentPhase)).phase_ (currentPhase);
	}

	size_ { |newSize = 0|
		var oldSize = this.size;
		super.size_ (newSize);

		if (newSize > oldSize) { for (oldSize, newSize - 1, (super.put (_, 0))) };
	}

	phase_ { |newPhase = 0|
		this.derotateInPlace (newPhase - phase);
		phase = newPhase;
	}

	rephase { |newPhase = 0|
		^ this.phase_ (newPhase);
	}

	rephased { |newPhase = 0|
		^ this.copy.rephase (newPhase);
	}

	dephase { |phaseDifference = 0|
		^ this.phase_ (phase + phaseDifference);
	}

	dephased { |phaseDifference = 0|
		^ this.copy.dephase (phaseDifference);
	}

	asEvent {
		^ (size: this.size, sum: this.sum, phase: this.phase);
	}

	asDurations {
		^ this.add (1).indicesOf1.differentiate.drop (1);
	}

}
