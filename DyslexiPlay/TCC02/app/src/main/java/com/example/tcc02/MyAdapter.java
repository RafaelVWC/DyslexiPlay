package com.example.tcc02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[],data2[],data3[];

    int images[];

    Context context;


    public MyAdapter(Context ct, String s1[],String s2[],String s3[], int image[])  {

        context = ct;

        data1 = s1;

        data2= s2;

        data3=s3;

        images = image;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.itens_information,parent,false);

        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


            holder.t1.setText(data1[position]);
            holder.t2.setText(data2[position]);
            holder.t3.setText(data3[position]);
            holder.i1.setImageResource(images[position]);

            holder.Main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,InformationPlus.class);
                    intent.putExtra("data1",data1[position]);
                    intent.putExtra("data2",data2[position]);
                    intent.putExtra("data3",data3[position]);
                    intent.putExtra("images",images[position]);
                    context.startActivity(intent);

                }
            });
        }






    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView t1, t2 , t3;

        ImageView i1;

        ConstraintLayout Main;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.txtTitulo);
            i1 = itemView.findViewById(R.id.imgDesign);
            t2 = itemView.findViewById(R.id.txDescription);
            t3 = itemView.findViewById(R.id.txLink);
            Main = itemView.findViewById(R.id.MainLayout);


        }
    }
}
