const express = require('express');
const app = express();
const port = 3000;

// Định nghĩa một route GET đơn giản
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
});

// Khởi động máy chủ và lắng nghe các kết nối đến cổng 3000


const COMMON = require('./COMMON');
const uri = COMMON.uri;

// những lệnh kết nối đầu tiên 
const mongoose = require('mongoose');
const nguoidungModel = require('./nguoidungModel');

const apiMobile = require('./api');
// Sử dụng router '/api'
app.use('/api', apiMobile);

app.get('/', async (req, res) => {
  await mongoose.connect(uri);

  let nguoidungs = await nguoidungModel.find();

  console.log(nguoidungs);
  res.send(nguoidungs);
});

app.get('/add_nguoidung', async (req, res) => {
  await mongoose.connect(uri);

  let nguoidung = {
    ten: 'nguyen van a',
    tuoi: 20,
    diachi: 'quang tri',
    sodienthoai: 99988833322
  }

  let kq = await nguoidungModel.create(nguoidung);
  console.log(kq);
  let nguoidungs = await nguoidungModel.find();
  res.send(nguoidungs);
});
