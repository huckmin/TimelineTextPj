package com.testing.kmin.timelinetextpj;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TapTwoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TapTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TapTwoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<ItemData> itemList = new ArrayList<ItemData>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TapTwoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TapTwoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TapTwoFragment newInstance(String param1, String param2) {
        TapTwoFragment fragment = new TapTwoFragment();
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
        View v = inflater.inflate(R.layout.fragment_tap_two, container, false);
        setDatas();
        recyclerView = v.findViewById(R.id.recycler_continert);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        mAdapter = new MyAdapter(getActivity().getApplicationContext(),itemList); //list를 넘겨준다.
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
//                    Toast.makeText(getApplicationContext(),"LAst",Toast.LENGTH_SHORT).show();
//bottom event
                    if(itemList.size() <= 9){
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "6번제목","2018년 1월 6일" ,"여섯번째 내용입니다.","" ));
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "7번제목","2018년 1월 7일" ,"일곱번째 내용입니다.","" ));
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "8번제목","2018년 1월 8일" ,"여덜번째 내용입니다.","" ));
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "9번제목","2018년 1월 9일" ,"아홉번째 내용입니다.","" ));
                        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "10번제목","2018년 1월 10일" ,"열번째 내용입니다.","" ));
                        mAdapter.notifyItemInserted(itemList.size()-1);
                    }

                }
            }
        });
        return v;
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

    private void setDatas(){
        try{
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            String urlString = "http://13.124.168.201:8000/timeline/";

            StringRequest stringRequest = new StringRequest(Request.Method.GET, urlString,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            try{
                                JSONArray nArr = new JSONArray(response.toString());
                                for(int i=nArr.length()-1 ; i >= 0 ; i--){
                                    itemList.add(new ItemData(nArr.getJSONObject(i)));
                                }
                                mAdapter.notifyItemInserted(itemList.size()-1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                            Log.d("response", "onResponse: " + response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(stringRequest);
        }catch(Exception e){

        }
//        SetTimeLineData setDatat = new SetTimeLineData();
//        setDatat.execute();
//        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "1번제목","2018년 1월 1일" ,"첫번째 내용입니다.",""  ));
//        String ur = "http://ww2.sjkoreancatholic.org/files/testing_image.jpg";
//        String ur2 = "http://cfs7.tistory.com/upload_control/download.blog?fhandle=YmxvZzgyMzM1QGZzNy50aXN0b3J5LmNvbTovYXR0YWNoLzAvMDYwMDAwMDAwMDAwLmpwZw%3D%3D";
//        itemList.add(new ItemData( ItemData.TYPE_COL_TWO, "2번제목","2018년 1월 2일" ,"두번째 내용입니다.","하고싶은"  ));
//        itemList.add(new ItemData( ItemData.TYPE_COL_TWO, "3번제목","2018년 1월 3일" ,"세번째 내용입니다.","먹고싶은"  ));
//        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "4번제목","2018년 1월 4일" ,"네번째 내용입니다.","", ur, ur2,""  ));
//        itemList.add(new ItemData( ItemData.TYPE_COL_ONE, "5번제목","2018년 1월 5일" ,"다섯번째 내용입니다.",""  ));
    }


//    class SetTimeLineData extends AsyncTask<String, String, JSONArray>{
//        @Override
//        protected void onPostExecute(JSONArray jsonArray) {
//            super.onPostExecute(jsonArray);
//        }
//
//        @Override
//        protected JSONArray doInBackground(String... strings) {
//            JSONArray jsonResArray = new JSONArray();
//            GetConnection conn = new GetConnection(getActivity());
//            String resStr = conn.sendRequest(null, null,null);
//
//            try{
//                jsonResArray = new JSONArray(resStr);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            Log.d("test", resStr);
//            return jsonResArray;
//        }
//    }


}
