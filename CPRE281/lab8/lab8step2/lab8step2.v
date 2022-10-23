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

// PROGRAM		"Quartus Prime"
// VERSION		"Version 20.1.1 Build 720 11/11/2020 SJ Standard Edition"
// CREATED		"Thu Oct 28 09:44:35 2021"

module lab8step2(
	X3,
	X2,
	X1,
	X0,
	Xc1,
	Xc2,
	Xc3,
	S,
	F
);


input wire	X3;
input wire	X2;
input wire	X1;
input wire	X0;
input wire	Xc1;
input wire	Xc2;
input wire	Xc3;
input wire	[1:0] S;
output wire	[3:0] F;

wire	[3:0] F_ALTERA_SYNTHESIZED;





mux4to1	b2v_inst(
	.w0(X3),
	.w1(X2),
	.w2(X1),
	.w3(X0),
	.S(S),
	.f(F_ALTERA_SYNTHESIZED[3]));


mux4to1	b2v_inst1(
	.w0(X2),
	.w1(X1),
	.w2(X0),
	.w3(Xc1),
	.S(S),
	.f(F_ALTERA_SYNTHESIZED[2]));


mux4to1	b2v_inst2(
	.w0(X1),
	.w1(X0),
	.w2(Xc1),
	.w3(Xc2),
	.S(S),
	.f(F_ALTERA_SYNTHESIZED[1]));


mux4to1	b2v_inst3(
	.w0(X0),
	.w1(Xc1),
	.w2(Xc2),
	.w3(Xc3),
	.S(S),
	.f(F_ALTERA_SYNTHESIZED[0]));

assign	F = F_ALTERA_SYNTHESIZED;

endmodule
