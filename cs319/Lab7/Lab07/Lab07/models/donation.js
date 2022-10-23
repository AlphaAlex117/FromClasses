const mongoose = require('mongoose')
const Schema = mongoose.Schema

//Schema
const donationSchema = new Schema({
    name: {type:String,
        required:true},
    email: {type:String,
        required:true},
    charity: {type:String,
        required:true},
    amount: {type:Number,
        required:true}
}, {timestamps: true});

//Model
const Donation = mongoose.model('Donation', donationSchema)

module.exports = Donation