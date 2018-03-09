package com.example.mani.hash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AllSchemes extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Schemes> sehmesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_schemes);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sehmesList = new ArrayList<>();

        sehmesList.add(new Schemes("JANANI SURAKSHA YOJANA (JSY)","The scheme focuses on the poor pregnant woman with special dispensation for states having low institutional delivery rates namely the states of Uttar Pradesh, Uttaranchal, Bihar, Jharkhand, Madhya Pradesh, Chhattisgarh, Assam, Rajasthan, Orissa and Jammu and Kashmir.\n" +
                "\n" + "While these states have been named as Low Performing States (LPS), the remaining states have been named as High performing States \n" +
                "(HPS).\n","1. All pregnant women delivering in Government health centres like Sub-centre, PHC/CHC/ FRU / general wards of District and state Hospitals or accredited private institutions HPS States.\n" +
                "\n" + "2. BPL pregnant women, aged 19 years and above.\n" +
                "\n" + "3.All  SC  and  ST  women delivering  in  a  government  health centre  like  Sub-centre,  PHC/CHC/  FRU  /  general  ward\n" +
                "of District and state Hospitals or accredited private institutions.",
                "Mothers in Rural Areas from LPS will be provided a package of Rs.1400 and for HPS it is Rs.700.\n" +
                        "\n" + "In Urban Areas, Mothers from LPS will be provided a package of Rs.1000 and for HPS it is Rs.600.",
                "Mother who fullfill above criteria can contact with their local ASHA.\n" +
                        "\n" +
                        "The Yojana has identified ASHA, the accredited social health activist as an effective link between the Government and the poor pregnant women in l0 low performing states, namely the 8 EAG states and Assam and J&K and the remaining NE States. In ot\n" +
                        "her eligible states and UTs, wherever,AWW and TBAs or ASHA like activist has been engaged in this purpose, she can be associated with this Yojana for providing the services.",
                "null","http://ayushmanbharat.net/wp-content/uploads/2018/02/JSR.pdf"));


        sehmesList.add(new Schemes("Congress Safai Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Jai Hind","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Engineering","A","d",
                "w","w","d","d"));

        sehmesList.add(new Schemes("All India Berojgar Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Congress Safai Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Jai Hind","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Engineering","A","d",
                "w","w","d","d"));

        sehmesList.add(new Schemes("All India Berojgar Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Congress Safai Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Jai Hind","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Engineering","A","d",
                "w","w","d","d"));

        sehmesList.add(new Schemes("All India Berojgar Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Congress Safai Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Jai Hind","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Engineering","A","d",
                "w","w","d","d"));

        sehmesList.add(new Schemes("All India Berojgar Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Congress Safai Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Jai Hind","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Engineering","A","d",
                "w","w","d","d"));

        sehmesList.add(new Schemes("All India Berojgar Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Congress Safai Yojna","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Jai Hind","A","d",
                "w","w","d","d"));
        sehmesList.add(new Schemes("Engineering","A","d",
                "w","w","d","d"));

        SchemesAdapter adapter = new SchemesAdapter(AllSchemes.this,sehmesList);
        recyclerView.setAdapter(adapter);
    }
}
