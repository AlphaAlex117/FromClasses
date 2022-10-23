// WARNING: Do NOT edit the input and output ports in this file in a text
// editor if you plan to continue editing the block that represents it in
// the Block Editor! File corruption is VERY likely to occur.

// Copyright (C) 2020  Intel Corporation. All rights reserved.
// Your use of Intel Corporation's design tools, logic functions
// and other software and tools, and any partner logic
// functions, and any output files from any of the foregoing
// (including device programming or simulation files), and any
// associated documentation or information are expressly subject
// to the terms and conditions of the Intel Program License
// Subscription Agreement, the Intel Quartus Prime License Agreement,
// the Intel FPGA IP License Agreement, or other applicable license
// agreement, including, without limitation, that your use is for
// the sole purpose of programming logic devices manufactured by
// Intel and sold by Intel or its authorized distributors.  Please
// refer to the applicable agreement for further details, at
// https://fpgasoftware.intel.com/eula.


// Generated by Quartus Prime Version 20.1 (Build Build 720 11/11/2020)
// Created on Thu Sep 23 09:13:56 2021

//  Module Declaration
module normal
(
// {{ALTERA_ARGS_BEGIN}} DO NOT REMOVE THIS LINE!
T, H, P, E
// {{ALTERA_ARGS_END}} DO NOT REMOVE THIS LINE!
);
// Port Declaration

// {{ALTERA_IO_BEGIN}} DO NOT REMOVE THIS LINE!
input T;
input H;
input P;
output E;
// {{ALTERA_IO_END}} DO NOT REMOVE THIS LINE!
reg E;

always @(T or H or P)
begin
	case ({T,H,P})
	
		3'b000: E= 'b0;
		3'b001: E= 'b0;
		3'b010: E= 'b0;
		3'b011: E= 'b1;
		3'b100: E= 'b0;
		3'b101: E= 'b1;
		3'b110: E= 'b1;
		3'b111: E= 'b1;
	endcase
end

endmodule