package com.trios.wesamrestaurant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuListFragment extends ListFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
String[]dishesList= {"Malted Custard French Toast",
        "Braised Leeks with Mozzarella & a Fried Egg",
        "Island Duck with Mulberry Mustard",
        "Lamb Salad with Fregola",
        "Pappardelle with Sea Urchin and Cauliflower",
        "Pasta with Lamb Ragù",
        "Pork Rillette Hand Pies",
        "Scallop Sashimi with Meyer Lemon Confit",
        "Smoked Pork Jowl with Pickles",
        "Vegan Charcuterie"
};
String []dishDetails={"Dips thick brioche slices in a vanilla-and-malt-spiked custard,  the slices sous vide are slowly cooked in a hot-water bath so that every inch of the brioche absorbs the custard. the French toast is caramelized in a hot pan, then serves it with marinated fruit (quince in the winter), sweet citrus-flavored whipped cream and a sprinkling of pink peppercorns",
        "Terrific leek gratin, topped with mozzarella, a fried egg and mustardy bread crumbs",
        "only US ingredients are used for their Italian-American prix fixe dinner menuj, ducks come from Long Island, New York.  he succulent bird has a pungent, sweet mulberry-and-mustard-oil glaze. Broccoli, sesame crumbs, and mulberry mustard are added",
        "The roast lamb, sweet onions and arugula are all local; the chewy fregola and the capers in the salad's piquant dressing are not",
        "the paste is prepared with wheat that is stone-grounded every single day, the incredible \"just-ground\" pappardelle with sea urchin, cauliflower and crushed chile—a plate of silky pasta with briny seafood and a hint of heat",
        "large hollow pasta tubes (paccheri) are mixed with chunks of lamb, tomato ragù and grated Pecorino, the dish is finished with mint",
        "the delicious pork rillette–filled pork belly and shoulder are simmered with wine and garlic for hours, mixed until it's almost smooth and packs it into flaky pastry ",
        "a sliver of scallop sashimi with lightly sweet Meyer lemon confit, crunchy toasted buckwheat kernels and—pushing it over the top—tiny pieces of compressed apple, vacuum-packed to concentrate the flavor.",
        "the slowly smoking cured pork jowl over pecan wood and serves thin slices of the luscious meat as an appetizer with as many pickled ingredients as possible, including house-made half-sour pickles, pickled chiles and pickled mustard seeds stirred into the blackstrap-molasses garnish.",
        "fantastic roasted broccoli with a vegan version of the Italian tuna-based sauce tonnato (made here with seaweed and miso",
};
    String[]dishPrice = {"$23.99", "$19.99", "$23.99", "$39.99", "$35.99","$39.99", "$29.99", "$39.99", "$27.95", "$29.99" };
   String[]dishImage = {"maltedcustardfrenchtoast","leekapalooza",
            "islandduckwithmulberrymustard","lambsaladwithfregola",
            "pappardellewithsaeaurchinandcauliflower","pastawithlambragu",
            "porkrillettehandpies", "scallopsashimiwithmeyerlemonconfit",
            "smokedporkjowlwithpickles", "vegancharcuterie"};


    public MenuListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuListFragment newInstance(String param1, String param2) {
        MenuListFragment fragment = new MenuListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_menu_list, container, false);
        ArrayAdapter adapter = new ArrayAdapter(
                requireActivity(),
                android.R.layout.simple_list_item_1, dishesList);

        setListAdapter(adapter);
        return view;


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_menu_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l,View v,int position, long id) {
        super.onListItemClick(l, v, position, id);
        AboutFragment txt = (AboutFragment)getParentFragmentManager().findFragmentById(R.id.about_dish_fragment);
        txt.change("Dish Contents: "+dishDetails[position], "Price: "+ dishPrice[position], dishImage[position]);
        l.setSelector(android.R.color.holo_blue_dark);
    }

//    @Override
//    public void onListItemClick(ListView l,View v,  int position, Long id){
//        super.onListItemClick(l, v, position, id);
//        AboutFragment txt = (AboutFragment)getParentFragmentManager().findFragmentById(R.id.about_dish_fragment);
//        txt.change("Dish Contents: "+dishDetails[position], "Price: "+ dishPrice[position], dishImage[position]);
//        l.setSelector(android.R.color.holo_blue_dark);
//    }



}