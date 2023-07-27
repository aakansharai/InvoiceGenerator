package com.example.pdfgenerater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.textclassifier.TextLanguage;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class pdf_layout_1 extends AppCompatActivity {

    TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_layout1);

        id = findViewById(R.id.id);

        Toast.makeText(this, "Target Down Successfully!!", Toast.LENGTH_SHORT).show();

        String data = "{\n" +
                "  \"AIR\" : {\n" +
                "    \"tripInfos\" : [\n" +
                "      {\n" +
                "        \"sI\" : [\n" +
                "          {\n" +
                "            \"id\" : \"139520\" ,\n" +
                "            \"fD\" : {\n" +
                "              \"aI\" : {\n" +
                "                \"code\" : \"6E\" ,\n" +
                "                \"name\" : \"IndiGo\" ,\n" +
                "                \"isLcc\" : true\n" +
                "              } ,\n" +
                "              \"fN\" : \"7175\" ,\n" +
                "              \"eT\" : \"ATR\"\n" +
                "            } ,\n" +
                "            \"stops\" : 0 ,\n" +
                "            \"duration\" : 55 ,\n" +
                "            \"cT\" : 85 ,\n" +
                "            \"da\" : {\n" +
                "              \"code\" : \"IDR\" ,\n" +
                "              \"name\" : \"Devi Ahilya Bai Holkar Arpt\" ,\n" +
                "              \"cityCode\" : \"IDR\" ,\n" +
                "              \"city\" : \"Indore\" ,\n" +
                "              \"country\" : \"India\" ,\n" +
                "              \"countryCode\" : \"IN\"\n" +
                "            } ,\n" +
                "            \"aa\" : {\n" +
                "              \"code\" : \"AMD\" ,\n" +
                "              \"name\" : \"Sardar Vallabh Bhai Patel Intl Arpt\" ,\n" +
                "              \"cityCode\" : \"AMD\" ,\n" +
                "              \"city\" : \"Ahmedabad\" ,\n" +
                "              \"country\" : \"India\" ,\n" +
                "              \"countryCode\" : \"IN\" ,\n" +
                "              \"terminal\" : \"Terminal 1\"\n" +
                "            } ,\n" +
                "            \"dt\" : \"2023-08-13T06:45\" ,\n" +
                "            \"at\" : \"2023-08-13T07:40\" ,\n" +
                "            \"iand\" : false ,\n" +
                "            \"isRs\" : false ,\n" +
                "            \"sN\" : 0\n" +
                "          } ,\n" +
                "          {\n" +
                "            \"id\" : \"139521\" ,\n" +
                "            \"fD\" : {\n" +
                "              \"aI\" : {\n" +
                "                \"code\" : \"6E\" ,\n" +
                "                \"name\" : \"IndiGo\" ,\n" +
                "                \"isLcc\" : true\n" +
                "              } ,\n" +
                "              \"fN\" : \"265\" ,\n" +
                "              \"eT\" : \"320\"\n" +
                "            } ,\n" +
                "            \"stops\" : 0 ,\n" +
                "            \"duration\" : 110 ,\n" +
                "            \"da\" : {\n" +
                "              \"code\" : \"AMD\" ,\n" +
                "              \"name\" : \"Sardar Vallabh Bhai Patel Intl Arpt\" ,\n" +
                "              \"cityCode\" : \"AMD\" ,\n" +
                "              \"city\" : \"Ahmedabad\" ,\n" +
                "              \"country\" : \"India\" ,\n" +
                "              \"countryCode\" : \"IN\" ,\n" +
                "              \"terminal\" : \"Terminal 1\"\n" +
                "            } ,\n" +
                "            \"aa\" : {\n" +
                "              \"code\" : \"SXR\" ,\n" +
                "              \"name\" : \"Srinagar Arpt\" ,\n" +
                "              \"cityCode\" : \"SXR\" ,\n" +
                "              \"city\" : \"Srinagar\" ,\n" +
                "              \"country\" : \"India\" ,\n" +
                "              \"countryCode\" : \"IN\"\n" +
                "            } ,\n" +
                "            \"dt\" : \"2023-08-13T09:05\" ,\n" +
                "            \"at\" : \"2023-08-13T10:55\" ,\n" +
                "            \"iand\" : false ,\n" +
                "            \"isRs\" : false ,\n" +
                "            \"sN\" : 1\n" +
                "          }\n" +
                "        ]\n" +
                "      } ,\n" +
                "      {\n" +
                "        \"sI\" : [\n" +
                "          {\n" +
                "            \"id\" : \"139522\" ,\n" +
                "            \"fD\" : {\n" +
                "              \"aI\" : {\n" +
                "                \"code\" : \"6E\" ,\n" +
                "                \"name\" : \"IndiGo\" ,\n" +
                "                \"isLcc\" : true\n" +
                "              } ,\n" +
                "              \"fN\" : \"6655\" ,\n" +
                "              \"eT\" : \"320\"\n" +
                "            } ,\n" +
                "            \"stops\" : 0 ,\n" +
                "            \"duration\" : 95 ,\n" +
                "            \"cT\" : 120 ,\n" +
                "            \"da\" : {\n" +
                "              \"code\" : \"SXR\" ,\n" +
                "              \"name\" : \"Srinagar Arpt\" ,\n" +
                "              \"cityCode\" : \"SXR\" ,\n" +
                "              \"city\" : \"Srinagar\" ,\n" +
                "              \"country\" : \"India\" ,\n" +
                "              \"countryCode\" : \"IN\"\n" +
                "            } ,\n" +
                "            \"aa\" : {\n" +
                "              \"code\" : \"DEL\" ,\n" +
                "              \"name\" : \"Delhi Indira Gandhi Intl\" ,\n" +
                "              \"cityCode\" : \"DEL\" ,\n" +
                "              \"city\" : \"Delhi\" ,\n" +
                "              \"country\" : \"India\" ,\n" +
                "              \"countryCode\" : \"IN\" ,\n" +
                "              \"terminal\" : \"Terminal 1\"\n" +
                "            } ,\n" +
                "            \"dt\" : \"2023-08-16T11:45\" ,\n" +
                "            \"at\" : \"2023-08-16T13:20\" ,\n" +
                "            \"iand\" : false ,\n" +
                "            \"isRs\" : true ,\n" +
                "            \"sN\" : 0\n" +
                "          } ,\n" +
                "          {\n" +
                "            \"id\" : \"139523\" ,\n" +
                "            \"fD\" : {\n" +
                "              \"aI\" : {\n" +
                "                \"code\" : \"6E\" ,\n" +
                "                \"name\" : \"IndiGo\" ,\n" +
                "                \"isLcc\" : true\n" +
                "              } ,\n" +
                "              \"fN\" : \"6241\" ,\n" +
                "              \"eT\" : \"320\"\n" +
                "            } ,\n" +
                "            \"stops\" : 0 ,\n" +
                "            \"duration\" : 85 ,\n" +
                "            \"da\" : {\n" +
                "              \"code\" : \"DEL\" ,\n" +
                "              \"name\" : \"Delhi Indira Gandhi Intl\" ,\n" +
                "              \"cityCode\" : \"DEL\" ,\n" +
                "              \"city\" : \"Delhi\" ,\n" +
                "              \"country\" : \"India\" ,\n" +
                "              \"countryCode\" : \"IN\" ,\n" +
                "              \"terminal\" : \"Terminal 1\"\n" +
                "            } ,\n" +
                "            \"aa\" : {\n" +
                "              \"code\" : \"IDR\" ,\n" +
                "              \"name\" : \"Devi Ahilya Bai Holkar Arpt\" ,\n" +
                "              \"cityCode\" : \"IDR\" ,\n" +
                "              \"city\" : \"Indore\" ,\n" +
                "              \"country\" : \"India\" ,\n" +
                "              \"countryCode\" : \"IN\"\n" +
                "            } ,\n" +
                "            \"dt\" : \"2023-08-16T15:20\" ,\n" +
                "            \"at\" : \"2023-08-16T16:45\" ,\n" +
                "            \"iand\" : false ,\n" +
                "            \"isRs\" : true ,\n" +
                "            \"sN\" : 1\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ] ,\n" +
                "    \"travellerInfos\" : [\n" +
                "      {\n" +
                "        \"pnrDetails\" : {\n" +
                "          \"IDR-AMD\" : \"TESTPNR\" ,\n" +
                "          \"AMD-SXR\" : \"TESTPNR\" ,\n" +
                "          \"SXR-DEL\" : \"TESTPNR\" ,\n" +
                "          \"DEL-IDR\" : \"TESTPNR\"\n" +
                "        } ,\n" +
                "        \"ti\" : \"Mr\" ,\n" +
                "        \"pt\" : \"ADULT\" ,\n" +
                "        \"fN\" : \"Meet\" ,\n" +
                "        \"lN\" : \"Vani\" ,\n" +
                "        \"dob\" : \"1999-03-29\"\n" +
                "      }\n" +
                "    ] ,\n" +
                "    \"totalPriceInfo\" : {\n" +
                "      \"totalFareDetail\" : {\n" +
                "        \"fC\" : {\n" +
                "          \"IGST\" : 5.40 ,\n" +
                "          \"NF\" : 17292.40 ,\n" +
                "          \"BF\" : 15003.00 ,\n" +
                "          \"TAF\" : 2289.40 ,\n" +
                "          \"TF\" : 17292.40\n" +
                "        } ,\n" +
                "        \"afC\" : {\n" +
                "          \"TAF\" : {\n" +
                "            \"OT\" : 1493.00 ,\n" +
                "            \"YQ\" : 0.00 ,\n" +
                "            \"MF\" : 30.00 ,\n" +
                "            \"AGST\" : 761.00 ,\n" +
                "            \"MFT\" : 5.40\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    } ,\n" +
                "    \"isara\" : false\n" +
                "  }\n" +
                "}";

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(data, new TypeToken<JsonObject>() {
        }.getType());

        JsonArray jsonElements = jsonObject.getAsJsonObject("AIR").getAsJsonArray("tripInfos").get(0).getAsJsonObject().getAsJsonArray("sI");
        JsonObject firstSI = jsonElements.get(0).getAsJsonObject();
        String idN = firstSI.get("id").getAsString();

        id.setText(idN);

        Log.e("DATA" , idN);

    }
}