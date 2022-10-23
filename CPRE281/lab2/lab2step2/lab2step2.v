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
// CREATED		"Thu Sep 09 09:21:40 2021"

module lab2step2(
	W,
	G,
	C,
	Alarm
);


input wire	W;
input wire	G;
input wire	C;
output wire	Alarm;

wire	SYNTHESIZED_WIRE_0;
wire	SYNTHESIZED_WIRE_1;
wire	SYNTHESIZED_WIRE_2;
wire	SYNTHESIZED_WIRE_3;
wire	SYNTHESIZED_WIRE_9;
wire	SYNTHESIZED_WIRE_10;
wire	SYNTHESIZED_WIRE_8;




assign	Alarm = SYNTHESIZED_WIRE_0 | SYNTHESIZED_WIRE_1 | SYNTHESIZED_WIRE_2 | SYNTHESIZED_WIRE_3;

assign	SYNTHESIZED_WIRE_0 = SYNTHESIZED_WIRE_9 & SYNTHESIZED_WIRE_10;

assign	SYNTHESIZED_WIRE_2 = C & G;

assign	SYNTHESIZED_WIRE_9 =  ~C;

assign	SYNTHESIZED_WIRE_10 =  ~G;

assign	SYNTHESIZED_WIRE_8 =  ~W;

assign	SYNTHESIZED_WIRE_3 = SYNTHESIZED_WIRE_9 & G & W;

assign	SYNTHESIZED_WIRE_1 = C & SYNTHESIZED_WIRE_10 & SYNTHESIZED_WIRE_8;


endmodule
