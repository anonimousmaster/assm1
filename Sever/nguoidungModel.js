const mongoose = require('mongoose');
// cau hinh giong tren mongodb 
const nguoidungSchema = new mongoose.Schema({
    ten:{
        type: String,
        require: true
    },
    tuoi:{
        type:Number,
    },
    diachi:{
        type: String,
        require: true
    },
    sodienthoai:{
        type:Number,
    },
});
//phải để giống tên bảng ở mongodb
const nguoidungModel = new mongoose.model('nguoidung',nguoidungSchema);
// cuoi cung
module.exports = nguoidungModel;


