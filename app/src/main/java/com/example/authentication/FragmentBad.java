package com.example.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentBad extends Fragment {
    View v;
    private RecyclerView bad_recyclerview;
    private List<Good> lstBad;

    public FragmentBad() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.bading_fragment,container,false);
        bad_recyclerview=(RecyclerView) v.findViewById(R.id.bad_recyclerview);
        RecyclerViewAdapter recyclerAdapter=new RecyclerViewAdapter(getContext(),lstBad);
        bad_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        bad_recyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstBad=new ArrayList<>();
        lstBad.add(new Good("Asam borat (boraks)","Boraks dalam makanan biasanya dimaksudkan sebagai pengeras, pengental, dan pengawet. Beberapa contoh makanan yang mengandungi boraks termasuk bebola daging, mi basah, keropok, dan ladu. Boraks adalah toksik kepada semua sel. Apabila tertelan sebatian ini boleh menyebabkan kesan negatif pada sistem saraf pusat, buah pinggang dan hati. Buah pinggang adalah organ yang paling cepat rosak berbanding organ lain. Di samping itu, ia boleh menyebabkan gejala yang lain termasuk ketidakselesaan badan (malaise), mual, sakit teruk di bahagian atas perut (epigastrik), pendarahan pada saluran pencernaan (gastroenteritis) disertai dengan muntah darah, cirit-birit, kelemahan, mengantuk, demam, dan rasa sakit kepala.",R.drawable.supplement_img));
        lstBad.add(new Good("Dietilpirokarbonat","Digunakan sebagai pengawet tetapi boleh menyebabkan barah.",R.drawable.supplement_img));
        lstBad.add(new Good("Dulsin","Pemanis tiruan dengan rasa manis 250 kali ganda daripada sukrosa. Hasil percubaan pada haiwan menunjukkan bahawa dulsin boleh menyebabkan barah.",R.drawable.supplement_img));
        lstBad.add(new Good("Formalin","Larutan tidak berwarna dan mempunyai bau yang kuat. Formalin digunakan sebagai pembunuh kuman sehingga digunakan untuk membersihkan lantai dan pakaian, penghalau serangga, bahan pembuatan baja dan minyak wangi, bahan pengawet produk kosmetik, dan pengawet mayat. Beberapa contoh produk makanan yang sering mengandungi formaldehid termasuk ikan segar, ayam, mi basah dan tauhu. kesan langsung terhadap kesihatan manusia termasuk kerengsaan, alergi, kemerahan, mata berair, mual, muntah, terbakar, sakit perut dan pening.",R.drawable.supplement_img));
        lstBad.add(new Good("Kalium bromat","Penggunaannya dalam makanan dan minuman boleh membahayakan kesihatan kerana bersifat karsinogenik.",R.drawable.supplement_img));
        lstBad.add(new Good("Auramine","Berdasarkan kajian epidemiologi pada manusia menunjukkan bahawa pewarna auramine dapat meningkatkan risiko barah pundi kencing dan prostat.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna kuning mentega","Bersifat karsinogenik pada tikus, menghasilkan tumor hati, sedangkan pada anjing menyebabkan tumor pundi kencing.",R.drawable.supplement_img));
        lstBad.add(new Good("Black 7984","Pewarna coklat atau hitam, boleh menyebabkan reaksi alergi dan intoleransi, terutama pada orang yang tidak toleran terhadap aspirin selain boleh memburukkan lagi gejala asma.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna Chrysoidine","Bersifat karsinogenik kepada manusia dan beracun kepada saluran pencernaan dan hati.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna Citrus Red No 2","Mempunyai sifat karsinogenik pada tikus. Selepas pemberian oral, sebatian ini menghasilkan tumor hiperplasia dan pundi kencing. Pemberian subkutan menghasilkan adenokarsinoma (tumor jinak yang berasal dari kelenjar) dan limfosarcomas (tumor limfa) pada tikus betina. Kemungkinan penyebab barah pada manusia.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna Chocolate Brown FB","Tidak ada penemuan keracunan dan pengaruhnya terhadap kadar kematian, berat badan, berat organ dan petunjuk tumor pada dos hingga 2000 mg setiap hari pada tikus. Walau bagaimanapun, deposit pigmen dijumpai di beberapa organ badan pada dos melebihi 3000 mg / kg berat badan.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna CI Basic Red 9","Digunakan sebagai pewarna untuk serat tekstil, penyediaan pigmen untuk mencetak dakwat. Merupakan bahan karsinogenik kerana telah dikenal pasti menyebabkan barah pundi kencing.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna Metanil Yellow","Biasa digunakan dalam industri tekstil, cat, kertas dan kulit binatang, petunjuk reaksi peneutralan (asid-basa). Metanil kuning boleh menyebabkan rasa mual, muntah, sakit perut, cirit-birit, panas, tidak selesa dan tekanan darah. Jangka panjang boleh menyebabkan barah pundi kencing.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna Oil Orange SS","Berbahaya jika ditelan atau diserap oleh kulit. Karsinogenik pada haiwan. Disyaki sebagai karsinogen manusia.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna Orange G","Berbahaya sekiranya tertelan, disedut atau diserap melalui kulit. Kemungkinan iritasi pada kulit, mata dan saluran gastrousus. Bersifat tumorigen dan mutagen.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna Ponceau SX","Dapat menyebabkan kerosakan pada sistem urin.",R.drawable.supplement_img));
        lstBad.add(new Good("Zat warna Rhodamin B","Bersifat karsinogenik. Digunakan sebagai pewarna untuk kertas, tekstil (sutera, bulu, kapas), sabun, kayu, plastik dan kulit, sebagai reagen di makmal untuk menguji antimoni, kobalt, niobium, emas, mangan, merkuri, tantalum dan tungsten, dan digunakan untuk pewarna biologi. Rhodamine B dapat terkumpul dalam lemak sehingga dari masa ke masa jumlahnya akan terus meningkat. Rhodamine B lebih banyak diserap dalam saluran pencernaan dan menunjukkan ikatan protein yang kuat. Kerosakan pada hati tikus disebabkan oleh makanan yang mengandungi kepekatan rhodamine B. yang tinggi. Pendedahan yang lama terhadap Rhodamine B boleh menyebabkan hati gagal berfungsi dan barah hati.",R.drawable.supplement_img));
        lstBad.add(new Good("Magenta I, Magenta II, Magenta III, Ponceau 3R, Sudan I serta Benzyl violet 6B","Adalah pewarna yang mempunyai sifat karsinogenik, yang menyebabkan barah pada manusia.",R.drawable.supplement_img));
    }
}
