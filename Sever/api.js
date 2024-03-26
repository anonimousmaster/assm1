const express = require('express');
const router = express.Router();
module.exports= router;

router.get('/', (req,res)=>{
    res.send('vao api mobile');
})
const mongoose = require('mongoose');
const nguoidungModel = require('./nguoidungModel');
const COMMON = require('./COMMON');

router.get('/list',async (req,res)=>{
    await mongoose.connect(COMMON.uri);

    let nguoidungs = await nguoidungModel.find();
  
    console.log(nguoidungs);
    res.send(nguoidungs);
})