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
    public void givenCSVFileShouldReturnAverageOfRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedAverageData=cricketLeagueAnalyser.getAverageWiseSortedData();
        IplRunSheetDAO[] sortedData=new Gson().fromJson(sortedAverageData,IplRunSheetDAO[].class);
        Assert.assertEquals("MS Dhoni",sortedData[sortedData.length-1].player);
        Assert.assertEquals("Ishant Sharma",sortedData[0].player);
    }

    @Test
    public void givenCSVFileShouldReturnMinAverageOfRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedAverageData=cricketLeagueAnalyser.getAverageWiseSortedData();
        IplRunSheetDAO[] sortedData=new Gson().fromJson(sortedAverageData,IplRunSheetDAO[].class);
        Assert.assertEquals("Ishant Sharma",sortedData[0].player);
    }

    @Test
    public void givenCSVFileShouldReturnMaxStrikingRateInRecords() throws CricketLeagueAnalyserException {
    CricketLeagueAnalyser cricketLeagueAnalyser= new CricketLeagueAnalyser();
    cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
    String sortedStrikeRateData=cricketLeagueAnalyser.getStrikeRateWiseSortedData();
    IplRunSheetDAO[] sortedData=new Gson().fromJson(sortedStrikeRateData,IplRunSheetDAO[].class);
    Assert.assertEquals("Ishant Sharma",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnMaximunSixesInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedStrikeRateData=cricketLeagueAnalyser.getSixesWiseSortedData();
        IplRunSheetDAO[] sortedData=new Gson().fromJson(sortedStrikeRateData,IplRunSheetDAO[].class);
        Assert.assertEquals("Andre Russell",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnMinimunSixesInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedDataByFourAndSixes=cricketLeagueAnalyser.getSixesWiseSortedData();
        IplRunSheetDAO[] sortedData=new Gson().fromJson(sortedDataByFourAndSixes,IplRunSheetDAO[].class);
        Assert.assertEquals("Kuldeep Yadav",sortedData[0].player);
    }

    @Test
    public void givenCSVFileShouldReturnPlayerOfBestCombinationsOfSixesAndFoursInRecord() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedDataBySixesAnfFours=cricketLeagueAnalyser.getSixesAndFoursWiseSortedData();
        IplRunSheetDAO[] sortedData=new Gson().fromJson(sortedDataBySixesAnfFours,IplRunSheetDAO[].class);
        Assert.assertEquals("Andre Russell",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnMaximunFoursInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getFoursWiseSortedData();
        IplRunSheetDAO[] sortedStrikeRateData=new Gson().fromJson(sortedData,IplRunSheetDAO[].class);
        Assert.assertEquals("Tim Southee",sortedStrikeRateData[0].player);
    }

    @Test
    public void givenCSVFileShouldReturnMinimunFoursInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getFoursWiseSortedData();
        IplRunSheetDAO[] sortedStrikeRateData=new Gson().fromJson(sortedData,IplRunSheetDAO[].class);
        Assert.assertEquals("Shikhar Dhawan",sortedStrikeRateData[sortedStrikeRateData.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnPlayerOfBestCombinationsOfSixesFoursAndStrikeRate() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getStrikeRateWiseWithSixesAndFoursSortedData();
        IplRunSheetDAO[] sortedStrikeRateData=new Gson().fromJson(sortedData,IplRunSheetDAO[].class);
        Assert.assertEquals("Andre Russell",sortedStrikeRateData[sortedStrikeRateData.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnPlayerOfBestCombinationOfAverageAndStrikeRate() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getBestCombinationOfAverageAndStrikeRate();
        IplRunSheetDAO[] sortedCombinationOfStrikeRateAndAverage=new Gson().fromJson(sortedData,IplRunSheetDAO[].class);
        Assert.assertEquals("MS Dhoni",sortedCombinationOfStrikeRateAndAverage[sortedCombinationOfStrikeRateAndAverage.length-1].player);
    }

    @Test
    public void givenCSVFileShouldReturnPlayerOfBestCombinationOfMaxRunsWithAverages() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedCombinationOfRunsAndAverage=cricketLeagueAnalyser.getBestCombinationRunsAndAverage();
        IplRunSheetDAO[] sortedData=new Gson().fromJson(sortedCombinationOfRunsAndAverage,IplRunSheetDAO[].class);
        Assert.assertEquals("David Warner ",sortedData[sortedData.length-1].player);
    }

}
