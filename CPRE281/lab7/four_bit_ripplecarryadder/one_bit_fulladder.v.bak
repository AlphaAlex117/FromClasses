module one_bit_fulladder (Cin, X, Y, S, Cout);
	input X, Y, Cin;
	output S, Cout;
	
	assign S = (~X & ~Y & Cin) | (~X & Y & ~Cin) | (X & ~Y & ~Cin) | (X & Y & Cin);
	assign Cout = (~X & Y & Cin) | (X & ~Y & Cin) | (X & Y);
	
endmodule