package com.example.authentication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentGood extends Fragment {
    View v;
    private RecyclerView good_recyclerview;
    private List<Good> lstGood;

    public FragmentGood() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.gooding_fragment,container,false);
        good_recyclerview=(RecyclerView) v.findViewById(R.id.good_recyclerview);
        RecyclerViewAdapter recyclerAdapter=new RecyclerViewAdapter(getContext(),lstGood);
        good_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        good_recyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstGood=new ArrayList<>();
        lstGood.add(new Good("Vitamin C","Vitamin C, juga dikenali sebagai asid askorbik. Ia penting untuk pembentukan dan pengekalan kolagen, iaitu sejenis protein yang mengukuhkan kedudukan sel badan. Ia sangat mustahak untuk tulang dan gigi, untuk pembuluh darah, dan penyembuhan luka. Vitamin C juga membantu dalam proses metabolisma beberapa jenis asid amino dan hormon. Vitamin C juga membantu dalam proses metabolisma beberapa jenis asid amino dan hormon.",R.drawable.supplement_img));
        lstGood.add(new Good("Vitamin A","Membantu tumbesaran kanak-kanak yang sempurna, penglihatan yang baik (mencegah dan kadang-kala memulihkan rabun malam) untuk kanak-kanak dan orang dewasa, dan kulit yang sihat",R.drawable.supplement_img));
        lstGood.add(new Good("Vitamin B12","Vitamin B12 atau Cobalamin, dalam kombinasi dengan Folacin (Vitamin B12 juga dikenali sebagai Asid Folik). Ia digunakan dalam pembentukan sel darah merah dan juga membantu dan mengekalkan pelindung selaput saraf.",R.drawable.supplement_img));

    }

}
