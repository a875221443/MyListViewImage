package com.example.hanbing.mylistviewimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        String[] str=new String[]{
                "http://photo.enterdesk.com/2010-10-24/enterdesk.com-3B11711A460036C51C19F87E7064FE9D.jpg",
                "http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2291015098,628551162&fm=21&gp=0.jpg",
                "http://dl.bizhi.sogou.com/images/2012/01/19/191337.png",
                "http://img05.tooopen.com/images/20140604/sy_62331342149.jpg"
        };
        listView.setAdapter(new MyAdapter(str));
    }
    class MyAdapter extends BaseAdapter{
        private String[] str;
        public MyAdapter(String[] str) {
            this.str=str;
        }

        @Override
        public int getCount() {
            return str.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if(convertView==null){
                convertView=View.inflate(MainActivity.this,R.layout.item,null);
                holder=new ViewHolder();
                holder.imageView= (ImageView) convertView.findViewById(R.id.imageVeiw);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
                Glide.with(MainActivity.this)
                        .load(str[position])
                        .into(holder.imageView);

            return convertView;
        }
    }
    class ViewHolder{
        ImageView imageView;
    }
}
