package com.example.usuario.appturistico.mapas;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.appturistico.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link sitio2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link sitio2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sitio2 extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootview;
    private GoogleMap googleMap;
    private GoogleMap googleMap1;
    private  GoogleMap googleMap2;
    private MapView mapView;
    private TextView btnprueba;
    private List<Address> address;
    private Geocoder geocoder;

    private OnFragmentInteractionListener mListener;


    public sitio2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Hoteles.
     */
    // TODO: Rename and change types and number of parameters
    public static sitio2 newInstance(String param1, String param2) {
        sitio2 fragment = new sitio2();
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
        // Inflate the layout for this fragment
      rootview =  inflater.inflate(R.layout.fragment_hoteles, container, false);


      return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView   = (MapView)rootview.findViewById(R.id.maps);
        if(mapView !=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }







    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
        googleMap1 = googleMap;
        googleMap2 = googleMap;




            CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

            LatLng Bogota = new LatLng(5.755128,-72.908522);
            googleMap.addMarker(new MarkerOptions().position(Bogota).title("Estoy aqui").snippet("cra 12").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_logo)).draggable(true));


        LatLng sitio2 = new LatLng(5.757749, -72.906590);
        googleMap.addMarker(new MarkerOptions().position(sitio2).title("sitio 2").snippet("cra 13").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_sitio3)).draggable(true));
        googleMap2.moveCamera(CameraUpdateFactory.newLatLng(sitio2));



            googleMap.animateCamera(zoom);
            googleMap.setOnMarkerDragListener(this);

            geocoder = new Geocoder(getContext(), Locale.getDefault());




        LatLng paso1 = new LatLng(5.755699, -72.907970);
        LatLng paso2 = new LatLng(5.756349, -72.907544);
        LatLng paso3 = new LatLng( 5.756989, -72.907050);


        Polyline line = googleMap.addPolyline(new PolylineOptions()
                .add(Bogota,paso1,paso2,paso3,sitio2)
                .width(5)
                .color(Color.RED));















    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
