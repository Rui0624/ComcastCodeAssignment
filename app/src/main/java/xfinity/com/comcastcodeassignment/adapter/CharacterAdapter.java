package xfinity.com.comcastcodeassignment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import xfinity.com.comcastcodeassignment.R;
import xfinity.com.comcastcodeassignment.model.CharacterModel;
import xfinity.com.comcastcodeassignment.utils.CharacterSpliter;

/**
 * CharacterAdapter is used into the RecyclerView for both grid view or list view
 */
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> implements View.OnClickListener {

    private final Context context;
    private final List<CharacterModel> data;
    private OnItemClicked mOnItemClicked;

    private static final int GRID_VIEW = 0;
    private static final int LIST_VIEW = 1;

    public interface OnItemClicked {
        void onItemClicked(View view, CharacterModel characterModel);
    }

    public void setOnItemClickedListener(OnItemClicked mOnItemClicked) {
        this.mOnItemClicked = mOnItemClicked;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClicked != null) {
            int idx = (Integer) v.getTag();
            mOnItemClicked.onItemClicked( v, data.get( idx ) );
        }
    }

    /**
     * The constructor to define the adatper
     *
     * @param context pass the context into adapter
     * @param data the data should be display in the recyclerview
     */
    public CharacterAdapter(Context context, List<CharacterModel> data) {
        this.context = context;
        this.data = data;
    }


    /**
     * The getItemViewType is used to check the viewType
     *
     * @param position check each of item setted as grid or list
     * @return the view type as int
     */
    @Override
    public int getItemViewType(int position) {
        return data.get( position ).isUseGrid() ? GRID_VIEW : LIST_VIEW;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = viewType == GRID_VIEW ?
                LayoutInflater.from( context ).inflate( R.layout.item_grid, parent, false )
                : LayoutInflater.from( context ).inflate( R.layout.item_list, parent, false );
        return new CharacterViewHolder( view );
    }

    /**
     * Bind the ViewHolder with each of data
     *
     * @param holder viewholder to be bound
     * @param position the position in the data list
     */
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        if (holder.iv_itemImage != null) {

            if (!TextUtils.isEmpty( data.get( position ).getIcon().getUrl() )) {
                Picasso.get()
                        .load( data.get( position ).getIcon().getUrl() )
                        .placeholder( R.drawable.image_not_available )
                        .into( holder.iv_itemImage );
            }

        } else {
            holder.tv_itemTitle.setText( CharacterSpliter.splitTitleDes( data.get( position ).getText() ).get( 0 ) );
        }
        holder.itemView.setTag( position );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * CharacterViewHolder is used to define the each of item in the recyclerview
     */
    class CharacterViewHolder extends RecyclerView.ViewHolder {
        final TextView tv_itemTitle;
        final ImageView iv_itemImage;

        CharacterViewHolder(@NonNull View itemView) {
            super( itemView );

            tv_itemTitle = itemView.findViewById( R.id.tv_itemTitle );
            iv_itemImage = itemView.findViewById( R.id.iv_itemImage );

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (tv_itemTitle != null) {
                        mOnItemClicked.onItemClicked( tv_itemTitle, data.get( getLayoutPosition() ) );
                    } else {
                        mOnItemClicked.onItemClicked( iv_itemImage, data.get( getLayoutPosition() ) );
                    }
                }
            } );
        }
    }
}
