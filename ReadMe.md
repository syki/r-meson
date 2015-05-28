# R 4 SuperCollider

Rhythm generation for SuperCollider.

Rhythms are defined as binary sequences:

	R[ 1, 0, 1, 1, 0, 1, 0, 0 ]

They can also be generated:

	Reuclid (size: 12, sum: 7) // -> Reuclid[ 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0 ]

And mutated:

	Reuclid (12, 7).phase_ (1) // -> Reuclid[ 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1 ]

R is a subclass of the built-in List (essentially a proxy for an Array),
and can be used as such:

	Reuclid (12, 5) + Reuclid (12, 7) // -> [ 2, 0, 1, 2, 0, 2, 0, 1, 2, 0, 2, 0 ]
