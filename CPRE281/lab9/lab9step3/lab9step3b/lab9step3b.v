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
// CREATED		"Thu Nov 04 09:52:33 2021"

module lab9step3b(
	CLK,
	D,
	Q,
	QN
);


input wire	CLK;
input wire	D;
output wire	Q;
output wire	QN;

wire	SYNTHESIZED_WIRE_0;
wire	SYNTHESIZED_WIRE_10;
wire	SYNTHESIZED_WIRE_11;
wire	SYNTHESIZED_WIRE_3;
wire	SYNTHESIZED_WIRE_4;
wire	SYNTHESIZED_WIRE_12;

assign	Q = SYNTHESIZED_WIRE_3;
assign	QN = SYNTHESIZED_WIRE_0;



assign	SYNTHESIZED_WIRE_3 = ~(SYNTHESIZED_WIRE_0 & SYNTHESIZED_WIRE_10);

assign	SYNTHESIZED_WIRE_0 = ~(SYNTHESIZED_WIRE_11 & SYNTHESIZED_WIRE_3);

assign	SYNTHESIZED_WIRE_10 = ~(CLK & SYNTHESIZED_WIRE_4);

assign	SYNTHESIZED_WIRE_4 = ~(SYNTHESIZED_WIRE_10 & SYNTHESIZED_WIRE_12);

assign	SYNTHESIZED_WIRE_12 = ~(D & SYNTHESIZED_WIRE_11);

assign	SYNTHESIZED_WIRE_11 = ~(SYNTHESIZED_WIRE_10 & CLK & SYNTHESIZED_WIRE_12);


endmodule
