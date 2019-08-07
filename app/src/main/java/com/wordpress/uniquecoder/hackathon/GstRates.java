package com.wordpress.uniquecoder.hackathon;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Toast;

        import com.android.volley.AuthFailureError;
        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.HashMap;
        import java.util.Map;

public class GstRates extends AppCompatActivity {
    private static final String ROOT_URL = "http://ucdapeiron.heliohost.org/test/";
    public static final String GET_TAX_RATES = ROOT_URL+"findRate.php";
    public String sgst="18.",cgst="18.",hsn;
    GstRates(String hsn_code)
    {
        hsn = hsn_code;
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gst_rates);
//
//
//    }
    public void getData()
    {
        Toast.makeText(this, "getData() called", Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_TAX_RATES, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getString("error").equals("false"))
                    {
                        sgst = jsonObject.getString("sgst");
                        cgst = jsonObject.getString("cgst");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("hsn_code",hsn);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(GstRates.this);
        requestQueue.add(stringRequest);
    }

}