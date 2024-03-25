package com.example.lab1_ph35122_dohoanglong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NguoidungAdapter extends BaseAdapter {

    List<nguoidungModel> nguoidungModelList;

    Context context;

    public NguoidungAdapter (Context context, List<nguoidungModel> nguoidungModelList) {
        this.context = context;
        this.nguoidungModelList = nguoidungModelList;
    }

    @Override
    public int getCount() {
        return nguoidungModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return nguoidungModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.iteam_nguoidung, viewGroup, false);

        TextView tvID = (TextView) rowView.findViewById(R.id.tvId);
        ImageView imgAvatar = (ImageView) rowView.findViewById(R.id.imgAvatatr);
        TextView tvName = (TextView) rowView.findViewById(R.id.tvName);

        TextView tvTuoi = (TextView) rowView.findViewById(R.id.tvTuoi);

        TextView tvDiachi = (TextView) rowView.findViewById(R.id.tvDiachi);

        TextView tvSodienthoai = (TextView) rowView.findViewById(R.id.tvSodienthoai);

//        String imageUrl = mList.get(position).getThumbnailUrl();
//        Picasso.get().load(imageUrl).into(imgAvatar);
////        imgAvatar.setImageResource(imageId[position]);
        tvName.setText(String.valueOf(nguoidungModelList.get(position).getTen()));

        tvTuoi.setText(String.valueOf(nguoidungModelList.get(position).getTuoi()));

        tvDiachi.setText(String.valueOf(nguoidungModelList.get(position).getDiachi()));

        tvSodienthoai.setText(String.valueOf(nguoidungModelList.get(position).getSodienthoai()));

        return rowView;
    }
}
