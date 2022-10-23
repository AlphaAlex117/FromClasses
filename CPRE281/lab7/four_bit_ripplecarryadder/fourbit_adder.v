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
// CREATED		"Thu Oct 21 09:27:16 2021"

module fourbit_adder(
	X3,
	Y3,
	X2,
	Y2,
	X1,
	Y1,
	X0,
	Y0,
	Cin,
	Cout,
	S3,
	S2,
	S1,
	S0,
	Oflow
);


input wire	X3;
input wire	Y3;
input wire	X2;
input wire	Y2;
input wire	X1;
input wire	Y1;
input wire	X0;
input wire	Y0;
input wire	Cin;
output wire	Cout;
output wire	S3;
output wire	S2;
output wire	S1;
output wire	S0;
output wire	Oflow;

wire	SYNTHESIZED_WIRE_0;
wire	SYNTHESIZED_WIRE_5;
wire	SYNTHESIZED_WIRE_2;
wire	SYNTHESIZED_WIRE_3;

assign	Cout = SYNTHESIZED_WIRE_3;




one_bit_fulladder	b2v_inst(
	.X(X2),
	.Y(Y2),
	.Cin(SYNTHESIZED_WIRE_0),
	.Cout(SYNTHESIZED_WIRE_5),
	.S(S2));


one_bit_fulladder	b2v_inst2(
	.X(X3),
	.Y(Y3),
	.Cin(SYNTHESIZED_WIRE_5),
	.Cout(SYNTHESIZED_WIRE_3),
	.S(S3));


one_bit_fulladder	b2v_inst3(
	.X(X1),
	.Y(Y1),
	.Cin(SYNTHESIZED_WIRE_2),
	.Cout(SYNTHESIZED_WIRE_0),
	.S(S1));


one_bit_fulladder	b2v_inst4(
	.X(X0),
	.Y(Y0),
	.Cin(Cin),
	.Cout(SYNTHESIZED_WIRE_2),
	.S(S0));

assign	Oflow = SYNTHESIZED_WIRE_3 ^ SYNTHESIZED_WIRE_5;


endmodule
