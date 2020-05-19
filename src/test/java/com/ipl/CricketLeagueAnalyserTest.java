package com.ipl;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
public class CricketLeagueAnalyserTest {
    public static final String IPL_2019_FACT_SHEET_MOSTRUNS="C:\\Users\\KYOOLBABAA\\Desktop\\New folder\\IPL2019FactsheetMostRuns.csv";
    public static final String INCOMPATIBLE_FILE_PATH="C:\\Users\\KYOOLBABAA\\Desktop\\New folder\\SCode.csv";
    public static final String INVALID_FILE_PATH="abc.txt";

    @Test
    public void givenCSVFileShouldReturnCorrectRecord() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        int count=cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        Assert.assertEquals(100,count);
    }

    @Test
    public void givenWrongFilePathShouldReturnIOException() {
       try {
           CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
           int count = cricketLeagueAnalyser.loadRunsSheetData(INVALID_FILE_PATH);
       }catch(CricketLeagueAnalyserException e){
           Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.FILE_NOT_PRESENT,e.type);
       }
    }

    @Test
    public void givenWrongCsvFileShouldThroughRunTimeException() throws CricketLeagueAnalyserException {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadRunsSheetData(INCOMPATIBLE_FILE_PATH);
        }catch(CricketLeagueAnalyserException e){
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.DATA_NOT_APPROPRIATE,e.type);
        }
    }

    @Test
    public void givenCSVFileShouldReturnMaxAverageOfRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getAverageWiseSortedData();
        IplRunSheetDAO[] sortedAverageData=new Gson().fromJson(sortedData,IplRunSheetDAO[].class);
        Assert.assertEquals("MS Dhoni",sortedAverageData[sortedAverageData.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnMaxStrikingRateInRecords() throws CricketLeagueAnalyserException {
    CricketLeagueAnalyser cricketLeagueAnalyser= new CricketLeagueAnalyser();
    cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
    String sortedData=cricketLeagueAnalyser.getStrikeRateWiseSortedData();
    IplRunSheetDAO[] sortedStrikeRateData=new Gson().fromJson(sortedData,IplRunSheetDAO[].class);
    Assert.assertEquals("Ishant Sharma",sortedStrikeRateData[sortedStrikeRateData.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnMaximunSixesInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getSixesWiseSortedData();
        IplRunSheetDAO[] sortedStrikeRateData=new Gson().fromJson(sortedData,IplRunSheetDAO[].class);
        Assert.assertEquals("Andre Russell",sortedStrikeRateData[sortedStrikeRateData.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnMaximunFoursInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getFoursWiseSortedData();
        IplRunSheetDAO[] sortedStrikeRateData=new Gson().fromJson(sortedData,IplRunSheetDAO[].class);
        Assert.assertEquals("Shikhar Dhawan",sortedStrikeRateData[sortedStrikeRateData.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnCountSixesAndFoursOfBestStrikeRatePlayer() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getStrikeRateWiseWithSixesAndFoursSortedData();
        IplRunSheetDAO[] sortedStrikeRateData=new Gson().fromJson(sortedData,IplRunSheetDAO[].class);
        Assert.assertEquals("Ishant Sharma",sortedStrikeRateData[sortedStrikeRateData.length-1].player);
    }


}
