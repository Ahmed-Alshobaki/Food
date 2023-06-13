package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.EditItamFoodBinding;
import com.example.myapplication.databinding.FoodItamBinding;

import java.util.List;

import DataBase.DataBase_food;
import DataBase.Food;

public class adapterFood_Edit_item_Admin extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Food> Food_Edit_item;
    onclick onclick;
    EditItamFoodBinding binding;
    DataBase_food dataBase_food;

    public adapterFood_Edit_item_Admin(Context context, List<Food> Food_Edit_item, onclick onclick) {
        this.context = context;
        this.Food_Edit_item = Food_Edit_item;
        this.onclick = onclick ;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = EditItamFoodBinding.inflate(LayoutInflater.from(context),parent,false);
        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        myViewHolder  myViewHolder= (myViewHolder) holder;
        myViewHolder.binding.description.setText(Food_Edit_item.get(position).getDescription());
        myViewHolder.binding.evaluate.setText(Food_Edit_item.get(position).getRate());
        myViewHolder.binding.Price.setText(Food_Edit_item.get(position).getPrice());
        myViewHolder.binding.title.setText(Food_Edit_item.get(position).getName());
        myViewHolder.binding.IdNumber.setText(Food_Edit_item.get(position).getId());
        myViewHolder.binding.ImageFood.setImageBitmap(Food_Edit_item.get(position).getImage());
        myViewHolder.binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBase_food =new DataBase_food(v.getContext());
            dataBase_food.deleteFoodById(Food_Edit_item.get(position).getId());

                Food_Edit_item.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, Food_Edit_item.size());
            }
        });





        myViewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             onclick.onitem(position);
            }
        });




    }

    @Override
    public int getItemCount() {
        return Food_Edit_item.size();
    }
    public class myViewHolder extends RecyclerView.ViewHolder{
        EditItamFoodBinding binding;


        public myViewHolder( EditItamFoodBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

    }
    public interface  onclick{
        void  onitem(int position);
    }
}
