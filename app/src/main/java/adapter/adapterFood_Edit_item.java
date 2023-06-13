package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FoodItamBinding;

import java.util.List;

import DataBase.DataBase_food;
import DataBase.Food;

public class adapterFood_Edit_item extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Food> recycleFoods;
    onclick onclick;
    FoodItamBinding binding;
    DataBase_food dataBase_food;

    public adapterFood_Edit_item(Context context, List<Food> recycleFoods, onclick onclick) {
        this.context = context;
        this.recycleFoods = recycleFoods;
        this.onclick = onclick ;
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
        myViewHolder.binding.evaluate.setText(recycleFoods.get(position).getRate());
        myViewHolder.binding.Price.setText(recycleFoods.get(position).getPrice());
        myViewHolder.binding.title.setText(recycleFoods.get(position).getName());




        myViewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             onclick.onitem(position);
            }
        });




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
    public interface  onclick{
        void  onitem(int position);
    }
}
