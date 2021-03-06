package knagent.com.reservations;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolders extends RecyclerView.ViewHolder{

    public TextView personName;
    public TextView personAddress;
    public ImageView personPhoto;
    public Button removeButton;

    public RecyclerViewHolders(View itemView) {
        super(itemView);

        personName = (TextView)itemView.findViewById(R.id.person_name);
        personAddress = (TextView)itemView.findViewById(R.id.person_address);
        personPhoto = (ImageView)itemView.findViewById(R.id.circleView);
        removeButton = (Button)itemView.findViewById(R.id.removeButton);
    }
}
