package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FoodItamBinding;

import java.util.List;

public class adapterFood extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<recycleFood> recycleFoods;
    FoodItamBinding binding;

    public adapterFood(Context context, List<recycleFood> recycleFoods) {
        this.context = context;
        this.recycleFoods = recycleFoods;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = FoodItamBinding.inflate(LayoutInflater.from(context),parent,false);
        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        myViewHolder  myViewHolder= (myViewHolder) holder;
        myViewHolder.binding.description.setText(recycleFoods.get(position).getDescription());
        myViewHolder.binding.evaluate.setText(recycleFoods.get(position).getEvaluate());
        myViewHolder.binding.rate.setText(recycleFoods.get(position).getRate());
        myViewHolder.binding.title.setText(recycleFoods.get(position).getTitle());
        myViewHolder.binding.ImageFood.setImageResource(recycleFoods.get(position).getImageFood());
        myViewHolder.binding.ImageView.setImageResource(recycleFoods.get(position).getImageView());
        myViewHolder.binding.rateMane.setText(recycleFoods.get(position).getRate_mane());




    }

    @Override
    public int getItemCount() {
        return recycleFoods.size();
    }
    public class myViewHolder extends RecyclerView.ViewHolder{
    FoodItamBinding binding;


        public myViewHolder( FoodItamBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
