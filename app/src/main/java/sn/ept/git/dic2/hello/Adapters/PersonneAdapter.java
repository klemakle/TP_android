package sn.ept.git.dic2.hello.Adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sn.ept.git.dic2.hello.DetailActivity;
import sn.ept.git.dic2.hello.Models.Personne;
import sn.ept.git.dic2.hello.R;

public class PersonneAdapter extends RecyclerView.Adapter<PersonneAdapter.ViewHolder> {
    Context context;
    List<Personne> results;

    public PersonneAdapter(Context ctx, List<Personne> results) {
        this.results = results;
        this.context = ctx;
    }

    private OnItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_person, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Personne model = getPersonne(position);
        holder.tvPrenom.setText(model.getPrenom());
        holder.tvNom.setText(model.getNom());
        holder.tvEmail.setText(model.getEmail());
    }

    @Override
    public int getItemCount() {
        return this.results.size();
    }

    public void setResults(List<Personne> listP) {
        this.results = listP;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // textviews
        TextView tvPrenom, tvNom, tvEmail;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            // matching
            tvPrenom = itemView.findViewById(R.id.id_prenom);
            tvNom = itemView.findViewById(R.id.id_nom);
            tvEmail = itemView.findViewById(R.id.id_email);

            // listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = ViewHolder.this.getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(results.get(position));
                    }
                }
            });

        }
    }

    public Personne getPersonne(int position) {
        return results.get(position);
    }

    public interface OnItemClickListener {

        void onItemClick(Personne model);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
