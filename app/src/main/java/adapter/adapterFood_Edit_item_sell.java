package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.EditItamFoodBinding;
import com.example.myapplication.databinding.ItamSellFoodBinding;

import java.util.List;

import DataBase.DataBase_food;
import DataBase.Food;

public class adapterFood_Edit_item_sell extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Food> Food_Edit_item;
    onclick onclick;
    ItamSellFoodBinding binding;
    DataBase_food dataBase_food;

    public adapterFood_Edit_item_sell(Context context, List<Food> Food_Edit_item, onclick onclick) {
        this.context = context;
        this.Food_Edit_item = Food_Edit_item;
        this.onclick = onclick ;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItamSellFoodBinding.inflate(LayoutInflater.from(context),parent,false);
        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        myViewHolder  myViewHolder= (myViewHolder) holder;
        myViewHolder.binding.DESCRIPTION.setText(Food_Edit_item.get(position).getDescription());
        myViewHolder.binding.PRICE.setText(Food_Edit_item.get(position).getPrice());
        myViewHolder.binding.name.setText(Food_Edit_item.get(position).getName());
        DataBase_food dataBase_food= new DataBase_food(context.getApplicationContext());
        binding.imageView3.setImageBitmap(dataBase_food.getbyteBitmap(dataBase_food.getImageById(Food_Edit_item.get(position).getId())));






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
        ItamSellFoodBinding binding;


        public myViewHolder( ItamSellFoodBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

    }
    public interface  onclick{
        void  onitem(int position);
    }
}
