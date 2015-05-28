R : List {

	var < phase = 0;

*	copyInstance { |instance|
		var phi = instance.phase;
		^ this.new.array_ (instance.array.rotate (phi)).phase_ (phi);
	}

	size_ { |n = 0|
		var m = this.size;
		super.size_ (n);
		if (n > m) { for (m, n - 1, (super.put (_, 0))) };
	}

	phase_ { |k = 0|
		this.unrotateInPlace (k - phase);
		phase = k;
	}

	rephase { |k = 0|
		^ this.phase_ (k);
	}

	rephased { |k = 0|
		^ this.copy.rephase (k);
	}

	dephase { |d = 0|
		^ this.phase_ (phase + d);
	}

	dephased { |d = 0|
		^ this.copy.dephase (d);
	}

	asEvent {
		^ (size: this.size, sum: this.sum, phase: this.phase);
	}

}
