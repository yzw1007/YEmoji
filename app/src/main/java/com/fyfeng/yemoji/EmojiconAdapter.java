package com.fyfeng.yemoji;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import io.github.rockerhieu.emojicon.EmojiconTextView;
import io.github.rockerhieu.emojicon.emoji.Emojicon;

public class EmojiconAdapter extends ArrayAdapter<Emojicon> {

    public EmojiconAdapter(@NonNull Context context, List<Emojicon> data) {
        super(context,R.layout.emojicon_item, data);
    }
    public EmojiconAdapter(Context context, Emojicon[] data) {
        super(context, R.layout.emojicon_item, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = View.inflate(getContext(), R.layout.emojicon_item, null);
            ViewHolder holder = new ViewHolder();
            holder.icon =  v.findViewById(R.id.emojicon_icon);
            holder.icon.setUseSystemDefault(false);
            v.setTag(holder);
        }
        Emojicon emoji = getItem(position);
        ViewHolder holder = (ViewHolder) v.getTag();
        holder.icon.setText(emoji.getEmoji());
        return v;
    }

    static class ViewHolder {
        EmojiconTextView icon;
    }
}
