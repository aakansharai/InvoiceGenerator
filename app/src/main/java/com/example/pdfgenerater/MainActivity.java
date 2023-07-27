package com.example.pdfgenerater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.pdfgenerater.Data.FlightData;
//import com.example.pdfgenerater.Data.Info;

import com.example.pdfgenerater.databinding.ActivityMainBinding;
import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {

//    Button generateBtn;
//    TextView title;
    RecyclerView recyclerView, recyclerForReturn;
    TextView basePrice, AirlineTaxesFee, ConvenientFee, TotalPaid;
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
            "      },\n" +
            "      {\n" +
            "        \"pnrDetails\" : {\n" +
            "          \"IDR-AMD\" : \"TESTPNR2\" ,\n" +
            "          \"AMD-SXR\" : \"TESTPNR\" ,\n" +
            "          \"SXR-DEL\" : \"TESTPNR\" ,\n" +
            "          \"DEL-IDR\" : \"TESTPNR\"\n" +
            "        } ,\n" +
            "        \"ti\" : \"Miss\" ,\n" +
            "        \"pt\" : \"ADULT\" ,\n" +
            "        \"fN\" : \"Tripti\" ,\n" +
            "        \"lN\" : \"Rai\" ,\n" +
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

    private PdfGenerator.XmlToPDFLifecycleObserver xmlToPDFLifecycleObserver;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

//        GetData();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(data, new TypeToken<JsonObject>() {
        }.getType());

        JsonArray jsonElements = jsonObject.getAsJsonObject("AIR").getAsJsonArray("tripInfos").get(0).getAsJsonObject().getAsJsonArray("sI");
        JsonArray length = jsonObject.getAsJsonObject("AIR").getAsJsonArray("tripInfos");

        JsonArray travellersInfo = jsonObject.getAsJsonObject("AIR").getAsJsonArray("travellerInfos");

        JsonObject firstSI = jsonElements.get(0).getAsJsonObject();


        recyclerView = activityMainBinding.recycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdapterSI1 adapterSI11 = new AdapterSI1(MainActivity.this, jsonElements, travellersInfo);
        recyclerView.setAdapter(adapterSI11);

        if(length.size()>1){
            JsonArray jsonSI2 = jsonObject.getAsJsonObject("AIR").getAsJsonArray("tripInfos").get(1).getAsJsonObject().getAsJsonArray("sI");

            recyclerForReturn = activityMainBinding.recyclerForPayment;
            recyclerForReturn.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            AdapterSI2 adapterSI2 = new AdapterSI2(MainActivity.this, jsonSI2, travellersInfo);
            recyclerForReturn.setAdapter(adapterSI2);
        }


        // PAYMENT - STRUCTURE --------------------

        JsonObject payment = jsonObject.getAsJsonObject("AIR").getAsJsonObject("totalPriceInfo").getAsJsonObject("totalFareDetail").getAsJsonObject("fC");
        basePrice = findViewById(R.id.basePrice);
        AirlineTaxesFee = findViewById(R.id.AirlineTaxAndFee);
        ConvenientFee = findViewById(R.id.ConvenientFee);
        TotalPaid = findViewById(R.id.totalFee);

        basePrice.setText("₹ "+payment.get("BF").getAsFloat());
        AirlineTaxesFee.setText("₹ "+payment.get("TAF").getAsFloat());
        ConvenientFee.setText("₹ "+payment.get("TAF").getAsFloat());
        TotalPaid.setText("₹ "+payment.get("TF").getAsFloat());


        float bPrice = payment.get("BF").getAsFloat();

        Toast.makeText(this, ""+bPrice, Toast.LENGTH_SHORT).show();

        // XML - PDF GENERATION PROCESS --------------------

        xmlToPDFLifecycleObserver = new PdfGenerator.XmlToPDFLifecycleObserver(this);
        getLifecycle().addObserver(xmlToPDFLifecycleObserver);

        activityMainBinding.generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityMainBinding.generate.setVisibility(View.GONE);
                generatePDF();
            }
        });

    }

