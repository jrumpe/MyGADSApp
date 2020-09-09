package com.example.mygadsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.mygadsapp.R;
import com.example.mygadsapp.models.BaseModel;
import com.example.mygadsapp.models.LearnerLeadersModel;
import com.example.mygadsapp.models.SkillIQModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecAdapter extends Adapter {

    Context context;
    List<BaseModel> baseModelList;

    public MyRecAdapter(Context context, List<BaseModel> baseModelList) {
        this.context = context;
        this.baseModelList = baseModelList;
    }

    @Override
    public int getItemViewType(int position) {
        if (baseModelList.get(position) instanceof LearnerLeadersModel)
            return 0;
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_learner, parent, false);
            return new LearnerLeaderVH(view);
        }
        view = LayoutInflater.from(context).inflate(R.layout.layout_skilliq, parent, false);
        return new SkillIQVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BaseModel baseModel = baseModelList.get(position);
        if (holder instanceof LearnerLeaderVH) {
            LearnerLeadersModel learnerLeadersModel = (LearnerLeadersModel) baseModel;
            Picasso.get().load(learnerLeadersModel.getImageurl()).into(((LearnerLeaderVH) holder).img);
            ((LearnerLeaderVH) holder).learnerName.setText(learnerLeadersModel.getName());
            ((LearnerLeaderVH) holder).learningHours.setText(String.format("%s learning hours, %s", learnerLeadersModel.getHours(), learnerLeadersModel.getCountry()));
            return;
        }

        if (holder instanceof SkillIQVH) {
            SkillIQModel skillIQModel = (SkillIQModel) baseModel;
            Picasso.get().load(skillIQModel.getImageurl()).into(((SkillIQVH) holder).img);
            ((SkillIQVH) holder).name.setText(skillIQModel.getName());
            ((SkillIQVH) holder).iqScore.setText(String.format("%s Skill IQ Score, %s", skillIQModel.getScore(), skillIQModel.getCountry()));
        }
    }

    @Override
    public int getItemCount() {
        return baseModelList.size();
    }


    static class LearnerLeaderVH extends RecyclerView.ViewHolder {
        public LearnerLeaderVH(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            learnerName = (TextView) itemView.findViewById(R.id.learner_name);
            learningHours = (TextView) itemView.findViewById(R.id.learning_hours);
        }

        ImageView img;
        TextView learnerName;
        TextView learningHours;

    }

    static class SkillIQVH extends RecyclerView.ViewHolder {
        public SkillIQVH(@NonNull View convertView) {
            super(convertView);
            img = (ImageView) convertView.findViewById(R.id.img);
            name = (TextView) convertView.findViewById(R.id.name);
            iqScore = (TextView) convertView.findViewById(R.id.iq_score);
        }

        ImageView img;
        TextView name;
        TextView iqScore;
    }

}
