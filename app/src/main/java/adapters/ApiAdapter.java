package adapters;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quantum.rerevise.R;

import java.util.ArrayList;
import java.util.List;

import model.ApiModel;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {

    private List<ApiModel> apiModelList=new ArrayList<>();

    public void setList(List<ApiModel> list){
        apiModelList=list;
    }


    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.api_item_layout,parent,false);
        return new ApiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
        ApiModel apiModel=apiModelList.get(position);
        holder.title.setText(apiModel.getTitle());
        holder.body.setText(apiModel.getBody());

    }

    @Override
    public int getItemCount() {
        return apiModelList.size();
    }

    public class ApiViewHolder extends RecyclerView.ViewHolder {

        public TextView title,body;

        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title_text);
            body=itemView.findViewById(R.id.body_text);

        }
    }
}