//    private void GetData() {
//
//        Gson gson = new Gson();
//        JsonObject jsonObject = gson.fromJson(data, new TypeToken<JsonObject>() {
//        }.getType());
//
//        JsonArray jsonElements = jsonObject.getAsJsonObject("AIR").getAsJsonArray("tripInfos").get(0).getAsJsonObject().getAsJsonArray("sI");
//
//        JsonObject firstSI = jsonElements.get(0).getAsJsonObject();
//        String idN = firstSI.get("id").getAsString();
//        activityMainBinding.idText.setText(idN);
//
//
//        JsonObject fD = firstSI.getAsJsonObject("fD");
//
//        String code = fD.getAsJsonObject("aI").get("code").getAsString();
//        String name = fD.getAsJsonObject("aI").get("name").getAsString();
//        boolean isLcc = fD.getAsJsonObject("aI").get("isLcc").getAsBoolean();
//        String fN = fD.get("fN").getAsString();
//        String eT = fD.get("eT").getAsString();
//
//        // ---- Airline And Code
//        String codeAIR = fN+" "+eT;
//        activityMainBinding.airlineName.setText(name);
//        activityMainBinding.airlineCode.setText(codeAIR);
//
//        Log.e("DATA" , idN + " " + code + " " + " " + isLcc + " " + fN + " "+eT+" ");
//
//        JsonObject da = firstSI.getAsJsonObject("da");
//
//        String daCode = da.get("code").getAsString();
//        String daCity = da.get("city").getAsString();
//        String airportNameDe = da.get("name").getAsString();
//
//        activityMainBinding.cityFrom.setText(daCity);
//        activityMainBinding.cityCodeFrom.setText(daCode);
//        activityMainBinding.departureAirport.setText(airportNameDe);
//        activityMainBinding.departureCity.setText(daCity);
//
//        int size = jsonElements.size();
//        Toast.makeText(this, String.valueOf(size), Toast.LENGTH_SHORT).show();
////        JsonObject lastSI = jsonElements.get(size-1).getAsJsonObject();
//        JsonObject aa = firstSI.getAsJsonObject("aa");
//
//        String aaCode = aa.get("code").getAsString();
//        String aaCity = aa.get("city").getAsString();
//        String aaAirportName = aa.get("name").getAsString();
//
//        activityMainBinding.cityTo.setText(aaCity);
//        activityMainBinding.cityCodeTO.setText(aaCode);
//        activityMainBinding.arrivingAirport.setText(aaAirportName);
//        activityMainBinding.arrivingCity.setText(aaCity);
////        activityMainBinding.daTerminal.setText(aaTerminal);
//
//        int stop = firstSI.get("stops").getAsInt();
//        int duration = firstSI.get("duration").getAsInt();
//
//        int hours = duration/60;
//        int min = duration%60;
//        String totalTime = ""+hours+"h "+min+"m";
//        activityMainBinding.totalTime.setText(totalTime);
//        activityMainBinding.centerBoxTiming.setText(totalTime);
//
//        String dt = firstSI.get("dt").getAsString();
//        String at = firstSI.get("at").getAsString();
//
//        activityMainBinding.allDateFrom.setText(dt);
//        activityMainBinding.allDateTo.setText(at);
//
//        int lengthDa = dt.length();
//        int lengthAa = at.length();
//        String timeDA = dt.substring(lengthDa-5, lengthDa);
//        String timAA = at.substring(lengthAa-5, lengthAa);
//        activityMainBinding.cityTimeFrom.setText(timeDA);
//        activityMainBinding.cityTimeTo.setText(timAA);
//
////        activityMainBinding.cityTimeFrom.setText(at.length());
//
//
//
//
////       -----------   PASSENGER     -----------   DETAILS   -------------------
//        JsonArray psn = jsonObject.getAsJsonObject("AIR").getAsJsonArray("travellerInfos");
//
//
//
////        JsonObject passenger = psn.get(1).getAsJsonObject();
//
////        String personName = passenger.get("ti").getAsString()+passenger.get("fN").getAsString()+passenger.get("lN").getAsString();
//
////        activityMainBinding.PNR.setText(pnr.get("IDR-AMD").getAsString());
////        activityMainBinding.personName.setText(personName);
//
//
//
//
////       -----------   RETURN     -----------   TICKET   -------------------
//
//        JsonArray jsonElements2 = jsonObject.getAsJsonObject("AIR").getAsJsonArray("tripInfos").get(1).getAsJsonObject().getAsJsonArray("sI");
//        JsonObject secondSI = jsonElements2.get(1).getAsJsonObject();
//        String id2 = secondSI.get("id").getAsString();
//
//
//        if(idN.equals(id2)){
//            activityMainBinding.stops.setText("NONSTOP |  "); }
//        else{
//            String stopCount = String.valueOf(stop);
//            activityMainBinding.stops.setText("STOP - " + stopCount +" |  ");}
//
//
//
//    }

    private void generatePDF() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = inflater.inflate(R.layout.activity_main, null);


//        View content2 = inflater.inflate(R.layout.pdf_layout2, null);
        PdfGenerator.getBuilder()
                .setContext(MainActivity.this)
                .fromViewSource()
                .fromView(content)
                .setFileName("MyFile")
                .savePDFSharedStorage(xmlToPDFLifecycleObserver)
                .actionAfterPDFGeneration(PdfGenerator.ActionAfterPDFGeneration.OPEN)
                .build(new PdfGeneratorListener() {

                    @Override
                    public void onFailure(FailureResponse failureResponse) {
                        super.onFailure(failureResponse);
                        Gson gson = new Gson();
                        Log.e("BTN_ERROR", gson.toJson(failureResponse));
                        Toast.makeText(MainActivity.this, failureResponse.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStartPDFGeneration() {
                        Toast.makeText(MainActivity.this, "PDF generating...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFinishPDFGeneration() {
                        Toast.makeText(MainActivity.this, "PDF Downloading Finished!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(SuccessResponse response) {
                        super.onSuccess(response);
                        Toast.makeText(MainActivity.this, "PDF Downloaded Successfully!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}