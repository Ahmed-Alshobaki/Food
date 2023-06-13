package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FoodItamBinding;
import com.example.myapplication.databinding.UsersAdminBinding;

import java.util.List;

import DataBase.DataBase_food;
import DataBase.Food;
import DataBase.user;

public class adapterFood_veiw_users extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<user> recycleFoods;
    onclick onclick;
    UsersAdminBinding binding;
    DataBase_food dataBase_food;

    public adapterFood_veiw_users(Context context, List<user> recycleuser) {
        this.context = context;
        this.recycleFoods = recycleuser;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = UsersAdminBinding.inflate(LayoutInflater.from(context),parent,false);
        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        myViewHolder  myViewHolder= (myViewHolder) holder;
        myViewHolder.binding.NameSeen.setText(recycleFoods.get(position).getName());
        myViewHolder.binding.PasswordSeen.setText(recycleFoods.get(position).getPassword());
        myViewHolder.binding.EmailSeen.setText(recycleFoods.get(position).getEmail());





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
        UsersAdminBinding binding;


        public myViewHolder( UsersAdminBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

    }
    public interface  onclick{
        void  onitem(int position);
    }
}
