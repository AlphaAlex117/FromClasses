module lab3step1 (A, C, G, W);

	input C, G, W;
	output A;
	
	
	not(H, G);
	not(D, C);
	not(X, W);
	or(M, C, H, W);
	or(N, D, G, X);
	and(A, M, N);
	
endmodule 