package in.andriod.heady.assessmenttest;



import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterTopStories extends RecyclerView.Adapter<AdapterTopStories.StoriesViewHolder> {


    private ArrayList<TopStories> mListTopStories;



    public AdapterTopStories (ArrayList<TopStories> listTopStories){

        mListTopStories = listTopStories;
    }




    public class StoriesViewHolder extends RecyclerView.ViewHolder {


        private TextView mSection, mTitle,mDesc,mPublished;

        public StoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            mSection = itemView.findViewById(R.id.story_Section);
            mTitle = itemView.findViewById(R.id.story_Title);
            mDesc = itemView.findViewById(R.id.story_Desc);
            mPublished =itemView.findViewById(R.id.story_Published);



        }
    }


    @Override
    public int getItemCount() {
        if (mListTopStories != null) {


            return mListTopStories.size();

        }

        return 0;
    }

        @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View view = layoutInflater.inflate(R.layout.top_stories,viewGroup,false);

        return new StoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder storiesViewHolder, int position) {

        TopStories topStories = mListTopStories.get(position);

        storiesViewHolder.mSection.setText(topStories.getSection());
        storiesViewHolder.mTitle.setText(topStories.getTitle());
        storiesViewHolder.mDesc.setText(topStories.getDesc());
        storiesViewHolder.mPublished.setText(topStories.getPublished());

    }

}



