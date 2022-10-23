module seven_seg_decoder (A, B, C, D, E, F, G, x3, x2, x1, x0);
	input x3, x2, x1, x0;
	output A, B, C, D, E, F, G;
	reg A, B, C, D, E, F, G;
	
	always @(x3 or x2 or x1 or x0)
	begin
		case({x3,x2,x1,x0})
			4'b0000: begin
						A='b0;
						B='b0;
						C='b0;
						D='b0;
						E='b0;
						F='b0;
						G='b1;
						end
			4'b0001: begin
						A='b1;
						B='b0;
						C='b0;
						D='b1;
						E='b1;
						F='b1;
						G='b1;
						end
			4'b0010: begin
						A='b0;
						B='b0;
						C='b1;
						D='b0;
						E='b0;
						F='b1;
						G='b0;
						end
			4'b0011: begin
						A='b0;
						B='b0;
						C='b0;
						D='b0;
						E='b1;
						F='b1;
						G='b0;
						end
			4'b0100: begin
						A='b1;
						B='b0;
						C='b0;
						D='b1;
						E='b1;
						F='b0;
						G='b0;
						end
			4'b0101: begin
						A='b0;
						B='b1;
						C='b0;
						D='b0;
						E='b1;
						F='b0;
						G='b0;
						end
			4'b0110: begin
						A='b0;
						B='b1;
						C='b0;
						D='b0;
						E='b0;
						F='b0;
						G='b0;
						end
			4'b0111: begin
						A='b0;
						B='b0;
						C='b0;
						D='b1;
						E='b1;
						F='b1;
						G='b1;
						end
			4'b1000: begin
						A='b0;
						B='b0;
						C='b0;
						D='b0;
						E='b0;
						F='b0;
						G='b0;
						end
			4'b1001: begin
						A='b0;
						B='b0;
						C='b0;
						D='b0;
						E='b1;
						F='b0;
						G='b0;
						end
			4'b1010: begin
						A='b0;
						B='b0;
						C='b0;
						D='b1;
						E='b0;
						F='b0;
						G='b0;
						end
			4'b1011: begin
						A='b1;
						B='b1;
						C='b0;
						D='b0;
						E='b0;
						F='b0;
						G='b0;
						end
			4'b1100: begin
						A='b0;
						B='b1;
						C='b1;
						D='b0;
						E='b0;
						F='b0;
						G='b1;
						end
			4'b1101: begin
						A='b1;
						B='b0;
						C='b0;
						D='b0;
						E='b0;
						F='b1;
						G='b0;
						end
			4'b1110: begin
						A='b0;
						B='b1;
						C='b1;
						D='b0;
						E='b0;
						F='b0;
						G='b0;
						end
			4'b1111: begin
						A='b0;
						B='b1;
						C='b1;
						D='b1;
						E='b0;
						F='b0;
						G='b0;
						end
		endcase
	end
endmodule
	