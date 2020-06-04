package com.ipl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.HashMap;
import java.util.Map;

public class CricketLeagueAdapterTest {
    Map <String,IplSheetDAO>batsmanData;
    Map<String,IplSheetDAO> bowlersData;

    @Before
    public void setUp()  {
       batsmanData=new HashMap();
        batsmanData.put("David Warner",new IplSheetDAO(new IplBatsmenSheetCSV("David Warner",2,692,
                143.86,69.2,21,57)));
        batsmanData.put("KL Rahul",new IplSheetDAO(new IplBatsmenSheetCSV("KL Rahul",1,593,
                135.33,53.2,25,49)));
        batsmanData.put("Quinton de Kock",new IplSheetDAO(new IplBatsmenSheetCSV("Quinton de Kock",1,523,
                132.33,35.2,25,45)));
        batsmanData.put("Shikhar Dhawan",new IplSheetDAO(new IplBatsmenSheetCSV("Shikhar Dhawan",1,529,
                135.67,34.6,64,11)));

         bowlersData=new HashMap<String,IplSheetDAO>();
        bowlersData.put("Imran Tahir",new IplSheetDAO(new IplBowlersSheetCSV("Imran Tahir",64.2,431
                ,26,16.57,6.69,14.84,2,0)));
        bowlersData.put("Kagiso Rabada",new IplSheetDAO(new IplBowlersSheetCSV("Kagiso Rabada",47,368,25
                ,14.72,7.82,11.28,2,0)));
        bowlersData.put("Deepak Chahar",new IplSheetDAO(new IplBowlersSheetCSV("Deepak Chahar",64.3,482,22,
                21.9,7.47,17.59,0,0)));
        bowlersData.put("Shreyas Gopal",new IplSheetDAO(new IplBowlersSheetCSV("Shreyas Gopal",48,347,20,
                17.35,7.22,14.4,0,0)));

    }

    @Test
    public void givenBatsmenDatain_whenAdded_shouldReturnCorrectCount() throws CricketLeagueAnalyserException {
        IplBatsmenSheetAdapter iplBatsmenSheetAdapter =mock(IplBatsmenSheetAdapter.class);
        when(iplBatsmenSheetAdapter.
                loadIplSheetData(eq(IplBatsmenSheetCSV.class),any(String.class))).thenReturn(batsmanData);
        Map data= iplBatsmenSheetAdapter.loadIplSheetData(IplBatsmenSheetCSV.class,"milan");
        Assert.assertEquals(4,data.size());
    }

    @Test
    public void givenBolwersDatain_whenAdded_shouldReturnCorrectCount() throws CricketLeagueAnalyserException {
        IplBolwersSheetAdapter iplBowlersSheetAdapter =mock(IplBolwersSheetAdapter.class);
        when(iplBowlersSheetAdapter.
                loadIplSheetData(eq(IplBowlersSheetCSV.class),any(String.class))).thenReturn(bowlersData);
        Map data= iplBowlersSheetAdapter.loadIplSheetData(IplBowlersSheetCSV.class,"milan");
        Assert.assertEquals(4,data.size());
    }

}
