module primedetector(P, W, X, Y, Z);
	input W, X, Y, Z;
	output P;
	
	assign P = ((X & ~Y & Z) | (~W & X & Z) | (~W & ~X & Y) | (~X & Y & Z));
	
endmodule 