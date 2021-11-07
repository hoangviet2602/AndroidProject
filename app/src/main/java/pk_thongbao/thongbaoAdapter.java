package pk_thongbao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

import java.util.List;

public class thongbaoAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<thongbao> thongbaoList;

    public thongbaoAdapter(Context context, int layout, List<thongbao> thongbaoList) {
        this.context = context;
        this.layout = layout;
        this.thongbaoList = thongbaoList;
    }

    @Override
    public int getCount() {
        return thongbaoList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView txtTen =  (TextView) view.findViewById(R.id.textviewTen);
        TextView txtMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);

        thongbao thongbao = thongbaoList.get(i);
        txtTen.setText(thongbao.getTen());
        txtMoTa.setText(thongbao.getMoTa());
        imgHinh.setImageResource(thongbao.getHinh());

        return view;
    }
}
