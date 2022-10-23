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
// CREATED		"Thu Nov 11 10:10:05 2021"

module lab10step3a(
	Clock,
	CLRN,
	Q
);


input wire	Clock;
input wire	CLRN;
output wire	[3:0] Q;

wire	[3:0] Q_ALTERA_SYNTHESIZED;
wire	SYNTHESIZED_WIRE_15;
wire	SYNTHESIZED_WIRE_4;
wire	SYNTHESIZED_WIRE_8;
wire	SYNTHESIZED_WIRE_12;

assign	SYNTHESIZED_WIRE_15 = 1;




jkff2_0	b2v_inst(
	.K(SYNTHESIZED_WIRE_15),
	.CLRN(CLRN),
	.CLK(Clock),
	.PRN(SYNTHESIZED_WIRE_15),
	.J(SYNTHESIZED_WIRE_15),
	.QN(SYNTHESIZED_WIRE_4),
	.Q(Q_ALTERA_SYNTHESIZED[0]));


jkff2_1	b2v_inst1(
	.K(SYNTHESIZED_WIRE_15),
	.CLRN(CLRN),
	.CLK(SYNTHESIZED_WIRE_4),
	.PRN(SYNTHESIZED_WIRE_15),
	.J(SYNTHESIZED_WIRE_15),
	.QN(SYNTHESIZED_WIRE_8),
	.Q(Q_ALTERA_SYNTHESIZED[1]));


jkff2_2	b2v_inst2(
	.K(SYNTHESIZED_WIRE_15),
	.CLRN(CLRN),
	.CLK(SYNTHESIZED_WIRE_8),
	.PRN(SYNTHESIZED_WIRE_15),
	.J(SYNTHESIZED_WIRE_15),
	.QN(SYNTHESIZED_WIRE_12),
	.Q(Q_ALTERA_SYNTHESIZED[2]));


jkff2_3	b2v_inst3(
	.K(SYNTHESIZED_WIRE_15),
	.CLRN(CLRN),
	.CLK(SYNTHESIZED_WIRE_12),
	.PRN(SYNTHESIZED_WIRE_15),
	.J(SYNTHESIZED_WIRE_15),
	
	.Q(Q_ALTERA_SYNTHESIZED[3]));


assign	Q = Q_ALTERA_SYNTHESIZED;

endmodule

module jkff2_0(K,CLRN,CLK,PRN,J,QN,Q);
/* synthesis black_box */

input K;
input CLRN;
input CLK;
input PRN;
input J;
output QN;
output Q;

endmodule

module jkff2_1(K,CLRN,CLK,PRN,J,QN,Q);
/* synthesis black_box */

input K;
input CLRN;
input CLK;
input PRN;
input J;
output QN;
output Q;

endmodule

module jkff2_2(K,CLRN,CLK,PRN,J,QN,Q);
/* synthesis black_box */

input K;
input CLRN;
input CLK;
input PRN;
input J;
output QN;
output Q;

endmodule

module jkff2_3(K,CLRN,CLK,PRN,J,Q);
/* synthesis black_box */

input K;
input CLRN;
input CLK;
input PRN;
input J;
output Q;

endmodule
